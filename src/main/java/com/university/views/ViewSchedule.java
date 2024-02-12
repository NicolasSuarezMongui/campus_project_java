package com.university.views;

public class ViewSchedule extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createSchedule();
                    break;
                case 2:
                    modifySchedule();
                    break;
                case 3:
                    deleteSchedule();
                    break;
                default:
                    break;
            }
        }while(opc>0 && opc<5);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Student's Menu " + "*".repeat(10));
        System.out.println("\t 1) Asign a new Schedule");
        System.out.println("\t 2) Edit Student");
        System.out.println("\t 3) Delete Student");
        System.out.println("\t 4) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createSchedule(){
        
        //serviceSchedule.create(Schedule);
    }

    private static void getSchedule() {
        
    }

    private static void modifySchedule() {
        
    }

    private static void deleteSchedule() {
      
    }
    
}
