import java.util.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class RottingOranges {

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

        System.out.println("Minimum no. of seconds: " + orangesRotting(matrix));
    }

    private static int orangesRotting(int[][] matrix) {
        Queue<Pair> queue=new LinkedList<>();
        int ans=0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==2){
                    queue.add(new Pair(i, j));
                }
            }
        }

        while(!queue.isEmpty()){

            int size=queue.size();
            int temp=0;
            while(size>0){
                Pair tmp=queue.remove();
                matrix[tmp.x][tmp.y]=2;
                for(int i=0;i<4;i++){
                    int ii=tmp.x+dx[i];
                    int ij=tmp.y+dy[i];

                    if(ii<0 || ij<0 || ii>=matrix.length || ij>=matrix[0].length || matrix[ii][ij]!=1){
                        continue;
                    }

                    temp=1;
                    queue.add(new Pair(ii, ij));
                }
                size--;
            }
            ans=ans+temp;
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    ans=-1;
                }
            }
        }

        return ans;
    }
}
