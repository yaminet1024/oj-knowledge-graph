package cn.yaminets.ojknowledgegraph.pojo.relation;


import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.pojo.node.Types;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "类型")
@Data
public class TypeRelation {
    @Id
    @GeneratedValue
    private Long id;


    /**
     * 建立 类型 -> 问题 的关系连接
     */

    /**
     * 类型节点
     */
    @StartNode
    private Types types;

    /**
     * 问题节点
     */
    @EndNode
    private Problem problem;




}
