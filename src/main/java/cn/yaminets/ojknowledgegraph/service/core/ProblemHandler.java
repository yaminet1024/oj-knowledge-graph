package cn.yaminets.ojknowledgegraph.service.core;

import cn.yaminets.ojknowledgegraph.pojo.RawProblem;
import cn.yaminets.ojknowledgegraph.pojo.node.Difficulty;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.pojo.node.Tags;
import cn.yaminets.ojknowledgegraph.pojo.node.Types;
import cn.yaminets.ojknowledgegraph.repository.LuoguDifficultyRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguProblemRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguTagsRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguTypesRepository;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProblemHandler implements NodeHandler {

    private int startPage = 1;

    //todo 暂时只取前面10页
    private int endPage = 1;

    private Logger logger = LoggerFactory.getLogger("ProblemHandler");

    @Resource
    LuoguProblemRepository problemRepository;

    @Resource
    LuoguTagsRepository tagsRepository;

    @Resource
    LuoguTypesRepository typesRepository;

    @Resource
    LuoguDifficultyRepository difficultyRepository;

    @Override
    public void handler(NodeChain chain) {
        logger.info("nodeHandler: 构建[问题]节点 开始");
        for(int i = startPage; i<= endPage; i++){
            HttpGet httpGet = new HttpGet(getUrl(i));
            CloseableHttpClient client = HttpClients.createDefault();
            try {
                CloseableHttpResponse response = client.execute(httpGet);
                RawProblem rawProblem = JSONObject.parseObject(EntityUtils.toString(response.getEntity()),RawProblem.class);
                List<Problem> problems = rawToProblemList(rawProblem);
                for(Problem problem: problems){
                    problemRepository.save(problem);
                }
                logger.info(JSON.toJSONString(rawProblem));
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("nodeHandler: 构建[问题]节点 完成");
        chain.process();
    }

    private List<Problem> rawToProblemList(RawProblem rawProblem) {
        List<Problem> problems = new ArrayList<>();
        for(RawProblem.CurrentDataBean.ProblemsBean.ResultBean resultBean : rawProblem.getCurrentData().getProblems().getResult()){
            Problem problem = new Problem();
            problem.setPid(resultBean.getPid());
            problem.setTitle(resultBean.getTitle());

            String contentUrl = "https://www.luogu.com.cn/problem/"+ resultBean.getPid();

            try {
                Document content = Jsoup.connect(contentUrl).get();
                problem.setContentHtml(content.outerHtml());
            } catch (IOException e) {
                e.printStackTrace();
            }


            //更新标签节点
            for(Integer tagItem: resultBean.getTags()){
                Tags tags = tagsRepository.findFirstByTagInt(tagItem);
                if(tags == null){
                    logger.warn("不存在该标签:" + tagItem);
                }else {
                    Set<Problem> problemList = tags.getProblemList();
                    if(problemList == null){
                        problemList = new HashSet<>();
                    }
                    problemList.add(problem);
                    tags.setProblemList(problemList);
                    tagsRepository.save(tags);
                }
            }

            //更新类型节点
            Types types = typesRepository.findFirstByTagEN(resultBean.getType());
            if(types == null){
                logger.warn("不存在的类型: " + resultBean.getType());
            }else {
                Set<Problem> problemList = types.getProblemList();
                if(problemList == null){
                    problemList = new HashSet<>();
                }
                problemList.add(problem);
                types.setProblemList(problemList);
                typesRepository.save(types);
            }

            //更新难度节点
            Difficulty difficulty = difficultyRepository.findDifficultyByDifficulty(resultBean.getDifficulty());
            if(difficulty == null){
                logger.warn("不存在的难度: " + resultBean.getDifficulty());
            }else {
                Set<Problem> problemList = difficulty.getProblemList();
                if(null == problemList){
                    problemList = new HashSet<>();
                }
                problemList.add(problem);
                difficulty.setProblemList(problemList);
                difficultyRepository.save(difficulty);
            }
            problems.add(problem);
        }
        return problems;
    }


    private String getUrl(int page){
        return String.format("https://www.luogu.com.cn/problem/list?page=%s&_contentOnly=1",page);
    }
}
