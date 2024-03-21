import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("1.Calculator using Functional Interface\n2.Find Employees with particular skill\n3.Interest Calculator");
            System.out.println("Enter the option");
             option = sc.nextInt();

            switch (option) {
                case 1: {
                    TestCalculator testCalculator = new TestCalculator();
                    testCalculator.Calc();
                    break;
                }
                case 2: {
                    EmployeeStream employeeStream = new EmployeeStream();
                    employeeStream.getEmployeeWithSkill();
                    break;
                }
                case 3: {
                    TestInterestCalculator testInterestCalculator = new TestInterestCalculator();
                    testInterestCalculator.testCal();
                    break;
                }
                case 0: {
                    System.out.println("Exiting...");
                    break;
                }
            }
        } while (option != 0);
    }
}