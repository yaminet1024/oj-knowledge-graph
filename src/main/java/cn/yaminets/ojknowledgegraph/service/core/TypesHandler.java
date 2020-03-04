package cn.yaminets.ojknowledgegraph.service.core;

import cn.yaminets.ojknowledgegraph.pojo.node.Types;
import cn.yaminets.ojknowledgegraph.repository.LuoguTypesRepository;
import cn.yaminets.ojknowledgegraph.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service
public class TypesHandler implements NodeHandler {

    @Resource
    LuoguTypesRepository typesRepository;

    Logger logger = LoggerFactory.getLogger("TypesHandler");

    @Override
    public void handler(NodeChain chain) {
        logger.info("nodeHandler: 构建[类型]节点 开始！");
        //建立类型节点
        Map<String,String> typesMap = new HashMap<>();
        typesMap.put("P","洛谷题库");
        typesMap.put("CF","CodeForces");
        typesMap.put("SP","SPOJ");
        typesMap.put("AT","AtCoder");
        typesMap.put("UVA","UVA");

        for (String s : typesMap.keySet()) {
            Types types = new Types();
            types.setTagEN(s);
            types.setTagString(typesMap.get(s));
            typesRepository.save(types);
        }
        logger.info("nodeHandler: 构建[类型]节点 完成!");

        chain.process();
    }
}
