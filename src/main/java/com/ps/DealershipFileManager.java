package com.ps;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DealershipFileManager {

    public static Dealership getDealership() {

        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {

            String dealershipInfo = reader.readLine(); // only read the first line first for dealership info
            String[] dealershipData = dealershipInfo.split("\\|");
            String name = dealershipData[0];
            String address = dealershipData[1];
            String phone = dealershipData[2];
            dealership = new Dealership(name, address, phone);

            String line;
            while ((line = reader.readLine()) != null) { // now we loop for rest of vehicle info

                String[] vehicleData = line.split("\\|");
                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);

            }
        } catch (IOException e) {

            System.err.println("error " + e.getMessage());

        }

        return dealership;
    }

    public static void saveDealership(Dealership dealership) {

    }
}