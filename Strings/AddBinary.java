import java.util.Scanner;

public class AddBinary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter first string:");
        String s1=sc.next();
        System.out.println("Enter Second string:");
        String s2=sc.next();
        
        System.out.println("Binary addition is: "+addBinary(s1,s2));
            }
        
            private static String addBinary(String s1, String s2) {
                String total="";

                int i=s1.length()-1;
                int j=s2.length()-1;
                int carry=0;

                while(i>=0 && j>=0){
                    if(s1.charAt(i)=='1' && s2.charAt(j)=='1'){
                        if(carry==1){
                            total=total+"1";
                            carry=1;
                        }else{
                            total=total+"0";
                            carry=1;
                        }
                    }else if((s1.charAt(i)=='1' && s2.charAt(j)=='0') || (s1.charAt(i)=='0' && s2.charAt(j)=='1')){
                        if(carry==1){
                            total=total+"0";
                            carry=1;
                        }else{
                            total=total+"1";
                            carry=0;
                        }
                    }else if(s1.charAt(i)=='0' && s2.charAt(j)=='0'){
                        if(carry==1){
                            total=total+"1";
                            carry=0;
                        }else{
                            total=total+"0";
                            carry=0;
                        }
                    }
                    i--;
                    j--;
                }

                while(i>=0){
                    if(s1.charAt(i)=='1' && carry==1){
                        
                        total=total+"0";
                        carry=1;
                    }else if((s1.charAt(i)=='0' && carry==1) || (s1.charAt(i)=='1' && carry==0)){
                        
                            total=total+"1";
                            carry=0;
                       
                    }else {
                        
                            total=total+"0";
                            carry=0;
                        
                    }
                    i--;
                }

                while(j>=0){
                    if(s2.charAt(j)=='1' && carry==1){
                        total=total+"0";
                        carry=1;
                    }else if((s2.charAt(j)=='0' && carry==1) || (s2.charAt(j)=='1' && carry==0)){
                        
                            total=total+"1";
                            carry=0;
                       
                    }else {
                        
                            total=total+"0";
                            carry=0;
                        
                    }
                    j--;
                }

                if(carry==1){
                    total=total+"1";
                }
                StringBuilder str=new StringBuilder(total);
                return str.reverse().toString();
            }
}
