import java.util.Arrays;
import java.util.Scanner;

public class InsertInterval {
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

        System.out.println("Enter new interval:");
        int newInterval[]=new int[2];
        System.out.println("[interval] Enter first number:");
        newInterval[0]=sc.nextInt();

        System.out.println("[interval] Enter second number:");
        newInterval[1]=sc.nextInt();
        size=size+1;
        int finalArr[][]=new int[size][2];
        System.out.println(finalArr.length);
        for (int i = 0; i < size - 1; i++) {
            finalArr[i] = arr[i];
        }
        finalArr[size-1][0]=newInterval[0];
        finalArr[size-1][1]=newInterval[1];

        Arrays.sort(finalArr,(a,b)->Integer.compare(a[0], b[0]));

        System.out.println("Sorted elements:");
        for(int i=0;i<size;i++){
            System.out.println(finalArr[i][0]+" "+finalArr[i][1]);
        }

        int k=0;
        
        for(int i=1;i<size;i++){

            if(finalArr[k][1]>=finalArr[i][0]){
                finalArr[k][1]=Math.max(finalArr[k][1],finalArr[i][1]);
            }else{
                k++;
                finalArr[k]=finalArr[i];
            }

        }

        int ans[][]=Arrays.copyOfRange(finalArr, 0, k+1);

        System.out.println("Answer is:");
        for (int j = 0; j < ans.length; j++) {
            System.out.println(ans[j][0] + " " + ans[j][1]);
        }
    }
}
