package javaException;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideBYL(x, y));
//        System.out.println(divideEAFP(x, y));
//        System.out.println(divide(x, y));
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    // LBYL - Look Before You Leap
    private static int getIntLBYL() {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = sc.next();
        for(int i=0; i<input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    // EAFP - Easier to Ask Forgiveness than Permission
    private static int getIntEAFP() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an Integer ");
        try {
            return sc.nextInt();
        } catch (InputMismatchException e){
            return 0;
        }
    }

    private static int divideBYL(int x, int y){
        if(y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y){
        try {
            return x / y;
        } catch (ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x / y;
    }
}