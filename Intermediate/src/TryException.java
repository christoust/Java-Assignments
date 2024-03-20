public class TryException {
    public static void main(String[] args) {
        int a = 5;
        try{
            if(a==5)
            {
                throw new InvalidInputException("");
            }

        }
        catch (ArithmeticException e)
        {
            System.out.println("This is exception");

        }

    }
}
