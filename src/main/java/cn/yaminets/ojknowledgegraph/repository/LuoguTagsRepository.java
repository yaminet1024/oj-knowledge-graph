package cn.yaminets.ojknowledgegraph.repository;

import cn.yaminets.ojknowledgegraph.pojo.node.Tags;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LuoguTagsRepository extends CrudRepository<Tags,Long> {
    Tags findFirstByTagInt(int tagInt);
    List<Tags> findTagsByNameContains(String s);
}
