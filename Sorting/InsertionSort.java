import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size:");
        int s=sc.nextInt();

        int arr[]=new int[s];

        System.out.println("Enter array elements:");
        for(int i=0;i<s;i++){
            arr[i]=sc.nextInt();
        }

        int min=0,j=0,tmp=0;
        for(int i=1;i<s;i++){
            min=i;
            j=i-1;
            while(j>=0){
                if(arr[j]>arr[min]){
                    tmp=arr[j];
                    arr[j]=arr[min];
                    arr[min]=tmp;
                }
                min=j;
                j--;
            }
        }

        System.out.println("Sorted Elements:");

        for(int i=0;i<s;i++){
           System.out.print(arr[i]+" ");
        }
    }
}
