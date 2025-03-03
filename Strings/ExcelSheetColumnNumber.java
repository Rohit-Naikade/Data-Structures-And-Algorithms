import java.util.Scanner;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter string");
        String str=sc.next();

        System.out.println("Excel Ccolumn Name is: "+sheetName(str));
                //System.out.println(Math.pow(26, 0));
            }
        
            private static int sheetName(String str) {

                int total=0;

                StringBuilder sheet=new StringBuilder(str);
                str=sheet.reverse().toString();
                for(int i=0;i<str.length();i++){

                    total=total+(int)((Math.abs(str.charAt(i)-64))*Math.pow(26, i));
                }
                return total;
            }
}
