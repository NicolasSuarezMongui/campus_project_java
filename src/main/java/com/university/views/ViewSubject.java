package com.university.views;

import com.university.repository.models.Subject;

public class ViewSubject extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createSubject();
                    break;
                case 2:
                    getSubject();
                    break;
                case 3:
                    modifySubject();
                    break;
                case 4:
                    deleteSubject();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<4);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Student's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Subject");
        System.out.println("\t 2) Get Subject by ID");
        System.out.println("\t 3) Edit Subject");
        System.out.println("\t 4) Delete Subject");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createSubject(){

    }

    private static void getSubject() {
        
    }

    private static void modifySubject() {
        
    }

    private static void deleteSubject() {
      
    }
    
}
