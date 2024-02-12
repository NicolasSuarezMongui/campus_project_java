package com.university.views;

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
                    getFare();
                    break;
                case 3:
                    modifyFare();
                    break;
                case 4:
                    deleteFare();
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
        System.out.println("\t 4) Delete Fare");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createFare(){
        
        //serviceFare.create(Fare);
    }

    private static void getFare() {
        
    }

    private static void modifyFare() {
        
    }

    private static void deleteFare() {
      
    }
    
}
