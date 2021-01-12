package Ch07;

import java.util.HashMap;
import java.util.HashSet;

// 图
public class Graph {
    // 点集合，用Map的原因是因为Map根据Key找点方便
    public HashMap<Integer,Node> nodes;
    // 边集合
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
