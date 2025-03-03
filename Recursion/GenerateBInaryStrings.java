import java.util.Scanner;

public class GenerateBInaryStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number:");
        int num = sc.nextInt();

        char ch[] = new char[num];

        ch[0] = '0';
        generate(ch, num, 1);
        ch[0] = '1';
        generate(ch, num, 1);
    }

    private static String toString(char[] ch){
        String str = new String(ch);
        return str;
    }
    private static void generate(char[] ch, int num, int i) {
        if(i==num){
            System.out.println(toString(ch));
            return;
        }

        if(ch[i-1]=='0'){
            ch[i]='0';
            generate(ch, num, i+1);
            ch[i]='1';
            generate(ch, num, i+1);
        }

        if(ch[i-1]=='1'){
            ch[i]='0';
            generate(ch, num, i+1);
        }
    }
}
