package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List <TaxPayer> list = new ArrayList<>();
        double sum = 0;

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i=1;i<=n;i++) {
            System.out.println("Tax payer #" + i + " data");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, annualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employess: ");
                int empNumber = sc.nextInt();
                list.add(new Company(name, annualIncome, empNumber));
            }

        }
        System.out.println();
        System.out.println("TAXES PAID:");

        for (TaxPayer payer : list) {
            System.out.printf(payer.getName() + ": $ %.2f\n", payer.Tax());

            sum += payer.Tax();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + sum);
        sc.close();
    }
}