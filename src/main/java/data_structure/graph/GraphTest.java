package data_structure.graph;

/**
 * @ClassName GraphTest
 * @Author Maxwell
 * @Date 2020/12/19 21:17
 * @Description GraphTest
 * @Version 1.0
 */
public class GraphTest {

    public static void main(String[] args) {
        /** 顶点集合 */
        String[] vertexes = {"A", "B", "C", "D", "E"};
        /** 初始化图 */
        Graph graph = new Graph(vertexes.length);
        /** 插入顶点 */
        for (String vertex : vertexes) {
            graph.addVertex(vertex);
        }
        /**
         * 插入边
         * A-B
         * A-C
         * B-C
         * B-D
         * B-E
         */
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

         graph.printGraph();
        // System.out.println("该图的顶点数：" + graph.getNumOfVertex());
        // System.out.println("该图的边数：" + graph.getNumOfEdges());

        graph.dfs();
    }

}