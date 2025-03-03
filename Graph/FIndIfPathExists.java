import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class FIndIfPathExists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int graph[][] = new int[10000][10000];

        System.out.println("Enter no of nodes:");
        int nodes = sc.nextInt();

        System.out.println("Enter no of edges:");
        int num = sc.nextInt();

        int node1, node2;
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Edge:");
            node1 = sc.nextInt();
            node2 = sc.nextInt();

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        System.out.println("Enter source:");
        int src = sc.nextInt();
        System.out.println("Enter destination:");
        int dest = sc.nextInt();

        System.out.println("If path exists: " + findPath(nodes, graph, src, dest));
    }

    private static boolean findPath(int nodes, int[][] graph, int source, int destination) {
        Queue<Integer> queue=new LinkedList();

        int visited[]=new int[10000];
        queue.add(source);

        while(!queue.isEmpty()){
            int num=queue.remove();
            visited[num]=1;

            for(int i=0;i<nodes;i++){
                int nm=graph[num][i];
                if(nm==1 && visited[i]==0){
                    queue.add(i);
                    visited[i]=1;
                }
            }
        }

        return visited[destination]==1;
    }
}
