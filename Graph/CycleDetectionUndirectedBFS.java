import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.*;
import java.util.Scanner;

public class CycleDetectionUndirectedBFS {
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
        int parent[] = new int[graph.size()];
        Arrays.fill(parent, -1);
        boolean res = false;
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i] == 0) {
                res = detectCycle(graph, parent, i, visited);
                if (res)
                    break;
            }

        }

        System.out.println("is cycle present? " + res);
    }

    private static boolean detectCycle(Map<Integer, ArrayList<Integer>> graph, int[] parent, int node, int[] visited) {
        Queue<Integer> queue=new LinkedList();
        queue.add(node);
        visited[node]=1;

        while(!queue.isEmpty()){
            int tmp=queue.remove();

            for(Integer num: graph.get(tmp)){
                if(visited[num]==0){
                    queue.add(num);
                    visited[num]=1;
                    parent[num]=tmp;
                }else if(parent[tmp]==num){
                    return true;
                }
            }
        }
        return false;
    }
}
