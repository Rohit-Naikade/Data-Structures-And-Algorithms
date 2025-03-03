import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestCycle {

    public static int longCycle = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of nodes:");
        int num = sc.nextInt();

        int edges[] = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter Edge from :"+i);
            edges[i] = sc.nextInt();
        }

        int visited[] = new int[num];
        int currPath[] = new int[num];

        for (int i = 0; i < num; i++) {
            if (visited[i] == 0) {
                detectCycle(edges, visited, currPath, i, 0);
            }
        }

        System.out.println("Longest cycle is: "+longCycle);
    }

    private static void detectCycle(int[] edges, int[] visited, int[] currPath, int node, int cnt) {
        cnt++;
        visited[node]=1;
        currPath[node]=cnt;

        if(edges[node]!=-1){
            int tmp=edges[node];
            if(visited[tmp]==0){
                detectCycle(edges, visited, currPath, tmp, cnt);
            }else if(currPath[tmp]!=0){
                System.out.println(node+" "+tmp+" "+longCycle);
                int diff=Math.abs(currPath[node]-currPath[tmp])+1;
                longCycle=Math.max(longCycle, diff);
            }
        }
        currPath[node]=0;
    }
}
