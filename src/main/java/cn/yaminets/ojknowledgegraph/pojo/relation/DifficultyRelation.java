package cn.yaminets.ojknowledgegraph.pojo.relation;


import cn.yaminets.ojknowledgegraph.pojo.node.Difficulty;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "难度")
@Data
public class DifficultyRelation {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 建立 难度 -> 问题 的关系连接
     */

    /**
     * 难度节点
     */
    @StartNode
    private Difficulty difficulty;

    /**
     * 问题节点
     */
    @EndNode
    private Problem problem;






}
