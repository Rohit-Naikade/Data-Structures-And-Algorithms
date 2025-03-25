import java.util.*;

public class courseSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Courses:");
        int size = sc.nextInt();

        System.out.println("Enter Edge count:");
        int edges = sc.nextInt();

        int u, v;
        List<List<Integer>> graph=new ArrayList<>();

        int courses[][] = new int[size][2];
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter U:");
            u = sc.nextInt();
            System.out.println("Enter V:");
            v = sc.nextInt();
            courses[i][0] = u;
            courses[i][1] = v;
        }

        for(int i=0;i<courses.length;i++){
            list.putIfAbsent(courses[i][1], new ArrayList<>());
            list.get(courses[i][1]).add(courses[i][0]);

        }

        System.out.println(list);

        // int result[] = findOrder(size, courses);

        // System.out.println("Result is: ");
        // for (int i = 0; i < result.length; i++) {
        //     System.out.print(result[i] + " ");
        // }

    }

    private static int[] findOrder(int size, int[][] courses) {
        int degree[]=new int[size];
        int result[]=new int[size];

        int cnt =0;
        Map<Integer, ArrayList<Integer>> graph=new HashMap<>();
        for(int i=0; i<size; i++){
            graph.putIfAbsent(i, new ArrayList<>());
            graph.get(courses[i][1]).add(i);
        }

        System.out.println("Graph: "+graph);
        for(int i=0; i<graph.size(); i++){
           for(Integer num: graph.get(i)){
                degree[num]++;
           }
        }

        Queue<Integer> queue=new LinkedList();

        for(int i=0; i<size; i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int num=queue.remove();
            result[cnt]=num;
            cnt++;
            for(int tmp: graph.get(num)){
                degree[tmp]--;
                if(degree[tmp]==0){
                    queue.add(tmp);
                }
            }
        }
        return result;

    }
}
