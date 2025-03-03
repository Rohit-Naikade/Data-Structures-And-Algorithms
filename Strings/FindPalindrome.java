import java.util.Scanner;

public class FindPalindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter String:");
        String str=sc.nextLine();

        System.out.println("is string palindrome: "+isPalindrome(str));
                
            }
        
            private static boolean isPalindrome(String str) {
                
                str=str.replaceAll("[^a-zA-Z]", "");
                System.out.println(str);
                StringBuilder result=new StringBuilder(str);
                if(str.toLowerCase().equals(result.reverse().toString().toLowerCase())){
                    return true;
                }
                return false;
            }
}
