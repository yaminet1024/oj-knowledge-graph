package cn.yaminets.ojknowledgegraph.pojo.relation;

import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.pojo.node.Tags;
import cn.yaminets.ojknowledgegraph.pojo.node.Types;
import lombok.Data;
import org.neo4j.ogm.annotation.*;


@RelationshipEntity(type = "标签")
@Data
public class TagRelation {
    @Id
    @GeneratedValue
    private Long id;


    /**
     * 建立 标签 -> 问题 的关系连接
     */

    /**
     * 类型节点
     */
    @StartNode
    private Tags tags;

    /**
     * 问题节点
     */
    @EndNode
    private Problem problem;
}
