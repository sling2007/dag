# dag

本文实现的是一个单机版的DAG调度。

定时任务是软件开发中经常遇到的问题。简单的定时任务只需要在固定时间触发它的执行就可以了。
但是对于复杂的定时任务，可能是由多个任务组成一个任务组，它们之间存在依赖关系，一个任务执行的条件，必须是它的前置任务已经执行成功（或者没有前置任务），它才可以执行。
例如下面这幅图（有向无环图）：

# 构造一个DAG（有向无环图）如下： 

7依赖4、5

4依赖2

3依赖2

2依赖6、1

5依赖1

6无依赖

1无依赖


9依赖8

8无依赖


10无依赖

        6       1           8    10
          \   /   \         |
            2       5       9
          /   \     |
        3       4   |
                  \ |
                    7
这个任务关系图其实就是“有向无环图”（简称DAG）这种数据结构。

图是由一系列顶点和连接顶点的边组成的数据结构。它分为有向图和无向图。

有向图的边是有方向的，即A->B这条边和B->A是两条不同的边，而无向图中，A->B和B->A是共用一条边的。

基于这种数据结构，我们可以用图的顶点表示一个任务，而图的边表示任务之间的依赖关系，就可以基于有向无环图来实现任务调度。

        
# 实现
具体参照代码， 入口是com.sling.pipeline.client.Test
DAG中最主要的数据结构是Node和Edge

这里实现的是一个单机版的DAG调度。

实际场景中，必须做成分布式的。 可以考虑加入zk、redis、db等。

# 运行日志 

        
        {"nodes":[{"id":1,"name":"node1","state":0},{"id":2,"name":"node2","state":0},{"id":3,"name":"node3","state":0},{"id":4,"name":"node4","state":0},{"id":5,"name":"node5","state":0},{"id":6,"name":"node6","state":0},{"id":7,"name":"node7","state":0},{"id":8,"name":"node8","state":0},{"id":9,"name":"node9","state":0},{"id":10,"name":"node10","state":0}],"edges":[{"from":{"id":1,"name":"node1","state":0},"to":{"id":2,"name":"node2","state":0}},{"from":{"id":1,"name":"node1","state":0},"to":{"id":5,"name":"node5","state":0}},{"from":{"id":6,"name":"node6","state":0},"to":{"id":2,"name":"node2","state":0}},{"from":{"id":2,"name":"node2","state":0},"to":{"id":3,"name":"node3","state":0}},{"from":{"id":2,"name":"node2","state":0},"to":{"id":4,"name":"node4","state":0}},{"from":{"id":4,"name":"node4","state":0},"to":{"id":7,"name":"node7","state":0}},{"from":{"id":5,"name":"node5","state":0},"to":{"id":7,"name":"node7","state":0}},{"from":{"id":8,"name":"node8","state":0},"to":{"id":9,"name":"node9","state":0}}],"node2Parents":{"[Node id\u003d2,name\u003dnode2]":[{"id":1,"name":"node1","state":0},{"id":6,"name":"node6","state":0}],"[Node id\u003d5,name\u003dnode5]":[{"id":1,"name":"node1","state":0}],"[Node id\u003d3,name\u003dnode3]":[{"id":2,"name":"node2","state":0}],"[Node id\u003d4,name\u003dnode4]":[{"id":2,"name":"node2","state":0}],"[Node id\u003d7,name\u003dnode7]":[{"id":4,"name":"node4","state":0},{"id":5,"name":"node5","state":0}],"[Node id\u003d9,name\u003dnode9]":[{"id":8,"name":"node8","state":0}]}}
        
        =====ROUND+1=====
        Node id: [1], node name: [node1] is running. it will cost 4s.
        Node id: [10], node name: [node10] is running. it will cost 9s.
        Node id: [6], node name: [node6] is running. it will cost 3s.
        Node id: [8], node name: [node8] is running. it will cost 3s.
        =====ROUND+2=====
        =====ROUND+3=====
        Node id: [8], node name: [node8] run successfully
        =====ROUND+4=====
        Node id: [6], node name: [node6] run successfully
        Node id: [9], node name: [node9] is running. it will cost 0s.
        Node id: [9], node name: [node9] run successfully
        Node id: [1], node name: [node1] run successfully
        =====ROUND+5=====
        Node id: [2], node name: [node2] is running. it will cost 4s.
        Node id: [5], node name: [node5] is running. it will cost 4s.
        =====ROUND+6=====
        =====ROUND+7=====
        =====ROUND+8=====
        Node id: [5], node name: [node5] run successfully
        Node id: [2], node name: [node2] run successfully
        =====ROUND+9=====
        Node id: [3], node name: [node3] is running. it will cost 1s.
        Node id: [4], node name: [node4] is running. it will cost 3s.
        Node id: [10], node name: [node10] run successfully
        =====ROUND+10=====
        Node id: [3], node name: [node3] run successfully
        =====ROUND+11=====
        Node id: [4], node name: [node4] run successfully
        =====ROUND+12=====
        Node id: [7], node name: [node7] is running. it will cost 3s.
        =====ROUND+13=====
        =====ROUND+14=====
        Node id: [7], node name: [node7] run successfully
        =====ROUND+15=====
        =D=A=G=O=V=E=R=



