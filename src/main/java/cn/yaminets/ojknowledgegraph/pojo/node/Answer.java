package cn.yaminets.ojknowledgegraph.pojo.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
public class Answer {
    @Id
    @GeneratedValue
    private Long id;


    /**
     * 问题的提供者
     */
    private String userName;


    /**
     * 问题的题解
     */
    private String answerString;



}
