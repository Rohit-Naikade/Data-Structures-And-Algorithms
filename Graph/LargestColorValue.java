import java.util.*;

public class LargestColorValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter colors:");
        String colors = sc.next();

        System.out.println("Enter Edge count:");
        int edgeCount = sc.nextInt();

        int u, v;
        int edges[][] = new int[edgeCount][2];
        for (int i = 0; i < edgeCount; i++) {
            System.out.println("Enter U:");
            u = sc.nextInt();
            System.out.println("Enter V:");
            v = sc.nextInt();
            edges[i][0] = u;
            edges[i][1] = v;
        }

        System.out.print("Largest Color Value: " + largestPathValue(colors, edges));
    }

    private static int largestPathValue(String colors, int[][] edges) {
        
        Map<Integer, ArrayList<Integer>> graph=new HashMap<>();
        Map<Integer, int[]> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();

        int indgree[]=new int[colors.length()];

        for(int i=0;i<colors.length();i++){
            graph.put(i, new ArrayList<>());
            map.put(i, new int[26]);
        }

        for(int i=0;i<edges.length;i++){
            graph.get(i).add(edges[i][1]);
            indgree[edges[i][1]]++;
        }

        int processed=0;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<indgree.length;i++){
            if(indgree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int tmp=queue.remove();
            processed++;
            int arr[]=map.get(tmp);
            arr[colors.charAt(tmp)-'a']++;
            max=Math.max(max,  arr[colors.charAt(tmp)-'a']);
            for(Integer num:graph.get(tmp)){
                indgree[num]--;
                if(indgree[num]==0){
                    queue.add(num);
                }

                int tmpArr[]=map.get(num);
                for(int i=0;i<26;i++){
                    tmpArr[i]=Math.max(arr[i],tmpArr[i]);
                }
            }

            
        }



        return processed==colors.length()?max:-1;
    }

}
