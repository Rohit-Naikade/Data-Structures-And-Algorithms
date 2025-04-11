import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CrsSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Courses:");
        int size = sc.nextInt();

        System.out.println("Enter Edge count:");
        int edges = sc.nextInt();

        int u, v;
        Map<Integer, List<Integer>> graph=new HashMap<>();
        int visited[]=new int[size];
        int currPath[]=new int[size];
        int courses[][] = new int[edges][2];
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter U:");
            u = sc.nextInt();
            System.out.println("Enter V:");
            v = sc.nextInt();
            courses[i][0] = u;
            courses[i][1] = v;
        }

        for(int i=0;i<edges;i++){
            graph.putIfAbsent(courses[i][1], new ArrayList<>());
            graph.get(courses[i][1]).add(courses[i][0]);

        }

        System.out.println(graph);


        boolean hasCycle=false;
        for(int i=0;i<size;i++){
            if(visited[i]==0){
                hasCycle=findOrder(graph, i, visited, currPath);
                if(hasCycle){
                    break;
                }
            }
        }

          System.out.println("Result is: "+ hasCycle);
      }

        

    public static boolean findOrder(Map<Integer, List<Integer>> graph, int node, int visited[], int currPath[]){
        System.out.println("Executed"+node);
        visited[node]=1;
        currPath[node]=1;

        boolean hasCycle=false;
        if(!graph.containsKey(node)){
            currPath[node]=0;
            return false;
        }
        for(int num: graph.get(node)){
            if(visited[num]==0){
                hasCycle=findOrder(graph, num, visited, currPath);
                if(hasCycle){
                    return true;
                }
            }else if(currPath[num]==1){
                return true;
            }
        }

        currPath[node]=0;
        return false;
    }
}
