import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DetectCycleUndirected {
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

        System.out.println(graph);

        int visited[] = new int[graph.size()];

        boolean res = false;
        for (int i = 0; i < graph.size(); i++) {
            if(visited[i]==0){
                res = detectCycle(graph,i,  -1, visited);
                if(res) break;
            }
            
        }

        System.out.println("is cycle present? "+res);

    }

    private static boolean detectCycle(Map<Integer, ArrayList<Integer>> graph,int node, int parent, int[] visited) {
        visited[node]=1;
        boolean ans=false;
        for(Integer num: graph.get(node)){
            if(visited[num]==0){
                ans=detectCycle(graph, num, node, visited);
                if(ans) return true;
            }else if(visited[num]==1 && num!=parent){
                System.out.println(node+" "+num+" "+parent);
                return true;
            }
        }
        return false;
    }
}
