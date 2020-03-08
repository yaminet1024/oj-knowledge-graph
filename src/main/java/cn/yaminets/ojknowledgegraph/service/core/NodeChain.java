package cn.yaminets.ojknowledgegraph.service.core;

import cn.yaminets.ojknowledgegraph.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


public class NodeChain {

    private List<NodeHandler> nodeChainList;

    private int index;

    private Boolean clearFirst = false;

    NodeChain(List<NodeHandler> nodeChainList, int mIndex){
        this.nodeChainList = nodeChainList;
        this.index = mIndex;
    }

    public void process(){
        //执行之前先清空数据库
        if(index == 0){

        }
        if(index >= nodeChainList.size()){
            return;
        }
        NodeChain next = new NodeChain(nodeChainList,index + 1);
        NodeHandler nodeHandler = nodeChainList.get(index);
        nodeHandler.handler(next);
    }

    public void setClearFirst(Boolean b){
        clearFirst = b;
    }


    public static class Builder{
        private List<NodeHandler> nodeChainList = new ArrayList<>();
        private Boolean clearFirst = false;

        public Builder clearFirst(Boolean b){
            clearFirst = b;
            return this;
        }


        public Builder addNodeBean(@NotNull NodeHandler nodeHandler){
            nodeChainList.add(nodeHandler);
            return this;
        }

        public Builder addNodeBean(@NotNull Class<? extends NodeHandler> c){
            nodeChainList.add(BeanUtil.getBean(c));
            return this;
        }



        public NodeChain build(){
            NodeChain nodeChain = new NodeChain(nodeChainList,0);
            nodeChain.setClearFirst(clearFirst);
            return nodeChain;
        }
    }

}
