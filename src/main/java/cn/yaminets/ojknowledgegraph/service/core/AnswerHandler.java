package cn.yaminets.ojknowledgegraph.service.core;


import cn.yaminets.ojknowledgegraph.pojo.node.Answer;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.pojo.node.ProblemPojo;
import cn.yaminets.ojknowledgegraph.repository.LuoguAnswerRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguProblemRepository;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class AnswerHandler implements NodeHandler {

    @Resource
    LuoguProblemRepository problemRepository;

    @Resource
    LuoguAnswerRepository answerRepository;

    Logger logger = LoggerFactory.getLogger("AnswerHandler");

    @Override
    public void handler(NodeChain chain) {
        Page<Problem> tempPageProblem = problemRepository.findAll(PageRequest.of(0,20));
        int totalPage = tempPageProblem.getTotalPages();
        //第一层循环，遍历所有的问题
        for(int i=0; i<totalPage;i++){
            Page<Problem> problemPage = problemRepository.findAll(PageRequest.of(i,20));
            List<Problem> result = problemPage.getContent();
            //第二层for循环，遍历所有题解
            for (Problem problem : result) {
                String url = "https://www.luogu.com.cn/problem/solution/" + problem.getPid() + "?page=1&_contentOnly=1";
                try {
                    CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
                    HttpGet httpGet = new HttpGet(url);
                    httpGet.addHeader("Cookie","UM_distinctid=1709409a4a8337-035b5a494424378-4b506d-1ea000-1709409a4a923d; CNZZDATA5476811=cnzz_eid%3D970868857-1583031542-https%253A%252F%252Fwww.baidu.com%252F%26ntime%3D1590905459; __client_id=dfbc69da2cac770329709e2bc83cbabba5559dc2; _uid=349784");
                    CloseableHttpResponse response =closeableHttpClient.execute(httpGet);
                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                    logger.info(content);
                    response.close();
                    Thread.sleep(1000);
                    int pageSize = 1;
                    Gson gson = new Gson();
                    ProblemPojo problemPojo = gson.fromJson(content, ProblemPojo.class);
                    pageSize = problemPojo.getCurrentData().getSolutions().getCount()/problemPojo.getCurrentData().getSolutions().getPerPage() + 1;
                    logger.info(problem.getPid() + "页数 " + pageSize);
                    //第三层循环，提取出所有的答案
                    Set<Answer> answerSet = new HashSet<>();
                    //todo 暂时只取第一页的答案，答案太多了
                    for(int j = 1;j <=1; j++){
                        String answerUrl = "https://www.luogu.com.cn/problem/solution/" + problem.getPid() + "?page=" + j +"&_contentOnly=1";
                        CloseableHttpClient answerClient = HttpClients.createDefault();
                        HttpGet answerHttpGet = new HttpGet(answerUrl);
                        answerHttpGet.addHeader("Cookie","UM_distinctid=1709409a4a8337-035b5a494424378-4b506d-1ea000-1709409a4a923d; CNZZDATA5476811=cnzz_eid%3D970868857-1583031542-https%253A%252F%252Fwww.baidu.com%252F%26ntime%3D1590905459; __client_id=dfbc69da2cac770329709e2bc83cbabba5559dc2; _uid=349784");
                        CloseableHttpResponse answerResponse =answerClient.execute(answerHttpGet);
                        String answerContent = EntityUtils.toString(answerResponse.getEntity(), "UTF-8");
                        answerClient.close();
                        logger.info(content);
                        response.close();
                        Thread.sleep(1000);
                        ProblemPojo answerProblemPojo = gson.fromJson(answerContent, ProblemPojo.class);
                        if(answerProblemPojo.getCurrentData().getSolutions().getResult().isEmpty()){
                            logger.info(problem.getId() + " 是空的答案");
                        }
                        logger.info(problem.getPid() + "第" + j +  "页答案数量 " + answerProblemPojo.getCurrentData().getSolutions().getResult().size());
                        for(ProblemPojo.CurrentDataBean.SolutionsBean.ResultBean element: answerProblemPojo.getCurrentData().getSolutions().getResult()){
                            Answer answer = new Answer();
                            logger.info(problem.getPid() + " 获取了答案");
                            answer.setAnswerString(element.getContent());
                            answer.setProblem(problem);
                            answer.setPid(problem.getPid());
                            answerRepository.save(answer);
                        }
//                        if(!answerSet.isEmpty()){
//                            problem.setAnswers(answerSet);
//                            problemRepository.save(problem);
//                        }
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
            logger.info("问题图谱构建已完成：" + ((float)i/(float) totalPage*100) + "%");
        }
        chain.process();
    }


//    @Override
//    public void handler(NodeChain chain) {
//        Page<Problem> tempPageProblem = problemRepository.findAll(PageRequest.of(1,20));
//        int totalPage = tempPageProblem.getTotalPages();
//        //第一层循环，遍历所有的问题
//        for(int i=1; i<=totalPage;i++){
//            Page<Problem> problemPage = problemRepository.findAll(PageRequest.of(i,20));
//            List<Problem> result = problemPage.getContent();
//            //第二层for循环，遍历所有题解
//            for (Problem problem : result) {
//                String url = "https://www.luogu.com.cn/problemnew/solution/" + problem.getPid() + "?page=1&_contentOnly=1";
//                try {
//                    Map<String, String> headers = new HashMap<>();
//                    headers.put("cookie","UM_distinctid=17081fd94fc76d-067fceb71758ea-39617b0f-1ea000-17081fd94fd9ed; __client_id=f9e0d5b52943359029ba7fb5378aed46caecded6; CNZZDATA5476811=cnzz_eid%3D1903694398-1582728821-https%253A%252F%252Fwww.baidu.com%252F%26ntime%3D1590893929; _uid=349784");
//                    headers.put("x-csrf-token","1590984377:KV4Gy3GbvP8UHtMIBnUPuNQatbUnXXIOJ50ph7rEjqE=");
//                    headers.put("referer","https://www.luogu.com.cn/problem/solution/P1001");
//                    headers.put("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36");
//                    Document htmlContent = Jsoup.connect(url).headers(headers)
//                            .get();
//                    logger.info(htmlContent.outerHtml());
//                    Thread.sleep(1000);
//                    int pageSize = 1;
//                    Elements pageDiv = htmlContent.select(".am-pagination").select("li");
//                    if (!pageDiv.isEmpty()) {
//                        if (pageDiv.last().text().equals(">")) {
//                            pageSize = pageDiv.size() - 1;
//                        } else {
//                            String lastPageString = pageDiv.last().getAllElements().last().attr("data-ci-pagination-page");
//                            pageSize = Integer.parseInt(lastPageString);
//                        }
//                    }
//                    logger.info(problem.getPid() + "页数 " + pageSize);
//                    //第三层循环，提取出所有的答案
//                    Set<Answer> answerSet = new HashSet<>();
//                    //todo 暂时只取第一页的答案，答案太多了
//                    for(int j = 1;j<=1; j++){
//                        String answerUrl = "https://www.luogu.com.cn/problemnew/solution/" + problem.getPid() + "?page=" + j;
//                        Document answerDocument = Jsoup.connect(answerUrl).get();
//                        Thread.sleep(1000);
//                        Elements answerDiv = answerDocument.select(".lg-content-left");
//                        logger.info(problem.getPid() + "第" + j +  "页答案数量 " + answerDiv.size());
//                        for(Element element: answerDiv){
//                            Answer answer = new Answer();
//                            answer.setAnswerString(element.outerHtml());
//                            answerSet.add(answer);
//                        }
//                        if(!answerSet.isEmpty()){
//                            problem.setAnswers(answerSet);
//                            problemRepository.save(problem);
//                        }
//                    }
//                } catch (IOException | InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//            logger.info("问题图谱构建已完成：" + ((float)i/(float) totalPage*100) + "%");
//        }
//        chain.process();
//    }
}
