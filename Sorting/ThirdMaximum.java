import java.util.Scanner;

public class ThirdMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int s = sc.nextInt();

        int arr[] = new int[s];

        System.out.println("Enter array elements:");
        for (int i = 0; i < s; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Third Maximum: " + thirdMaximum(arr));
    }

    private static int thirdMaximum(int[] arr) {
        
        double max1=Double.MIN_VALUE,max2=Double.MIN_VALUE,max3=Double.MIN_VALUE;
        double tmp1=0,tmp2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max1 && max1==Double.MIN_VALUE){
                max1=arr[i];
            }else if(arr[i]==max1){
                continue;
            }else if(arr[i]>max1 && max1!=Double.MIN_VALUE){
                tmp1=max1;
                max1=arr[i];
                tmp2=max2;
                max2=tmp1;
                max3=tmp2;
            }else if(arr[i]>max2 && max2==Double.MIN_VALUE){
                max2=arr[i];
            }else if(arr[i]>max2 && max2!=Double.MIN_VALUE){
                tmp1=max2;
                max2=arr[i];
                max3=tmp1;

            }else if(arr[i]==max2){
                continue;
            }else if(arr[i]>max3){
                max3=arr[i];
            }
        }
        System.out.println(max1+" "+max2+" "+max3);
        return (int) (max3==Double.MIN_VALUE?max1:max3);
    }
}
