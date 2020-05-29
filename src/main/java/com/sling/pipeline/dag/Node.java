package com.sling.pipeline.dag;

import java.util.Objects;
import java.util.Random;

/**
 * @author sunling.sl
 * @Description
 * @date 2020-05-29 下午2:33
 */
public class Node {
    private Long id;
    private String name;
    /**
     * 0 未执行
     * 1 执行中
     * 2 执行成功
     * 3 执行失败
     */
    private int state;

    public Node(Long id, String name) {
        this.id = id;
        this.name = name;
        this.state = 0;
    }

    public boolean execute() {
        int sleeptime =  new Random().nextInt(10);
        System.out.println("Node id: [" + id + "], " + "node name: [" + name + "] is running. it will cost " + sleeptime +"s.");
        state = 1;

        try {
            // 随机睡觉
            Thread.sleep(1000 * sleeptime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Node id: [" + id + "], " + "node name: [" + name + "] run successfully");
        state = 2;
        return true;
    }

    public boolean isInit(){
        return state == 0;
    }

    public boolean isRunning(){
        return state == 1;
    }

    public boolean isSuccess(){
        return state == 2;
    }

    public boolean isFailed(){
        return state == 3;
    }

    public boolean isOver(){
        return isSuccess() || isFailed();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Node)) { return false; }
        Node node = (Node)o;
        return getId().equals(node.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "[Node id=" + id + ",name=" + name+"]";
    }

}
