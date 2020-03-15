package cn.yaminets.ojknowledgegraph.pojo.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Set;

@NodeEntity
@Data
public class TagsTypes {

    @Id
    @GeneratedValue
    private Long id;


    /**
     * 分类描述
     */

    private String title;


    /**
     * 该类型下的标签
     */
    private Set<Integer> tagInt;
}
