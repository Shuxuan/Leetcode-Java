package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuxuannie on 7/12/16.
 *
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 */
public class NumConnectedComponentsInUndirectedGraph {

    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<>();
        public UnionFind(int n) {
            for (int i = 0; i < n; i++) {
                father.put(i, i);
            }
        }

        public int compressed_find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)){
                parent = father.get(parent);
            }

            int fa_x = father.get(x);
            while (fa_x != father.get(fa_x)) {
                int tmp = father.get(fa_x);
                father.put(fa_x, parent);
                fa_x = tmp;
            }

            return parent;
        }

        public void union(int x, int y) {
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if (fa_x != fa_y) {
                father.put(fa_x, fa_y);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        Set<Integer> fathers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int father = uf.compressed_find(i);
            if (!fathers.contains(father)) {
                fathers.add(father);
            }
        }

        return fathers.size();
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        int n = 5;
        NumConnectedComponentsInUndirectedGraph obj = new NumConnectedComponentsInUndirectedGraph();
        System.out.println(obj.countComponents(n, edges));
    }

}
