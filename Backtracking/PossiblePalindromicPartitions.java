import java.util.*;

public class PossiblePalindromicPartitions {

    static ArrayList<ArrayList<String>> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String:");
        String str = sc.next();

        LinkedList<String> list = new LinkedList<>();

        partitions(str, list, 0);

        System.out.println(answer);

    }

    private static void partitions(String str, LinkedList<String> list, int index) {
        if (index == str.length()) {
            answer.add(new ArrayList<>(list));
            return;
        }

        String palString = "";

        for (int i = index; i < str.length(); i++) {
            palString += str.charAt(i);
            System.out.println("palString:"+palString+" index:"+index);
            if (isPalindrome(palString)) {
                
                list.addLast(palString);
                System.out.println(list);
                partitions(str, list, i+1);
                list.removeLast();
                System.out.println(list);
            }
        }
    }

    private static boolean isPalindrome(String palString) {
       return palString.equals(new StringBuilder(palString).reverse().toString());
    }

}
