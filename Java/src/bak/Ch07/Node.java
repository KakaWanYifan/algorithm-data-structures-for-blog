package bak.Ch07;

import java.util.ArrayList;

// 点
public class Node {
    // id 节点的唯一标示
    public Integer id;
    // 入度 指向该节点的边的数量
    public Integer in;
    // 出度 从该节点出发的边的数量，也是nexts的size
    public Integer out;
    // 从该节点出发的边数，指向所有节点 next
    public ArrayList<Node> nexts;
    // 从该节点出发的边
    public ArrayList<Edge> edges;

    /**
     *
     * @param id 节点的ID
     */
    public Node(Integer id){
        this.id = id;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
