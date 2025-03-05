import java.util.*;
import java.util.Scanner;

import javax.naming.LinkException;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class GeekVillageAndWells {

    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, -1, 0, 1 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter no of cols:");
        int cols = sc.nextInt();

        char matrix[][] = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter value for " + i + " and " + j);
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        int ans[][]=new int[rows][cols];
        chefAndWells(rows, cols, matrix, ans);

        System.out.println("Answer is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void chefAndWells(int rows, int cols, char[][] matrix, int ans[][]) {

        
        Queue<Pair> queue=new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]=='W'){
                    queue.add(new Pair(i, j));
                }
            }
        }

        int level=1;

        while(!queue.isEmpty()){
            int size=queue.size();

            while(size>0){
                Pair tmp=queue.remove();

                for(int i=0;i<4;i++){
                    int ii=tmp.x+dx[i];
                    int ij=tmp.y+dy[i];

                    if(ii>=0 && ij>=0 && ii<rows && ij<cols && (matrix[ii][ij]=='H' || matrix[ii][ij]=='.')){
                        ans[ii][ij]=level*2;
                        matrix[ii][ij]='N';
                        queue.add(new Pair(ii, ij));
                    }
                }
                size--;
            }

            level++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]=='H'){
                    ans[i][j]=-1;
                }
            }
        }
    }
}
