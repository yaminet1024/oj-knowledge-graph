package cn.yaminets.ojknowledgegraph.service.grpc;

import cn.yaminets.grpclib.*;
import cn.yaminets.ojknowledgegraph.pojo.node.Answer;
import cn.yaminets.ojknowledgegraph.pojo.node.Difficulty;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.repository.LuoguAnswerRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguDifficultyRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguProblemRepository;
import cn.yaminets.ojknowledgegraph.repository.LuoguTagsRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.elasticsearch.cluster.Diff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@GrpcService
public class ProblemGrpcService extends ProblemServiceGrpc.ProblemServiceImplBase {

    @Resource
    LuoguProblemRepository problemRepository;

    @Resource
    LuoguDifficultyRepository difficultyRepository;

    @Resource
    LuoguAnswerRepository answerRepository;

    @Resource
    LuoguTagsRepository tagsRepository;

    Logger logger = LoggerFactory.getLogger("ProblemGrpcService");



    @Override
    public void getProblem(ProblemRequest request, StreamObserver<ProblemReply> responseObserver) {


        List<Problem> allReturnproblemList = new ArrayList<>();
        for (Problem value : problemRepository.findAll()) {
            if(value.getTitle().contains(request.getContent())){
                allReturnproblemList.add(value);
            }
        }

        List<Problem> resultList = new ArrayList<>();

        for(int i=request.getPage()*10 ;i<20;i++){
            if(i<allReturnproblemList.size()){
                resultList.add(allReturnproblemList.get(i));
            }
        }


        List<ProblemEntity> problemEntities = new ArrayList<>();
        for(Problem problem: resultList){
            List<AnswerEntity> answerEntities = new ArrayList<>();

            List<Answer> answerList = answerRepository.findAnswersByProblemIdV2(problem.getPid());
            if(answerList!=null && !answerList.isEmpty()){
                for(Answer answer: answerList){
                    AnswerEntity answerEntity = AnswerEntity.newBuilder()
                            .setAnswerString(answer.getAnswerString())
                            .build();
                    answerEntities.add(answerEntity);
                }
            }else {
                logger.info("id is "  + problem.getPid());
                logger.info("answer is  null ");

            }
            Difficulty difficulty = difficultyRepository.getDifByPid(problem.getPid());
            cn.yaminets.grpclib.Difficulty resultDifficulty = cn.yaminets.grpclib.Difficulty.newBuilder()
                    .setDifficultyString(difficulty.getDifficultyString())
                    .setId(difficulty.getId())
                    .build();

            List<cn.yaminets.ojknowledgegraph.pojo.node.Tags> tagsList = tagsRepository.getAllByPid(problem.getPid());


            ProblemEntity problemEntity = ProblemEntity.newBuilder()
                    .setContent(problem.getContentHtml())
                    .setTitle(problem.getTitle())
                    .setId(problem.getId())
                    .setPid(problem.getPid())
                    .setDifficulty(resultDifficulty)
                    .addAllAnswers(answerEntities)
                    .addAllTags(toGrpcModelList(tagsList))
                    .build();
            problemEntities.add(problemEntity);
        }

        ResultMessage resultMessage = ResultMessage.newBuilder()
                .setErrCode(0)
                .setMessage("success")
                .build();
        ProblemReply problemReply = ProblemReply.newBuilder()
                .addAllProblemList(problemEntities)
                .setResultMessage(resultMessage)
                .setPageSize(allReturnproblemList.size()/20)
                .build();

        responseObserver.onNext(problemReply);
        responseObserver.onCompleted();
    }

    private List<cn.yaminets.grpclib.Tags> toGrpcModelList(List<cn.yaminets.ojknowledgegraph.pojo.node.Tags> tagsList){
        if (tagsList == null) return null;
        List<cn.yaminets.grpclib.Tags> grpcResultList = new ArrayList<>();
        for(cn.yaminets.ojknowledgegraph.pojo.node.Tags tagItem: tagsList){
            cn.yaminets.grpclib.Tags tags = cn.yaminets.grpclib.Tags.newBuilder()
                    .setId(tagItem.getId())
                    .setTagString(tagItem.getName())
                    .setTagInt(tagItem.getTagInt())
                    .build();
            grpcResultList.add(tags);
        }
        return grpcResultList;
    }
}
