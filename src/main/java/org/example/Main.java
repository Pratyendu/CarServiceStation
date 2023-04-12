package org.example;

import Implementations.CarServiceStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarServiceStation station = new CarServiceStation();

        Scanner scanner = new Scanner(System.in);

        // Get the car type from the user
        System.out.print("Enter car type (Hatchback, Sedan, SUV): ");
        String carType = scanner.nextLine();

        // Get the service codes from the user
        List<String> serviceCodes = new ArrayList<>();
        System.out.print("Enter service codes (comma separated): ");
        String input = scanner.nextLine();
        String[] codes = input.split(",");
        for (String code : codes) {
            serviceCodes.add(code.trim());
        }

        // Generate the bill and print it to the console
        String bill = station.generateBill(carType, serviceCodes);
        System.out.println(bill);

        scanner.close();

    }
}