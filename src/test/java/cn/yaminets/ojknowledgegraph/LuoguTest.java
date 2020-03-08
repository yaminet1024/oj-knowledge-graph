package cn.yaminets.ojknowledgegraph;

import cn.yaminets.ojknowledgegraph.pojo.node.Answer;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.repository.LuoguProblemRepository;
import cn.yaminets.ojknowledgegraph.service.LuoguService;
import cn.yaminets.ojknowledgegraph.service.core.AnswerHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuoguTest {

    @Autowired
    LuoguService luoguService;

    @Autowired
    LuoguProblemRepository problemRepository;

    @Autowired
    AnswerHandler answerHandler;

    Logger logger = LoggerFactory.getLogger("LuoguTest");


    @Test
    public void testLuoguData(){
        luoguService.getData();
    }

    @Test
    public void testFindAllProblem(){
        answerHandler.handler(null);
    }


}
