import java.util.HashSet;
import java.util.Scanner;

public class IsomorphicStrings{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter first string:");
        String s1=sc.next();

        System.out.println("ENter second string:");
        String s2=sc.next();

        System.out.println("Is strings Isomorphic: "+isIsomorphic(s1,s2));
            }
        
            private static boolean isIsomorphic(String s1, String s2) {

                HashSet<Character> set1=new HashSet<>();
                HashSet<Character> set2=new HashSet<>();

                for(Character c: s1.toCharArray()){
                    set1.add(c);
                }

                for(Character c: s2.toCharArray()){
                    set2.add(c);
                }
                
                if(set1.equals(set2)){
                    return false;
                }
                return set1.size()==set2.size();
            }
}