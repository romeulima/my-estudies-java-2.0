package com.romeulima.java.poo.array;

import com.romeulima.java.poo.array.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serão digitadas? ");
        int n = sc.nextInt();

        Person[] vect = new Person[n];
        String name;
        int age;
        double height;

        for (int i = 0; i < vect.length; i++) {
            System.out.println("Dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            sc.nextLine();
            name = sc.nextLine();
            System.out.print("Idade: ");
            age = sc.nextInt();
            System.out.print("Altura: ");
            height = sc.nextDouble();
            vect[i] = new Person(name, age, height);
        }

        double sum = 0;
        int count = 0;
        for (int i = 0; i < vect.length; i++) {
            sum += vect[i].getHeight();
            if(vect[i].getAge() < 16){
                count++;
            }
        }

        double averageHeight = sum / vect.length;
        double percent = count * 100.0 / vect.length;

        System.out.println();
        System.out.printf("Altura média: %.2f%n", averageHeight);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", percent);

        for (int i = 0; i < vect.length; i++) {
            if (vect[i].getAge() < 16){
                System.out.println(vect[i].getName());
            }
        }
    }
}
