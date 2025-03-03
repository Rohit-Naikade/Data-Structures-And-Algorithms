import java.util.Scanner;

public class BubbleSort{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size:");
        int s=sc.nextInt();

        int arr[]=new int[s];

        System.out.println("Enter array elements:");
        for(int i=0;i<s;i++){
            arr[i]=sc.nextInt();
        }

        int tmp=0;

        for(int i=0;i<s-1;i++){
            for(int j=i+1;j<s;j++){
                if(arr[i]>arr[j]){
                    tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }

            }
        }

        System.out.println("Sorted Elements:");

        for(int i=0;i<s;i++){
           System.out.print(arr[i]+" ");
        }

    }
}