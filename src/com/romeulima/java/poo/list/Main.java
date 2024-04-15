package com.romeulima.java.poo.list;

import com.romeulima.java.poo.list.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        Integer n = sc.nextInt();

        List<Employee> employeeList = new ArrayList<>();
        Integer id;
        String name;
        Double salary;

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            id = sc.nextInt();

            while (hasId(employeeList, id)){
                System.out.print("Id already exist! Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            name = sc.nextLine();
            System.out.print("Salary: ");
            salary = sc.nextDouble();

            Employee employee = new Employee(id, name, salary);
            employeeList.add(employee);
        }

        System.out.println();

        System.out.print("Enter the employee id that will have your salary increase: ");
        int employeeId = sc.nextInt();

        Employee emp = employeeList.stream().filter(employee -> employee.getId() == employeeId).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id don't exists");
        } else {
            System.out.print("Enter the percentage: ");
            Double percent = sc.nextDouble();
            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public static boolean hasId(List<Employee> list, int id){
        Employee idExists = list.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);

        return idExists != null;
    }
}
