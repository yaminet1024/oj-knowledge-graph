package cn.yaminets.ojknowledgegraph.service.impl;

import cn.yaminets.ojknowledgegraph.pojo.RawProblem;
import cn.yaminets.ojknowledgegraph.pojo.node.Difficulty;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.pojo.node.Types;
import cn.yaminets.ojknowledgegraph.repository.LuoguDifficultyRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguProblemRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguTypesRepository;
import cn.yaminets.ojknowledgegraph.service.LuoguService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LuoguServiceImpl implements LuoguService {

    private  String luoguUrl = "https://www.luogu.com.cn/problem/list?page=1&_contentOnly=1";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private LuoguProblemRepository problemRepository;

    @Resource
    private LuoguDifficultyRepository difficultyRepository;

    @Resource
    private LuoguTypesRepository typesRepository;

    @Override
    public void update() {

    }

    @Override
    public void getData() {
        for(int i = 1;i < 5; i ++){
            HttpGet httpGet = new HttpGet(getUrl(i));
            CloseableHttpClient client = HttpClients.createDefault();
            try {
                CloseableHttpResponse response = client.execute(httpGet);
                RawProblem rawProblem = JSONObject.parseObject(EntityUtils.toString(response.getEntity()),RawProblem.class);
                List<Problem> problems = rawToNode(rawProblem);
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
    }

    private List<Problem> rawToNode(RawProblem rawProblem) {
        List<Problem> problems = new ArrayList<>();
        for(RawProblem.CurrentDataBean.ProblemsBean.ResultBean resultBean : rawProblem.getCurrentData().getProblems().getResult()){
            Problem problem = new Problem();
            problem.setPid(resultBean.getPid());
            problem.setTitle(resultBean.getTitle());


            //构建类型节点
            for(Integer tagItem: resultBean.getTags()){
                Types types = typesRepository.findFirstByTagInt(tagItem);
                if(types == null){
                    types = new Types();
                    types.setTagInt(tagItem);


                }else {
                    Set<Problem> problemList = types.getProblemList();
                    if(problemList == null){
                        problemList = new HashSet<>();
                    }
                    problemList.add(problem);
                    types.setProblemList(problemList);
                }
                typesRepository.save(types);
            }


            problems.add(problem);

            //构建难度节点
            Difficulty difficulty = difficultyRepository.findDifficultyByDifficulty(resultBean.getDifficulty());
            if(difficulty == null){
                difficulty = new Difficulty();
                difficulty.setDifficulty(resultBean.getDifficulty());
                String difficultyString = "";
                switch (resultBean.getDifficulty()){
                    case 1: difficultyString = "入门"; break;
                    case 2: difficultyString = "普及-"; break;
                    case 3: difficultyString = "普及/提高-"; break;
                    case 4: difficultyString = "普及+/提高"; break;
                    case 5: difficultyString = "提高+/省选-"; break;
                    case 6: difficultyString = "省选/NOI-"; break;
                    case 7: difficultyString = "NOI/NOI+/CTSC"; break;
                }
                difficulty.setDifficultyString(difficultyString);
            }else {
                Set<Problem> problemList = difficulty.getProblemList();
                if(null == problemList){
                    problemList = new HashSet<>();
                }
                problemList.add(problem);
                difficulty.setProblemList(problemList);
            }
            difficultyRepository.save(difficulty);

        }

        return problems;
    }


    private String getUrl(int page){
        return String.format("https://www.luogu.com.cn/problem/list?page=%s&_contentOnly=1",page);
    }
}
