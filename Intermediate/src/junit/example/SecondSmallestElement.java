package junit.example;

import java.util.Arrays;

public class SecondSmallestElement {
    public static void main(String[] args) {
        SecondSmallestElement ob = new SecondSmallestElement();
        int[] input = {10, 20, 30, -10, 22, 0, -5};
        int secondSmallestElement = ob.getSecondSmallestElement(input);
        System.out.println(secondSmallestElement);
    }

    public int getSecondSmallestElement(int[] input) throws NullPointerException {
        final String METHOD_NAME = "getSecondSmallestElement";
        System.out.println("Method Invoked" + METHOD_NAME + "Input" + Arrays.toString(input));
        if (input == null || input.length <= 2) {
            throw new NullPointerException("Input array might be null|empty|only 1 element pls check");
        } else {

            return Arrays.stream(input).distinct().sorted().skip(1).findAny().getAsInt();
        }
    }
}
