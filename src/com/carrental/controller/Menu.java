package com.carrental.controller;

import com.carrental.carRepository.Car;
import com.carrental.customerDataBase.Customer;
import com.carrental.prepareData.PrepareData;

import java.util.Scanner;

public class Menu {
    PrepareData pd = new PrepareData();
    Scanner scanner = new Scanner(System.in);
    int userID;
    int carID;



    public void displayBranches(){


    }

    public void initialize(){
        pd.fillCarList();
        pd.fillCustomerList();

//        System.out.println(pd.getPilaBranch());
//        System.out.println(pd.getPoznanBranch());
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

    public void rent() {
        userID = selectUser();
        System.out.println("You selected user: " + userID);
        carID = selectCar();
        System.out.println("You selected car: " + carID);
        //update user with selected car
        updateCustomer(userID, carID);
        updateCar(userID, carID);


    }

    private void updateCar(int userID, int carID) {

    }

    private void updateCustomer(int userID, int carID) {
        System.out.println(pd.getCustomers().get(userID - 1).getName());
        System.out.println(pd.getCars().get(carID - 1).getModel());

    }

    private int selectCar() {
        int i = 0;
        int result = 0;
        System.out.println("Pick your car: ");
        for(Car car: pd.getCars()){
            i++;
            System.out.println("[" + i + "]" + car.getModel() + " " + car.getType() + " price: " + car.getPricePerDay());
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
    }

    private int selectUser(){

        int i = 0;
        int result = 0;
        System.out.println("Select user: ");
        for(Customer customer: pd.getCustomers()){
            i++;
            System.out.println("[" + i + "]" + customer.getName() + " " + customer.getSurName());
        }

//        while(userID < 1 || userID > i){
            try {
                result = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please select valid user! [1 - " + i + "]");
//                break;
            }
            if(result < 1 || result > i) {
                System.out.println("Please select valid user! [1 - " + i + "]");
                return 0;
            } else {
                return result;
            }

//        }
//        return userID;
    }
}
