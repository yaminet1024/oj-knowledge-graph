package cn.yaminets.ojknowledgegraph.pojo.node;

import lombok.Data;
import org.elasticsearch.cluster.Diff;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;
import java.util.Set;

@NodeEntity
@Data
public class Problem {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 题目pid
     */
    private String pid;

    /**
     * 题目名称
     */
    private String title;

    /**
     * html格式化文本
     */
    private String contentHtml;


    /**
     * 问题的答案
     */
    @Relationship(type = "题解",direction = Relationship.OUTGOING)
    private Set<Answer> answers;

//    /**
//     * 题目难度
//     */
//    @Relationship(type = "难度",direction = Relationship.INCOMING)
//    private Difficulty difficulty;


//    /**
//     * 题目所属的类型
//     */
//    @Relationship(type = "标签",direction = Relationship.INCOMING)
//    private List<Types> tags;




}
