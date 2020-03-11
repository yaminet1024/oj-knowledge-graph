package cn.yaminets.ojknowledgegraph.service.core;

import cn.yaminets.ojknowledgegraph.pojo.node.Difficulty;
import cn.yaminets.ojknowledgegraph.pojo.node.Types;
import cn.yaminets.ojknowledgegraph.repository.LuoguDifficultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DifficultyHandler implements NodeHandler {

    @Resource
    LuoguDifficultyRepository difficultyRepository;

    Logger logger = LoggerFactory.getLogger("DifficultyHandler");

    @Override
    public void handler(NodeChain chain) {
        logger.info("nodeHandler: 构建[难度]节点 开始");
        //建立难度节点
        Map<Integer,String> difficultyMap = new HashMap<>();
        difficultyMap.put(0,"暂无评定");
        difficultyMap.put(1,"入门");
        difficultyMap.put(2,"普及-");
        difficultyMap.put(3,"普及/提高-");
        difficultyMap.put(4,"普及+/提高");
        difficultyMap.put(5,"提高+/省选-");
        difficultyMap.put(6,"省选/NOI-");
        difficultyMap.put(7,"NOI/NOI+/CTSC");


        for (int difficultyId : difficultyMap.keySet()) {
            Difficulty difficulty = new Difficulty();
            difficulty.setDifficultyString(difficultyMap.get(difficultyId));
            difficulty.setDifficulty(difficultyId);
            difficultyRepository.save(difficulty);
        }
        logger.info("nodeHandler: 构建[难度]节点 完成");
        chain.process();


    }
}
