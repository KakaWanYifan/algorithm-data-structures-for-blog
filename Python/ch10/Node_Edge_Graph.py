class Node:
    def __init__(self, v):
        self.id = v
        self.in_size = 0
        self.out_size = 0
        self.nexts = []
        self.edges = []

    def __str__(self):
        return "Node{" + "id=" + str(self.id) + ", in_size =" + str(self.in_size) + ", out_size =" + str(self.out_size) + "}"


class Edge:
    def __init__(self, w, f, t):
        self.weight = w
        self.from_node = f
        self.to_node = t

    def __str__(self):
        return "Edge{" + "weight=" + str(self.weight) + ", from_node=" + str(self.from_node.id) + ", to=" + str(self.to_node.id) + "}"


class Graph:
    def __init__(self):
        self.nodes = dict()
        self.edges = set()
