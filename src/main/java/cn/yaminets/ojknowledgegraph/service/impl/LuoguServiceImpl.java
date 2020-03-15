package cn.yaminets.ojknowledgegraph.service.impl;

import cn.yaminets.ojknowledgegraph.service.LuoguService;
import cn.yaminets.ojknowledgegraph.service.core.*;
import org.neo4j.ogm.session.Neo4jSession;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.transaction.SessionFactoryUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LuoguServiceImpl implements LuoguService {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    SessionFactory sessionFactory;



    @Override
    public void update() {
        Session session = sessionFactory.openSession();
        session.purgeDatabase();
    }


    @Override
    public void getData() {
        NodeChain chain = new NodeChain.Builder()
                .clearFirst(true)
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
