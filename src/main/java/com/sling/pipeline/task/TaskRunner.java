package com.sling.pipeline.task;

import com.sling.pipeline.dag.Node;

import java.util.Set;

/**
 * @author sunling.sl
 * @Description
 * @date 2020-05-29 下午4:11
 */
public class TaskRunner {

    public void submit(Set<Node> nodes) {
        nodes.forEach(this::submit);
    }

    public void submit(Node node){
        new Thread(){
            @Override
            public void run(){
                node.execute();
            }
        }.start();
    }


}
