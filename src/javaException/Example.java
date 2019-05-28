package javaException;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform Division, autopilot shutting down");
        }

    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ",y is " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            throw new ArithmeticException("No suitable input");
        }  catch (ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");
        }
    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an Integer");
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e){
                // go round again. Read past the end of line in the input first.
                sc.nextLine();
                System.out.println("Please Enter a number using only the digits 0 to 9");
            }
        }

    }
}
