package cn.yaminets.ojknowledgegraph.service.core;

import cn.yaminets.ojknowledgegraph.pojo.node.Tags;
import cn.yaminets.ojknowledgegraph.repository.LuoguTagsRepository;
import cn.yaminets.ojknowledgegraph.utils.BeanUtil;
import cn.yaminets.ojknowledgegraph.utils.YmUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TagsHandler implements NodeHandler {

    @Resource
    LuoguTagsRepository tagsRepository;

    Logger logger = LoggerFactory.getLogger("TagsHandler");


    @Override
    public void handler(NodeChain chain) {
        logger.info("nodeHandler: 构建[标签]节点 开始");
        String tagJson = YmUtils.readToString("src/main/resources/static/luogu_tag_string.json");
        if(tagJson == null || tagJson.isEmpty()){
            return ;
        }
        List<Tags> tags = JSONObject.parseArray(tagJson,Tags.class);
        for(Tags tag: tags){
            tagsRepository.save(tag);
        }
        logger.info("nodeHandler: 构建[标签]节点 完成");
        chain.process();

    }
}
