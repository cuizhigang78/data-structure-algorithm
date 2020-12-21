package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Graph
 * @Author Maxwell
 * @Date 2020/12/19 20:46
 * @Description 图
 * @Version 1.0
 */
public class Graph {
    /** 顶点集合 */
    private ArrayList<String> vertexes;
    /** 图的邻结矩阵 */
    private int[][] edges;
    /** 边（两点之间的连线）的数目 */
    private int numOfEdges;
    /** 结点是否已访问 */
    private boolean[] isVisited;

    /**
     * 构造函数
     * @param n 顶点个数
     */
    public Graph(int n) {
        vertexes = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
    }

    /**
     * 增加顶点
     * @param vertex
     */
    public void addVertex(String vertex) {
        vertexes.add(vertex);
    }

    /**
     * 增加边
     * @param v1 顶点1的下标
     * @param v2 顶点2的下标
     */
    public void addEdge(int v1, int v2) {
        edges[v1][v2] = 1;
        edges[v2][v1] = 1;
        numOfEdges++;
    }

    /**
     * 打印图
     */
    public void printGraph() {
        System.out.print("   ");
        for (int i = 0; i < vertexes.size(); i++) {
            if (i == vertexes.size() - 1) {
                System.out.println(vertexes.get(i));
            } else {
                System.out.print(vertexes.get(i) + "  ");
            }
        }
        for (int i = 0; i < edges.length; i++) {
            System.out.println(vertexes.get(i) + " " + Arrays.toString(edges[i]));
        }
    }

    /**
     * 获取边数目
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 获取顶点个数
     * @return
     */
    public int getNumOfVertex() {
        return vertexes.size();
    }

    /**
     *
     * 1. 访问初始结点v，并标记结点v为已访问
     * 2. 查找v的第一个邻接结点w
     * 3. 若w存在，则继续执行步骤4，否则回到第1步，将v的下一个结点作为v继续
     * 4. 若w未被访问，则对w进行深度优先遍历递归（即把w作为v，进行步骤123）
     * 5. 否则查找v的邻接结点中在w之后的下一个，转到步骤3
     */
    private void dfs(boolean[] isVisited, int v) {
        // 访问结点，输出
        System.out.print(vertexes.get(v) + "->");
        // 将结点置为已访问
        isVisited[v] = true;
        // 查找结点v的第一个邻接点w
        int w = getFirstNeighbor(v);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            } else {
                w = getNextNeighbor(v, w);
            }
        }
    }

    /**
     * 深度优先遍历（depth first search）
     */
    public void dfs() {
        /**
         * 为了防止出现有孤立点而无法被访问到的情况
         * 所以遍历所有结点
         */
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    /**
     * 获取v的第一个邻接结点(-1表示不存在)
     * @param v
     * @return
     */
    private int getFirstNeighbor(int v) {
        for (int i = 0; i < vertexes.size(); i++) {
            if (edges[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取v的邻接结点中，在w之后的第一个邻接结点(-1表示不存在)
     * @param v
     * @return
     */
    private int getNextNeighbor(int v, int w) {
        for (int i = w + 1; i < vertexes.size(); i++) {
            if (edges[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }

}
