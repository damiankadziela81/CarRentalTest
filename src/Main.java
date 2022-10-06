import com.carrental.controller.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.initialize();
        int userInput=0;

        while (true){

            System.out.println("Welcome to Car Rental, please make your choice: ");
            System.out.println("1. Not implemented");
            System.out.println("2. Display available cars");
            System.out.println("3. Display customers info");
            System.out.println("4. Enter customer info");
            System.out.println("5. Rent a car");
            System.out.println("6. Exit");
            Scanner scanner = new Scanner(System.in);
            try {
                userInput = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You didn't enetered a valid digit!");
            }


            switch(userInput) {
                case 1: menu.displayBranches();
                    break;
                case 2: menu.displayCars();
                    break;
                case 3: menu.displayCustomers();
                    break;
                case 4: menu.addCustomer();
                    break;
                case 5: menu.rent();
                    break;
                case 6: System.exit(0);
                    break;
                default:
                    System.out.println("You didn't enetered a valid digit!");


            }

        }


    }
}