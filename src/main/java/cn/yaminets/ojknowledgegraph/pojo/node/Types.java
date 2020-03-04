package cn.yaminets.ojknowledgegraph.pojo.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;
import java.util.Set;


@Data
@NodeEntity
public class Types {


    @Id
    @GeneratedValue
    private Long id;

    /**
     * 中文标签
     */
    private String tagString;

    /**
     * 英文标签
     */
    private String tagEN;



    /**
     * 该分类下的所有问题
     */
    @Relationship(type = "类型",direction = Relationship.OUTGOING)
    private Set<Problem> problemList;


}
