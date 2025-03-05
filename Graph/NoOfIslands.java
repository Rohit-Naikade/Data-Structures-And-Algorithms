import java.util.Scanner;

public class NoOfIslands {
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter no of cols:");
        int cols = sc.nextInt();

        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter value for " + i + " and " + j);
                matrix[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    DFS(i, j, rows, cols, matrix);
                    cnt++;
                }
            } 
        }

        System.out.println("Number of Islands are: " + cnt);

    }

    private static void DFS(int sr, int sc, int rows, int cols, int[][] matrix) {
        if(sr<0 || sc<0 || sr>=rows || sc>=cols || matrix[sr][sc]!=1){
            return;
        }
        matrix[sr][sc]=2;
        for(int i=0;i<4;i++){
            int ii=sr+dx[i];
            int ij=sc+dy[i];

            DFS(ii, ij, rows, cols, matrix);
        }
    }
}
