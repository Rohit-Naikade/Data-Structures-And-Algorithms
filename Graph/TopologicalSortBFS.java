import java.util.*;

public class TopologicalSortBFS {
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

        int degree[] = new int[num];

        for (int i = 0; i < num; i++) {
            for (Integer tp : graph.get(i)) {
                degree[tp]++;
            }
        }

        System.out.println("Topological sort is: " + BFS(graph, degree));
    }

    private static ArrayList<Integer> BFS(LinkedList<ArrayList<Integer>> graph, int[] degree) {
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int num=queue.remove();
            result.add(num);
            for(Integer tmp: graph.get(num)){
                degree[tmp]--;
                if(degree[tmp]==0){
                    queue.add(tmp);
                }
            }
        }


        return result;
    }
}
