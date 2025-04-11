import java.util.*;
import java.util.Map.Entry;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Size:");
        int size=sc.nextInt();

        int arr[][]=new int[size][2];

        for(int i=0;i<size;i++){
            System.out.println("Enter first number:");
            arr[i][0]=sc.nextInt();

            System.out.println("Enter second number:");
            arr[i][1]=sc.nextInt();
            
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[0], b[0]));

        System.out.println("Sorted elements:");
        for(int i=0;i<size;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }

        int k=0;
        
        for(int i=1;i<size;i++){

            if(arr[k][1]>=arr[i][0]){
                arr[k][1]=Math.max(arr[k][1],arr[i][1]);
            }else{
                k++;
                arr[k]=arr[i];
            }

        }

        int ans[][]=Arrays.copyOfRange(arr, 0, k+1);

        System.out.println(Arrays.toString(ans));

        System.out.println("Answer is:");
        for (int j = 0; j < ans.length; j++) {
            System.out.println(ans[j][0] + " " + ans[j][1]);
        }
    }
}
