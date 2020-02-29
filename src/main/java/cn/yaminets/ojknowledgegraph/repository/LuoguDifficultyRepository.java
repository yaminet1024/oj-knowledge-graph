package cn.yaminets.ojknowledgegraph.repository;

import cn.yaminets.ojknowledgegraph.pojo.node.Difficulty;
import org.springframework.data.repository.CrudRepository;

public interface LuoguDifficultyRepository extends CrudRepository<Difficulty,Long> {
    Difficulty findDifficultyByDifficulty(int difficultyInt);
}
