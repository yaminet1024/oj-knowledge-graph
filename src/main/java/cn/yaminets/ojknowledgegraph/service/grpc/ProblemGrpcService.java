package cn.yaminets.ojknowledgegraph.service.grpc;

import cn.yaminets.grpclib.*;
import cn.yaminets.ojknowledgegraph.pojo.node.Answer;
import cn.yaminets.ojknowledgegraph.pojo.node.Problem;
import cn.yaminets.ojknowledgegraph.repository.LuoguProblemRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@GrpcService
public class ProblemGrpcService extends ProblemServiceGrpc.ProblemServiceImplBase {

    @Resource
    LuoguProblemRepository problemRepository;

    @Override
    public void getProblem(ProblemRequest request, StreamObserver<ProblemReply> responseObserver) {
        Page<Problem> tempPageProblem = problemRepository.findAll(PageRequest.of(request.getPage(),  request.getLimit()));
        List<Problem> problemList = tempPageProblem.getContent();
        List<ProblemEntity> problemEntities = new ArrayList<>();
        for(Problem problem: problemList){
            List<AnswerEntity> answerEntities = new ArrayList<>();
            if(problem.getAnswers()!=null){
                for(Answer answer: problem.getAnswers()){
                    AnswerEntity answerEntity = AnswerEntity.newBuilder()
                            .setAnswerString(answer.getAnswerString())
                            .build();
                    answerEntities.add(answerEntity);
                }
            }
            ProblemEntity problemEntity = ProblemEntity.newBuilder()
                    .setContent(problem.getContentHtml())
                    .setTitle(problem.getTitle())
                    .setId(problem.getId())
                    .setPid(problem.getPid())
                    .addAllAnswers(answerEntities)
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
                .build();

        responseObserver.onNext(problemReply);
        responseObserver.onCompleted();
    }
}
