import java.util.*;

class NoOfProvinces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows:");
        int rows = sc.nextInt();

        System.out.println("Enter cols:");
        int cols = sc.nextInt();

        int matrix[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter value for " + i + " and" + j);
                matrix[i][j] = sc.nextInt();
            }
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    graph.putIfAbsent(i + 1, new ArrayList<>());
                    if (i != j) {
                        graph.get(i + 1).add(j + 1);
                    }
                }
            }
        }
        int visited[] = new int[rows];
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            if (visited[i] == 0) {
                DFS(graph, visited, i);
                cnt++;
            }
        }
        System.out.println(graph);
         System.out.println("Number of provinces are:"+cnt);
    }

    private static void DFS(Map<Integer, List<Integer>> graph, int[] visited, int root) {
        visited[root]=1;

        for(Integer num: graph.get(root+1)){
            if(visited[num-1]==0){
                DFS(graph, visited, num-1);
            }
        }
    }
}