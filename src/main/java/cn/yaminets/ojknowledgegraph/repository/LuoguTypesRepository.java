package cn.yaminets.ojknowledgegraph.repository;

import cn.yaminets.ojknowledgegraph.pojo.node.Types;
import org.springframework.data.repository.CrudRepository;

public interface LuoguTypesRepository extends CrudRepository<Types,Long> {
    Types findFirstByTagEN(String tagEn);
}
