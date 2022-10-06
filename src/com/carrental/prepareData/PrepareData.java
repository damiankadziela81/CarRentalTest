package com.carrental.prepareData;

import com.carrental.carRepository.Car;
import com.carrental.carRepository.CarType;
import com.carrental.customerDataBase.Customer;

import java.util.ArrayList;
import java.util.List;

public class PrepareData {

    List<Car> cars = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    public void fillCarList(){
        cars.add(new Car("Audi",CarType.SEDAN,0,null, 100.0));
        cars.add(new Car("Porche",CarType.SPORTS_CAR,0,null, 150));
        cars.add(new Car("Volvo",CarType.STATION_WAGON,0,null, 80));
        cars.add(new Car("BMW",CarType.SUV,0,null, 120));
        cars.add(new Car("Toyota",CarType.VAN,0,null, 60));
    }

    public void fillCustomerList(){
        customers.add(new Customer("Damian", "Kadziela"));
        customers.add(new Customer("Agnieszka", "Burak"));
        customers.add(new Customer("Stefan", "Cebula"));
    }



//    public String getBranchNames(){
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        for(CarRentalBranch crb: carRentalBranches) {
//            i++;
//            sb.append("[" + i + "] " + crb.getName()+"\n");
//        }
//        return sb.toString();
//    }



    public List<Car> getCars(){
        return cars;
    }

    public List<Customer> getCustomers(){
        return customers;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

}


