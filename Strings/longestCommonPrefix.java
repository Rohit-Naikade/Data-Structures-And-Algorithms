import java.util.Scanner;

public class longestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size of the array:");
        int size=sc.nextInt();
        String strs[]=new String[size];
        for(int i=0;i<size;i++){
            strs[i]=sc.next();
        }

        System.out.println("Longest Common Prefix is: "+longestCommonPrefix(strs));
            }
        
            private static String longestCommonPrefix(String[] strs) {
                String prefix=strs[0];

                for(int i=1;i<strs.length;i++){
                    while(!strs[i].startsWith(prefix)){
                        prefix=prefix.substring(0, prefix.length()-1);
                        if(prefix.isEmpty()) return "";
                    }
                }

                    return prefix;
            }
}
