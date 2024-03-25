import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date to check [yyyy-mm-dd]");
        String inputDate = sc.next();
        LocalDate date = LocalDate.parse(inputDate);
        LocalDate today = LocalDate.now();

        if (date.isBefore(today)) {
            System.out.println("The given date is before today");
        } else if (date.isAfter(today)) {
            System.out.println("The given date is after today");

        } else {
            System.out.println("The given date is today");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = formatter.format(date);
        System.out.println("Formatted date is " + formattedDate);
    }
}
