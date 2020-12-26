package Ch07;

// 边
public class Edge {
    // 边的权重
    public Integer weight;
    // 边的出发节点
    public Node from;
    // 边的指向节点
    public Node to;

    /**
     *
     * @param weight 权重
     * @param from from节点
     * @param to to节点
     */
    public Edge(Integer weight,Node from,Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
