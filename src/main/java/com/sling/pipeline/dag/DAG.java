package com.sling.pipeline.dag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunling.sl
 * @Description
 * @date 2020-05-29 下午2:39
 */
public class DAG {
    private Set<Node> nodes;
    private Set<Edge> edges;

    /**
     * 根据edge维系的一个node到父节点的map
     */
    private Map<Node, Set<Node>> node2Parents;

    public DAG() {
        nodes = new HashSet<Node>(10);
        edges = new HashSet<Edge>(10);
        node2Parents = new HashMap<>(10);
    }

    /**
     * TODO 去掉synchronized，需要把addNode分布式
     */
    public synchronized void addNode(Node node) {
        for (Node tmp : nodes) {
            if (tmp.equals(node)) {
                throw new IllegalArgumentException();
            }
        }

        nodes.add(node);
    }

    /**
     * TODO 去掉synchronized，需要把addEdge分布式
     */
    public synchronized void addEdge(Edge edge) {
        // 1、判重
        for (Edge tmp : edges) {
            if (tmp.equals(edge)) {
                throw new IllegalArgumentException();
            }
        }
        // 2、去环
        // todo

        // 3、构造node2Parents
        if (!node2Parents.containsKey(edge.getTo())) {
            node2Parents.put(edge.getTo(), new HashSet<>());
        }
        node2Parents.get(edge.getTo()).add(edge.getFrom());

        edges.add(edge);
    }

    public Set<Node> getParentsByNode(Node node) {
        return node2Parents.get(node);
    }

    /**
     * 判断传入的node是否达到可执行状态
     *
     * @param node
     * @return
     */
    public boolean isReadToRun(Node node) {
        if(node.isRunning() || node.isSuccess() || node.isFailed()){
            return false;
        }
        Set<Node> nodes = getParentsByNode(node);
        if (nodes == null) {
            return true;
        }
        for (Node parent : nodes) {
            // 父节点没有跑、正在跑、跑失败
            if (parent.isInit() || parent.isRunning() || parent.isFailed()) {
                return false;
            }
        }
        return true;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }
}
