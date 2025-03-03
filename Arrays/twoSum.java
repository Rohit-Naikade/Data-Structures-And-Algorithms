import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class twoSum{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of an array:");

        int n=sc.nextInt();
        System.out.println("Enter Array");

        int nums[]=new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        System.out.println("Enter target:");

        int target=sc.nextInt();

        int result[]=twoSum(nums, target);

        System.out.println(Arrays.toString(result));
        
            }
        
            private static int[] twoSum(int[] nums, int target) {

                int result[] = new int[2];
                for(int i=0;i<nums.length-1;i++){
                    for(int j=i+1;j<nums.length;j++){
                        if(nums[i]+nums[j]==target){
                            result[0]=i;
                            result[1]=j;
                            break;
                        }
                    }
                }

                return result;
            }
}