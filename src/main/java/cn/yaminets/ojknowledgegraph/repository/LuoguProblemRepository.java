package cn.yaminets.ojknowledgegraph.repository;

import cn.yaminets.ojknowledgegraph.pojo.node.Answer;
import cn.yaminets.ojknowledgegraph.pojo.node.Difficulty;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.pojo.node.Tags;
import org.springframework.data.domain.Page;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LuoguProblemRepository extends PagingAndSortingRepository<Problem,Long> {


}
