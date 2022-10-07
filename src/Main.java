import com.carrental.controller.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.initialize();
        String userInput;

        while (true){

            System.out.println("Welcome to Car Rental, please make your choice: ");
            System.out.println("1. Display stats");
            System.out.println("2. Display available cars");
            System.out.println("3. Display customers info");
            System.out.println("4. Add a new customer");
            System.out.println("5. Rent a car");
            System.out.println("6. Return a car");
            System.out.println("Q. Exit");
            Scanner scanner = new Scanner(System.in);

            userInput = scanner.nextLine().toLowerCase();

            switch(userInput) {
                case "1": menu.currentStatus();
                    break;
                case "2": menu.displayCars();
                    break;
                case "3": menu.displayCustomers();
                    break;
                case "4": menu.addCustomer();
                    break;
                case "5": menu.rentCar();
                    break;
                case "6": menu.returnCar();
                    break;
                case "q": System.exit(0);
                    break;
                default:
                    System.out.println("You didn't enetered a valid digit!");

            }
        }
    }
}