import java.util.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class FloodFillTraversals {

    static int dx[]={-1, 0, 1, 0};
    static int dy[]={0, -1, 0, 1};
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
        System.out.println("Enter no of source row:");
        int srcRow = sc.nextInt();
        System.out.println("Enter no of source column:");
        int srcCol = sc.nextInt();
        System.out.println("Enter color:");
        int color = sc.nextInt();

        int orgColor = matrix[srcRow][srcCol];

        if(matrix[srcRow][srcCol]!=color){
            BFS(srcRow, srcCol, rows, cols, orgColor, color, matrix);
        }
       
        System.out.println("Matrix after flood fill:");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println(" ");
        }

    }

    private static void BFS(int srcRow, int srcCol, int rows, int cols, int orgColor, int color, int[][] matrix) {

        Queue<Pair> queue=new LinkedList<>();

        queue.add(new Pair(srcRow, srcCol));

        while(!queue.isEmpty()){
            Pair tmp=queue.remove();
            matrix[tmp.x][tmp.y]=color;
            for(int i=0;i<4;i++){
                int ii=tmp.x+dx[i];
                int ij=tmp.y+dy[i];
                if(ii<0 || ij<0 || ii>=rows || ij>=cols || matrix[ii][ij]!=orgColor){
                    continue;
                }

                
                queue.add(new Pair(ii, ij));
            }
        }        
    }

    private static void DFS(int srcRow, int srcCol, int rows, int cols, int orgColor, int color, int[][] matrix) {
        if(srcRow<0 || srcCol<0 || srcRow>=rows || srcCol>=cols || matrix[srcRow][srcCol]!=orgColor){
            return;
        }

        matrix[srcRow][srcCol]=color;

        for(int i=0;i<4;i++){
            int ii=srcRow+dx[i];
            int ij=srcCol+dy[i];

            DFS(ii, ij, rows, cols, orgColor, color, matrix);
        }
    }
}
