package com.university.views;

import com.university.exceptions.periodexceptions.PeriodExceptionInsertDataBase;
import com.university.exceptions.periodexceptions.PeriodNullException;
import com.university.repository.models.Period;

public class ViewPeriod extends ViewMain {

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createPeriod();
                    break;
                case 2:
                    getPeriod();
                    break;
                case 3:
                    modifyPeriod();
                    break;
                case 4:
                    listPeriods();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<5);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Period's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Period");
        System.out.println("\t 2) Get Period by ID");
        System.out.println("\t 3) Edit Period");
        System.out.println("\t 4) List Periods");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createPeriod(){
        sc.nextLine();
        System.out.println("Creating new Period...");
        String year = "";
        do {
            System.out.print("\t Period's Year: ");
            year = sc.nextLine();
        }while(year.length() != 4 || year.matches("[0-9]+") == false);

        int opc = 0;
        do {
            System.out.println("\t Period's Semester: ");
            System.out.println("\t  1) 01");
            System.out.println("\t  2) 02");
            System.out.print("\t Choose(1/2)");
            opc = sc.nextInt();
        }while(opc < 0 || opc > 2);
        String semester = "";
        if(opc == 1) semester = "01";
        else semester = "02";
        String period_code = "P"+year.substring(2, 4)+"-"+semester;
        Period period = new Period(year, semester, period_code);
        try {
            servicePeriod.create(period);
            System.out.println("Period created successfully!");
        } catch (PeriodExceptionInsertDataBase e) {
            System.out.println(e.getMessage());
        }
        sc.next();
    }

    private static void getPeriod() {
        System.out.println("Searching a Period...");
        sc.nextLine();
        System.out.print("\t Period's ID: ");
        int id = sc.nextInt();
        try {
            Period period = servicePeriod.findById(id);
            System.out.println();
            period.print();
        } catch (PeriodNullException e) {
            System.out.println(e.getMessage());
        }
        sc.next();
    }

    private static void modifyPeriod() {
        
    }

    private static void deletePeriod() {
      
    }

    public static void listPeriods() {
        System.out.println("Period's List");
        for(Period period : servicePeriod.toList()) {
            period.print();
            System.out.println();
        }
        sc.next();
    }
    
}
