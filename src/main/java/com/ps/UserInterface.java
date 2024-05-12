package com.ps;

import java.util.*;

public class UserInterface {

    private Dealership dealership;

    public UserInterface() {
        init();
    }

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public void display() {

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("Program was quit successfully.");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 99);
        scanner.close();
    }

    private void displayMenu() {

        System.out.println("Menu:");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make - model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van");
        System.out.println("7 - List all vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

    }

    private void processGetByPriceRequest() {
    }

    private void processGetByMakeModelRequest(){

    }

    private void processGetByYearRequest(){

    }

    private void processGetByColorRequest(){

    }

    private void processGetByMileageRequest(){

    }

    private void processGetByVehicleTypeRequest(){

    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    private void processAddVehicleRequest(){

    }

    private void processRemoveVehicleRequest(){

    }

}