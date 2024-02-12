package com.university.views;

public class ViewReports extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createReport();
                    break;
                case 2:
                    getReport();
                    break;
                case 3:
                    modifyReport();
                    break;
                case 4:
                    deleteReport();
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
        System.out.println("\t 1) Students by Course");
        System.out.println("\t 2) Cost of a Student's semester");
        System.out.println("\t 3) University income per semester");
        System.out.println("\t 4) Display a student's timetable");
        System.out.println("\t 5) Number of Students by Program (Ordered)");
        System.out.println("\t 6) Return to Main Menu");
        return sc.nextInt();
    }

    private static void createReport(){
        
        //serviceReport.create(Report);
    }

    private static void getReport() {
        
    }

    private static void modifyReport() {
        
    }

    private static void deleteReport() {
      
    }
    
}
