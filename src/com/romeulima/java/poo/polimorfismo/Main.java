package com.romeulima.java.poo.polimorfismo;

import com.romeulima.java.poo.polimorfismo.entities.ImportedProduct;
import com.romeulima.java.poo.polimorfismo.entities.Product;
import com.romeulima.java.poo.polimorfismo.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used, imported (c/u/i)? ");
            char typeProduct = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (typeProduct == 'i'){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            } else if (typeProduct == 'c') {
                products.add(new Product(name, price));
            } else if (typeProduct == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufacture = LocalDate.parse(sc.next(), fmt);
                products.add(new UsedProduct(name, price, manufacture));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product product : products){
            System.out.println(product.priceTag());
        }
    }
}
