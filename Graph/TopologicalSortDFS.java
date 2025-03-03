import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of nodes:");
        int num = sc.nextInt();

        LinkedList<ArrayList<Integer>> graph = new LinkedList();

        for (int i = 0; i < num; i++) {
            System.out.println("Enter number :");
            int nm = sc.nextInt();

            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nm; j++) {
                int tp = sc.nextInt();
                tmp.add(tp);
            }

            graph.add(tmp);
        }

        int visited[]=new int[num];

        Deque<Integer> deque=new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            if (visited[i]==0) {
                DFS(graph, deque, visited, i);
            }
        }

        System.out.println("Topological sort is: " + deque);
    }

    private static void DFS(LinkedList<ArrayList<Integer>> graph, Deque<Integer> deque, int visited[], int node) {
        visited[node]=1;
        for(Integer num: graph.get(node)){
            if(visited[num]==0){
                DFS(graph,deque, visited, num);
            }
        }

        deque.addFirst(node);
    }
}
