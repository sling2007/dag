package com.sling.pipeline.schedue;

import com.sling.pipeline.dag.DAG;
import com.sling.pipeline.dag.Node;
import com.sling.pipeline.task.TaskRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author sunling.sl
 * @Description
 * @date 2020-05-29 下午3:19
 */
public class Scheduler {

    public void schedule(DAG dag) throws InterruptedException {
        TaskRunner runner = new TaskRunner();
        int index = 1;
        while (true) {
            System.out.println("=====ROUND+" + (index++) + "=====");

            Optional<Node> opt = dag.getNodes().stream().filter(node -> !node.isOver()).findFirst();
            if (!opt.isPresent()) {
                System.out.println("=D=A=G=O=V=E=R=");
                break;
            }

            Set<Node> todoList4ThisRound = new HashSet<>();
            for (Node node : dag.getNodes()) {
                if (dag.isReadToRun(node)) {
                    todoList4ThisRound.add(node);
                }
            }

            runner.submit(todoList4ThisRound);
            Thread.sleep(1000);
        }

    }
}
