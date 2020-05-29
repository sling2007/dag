package com.sling.pipeline.client;

import com.google.gson.Gson;
import com.sling.pipeline.dag.DAG;
import com.sling.pipeline.dag.Edge;
import com.sling.pipeline.dag.Node;
import com.sling.pipeline.schedue.Scheduler;

/**
 * @author sunling.sl
 * @Description
 * @date 2020-05-29 下午2:33
 */
public class Test {
    static private Gson GSON = new Gson();

    public static void main(String[] args) throws InterruptedException {
        DAG dag = new DAG();
        // init node
        Node node1 = new Node(1L, "node1");
        Node node2 = new Node(2L, "node2");
        Node node3 = new Node(3L, "node3");
        Node node4 = new Node(4L, "node4");
        Node node5 = new Node(5L, "node5");
        Node node6 = new Node(6L, "node6");
        Node node7 = new Node(7L, "node7");
        dag.addNode(node1);
        dag.addNode(node2);
        dag.addNode(node3);
        dag.addNode(node4);
        dag.addNode(node5);
        dag.addNode(node6);
        dag.addNode(node7);
        // init edge
        dag.addEdge(new Edge(node1, node2));
        dag.addEdge(new Edge(node1, node5));
        dag.addEdge(new Edge(node6, node2));
        dag.addEdge(new Edge(node2, node3));
        dag.addEdge(new Edge(node2, node4));
        dag.addEdge(new Edge(node4, node7));
        dag.addEdge(new Edge(node5, node7));

        System.out.println(GSON.toJson(dag));

        Scheduler scheduler = new Scheduler();
        scheduler.schedule(dag);

    }
}
