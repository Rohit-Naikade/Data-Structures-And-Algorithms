import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import java.util.*;

class Cell{
    int x,y;
    public Cell(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class ZeroOneMatrix {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};

    public static void main(String args[]){
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

        updateMatrix(matrix);
    }

    public static void updateMatrix(int mat[][]){
        Map<Integer, List<Integer>> graph=new HashMap<>();
        Queue<Cell> queue=new LinkedList();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    queue.add(new Cell(i, j));
                }
                
            }
        }

        System.out.println("Reached 1:"+queue.size());
        int level=1;
        int ans[][]=new int[mat.length][mat[0].length];

        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                Cell cell=queue.remove();

                for(int i=0;i<4;i++){
                    int ii=cell.x+dx[i];
                    int ij=cell.y+dy[i];

                    if(ii>=0 && ij>=0 && ii <mat.length && ij<mat[0].length && mat[ii][ij]==1){
                        if(ans[ii][ij]==0){
                            ans[ii][ij]=level;
                        }
                        //System.out.println(ii+" "+ij);
                        mat[ii][ij]=0;
                        queue.add(new Cell(ii,ij));
                    }
                }
                size--;
            }
            level++;
        }
        System.out.println("Reached 2");
        System.out.println("The answer is:");
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
