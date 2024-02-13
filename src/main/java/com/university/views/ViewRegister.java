package com.university.views;

import com.university.exceptions.registerexceptions.RegisterNullException;
import com.university.repository.models.Register;

public class ViewRegister extends ViewMain{
    public static void startMenu() {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    createRegister();
                    break;
                case 2:
                    printRegister();
                    break;
                case 3:
                    modifyRegister();
                    break;
                case 4:
                    listRegisters();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Not Available Choice");
                    sc.next();
            }
        }while(opc>0);
    }

    private static void createRegister() {
        sc.nextLine();
        System.out.println("Creating new Register...");
        System.out.print("\t Student ID: ");
        int student = sc.nextInt();
        System.out.print("\t Period ID: ");
        int period = sc.nextInt();
        System.out.print("\t Subject ID: ");
        int subject = sc.nextInt();
        Register register = new Register(student, period, subject);
        serviceRegister.create(register);
        System.out.println("Register Created");
        sc.next();
    }
    
    private static Register getRegister() {
        sc.nextLine();
        System.out.print("\t Register's ID: ");
        int id = sc.nextInt();
        try {
            return serviceRegister.findById(id);
        } catch (RegisterNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void printRegister() {
        System.out.println("Searching a Register...");
        sc.nextLine();
        System.out.print("\t Register's ID: ");
        int id = sc.nextInt();
        try {
            Register register = serviceRegister.findById(id);
            System.out.println();
            register.print();
        } catch (RegisterNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifyRegister() {
        System.out.println("Modifying a Register...");
        Register register = getRegister();
        if(register != null) {
            int opc = 0;
            System.out.println(" 1) Student ID");
            System.out.println(" 2) Period ID");
            System.out.println(" 3) Subject ID");
            opc = sc.nextInt();
            sc.nextLine();
            switch(opc){
                case 1:
                    System.out.print("\t New Student ID: ");
                    int student = sc.nextInt();
                    register.setStudentId(student);
                    break;
                case 2:
                    System.out.print("\t Period ID: ");
                    int period = sc.nextInt();
                    register.setPeriodId(period);
                    break;
                case 3:
                    System.out.print("\t Subject ID: ");
                    int subject = sc.nextInt();
                    register.setSignatureId(subject);
                    break;
                default:
                    System.out.println("Incorrect Choose");
                    break;
                
            }
            serviceRegister.update(register);
            System.out.println("Register Modified");
        }
        sc.next();
    }

    private static void listRegisters() {
        System.out.println("Register's List");
        for(Register register : serviceRegister.toList()) {
            register.print();
            System.out.println();
        }
        sc.next();
    }

        private static int showMenu() {
        System.out.println("*".repeat(10) + " Register's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Register");
        System.out.println("\t 2) Get Register by ID");
        System.out.println("\t 3) Edit Register");
        System.out.println("\t 4) List Registers");
        System.out.println("\t 0) Return to Main Menu");
        System.out.println("*".repeat(35));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    }
}
