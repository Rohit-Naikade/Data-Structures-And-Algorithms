import java.util.HashSet;
import java.util.Scanner;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String str = sc.next();

        System.out.println("Final String: " + replaceVowels(str));
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ) {
            return true;
        }
        return false;
    }

    private static String replaceVowels(String str) {

        char[] arr = str.toCharArray();

        char tmp;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (i<j && !isVowel(arr[i])) {
                
                i++;
            }
            while (i<j && !isVowel(arr[j])) {
                j--;
            }
            if(i>j){
                break;
            }
            tmp=arr[j];
            arr[j]=arr[i];
            arr[i]=tmp;
            i++;
            j--;
            
        }
        return new String(arr);
    }
}
