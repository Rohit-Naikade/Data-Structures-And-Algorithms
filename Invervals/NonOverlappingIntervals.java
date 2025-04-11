import java.util.*;

public class NonOverlappingIntervals{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size:");
        int size=sc.nextInt();

        int arr[][]=new int[size][2];

        for(int i=0;i<size;i++){
            System.out.println("Enter first number:");
            arr[i][0]=sc.nextInt();
            System.out.println("Enter second number:");
            arr[i][1]=sc.nextInt();
        }

        Arrays.sort(arr, (a,b)->Integer.compare(a[0], b[0]));
        System.out.println("elements:");

        for(int i=0;i<size;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }

        int result=0;

        int prev[]=arr[0];

        for(int i=1;i<size;i++){

            int curr[]=arr[i];

            if(isOverLap(prev, curr)){
                result++;
            }

            prev=curr;

        }

        System.out.println("Result:"+result);
    }

    static boolean isOverLap(int prev[], int curr[]){
        if(curr[0]>=prev[1]){
            return false;
        }
        return true;
    }
}