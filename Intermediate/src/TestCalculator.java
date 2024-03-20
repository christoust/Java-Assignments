import java.util.Scanner;

public class TestCalculator{
    public void Calc() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int number1 = sc.nextInt();
        System.out.println("Enter the second number");
        int number2 = sc.nextInt();
        System.out.println("Enter the operator");
        String ch = sc.next();
        switch(ch)
        {
            case "+":
            {
                Calculator add = (int a,int b)->a+b;
                float result = add.calculate(number1,number2);
                System.out.println("Sum is " + result);
                break;
            }

            case  "-":
            {
                Calculator substract = (int a,int b)->a-b;
                float result = substract.calculate(number1,number2);
                System.out.println("Difference is " + result);
                break;
            }

            case "*":{
                Calculator multiply = (int a,int b)->a*b;
                float result = multiply.calculate(number1,number2);
                System.out.println("The product is " + result);
                break;
            }

            default:
            {
                System.out.println("Enter the correct operator");
            }
        }


    }


}