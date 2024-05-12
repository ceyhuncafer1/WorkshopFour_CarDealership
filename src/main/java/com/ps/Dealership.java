package com.ps;
import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {

        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehiclesByType.add(vehicle);

            }
        }
        return vehiclesByType;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {

        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            int mileage = vehicle.getOdometer();

            if (mileage >= minMileage && mileage <= maxMileage) { //parameters

                vehiclesByMileage.add(vehicle);

            }
        }
        return vehiclesByMileage;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {

        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getColor().equalsIgnoreCase(color)) {

                vehiclesByColor.add(vehicle);

            }
        }
        return vehiclesByColor;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {

        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            int year = vehicle.getYear();

            if (year >= minYear && year <= maxYear) {

                vehiclesByYear.add(vehicle);

            }
        }
        return vehiclesByYear;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {

                vehiclesByMakeModel.add(vehicle);

            }
        }
        return vehiclesByMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {

        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            double price = vehicle.getPrice();

            if (price >= minPrice && price <= maxPrice) {

                vehiclesByPrice.add(vehicle);

            }
        }
        return vehiclesByPrice;
    }




}
