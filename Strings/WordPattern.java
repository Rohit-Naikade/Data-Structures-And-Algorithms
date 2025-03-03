import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WordPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter String: ");
        String str=sc.next();

        System.out.println("Enter sentence: ");
        String line=sc.nextLine();

        System.out.println("is word pattern matches: "+isWordPattern(str,"dog dog dog dog"));
            }
        
            private static boolean isWordPattern(String str, String line) {
                
                String arr[]=line.split(" ");

                HashSet<String> set1=new HashSet<>();
                HashSet<Character> set2=new HashSet<>();
                for(String temp:arr){
                    set1.add(temp);
                }
                for(Character temp:str.toCharArray()){
                    set2.add(temp);
                }

                System.out.println(line);
                if(str.length()!=arr.length || set1.size()!=set2.size()){
                    return false;
                }
                HashMap<Character,String> set=new HashMap<>();
                for(int i=0;i<str.length();i++){
                    if(set.containsKey(str.charAt(i))){
                        if(!set.get(str.charAt(i)).equals(arr[i])){
                            return false;
                        }
                    }else{
                        set.put(str.charAt(i), arr[i]);
                    }

                    System.out.println(set);
                }

                return true;
            }
}
