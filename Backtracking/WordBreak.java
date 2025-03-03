import java.util.*;

public class WordBreak {

    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string:");
        String str = sc.next();

        Set<String> set = new HashSet<>();

        System.out.println("Enter count:");
        int n = sc.nextInt();
        System.out.println("Enter dictionary words:");

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            set.add(word);
        }
        LinkedList<String> list = new LinkedList<>();
        calculate(str, 0, list, set);

        System.out.println("Answer: "+answer);
    }

    private static void calculate(String str, int index, LinkedList<String> list, Set<String> set) {
        if(str.length()==index){

            String sentence="";

            for(int i=0;i<list.size()-1;i++){
                sentence+=list.get(i)+" ";
            }
            answer.add(sentence);
            System.out.println("sentence:"+sentence);
            return;
        }

        String word="";
        for(int i=index;i<str.length();i++){
            word+=str.charAt(i);
            System.out.println(word+" list:"+list);
            if(set.contains(word)){
                list.addLast(word);
                System.out.println("add to list:"+list);
                calculate(str, i+1, list, set);
                list.removeLast();
                System.out.println("removed from list:"+list);
            }
        }
    }
}
