import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter String:");
        String input=sc.nextLine();

        System.out.println("Length of the last word of String is: "+lengthOfLast(input));
            }
        
            private static int lengthOfLast(String input) {
                System.out.println("|"+input+"|");
                String str=input.trim();
                System.out.println("|"+str+"|");

                String arr[]=str.split(" ");
                return arr[arr.length-1].length();
            }
}
