import java.util.Scanner;

public class QuickSort {
    public static void main(){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size:");
        int s=sc.nextInt();

        int arr[]=new int[s];

        System.out.println("Enter array elements:");
        for(int i=0;i<s;i++){
            arr[i]=sc.nextInt();
        }
    }

    
}
