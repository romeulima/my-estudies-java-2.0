package com.romeulima.java.poo.product;

import com.romeulima.java.poo.product.entity.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Product[] vect = new Product[n];

        String name;
        double price;
        Double sum = 0.0;

        for (int i = 0; i < vect.length; i++) {
            sc.nextLine();
            name = sc.nextLine();
            price = sc.nextDouble();
            vect[i] = new Product(name, price);
            sum += vect[i].getPrice();
        }

        Double avg = sum / vect.length;

        System.out.printf("Average: %.2f%n", avg);
    }
}
