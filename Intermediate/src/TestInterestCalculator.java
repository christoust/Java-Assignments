import java.util.Scanner;

public class TestInterestCalculator {


    public static void main(String[] args) {
        try {
            InterestCalcImpl ob = new InterestCalcImpl();
            Scanner sc = new Scanner(System.in);
            System.out.println("Interest Calculator");
            System.out.println("Enter the principal amount");
            float amount = sc.nextFloat();
            System.out.println("Enter the rate of interest");
            float rate = sc.nextInt();
            System.out.println("Enter the duration");
            int time = sc.nextInt();
            if(amount==0||rate==0||time==0)
            {
                throw new InvalidInputException("Value of amount,rate and time should not be less than or equal to zero");
            }
            System.out.println("1.Calculate Simple Interest\n2.Calculate Compound Interest");
            System.out.println("Enter option number");

            int option = sc.nextInt();
            switch (option) {
                case 1: {
                    double simpleInterest = ob.simpleInterest(amount, rate, time);
                    System.out.println("Simple Interest is: " + simpleInterest);
                    break;
                }
                case 2: {
                    double compoundInterest = ob.compoundInterest(amount, rate, time);
                    System.out.println("Compound Interest is: " + compoundInterest);
                    break;

                }
                default: {
                    System.out.println("Enter correct option");
                }

            }

        } catch (InvalidInputException e)
        {
            System.out.println(e.getMessage());
        }
    }

    }
