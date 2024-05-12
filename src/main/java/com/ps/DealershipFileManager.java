package com.ps;

import java.io.*;

public class DealershipFileManager {

    public static Dealership getDealership() {

        /*
        initialize dealership
        buffered reader to read the csv
        read first line
        read regular data
        make dealership contain these three parameters
        loop through file for vehicles
        returns dealership object with vehicle data from CSV file

         */

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

        //write to file with BufferedWriter
        //use delimiters to write to file
        //loop for each vehicle


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("savedInventory.csv"))) {

            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {

                writer.write(

                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice());

                writer.newLine();
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}