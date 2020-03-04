package cn.yaminets.ojknowledgegraph.pojo.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;
import java.util.Set;

@NodeEntity
@Data
public class Difficulty {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 难度数字表示
     */
    private int difficulty;

    /**
     * 难度中文
     */
    private String difficultyString;


    /**
     * 该难度下的所有问题
     */
    @Relationship(type = "难度",direction = Relationship.OUTGOING)
    private Set<Problem> problemList;


}
