import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string:");
        String str = sc.next();

        List<List<String>> ans = new ArrayList<>();

        partition(0, str, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    private static void partition(int pointer, String str, ArrayList<String> temp, List<List<String>> ans) {

        if (pointer == str.length()) {
            System.out.println("Saved: "+temp);
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = pointer + 1; i <= str.length(); i++) {
            
            if (isPalindrome(pointer, i-1, str)) {
                temp.add(str.substring(pointer, i));
                System.out.println("before: "+temp+" pointer: "+pointer+" i:"+i);
                partition(i, str, temp, ans);
                temp.remove(temp.size() - 1);
                System.out.println("after: "+temp+" pointer: "+pointer+" i:"+i);
            }
        }
    }

    private static boolean isPalindrome(int pointer, int i, String str) {

        while(pointer >=0 && i<str.length() &&pointer<i){
            if(str.charAt(pointer)!=str.charAt(i)){
                return false;
            }
            i--;
            pointer++;
        }

        return true;
    }
}
