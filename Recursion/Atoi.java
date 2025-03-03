import java.util.Scanner;

public class Atoi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter String:");
        String num=sc.next();

        num=num.trim();
        //System.out.println("|"+num.trim()+"|");

        boolean isNegative=num.charAt(0)=='-'?true:false;
        boolean isPositive=num.charAt(0)=='+'?true:false;

        int i=0;
        if(isNegative || isPositive){
            i=1;
        }
        String res="";
        while(i<num.length()){
            if(num.charAt(i)>= '0' && num.charAt(i)<='9'){
                res+=num.charAt(i);
            }else{
                break;
            }
            i++;
        }

        int result=0;
        int st=0;
        while(st<res.length()){
            result=result*10+(res.charAt(st)-'0') % Integer.MAX_VALUE;
            st++;
        }
        // if(isNegative){

        // }
        System.out.println(result);
    }
}

