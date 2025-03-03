import java.util.Scanner;

public class MergeSortedArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size of first array:");
        int m=sc.nextInt();
        System.out.println("Enter size of second array:");
        int n=sc.nextInt();
        int nums1[]=new int[m+n];

        System.out.println("Enter first array's elements:");
        for(int i=0;i<m+n;i++){
            nums1[i]=sc.nextInt();
        }
     
        int nums2[]=new int[n];

        System.out.println("Enter second array's elements:");
        for(int i=0;i<n;i++){
            nums2[i]=sc.nextInt();
        }

        mergeArray(nums1,m,nums2,n);
        System.out.println("Sorted array's elements:");
        for(int i=0;i<m+n;i++){
            System.out.print(nums1[i]+" ");
        }
        
            }
        
            private static void mergeArray(int[] nums1, int m, int[] nums2, int n) {
                
                int mid=(m+n)-1;
                m=m-1;
                n=n-1;
                if(m==0 || n==0){
                    return;
                }

                while(m>=0 && n>=0){
                    if(nums1[m]>nums2[n]){
                        nums1[mid]=nums1[m];
                        m--;
                    }else{
                        nums1[mid]=nums2[n];
                        n--;
                    }
                    mid--;
                }

                if(m!=-1){
                    while(m>=0){

                            nums1[mid]=nums1[m];
                            m--;
                            mid--;
                    }
                }else if(n!=-1){
                    while(n>=0){

                        nums1[mid]=nums2[n];
                        n--;
                        mid--;
                }
                }
                
            }
}
