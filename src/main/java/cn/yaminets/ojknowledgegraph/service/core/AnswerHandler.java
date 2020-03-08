package cn.yaminets.ojknowledgegraph.service.core;


import cn.yaminets.ojknowledgegraph.pojo.node.Answer;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.repository.LuoguProblemRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AnswerHandler implements NodeHandler {

    @Resource
    LuoguProblemRepository problemRepository;

    Logger logger = LoggerFactory.getLogger("AnswerHandler");

    @Override
    public void handler(NodeChain chain) {
        Page<Problem> tempPageProblem = problemRepository.findAll(PageRequest.of(1,20));
        int totalPage = tempPageProblem.getTotalPages();
        //第一层循环，遍历所有的问题
        for(int i=1; i<=totalPage;i++){
            Page<Problem> problemPage = problemRepository.findAll(PageRequest.of(i,20));
            List<Problem> result = problemPage.getContent();
            //第二层for循环，遍历所有题解
            for (Problem problem : result) {
                String url = "https://www.luogu.com.cn/problemnew/solution/" + problem.getPid() + "?page=1";
                try {
                    Document htmlContent = Jsoup.connect(url).get();
                    Thread.sleep(2000);
                    int pageSize = 1;
                    Elements pageDiv = htmlContent.select(".am-pagination").select("li");
                    if (!pageDiv.isEmpty()) {
                        if (pageDiv.last().text().equals(">")) {
                            pageSize = pageDiv.size() - 1;
                        } else {
                            String lastPageString = pageDiv.last().getAllElements().last().attr("data-ci-pagination-page");
                            pageSize = Integer.parseInt(lastPageString);
                        }
                    }
                    logger.info(problem.getPid() + "页数 " + pageSize);
                    //第三层循环，提取出所有的答案
                    Set<Answer> answerSet = new HashSet<>();
                    for(int j = 1;j<=pageSize; j++){
                        String answerUrl = "https://www.luogu.com.cn/problemnew/solution/" + problem.getPid() + "?page=" + j;
                        Document answerDocument = Jsoup.connect(answerUrl).get();
                        Thread.sleep(2000);
                        Elements answerDiv = answerDocument.select(".lg-content-left");
                        logger.info(problem.getPid() + "答案数量 " + answerDiv.size());
                        for(Element element: answerDiv){
                            Answer answer = new Answer();
                            answer.setAnswerString(element.outerHtml());
                            answerSet.add(answer);
                        }
                        if(!answerSet.isEmpty()){
                            problem.setAnswers(answerSet);
                            problemRepository.save(problem);
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        if(chain == null) return;
        chain.process();
    }
}
