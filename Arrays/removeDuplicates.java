import java.util.Arrays;
import java.util.Scanner;

public class removeDuplicates {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size:");
        int n=sc.nextInt();
        int nums[]=new int[n];
        System.out.println("Enter Array:");

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int k=removeDuplicates(nums);

        System.out.println("final size: "+k);
        System.out.println(Arrays.toString(nums));

                
            }
        
            private static int removeDuplicates(int[] nums) {
                
                int i=0;

                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]!=nums[j]){
                        nums[i+1]=nums[j];
                        i++;
                    }
                }

                return i+1;
            }
}
