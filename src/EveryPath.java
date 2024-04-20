import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EveryPath {
    private static final int PATH_WEIGHT = 5;
    private int vertices;
    private List<Map<Integer, Integer>> adjList;

    public EveryPath(int vertices) {
        this.vertices = vertices;
        initAdjList();
    }

    private void initAdjList() {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new HashMap<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).put(v, weight);
    }

    public void printAllPaths(int u, int w) {
        boolean[] isVisited = new boolean[vertices];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(u);
        findAllSimplePaths(u, w, isVisited, pathList, 0);
    }

    private void findAllSimplePaths(Integer u, Integer w, boolean[] isVisited, List<Integer> localPathList, int currentWeight) {
        isVisited[u] = true;

        if (u.equals(w) && currentWeight == PATH_WEIGHT) {
            for (int vertex : localPathList) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        } else {
            for (Map.Entry<Integer, Integer> entry : adjList.get(u).entrySet()) {
                Integer i = entry.getKey();
                Integer weight = entry.getValue();

                if (!isVisited[i] && currentWeight + weight <= PATH_WEIGHT) {
                    localPathList.add(i);
                    findAllSimplePaths(i, w, isVisited, localPathList, currentWeight + weight);
                    localPathList.remove(localPathList.size() - 1);
                }
            }
        }

        isVisited[u] = false;
    }

    public static void main(String[] args) {
        EveryPath g = new EveryPath(6);

        //g.addEdge(u, v, weight);
        g.addEdge(0, 1, 2);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 4, 1);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 4, 2);

        //Vertices (u, w)
        g.printAllPaths(0, 4);
    }
}
