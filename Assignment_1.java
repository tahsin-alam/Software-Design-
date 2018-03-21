
// Created by Tahsin Alam.
//9/20/17.
import java.util.Scanner;

public class Complex {
    private double real;
    private double imag;

    //Mutators for Complex class.

    public void setReal(double real)
    {
        this.real = real;
    }

    public void setImag(double imag)
    {
        this.imag = imag;
    }

    public void print() {
        if (getImag() >= 0)
            System.out.print(getReal() + "+" + getImag() + "i");
        else
            System.out.print(getReal() + getImag() + "i");
    }

    //Accesors for Complex Class

    public double getReal()
    {
        return real;
    }

    public double getImag()
    {
        return imag;
    }


        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            Complex mynumber = new Complex();// creating new object for complex class.

            // prompt for number
            System.out.print("Please enter real number:");
            double x = input.nextDouble();
            mynumber.setReal(x);// storing set value for real number and put it on mynumber
            System.out.print("Please enter imaginary number: "+"i");
            double y = input.nextDouble();// storing the set value for imaginary number and put it on mynumber.
            mynumber.setImag(y);

            System.out.printf("Input stored number in object mynumber: %n%f%n", mynumber.getReal());
            System.out.printf("Input stored number in object mynumber: %n%f%n", mynumber.getImag());





        }
    }
