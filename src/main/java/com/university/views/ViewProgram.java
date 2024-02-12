package com.university.views;

import com.university.exceptions.programexceptions.ProgramNullException;
import com.university.repository.models.Program;

public class ViewProgram extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    createProgram();
                    break;
                case 2:
                    printProgram();
                    break;
                case 3:
                    modifyProgram();
                    break;
                case 4:
                    listPrograms();
                    break;
                default:
                    break;
            }
        }while(opc>0 && opc<5);
    }

    private static int showMenu() {
        System.out.println("*".repeat(10) + " Program's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Program");
        System.out.println("\t 2) Get Program by ID");
        System.out.println("\t 3) Edit Program");
        System.out.println("\t 4) List Programs");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createProgram(){
        sc.nextLine();
        System.out.println("Creating new Program...");
        System.out.print("\t Program's Name: ");
        String name = sc.nextLine();
        Program program = new Program(name);
        serviceProgram.create(program);
        System.out.println("Program created successfully!");
        sc.next();
    }

    private static Program getProgram() {
        System.out.println("Searching a Program...");
        sc.nextLine();
        System.out.print("\t Program's ID: ");
        int id = sc.nextInt();
        try {
            return serviceProgram.findById(id);
        } catch (ProgramNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void printProgram() {
        System.out.println("Searching a Program...");
        sc.nextLine();
        System.out.print("Program's ID: ");
        int id = sc.nextInt();
        try {
            Program program = serviceProgram.findById(id);
            System.out.println();
            program.print();
        } catch (ProgramNullException e) {
            System.out.println(e.getMessage());
        }
        sc.next();
    }

    private static void modifyProgram() {
        
    }

    public static void listPrograms() {
        System.out.println("Program's List");
        for(Program program : serviceProgram.toList()) {
            program.print();
            System.out.println();
        }
        sc.next();
    }
    
}
