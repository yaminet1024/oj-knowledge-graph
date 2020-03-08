package cn.yaminets.ojknowledgegraph.pojo.relation;


import cn.yaminets.ojknowledgegraph.pojo.node.Answer;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "题解")
@Data
public class AnswerRelation {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 建立问题 -> 答案的关系
     */


    @StartNode
    private Problem problem;


    @EndNode
    private Answer answer;
}
