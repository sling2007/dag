package com.sling.pipeline.dag;

import java.util.Objects;

/**
 * @author sunling.sl
 * @Description
 * @date 2020-05-29 下午2:33
 */
public class Edge {
    private Node from;
    private Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Edge)) { return false; }
        Edge edge = (Edge)o;
        return getFrom().equals(edge.getFrom()) && getTo().equals(edge.getTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo());
    }

    @Override
    public String toString() {
        return "[Edge from = " + from + ", to = " + to + "]";
    }
}
