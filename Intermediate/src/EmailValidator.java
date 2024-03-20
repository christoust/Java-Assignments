import java.util.Scanner;
import java.util.regex.*;
public class EmailValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the email to validate: ");
        String email = sc.next();
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isValid=Pattern.matches(pattern, email);
        if(isValid) {
            System.out.println("Provided email: " + email + " is valid");
        }
            else
            {
                System.out.println("Provided email: " + email + " is not valid");
            }
    }
}
