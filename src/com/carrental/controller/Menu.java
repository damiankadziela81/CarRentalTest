package com.carrental.controller;

import com.carrental.builders.CarBuilder;
import com.carrental.carRepository.Car;
import com.carrental.carRepository.CarType;
import com.carrental.customerDataBase.Customer;
import com.carrental.prepareData.PrepareData;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private PrepareData pd = new PrepareData();
    private Scanner scanner = new Scanner(System.in);
    private int userID;
    private int carID;
    private List<Car> carsAvailableToRent;
    private List<Car> carsRented;



    public void currentStatus(){
        System.out.println("Total number of cars: " + pd.getCars().size());
        System.out.println("Number of customers: " + pd.getCustomers().size());
        carsAvailableToRent = pd.getCars().stream().filter(car -> !car.isRented()).toList();
        carsRented = pd.getCars().stream().filter(Car::isRented).toList();
        System.out.println("Number of cars available: " + carsAvailableToRent.size());
        System.out.println("Number of cars rented: " + carsRented.size());
        System.out.println("Cars available: " + carsAvailableToRent);
        System.out.println("Cars rented: " + carsRented);
    }

    public void initialize(){
        pd.fillCarList();
        pd.fillCustomerList();
        carsAvailableToRent = pd.getCars().stream().filter(car -> car.isRented() == false).toList();
    }

    public void displayCars() {
        System.out.println(pd.getCars());
    }

    public void displayCustomers() {
        System.out.println(pd.getCustomers());
    }

    public void addCustomer() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();

        Customer customer = new Customer(name, surname);
        pd.addCustomer(customer);
        System.out.println("Customer added.");

    }

    public void rentCar() {
        userID = selectUser();
        System.out.println("You selected user: " + userID);
        carID = selectCarForRent();
        System.out.println("You selected car: " + carID);
        //update user with selected car
        if(checkIfUserIDisValid(userID) && checkIfCarIDisValid(carID)) {
            if(pd.getCars().get(carID - 1).isRented()) {
                System.out.println("Sorry, this car is rented. Pick another one.");
            } else {
                updateRentingCustomer(userID, carID);
                updateRentedCar(userID, carID);
                System.out.println(pd.getCars().get(carID -1).getModel() + " was rented by "
                        + pd.getCustomers().get(userID - 1).getName() + " "
                        + pd.getCustomers().get(userID - 1).getSurName());
            }
        } else {
            System.out.println("Invalid selection!");
        }
    }

    public void returnCar() {
        carID = selectCarToReturn();
        if(checkIfCarIDisValid(carID)){
            if(pd.getCars().get(carID - 1).isRented()) {
                updateReturnedCar(carID);
                //remove the car from customer List

            } else {
                System.out.println("This car is not rented.");
            }
        } else {
            System.out.println("Invalid selection");
        }
    }

    private boolean checkIfUserIDisValid(int id) {
        return id > 0 && id <= pd.getCustomers().size();
    }

    private boolean checkIfCarIDisValid(int id) {
        return id > 0 && id <= pd.getCars().size();
    }

    private void updateRentedCar(int userId, int carId) {
        pd.getCars().get(carId - 1).setRented(true);
        pd.getCars().get(carId - 1).setMileage(pd.getCars().get(carId - 1).getMileage() + 100);
        pd.getCars().get(carId - 1).setRentedBy(pd.getCustomers().get(userId -1));
    }

    private void updateRentingCustomer(int userId, int carId) {
        pd.getCustomers().get(userId - 1).increaseNumberOfRentals(1);
        pd.getCustomers().get(userId - 1).increaseMoneySpent(pd.getCars().get(carId - 1).getPrice());
        pd.getCustomers().get(userId - 1).addCarToCurrentlyRented(pd.getCars().get(carId -1));
    }

    private void updateReturnedCar(int carId) {
        pd.getCars().get(carID - 1).setRented(false);
        pd.getCars().get(carID - 1).setRentedBy(null);
    }

    private int selectCarForRent() {
        int i = 0;
        int result = 0;
        if (checkIfThereAreCarsForRent(pd.getCars())){
            System.out.println("Pick your car: ");
            for(Car car: pd.getCars()){
                i++;
                if(!car.isRented()){
                    System.out.println("[" + i + "]" + car.getModel() + " " + car.getType() + " price: " + car.getPrice() + " available: " + !car.isRented());
                }
            }
            try {
                result = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please select valid car! [1 - " + i + "]");
            }
            if(result < 1 || result > i) {
                System.out.println("Please select valid car! [1 - " + i + "]");
                return 0;
            } else {
                return result;
            }
        } else {
            System.out.println("There are no cars available to rent.");
            return 0;
        }
    }

    private int selectCarToReturn(){
        int i = 0;
        int result = 0;
        if(checkIfThereAreCarsToReturn(pd.getCars())){
            System.out.println("Pick the car you want to return: ");
            for(Car car: pd.getCars()){
                i++;
                if(car.isRented()){
                    System.out.println("[" + i + "]" + car.getModel() + " " + car.getType() + " price: " + car.getPrice() + " available: " + !car.isRented());
                }
            }
            try {
                result = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please select valid car! [1 - " + i + "]");
            }
            if(result < 1 || result > i) {
                System.out.println("Please select valid car! [1 - " + i + "]");
                return 0;
            } else {
                return result;
            }
        } else {
            System.out.println("There are no cars available to return.");
            return 0;
        }
    }

    private int selectUser(){
        int i = 0;
        int result = 0;
        System.out.println("Select user: ");
        for(Customer customer: pd.getCustomers()){
            i++;
            System.out.println("[" + i + "]" + customer.getName() + " " + customer.getSurName());
        }
        try {
            result = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please select valid user! [1 - " + i + "]");
        }
        if(result < 1 || result > i) {
            System.out.println("Please select valid user! [1 - " + i + "]");
            return 0;
        } else {
            return result;
        }
    }

    private boolean checkIfThereAreCarsForRent(List<Car> cars){
        for(Car c : cars){
            if (!c.isRented()) return true;
        }
        return false;
    }

    private boolean checkIfThereAreCarsToReturn(List<Car> cars){
        for(Car c : cars) {
            if (c.isRented()) return true;
        }
        return false;
    }

    public void addNewCar() {
        System.out.println("Enter model name: ");

        String modelName = scanner.nextLine();
        System.out.println("Select type: ");
        System.out.println("[S]EDAN, [V]AN, S[U]V, [H]ATCHBACK, [C]ONVERTIBLE, C[O]UPE, S[T]ATION_WAGON, S[P]ORTS_CAR");
        CarType type;
        switch(scanner.nextLine().toUpperCase()) {
            case "S" -> type = CarType.SEDAN;
            case "V" -> type = CarType.VAN;
            case "U" -> type = CarType.SUV;
            case "H" -> type = CarType.HATCHBACK;
            case "C" -> type = CarType.CONVERTIBLE;
            case "O" -> type = CarType.COUPE;
            case "T" -> type = CarType.STATION_WAGON;
            case "P" -> type = CarType.SPORTS_CAR;
            default -> {
                System.out.println("Invalid choice. Setting to default (SEDAN).");
                type = CarType.SEDAN;
            }
        }
        int mileage = 0;
        boolean isCarDataValid = true;
        System.out.println("Enter mileage: ");
        try {
            mileage = scanner.nextInt();
        } catch (Exception e){
            isCarDataValid = false;
        }
        double price = 0;
        System.out.println("Enter price: ");
        try {
            price = scanner.nextDouble();
            scanner.nextLine(); // to consume the last \n that scanner.nextDouble/Int has left in the input buffer
        } catch (Exception e){
            isCarDataValid = false;
        }
        if (isCarDataValid) {
            var car = new CarBuilder().withModel(modelName).withType(type).withMileage(mileage).withPrice(price).build();
            System.out.println("Is this data correct? [Y] - add to the list / [N] - discard \n" + car);
            switch(scanner.nextLine().toUpperCase()) {
                case "Y" -> {
                    pd.getCars().add(car);
                    System.out.println("New car added.");
                }
                case "N" -> System.out.println("New car wasn't added.");
                default -> System.out.println("Invalid selection, car wasn't added.");
            }
        } else {
            System.out.println("Car data invalid, car creation cancelled.");
        }

    }
}
