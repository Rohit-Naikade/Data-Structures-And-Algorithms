import java.util.*;

class CombinationsOfPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter digits:");
        String digits = sc.next();

        List<String> ans = new ArrayList<>();
        String[] comb = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combinations(0, digits, comb, ans, new StringBuilder());
        System.out.println(ans);
    }

    private static void combinations(int index, String digits, String[] comb, List<String> ans, StringBuilder temp) {
        if (index == digits.length()) {
            ans.add(temp.toString());
            return;
        }

        for (char ch : comb[digits.charAt(index) - '0'].toCharArray()) {
            temp.append(ch);
            System.out.println("before: "+index+" "+temp);
            combinations(index + 1, digits, comb, ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}