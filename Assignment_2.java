//Tahsin Alam.
// CS 221
//Software Design.

import java.util.Scanner;

public class Welcome1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        boolean exit = false;
        do {

            System.out.print("Please enter your age: ");
            int age = scanner.nextInt();

            System.out.println("The result is: ");
            int result = age;

            System.out.print(age+ ",");
            while (age!= 1) {
                age=age/2;
                if (age == 1)
                    System.out.print(age);
                else
                    System.out.print(age+ ",");

            }


            System.out.println();
            for (int i = 0; i < result; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }


            System.out.println("\nDo you want to contiue? (Y/N)");
            char option = scanner.next().charAt(0);

            if (option == 'N' || option == 'n')
                exit=true;

        } while (!exit);
        System.out.print(("Goodbye!"));
    }
}