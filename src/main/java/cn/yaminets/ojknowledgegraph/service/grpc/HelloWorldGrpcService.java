package cn.yaminets.ojknowledgegraph.service.grpc;


import cn.yaminets.grpclib.GreeterGrpc;
import cn.yaminets.grpclib.HelloReply;
import cn.yaminets.grpclib.HelloRequest;
import cn.yaminets.grpclib.ResponseEntity;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GrpcService
public class HelloWorldGrpcService extends GreeterGrpc.GreeterImplBase {

    Logger logger = LoggerFactory.getLogger("HelloWorldGrpcService");

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply helloReply = HelloReply.newBuilder().setMessage("Hello Grpc!").build();
        logger.info(request.getName());
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();

    }
}
