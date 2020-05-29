# dag


{"nodes":[{"id":1,"name":"node1","state":0},{"id":2,"name":"node2","state":0},{"id":3,"name":"node3","state":0},{"id":4,"name":"node4","state":0},{"id":5,"name":"node5","state":0},{"id":6,"name":"node6","state":0},{"id":7,"name":"node7","state":0}],"edges":[{"from":{"id":1,"name":"node1","state":0},"to":{"id":2,"name":"node2","state":0}},{"from":{"id":1,"name":"node1","state":0},"to":{"id":5,"name":"node5","state":0}},{"from":{"id":6,"name":"node6","state":0},"to":{"id":2,"name":"node2","state":0}},{"from":{"id":2,"name":"node2","state":0},"to":{"id":3,"name":"node3","state":0}},{"from":{"id":2,"name":"node2","state":0},"to":{"id":4,"name":"node4","state":0}},{"from":{"id":4,"name":"node4","state":0},"to":{"id":7,"name":"node7","state":0}},{"from":{"id":5,"name":"node5","state":0},"to":{"id":7,"name":"node7","state":0}}],"node2Parents":{"[Node id\u003d2,name\u003dnode2]":[{"id":1,"name":"node1","state":0},{"id":6,"name":"node6","state":0}],"[Node id\u003d5,name\u003dnode5]":[{"id":1,"name":"node1","state":0}],"[Node id\u003d3,name\u003dnode3]":[{"id":2,"name":"node2","state":0}],"[Node id\u003d4,name\u003dnode4]":[{"id":2,"name":"node2","state":0}],"[Node id\u003d7,name\u003dnode7]":[{"id":4,"name":"node4","state":0},{"id":5,"name":"node5","state":0}]}}


=====D=A=G=====

Node id: [6], node name: [node6] is running. it will cost 8s.
Node id: [1], node name: [node1] is running. it will cost 4s.
=====D=A=G=====
=====D=A=G=====
=====D=A=G=====
Node id: [1], node name: [node1] run successfully
=====D=A=G=====
Node id: [5], node name: [node5] is running. it will cost 1s.
=====D=A=G=====
Node id: [5], node name: [node5] run successfully
=====D=A=G=====
=====D=A=G=====
Node id: [6], node name: [node6] run successfully
=====D=A=G=====
Node id: [2], node name: [node2] is running. it will cost 3s.
=====D=A=G=====
=====D=A=G=====
Node id: [2], node name: [node2] run successfully
=====D=A=G=====
Node id: [3], node name: [node3] is running. it will cost 1s.
Node id: [4], node name: [node4] is running. it will cost 7s.
=====D=A=G=====
Node id: [3], node name: [node3] run successfully
=====D=A=G=====
=====D=A=G=====
=====D=A=G=====
=====D=A=G=====
=====D=A=G=====
Node id: [4], node name: [node4] run successfully
=====D=A=G=====
Node id: [7], node name: [node7] is running. it will cost 5s.
=====D=A=G=====
=====D=A=G=====
=====D=A=G=====
=====D=A=G=====
Node id: [7], node name: [node7] run successfully
=====D=A=G=====
=D=A=G=O=V=E=R=
