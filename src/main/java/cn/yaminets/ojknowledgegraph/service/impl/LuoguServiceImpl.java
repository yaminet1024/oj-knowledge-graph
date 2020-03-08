package cn.yaminets.ojknowledgegraph.service.impl;

import cn.yaminets.ojknowledgegraph.service.LuoguService;
import cn.yaminets.ojknowledgegraph.service.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LuoguServiceImpl implements LuoguService {


    private Logger logger = LoggerFactory.getLogger(getClass());



    @Override
    public void update() {

    }


    @Override
    public void getData() {
        NodeChain chain = new NodeChain.Builder()
                .addNodeBean(TypesHandler.class)
                .addNodeBean(TagsHandler.class)
                .addNodeBean(DifficultyHandler.class)
                .addNodeBean(ProblemHandler.class)
                .addNodeBean(AnswerHandler.class)
                .build();
        chain.process();
        logger.info("NodeHandler: 构建图谱结构完成");

    }
}
