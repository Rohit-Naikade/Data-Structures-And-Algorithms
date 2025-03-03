import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FindDifference {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter first String:");
        String s1=sc.next();

        System.out.println("Enter second String:");
        String s2=sc.next();

        System.out.println("Extra character: "+difference(s1,s2));       
        
        }
        
            private static char difference(String s1, String s2) {
                String s3=s1+""+s2;
                
                ArrayList<Character> list=new ArrayList<>();
        
                for(char c: s3.toCharArray()){
                    if(list.contains(c)){
                        list.remove(list.indexOf(c));
                    }else{
                        list.add(c);
                    }
                    
                }

                
                 return list.get(0);

                
            }
}
