import java.util.*;

public class NoOfOpsToConnectNetwork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter no of nodes:");
        int nodes = sc.nextInt();

        int matrix[][] = new int[rows][2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Enter value for " + i + " and " + j);
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("No. of min. connections: " + makeConnected(nodes, matrix));
    }

    private static int makeConnected(int nodes, int[][] matrix) {

        if (matrix.length < nodes - 1) {
            return -1;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<nodes;i++){
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 0; i < matrix.length; i++) {

            graph.get(matrix[i][0]).add(matrix[i][1]);
            graph.get(matrix[i][1]).add(matrix[i][0]);

        }

        int visited[] = new int[nodes];
        int count = 0;
        for (int i = 0; i < nodes; i++) {
            if (visited[i] == 0) {
                DFS(i, graph, visited);
                count++;
            }
        }
        return count - 1;
    }

    private static void DFS(int node, Map<Integer, List<Integer>> graph, int visited[]) {
        visited[node]=1;

        for(Integer num: graph.get(node)){
            if(visited[num]==0){
                DFS(num, graph, visited);
            }
        }
    }
}
