import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectionDirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, ArrayList<Integer>> graph = new LinkedHashMap<>();

        System.out.println("Enter no of edges:");
        int num = sc.nextInt();

        int node1, node2;
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Edge:");
            node1 = sc.nextInt();
            node2 = sc.nextInt();

            graph.putIfAbsent(node1, new ArrayList<Integer>());
            graph.get(node1).add(node2);
        }

        System.out.println(graph);

        int visited[] = new int[100000];
        int currPath[] = new int[100000];

        boolean res = false;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                res = detectCycle(graph, currPath, i, visited);
                if (res)
                    break;
            }

        }

        System.out.println("is cycle present? " + res);
    }

    private static boolean detectCycle(Map<Integer, ArrayList<Integer>> graph, int[] currPath, int node,
            int[] visited) {

        visited[node] = 1;
        currPath[node] = 1;
        for (Integer num : graph.get(node)) {
            if (visited[num] == 0) {
                //visited[num] = 1;
                //currPath[num] = 1;
                boolean res=detectCycle(graph, currPath, num, visited);
                if(res) return true;

            } else if (currPath[num] == 1) {
                return true;
            }
        }

        currPath[node]=0;
        return false;
    }
}
