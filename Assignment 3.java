/Tahsin Alam.
// CS 221
//Software Design.
//Assignment 3

import java.util.Scanner;

public class Welcome1 {

    public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);


            boolean exit = false;
            do {
                int age =user_input();
                age_divison(age);
                print_stars(age);
                System.out.println("\nDo you want to contiue? (Y/N)");
                char option = scanner.next().charAt(0);

                if (option == 'N' || option == 'n')
                    exit = true;

            } while (!exit);
        System.out.print(("Goodbye!"));
    }
    public  static int user_input() {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter your age: ");
        int age = in.nextInt();
        return age;
    }
    public static void age_divison(int n) {


        System.out.println("The result is: ");
        int result = n;

        System.out.print(n + ",");
        while (n != 1) {
            n = n / 2;
            if (n == 1)
                System.out.print(n);
            else
                System.out.print(n + ",");

        }
    }
    public static void print_stars(int n){


                System.out.println();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
        }
    }