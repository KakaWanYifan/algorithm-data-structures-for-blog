package Ch07;

// 转换器
public class Converter {

    /**
     * 把矩阵结构的图转换成我们自己的图
     * @param matrix 矩阵
     * @return 转后后的图
     */
    public static Graph fromMatrixToGraph(Integer[][] matrix){
        // 初始化图
        Graph graph = new Graph();
        // 遍历矩阵的行
        for (int i = 0; i < matrix.length; i++) {
            // 第一个数代表权重
            Integer weight = matrix[i][0];
            // 第二个数代表from节点的Id
            Integer fromId = matrix[i][1];
            // 第三个数代表to节点的Id
            Integer toId = matrix[i][2];
            // 如果图不包含fromId的节点，即这个节点从来没出现过
            if (!graph.nodes.containsKey(fromId)){
                // 把节点添加到图中
                Node node = new Node(fromId);
                graph.nodes.put(fromId,node);
            }
            // 如果图中不包含toId的节点，即这个节点从来没出现过
            if (!graph.nodes.containsKey(toId)){
                // 把节点添加到图中
                Node node = new Node(fromId);
                graph.nodes.put(toId,node);
            }
            // 遍历的这一行的fromNode
            Node fromNode = graph.nodes.get(fromId);
            // 遍历的这一行的toNode
            Node toNode = graph.nodes.get(toId);
            // 实例化边
            Edge edge = new Edge(weight,fromNode,toNode);

            // fromNode的出度加一
            fromNode.out++;
            // toNode的入度加一
            toNode.in++;
            // fromNode的nexts增加一个节点
            fromNode.nexts.add(toNode);
            // 从fromNode出发的边新增一个
            fromNode.edges.add(edge);
            // 图新增一条边
            graph.edges.add(edge);
        }
        return graph;
    }
}
