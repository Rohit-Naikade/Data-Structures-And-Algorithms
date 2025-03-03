import java.util.Arrays;
import java.util.Scanner;

public class plusOne {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size of an array:");
        int n=sc.nextInt();

        System.out.println("Enter Array Elements: ");
        int nums[]=new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        nums=plusOne(nums);

        System.out.println(Arrays.toString(nums));

        }
        
            private static int[] plusOne(int[] nums) {
                
               
               String res="";
               int rem=0;
               int quotient=1;
               for(int i=nums.length-1; i>=0; i--){
                  rem=(nums[i]+quotient);

                  if(rem>9){
                        quotient=1;
                        rem=rem%10;
                        res+=rem;
                  }else{
                       res+=rem;
                       quotient=0;
                  }
               }

               if(quotient==1){
                res+=quotient;
               }
               System.out.println(res);
               if(nums.length==res.length()){
                    int i=0;
                    for(int j=res.length()-1;j>=0;j--){
                        nums[i]=res.charAt(j) - '0';
                        i++;
                    }
                    return nums;
               }else{
                   nums=new int[res.length()];
                   int i=0;
                    for(int j=res.length()-1;j>=0;j--){
                        nums[i]=res.charAt(j) - '0';
                        i++;
                    }
                    return nums;
               }
               
                
            }
}
