import java.util.Hashtable;
import java.util.Scanner;

public class RomanTOInteger{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter String:");
        String roman=sc.next();

        System.out.println("Roman to Integer is: "+romanToInt(roman));
            }
        
            private static int romanToInt(String roman) {

                Hashtable<String,Integer> hashtable=new Hashtable<>();

                hashtable.put("I", 1);
                hashtable.put("V", 5);
                hashtable.put("X", 10);
                hashtable.put("L", 50);
                hashtable.put("C", 100);
                hashtable.put("D", 500);
                hashtable.put("M", 1000);

                int total=0;
                for(int i=roman.length()-1;i>=0;i--){
                    if(roman.charAt(i)=='I'){
                        total=total+1;
                    }else if(roman.charAt(i)=='V'){
                        if((i-1)>=0 && roman.charAt(i-1)=='I'){
                            total=total+4;
                            i--;
                        }else{
                            total=total+5;
                        }
                    }else if(roman.charAt(i)=='X'){
                        if((i-1)>=0  && roman.charAt(i-1)=='I'){
                            total=total+9;
                            i--;
                        }else{
                            total=total+10;
                        }
                    }else if(roman.charAt(i)=='L'){
                        if((i-1)>=0  && roman.charAt(i-1)=='X' ){
                            total=total+40;
                            i--;
                        }else{
                            total=total+50;
                        }
                    }else if(roman.charAt(i)=='C'){
                        if((i-1)>=0  && roman.charAt(i-1)=='X' ){
                            total=total+90;
                            i--;
                        }else{
                            total=total+100;
                        }
                    }else if(roman.charAt(i)=='D'){
                        if((i-1)>=0  && roman.charAt(i-1)=='C'){
                            total=total+400;
                            i--;
                        }else{
                            total=total+500;
                        }
                    }else if(roman.charAt(i)=='M'){
                        if((i-1)>=0  && roman.charAt(i-1)=='C'){
                            total=total+900;
                            i--;
                        }else{
                            total=total+1000;
                        }
                    }

                }
                return total;
            }

}