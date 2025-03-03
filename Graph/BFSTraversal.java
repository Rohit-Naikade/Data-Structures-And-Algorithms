import java.util.*;

public class BFSTraversal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Map<Integer, ArrayList<Integer>> graph=new LinkedHashMap<>();

        System.out.println("Enter no of edges:");
        int num=sc.nextInt();

        int node1,node2;
        for(int i=0;i<num;i++){
            System.out.println("Enter Edge:");
            node1=sc.nextInt();
            node2=sc.nextInt();

            graph.putIfAbsent(node1, new ArrayList<Integer>());
            graph.get(node1).add(node2);
            graph.putIfAbsent(node2, new ArrayList<Integer>());
            graph.get(node2).add(node1);
        }

        System.out.println(graph);
        BFS(graph);

    }

    public static void BFS(Map<Integer, ArrayList<Integer>> graph){
        Queue<Integer> queue=new LinkedList<>();

        int visited[]=new int[1000];
        Arrays.fill(visited,0);
        int root=graph.entrySet().iterator().next().getKey();
        System.out.println("BFS Traversal:");
        queue.add(root);
        visited[root]=1;

        while(!queue.isEmpty()){
            int temp=queue.remove();
            System.out.print(" "+temp);
            visited[temp]=1;
            ArrayList<Integer> list= graph.get(temp);
            //System.out.println(list);
            for(int num: list){
                
                if(visited[num]==0){
                    queue.add(num);
                    visited[num]=1;
                }
            }
            //System.out.println(queue);
        }

    }
}
