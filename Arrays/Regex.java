import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String input = "queries/AUTHORITIES.sql";
        String regex = "(?<=/)([^/]+)(?=\\.)";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.find()) {
            System.out.println("Extracted value: " + matcher.group(1)); // Outputs: JP_2580_DATASET
        } else {
            System.out.println("No match found");
        }
    }
}
