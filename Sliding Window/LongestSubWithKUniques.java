import java.util.HashMap;
import java.util.Scanner;

public class LongestSubWithKUniques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String:");
        String str = sc.next();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        System.out.println("Longest SUbstring: " + longestSubstring(str, k));
    }

    private static int longestSubstring(String str, int k) {

        int left=0, right=0, ans=-1;
        HashMap<Character, Integer> map=new HashMap<>();
        while(right<str.length()){
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0)+1);

            while(map.size()>k && left<str.length()){
                map.put(str.charAt(left), map.get(str.charAt(left))-1);
                if(map.get(str.charAt(left))==0){
                    map.remove(str.charAt(left));
                }
                System.out.println("right:"+right);
                System.out.println(map);
                left++;
            }

            
            if(map.size()==k){
                ans=Math.max(ans, (right-left)+1);
            }

            right++;
            
            
        }
        return ans;
    }
}
