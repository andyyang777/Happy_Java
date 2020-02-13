/***
 * Assignment #2
 * @author  Shangze Yang
 * sy2827@nyu.edu
 * 12 Feb. 2020
 * 1 hours
 * Description: This program is designed for that when user enters 3 choices,
 * the program will output different results to meet the requirements.
 */

import java.util.*;

public class UserEntering {

    public static void main(String[] args){
        System.out.println("\nThis program is for Integer and String conversions." +
                "By entering the following numbers you can get different results.\n" +
                "Enter \"1\" to convert 10-base Integer to Binary, Octal, hexadecimal and hexatridecimal.\n" +
                "Enter \"2\" to convert all the Integers uptill the Integer you input with the target base you set.\n" +
                "Enter \"3\" to show all the non-ASCII Strings you input with their unicode.\n" +
                "Enter \"0\" to exit.\n");
        while (true){
            System.out.print("Please input the option number: ");
            var input = new Scanner(System.in);
            String option = input.next();

            if (Integer.parseInt(option) == 0) {
                System.out.println("\nExit the program. Happy learning Java!");
                break;
            }
            Choices(option);
        }
    }

    public static void Choices(String option){

        var InputNum = new Scanner(System.in);

        switch (option){
            case "0":
                break;

            case "1":
                System.out.print("Please input an Integer in base 10: ");
                int num1 = InputNum.nextInt();
                System.out.println("\nConvert " + num1 + " to Binary is: " + Integer.toBinaryString(num1));
                System.out.println("Convert " + num1 + " to Octal is: " + Integer.toOctalString(num1));
                System.out.println("Convert " + num1 + " to hexadecimal is: " + Integer.toHexString(num1));
                System.out.println("Convert " + num1 + " to hexatridecimal is: " + Integer.toString(num1,36) + "\n");
                break;

            case "2":
                System.out.print("Please input a target base (for example 2 for Binary, 8 for Octal): ");
                int target = InputNum.nextInt();
                System.out.print("Please input an Integer in base 10: ");
                int num2 = InputNum.nextInt();
                System.out.print("\n");
                for (int i=1; i<=num2; i++){
                    System.out.println("Convert " + i + " to the target base you set is: " + Integer.toString(i,target));
                }
                System.out.print("\n");
                break;

            case "3":
                System.out.print("Please enter a String: ");
                String num3 = InputNum.next();
                char[] Trans2Ascii = num3.toCharArray();
                for (int m=0;m<=Trans2Ascii.length-1;m++){
                    if((int)Trans2Ascii[m]>=0 && (int)Trans2Ascii[m]<=127){
                        continue;
                    }else {
                        System.out.println(Trans2Ascii[m] + " is a non Ascii character, and its unicode is: \\u" +  Integer.toHexString((int)Trans2Ascii[m]));
                    }
                }
                System.out.print("\n");
                break;

            default:
                System.out.println("\nYour input is wrong，please read the instructions at the begining. \n");
                break;
        }
    }
}
