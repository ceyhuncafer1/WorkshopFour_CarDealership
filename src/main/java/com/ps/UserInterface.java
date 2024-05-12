package com.ps;

import java.util.*;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    private int choice;

    private Dealership dealership;

    public UserInterface() {
        init();
    }

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public void display() {

        int choice = 0; // Initialize choice outside the loop

        do {
            displayMenu();

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

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
                        System.out.println("Program stopped.");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.next(); // Clear the invalid input from the scanner
            }

        } while (choice != 99);
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

        // Specific price range that you must return from inventory

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();

        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);

        if (vehicles.isEmpty()) {

            System.out.println("0 vehicles for this price range");

        } else {

            System.out.println("Vehicles within the price range $" + minPrice + " - $" + maxPrice + ":");

            for (Vehicle vehicle : vehicles) {

                System.out.println(vehicle);

            }
        }

    }

    private void processGetByMakeModelRequest(){

        // take make and model from user, return list of specified make and model

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

        if (vehicles.isEmpty()) {

            System.out.println("For this specific make and model we don't have any.");

        } else {

            System.out.println("Vehicles with the make '" + make + "' and model '" + model + "':");

            for (Vehicle vehicle : vehicles) {

                System.out.println(vehicle);

            }
        }

    }

    private void processGetByYearRequest(){

        // take min and max from user, return list of year range

        System.out.print("Enter the minimum year: ");
        int minYear = scanner.nextInt();

        System.out.print("Enter the maximum year: ");
        int maxYear = scanner.nextInt();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);

        if (vehicles.isEmpty()) {

            System.out.println("We do not have any vehicles from this year range.");

        } else {

            System.out.println("Vehicles within the year range " + minYear + " - " + maxYear + ":");

            for (Vehicle vehicle : vehicles) {

                System.out.println(vehicle);

            }
        }

    }

    private void processGetByColorRequest(){

        // Returns list of vehicles with the color the user chose from dealership inventory.

        System.out.print("Enter vehicle color you'd like: ");

        String color = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);

        if (vehicles.isEmpty()) {

            System.out.println("We do not have any vehicles with this color.");

        } else {

            System.out.println("Vehicles that have the color '" + color + "':");

            for (Vehicle vehicle : vehicles) {

                System.out.println(vehicle);

            }
        }

    }

    private void processGetByMileageRequest(){

        // Take input of min and max and then return a list with that mileage range from dealership inventory.

        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();

        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);

        if (vehicles.isEmpty()) {

            System.out.println("No vehicles found within the specified mileage range.");

        } else {

            displayVehicles(vehicles);

        }

    }

    private void processGetByVehicleTypeRequest(){

        // Returns vehicles of a certain type from dealership inventory

        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String vehicleType = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);

        if (vehicles.isEmpty()) {

            System.out.println("No existing vehicles for type " + vehicleType);

        } else {

            displayVehicles(vehicles);

        }

    }

    private void processGetAllVehiclesRequest() {

        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();

        displayVehicles(allVehicles);

    }

    private void processAddVehicleRequest(){

        //Take in all data needed to store car
        // Add the vehicle object to dealership inventory

        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Vehicle Type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);

        System.out.println("Vehicle was added.");

    }

    private void processRemoveVehicleRequest(){

        //take VIN
        //if VIN exists in arraylist remove from inventory

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter VIN of the vehicle to remove: ");
        int vinToRemove = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

        boolean vehicleRemoved = false;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVin() == vinToRemove) {

                dealership.removeVehicle(vehicle);
                vehicleRemoved = true;
                break;

            }
        }

        if (vehicleRemoved) {

            System.out.println("Removed vehicle from inventory.");

        } else {

            System.out.println("VIN " + vinToRemove + " had no matches.");

        }

    }

}