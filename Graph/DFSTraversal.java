import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DFSTraversal {
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
            graph.putIfAbsent(node2, new ArrayList<Integer>());
            graph.get(node2).add(node1);
        }

        int visited[] = new int[10000];
        System.out.println(graph);
        System.out.print("DFS Traversal:");
        DFS(0, graph, visited);
    }

    private static void DFS(int node, Map<Integer, ArrayList<Integer>> graph, int visited[]) {
        System.out.print(" "+node);
        visited[node]=1;
        ArrayList<Integer> list=graph.get(node);

        for(Integer num: list){
            if(visited[num]==0){
                DFS(num, graph, visited);
            }
        }
    }
}
