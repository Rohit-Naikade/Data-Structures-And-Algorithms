import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ReorderROutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, ArrayList<Integer>> graph = new LinkedHashMap<>();

        System.out.println("Enter no of Nodes:");
        int nodes = sc.nextInt();

        int visited[]=new int[nodes];

        System.out.println("Enter no of edges:");
        int num = sc.nextInt();

        Map<Integer, ArrayList<Integer>> forward = new LinkedHashMap();
        Map<Integer, ArrayList<Integer>> backward = new LinkedHashMap();

        int node1, node2;
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Edge:");
            node1 = sc.nextInt();
            node2 = sc.nextInt();

            forward.putIfAbsent(node1, new ArrayList<>());
            forward.get(node1).add(node2);
            backward.putIfAbsent(node2, new ArrayList<>());
            backward.get(node2).add(node1);

        }

        System.out.println(forward);
        System.out.println(backward);
        int ans[] = {0};
        DFS(0, ans, forward, backward, visited);
        System.out.println("Minimum reorders required: " + ans[0]);
    }

    private static void DFS(int node, int ans[], Map<Integer, ArrayList<Integer>> forward,
            Map<Integer, ArrayList<Integer>> backward, int visited[]) {
        visited[node]=1;
        System.out.println("Visited: "+node);
        if(forward.containsKey(node))
        for(Integer num: forward.get(node)){
            if(visited[num]==0){
                System.out.println("Forward: "+ num);
                ans[0]++;
                DFS(num, ans, forward, backward, visited);
            }
        }

        if(backward.containsKey(node))
        for(Integer num: backward.get(node)){
            if(visited[num]==0){
                System.out.println("Backward: "+ num);
                DFS(num, ans, forward, backward, visited);
            }
        }

     
    }
}
