import java.util.Scanner;

public class binarySearch {

    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of the array:");
        int n=sc.nextInt();

        int nums[]=new int[n];

        System.out.println("Enter array elements:");
        
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

        System.out.println("Enter target:");

        int target=sc.nextInt();

        System.out.println(binarySearch(nums,target));
        
        }
        
            private static int binarySearch(int[] nums, int target) {
                
              
                int left = 0;
                int right = nums.length-1;
                while(left<=right){
                   int mid=(left+right)/2;
        
                   if(nums[mid] == target){
                       return mid;
                   }
        
                   if(nums[mid]> target){
                         right=mid-1;
                   }else{
                        left=mid+1;
                   }
                }
        
        
                return left;
                
            }
}
