package com.university.views;

public class ViewCourse extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    getCourse();
                    break;
                case 3:
                    modifyCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<4);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Course's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Course");
        System.out.println("\t 2) Get Course by ID");
        System.out.println("\t 3) Edit Course");
        System.out.println("\t 4) Delete Course");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createCourse(){
        
        //serviceCourse.create(Course);
    }

    private static void getCourse() {
        
    }

    private static void modifyCourse() {
        
    }

    private static void deleteCourse() {
      
    }
    
}
