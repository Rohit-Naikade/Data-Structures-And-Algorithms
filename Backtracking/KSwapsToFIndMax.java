import java.util.Scanner;

public class KSwapsToFIndMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String:");
        String str = sc.next();
        System.out.println("Enter K:");
        int k = sc.nextInt();

        StringBuilder sb = new StringBuilder(str);
        StringBuilder sb1=new StringBuilder(str);
        findMax(sb1, sb, 0, k);

        System.out.println("Max Number: "+ sb1);
    }

    private static void findMax(StringBuilder str, StringBuilder sb, int start, int k) {
        if (start == sb.length() - 1 || k == 0) {
            return;
        }

        int max = 0;
        for (int i = start + 1; i < sb.length(); i++) {
            max = Math.max(max, sb.charAt(i) - '0');
        }

        System.out.println("Max: " + max+" k"+k+" start:"+start);


        for (int i = start + 1; i < sb.length(); i++) {

            
            if (sb.charAt(start) - '0' != max&& (int) sb.charAt(i) - '0' > (int) sb.charAt(start) - '0' && (int) sb.charAt(i) - '0' == max) {
                swap(sb, start, i);

                if(sb.compareTo(str)>0){
                    str.replace(0, str.length(), sb.toString());
                }
                System.out.println("str:"+str+" max:"+max);
                findMax(str, sb, start+1, k-1);
                swap(sb , start, i);
            }
        }

        findMax(str, sb, start+1, k);

    }

    private static void swap(StringBuilder str, int start, int i) {
        char temp=str.charAt(i);
        str.setCharAt(i, str.charAt(start));
        str.setCharAt(start, temp);

    }
}
