package cn.yaminets.ojknowledgegraph.repository;

import cn.yaminets.ojknowledgegraph.pojo.node.Answer;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LuoguAnswerRepository extends CrudRepository<Answer,Long> {

    List<Answer> findAnswersByProblemId(long problemId);

    @Query("MATCH (n:Answer{pid:$problemId}) RETURN n")
    List<Answer> findAnswersByProblemIdV2(String problemId);
 }
