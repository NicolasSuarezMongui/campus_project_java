package com.university.views;

import com.university.exceptions.fareexceptions.FareNullException;
import com.university.repository.models.Tuition;

public class ViewFare extends ViewMain {

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createFare();
                    break;
                case 2:
                    printFare();
                    break;
                case 3:
                    modifyFare();
                    break;
                case 4:
                    listFares();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<5);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Fare's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Fare");
        System.out.println("\t 2) Get Fare by ID");
        System.out.println("\t 3) Edit Fare");
        System.out.println("\t 4) List Fares");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createFare(){
        
        sc.nextLine();
        System.out.println("Creating new Fare...");
        System.out.print("\t Program ID: ");
        int program = sc.nextInt();
        System.out.print("\t Period ID: ");
        int period = sc.nextInt();
        System.out.print("\t Credit Value: ");
        int value = sc.nextInt();
        Tuition fare = new Tuition(value, program, period);
        serviceTuition.create(fare);
        sc.next();

    }

    private static Tuition getFare() {

        sc.nextLine();
        System.out.print("\t Fare's ID: ");
        int id = sc.nextInt();
        try {
            return serviceTuition.findById(id);
        } catch (FareNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    private static void printFare() {
        System.out.println("Searching a Fare...");
        sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        try {
            Tuition fare = serviceTuition.findById(id);
            System.out.println();
            fare.print();
        } catch (FareNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifyFare() {

        System.out.println("Modifying a Fare...");
        Tuition fare = getFare();
        if(fare != null) {
            int opc = 0;
            System.out.println(" 1) Program");
            System.out.println(" 2) Period");
            System.out.println(" 3) Credit Value");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc == 1){
                System.out.print("\t New Program: ");
                int program = sc.nextInt();
                fare.setProgramId(program);
            }else if(opc == 2){
                System.out.print("\t New Period: ");
                int period = sc.nextInt();
                fare.setPeriodId(period);
            }else if(opc == 3){
                System.out.print("\t New Credit Value: ");
                int value = sc.nextInt();
                fare.setCreditValue(value);
            }else{
                System.out.println("Incorrect Choose");
            }
            serviceTuition.update(fare);
            System.out.println("Fare Modified");
        }
        sc.next();
        
    }


    private static void listFares(){
        System.out.println("Fare's List");
        for(Tuition fare : serviceTuition.toList()) {
            fare.print();
            System.out.println();
        }
        sc.next();
    }
    
}
