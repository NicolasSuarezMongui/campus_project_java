package com.university.views;

import com.university.exceptions.departmentexceptions.DepartmentNullException;
import com.university.repository.models.Department;

public class ViewDepartment extends ViewMain {

    public static void startMenu() {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    createDepartment();
                    break;
                case 2:
                    printDepartment();
                    break;
                case 3:
                    modifyDepartment();
                    break;
                case 4:
                    listDepartments();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<4);
    }

        private static int showMenu() {
        System.out.println("*".repeat(10) + " Department's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Department");
        System.out.println("\t 2) Get Department by ID");
        System.out.println("\t 3) Edit Department");
        System.out.println("\t 4) List Department");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createDepartment(){
        sc.nextLine();
        System.out.println("Creating new Department...");
        System.out.print("\t Department's Name: ");
        String name = sc.nextLine();
        Department department = new Department(name);
        serviceDepartment.create(department);
        sc.next();
    }

    private static Department getDepartment() {
        System.out.print("\t Department's ID: ");
        int id = sc.nextInt();
        try {
            return serviceDepartment.findById(id);
        } catch (DepartmentNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void printDepartment() {
        System.out.println("Searching a Department...");
        sc.nextLine();
        System.out.print("Documento: ");
        int id = sc.nextInt();

        try {
            Department department = serviceDepartment.findById(id);
            System.out.println();
            department.print();
        } catch (DepartmentNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifyDepartment() {
        System.out.println("Modifying a Department...");
        Department department = getDepartment();
        if(department != null) {
            int opc = 0;
            do {
                System.out.println(" 1) Name");
                System.out.println(" 2) Save & Exit");
                opc = sc.nextInt();
                if(opc == 1){
                    System.out.print("\t Department's Name: ");
                    String name = sc.nextLine();
                    department.setName(name);
                }
            }while(opc < 1 || opc >= 2);
            System.out.println("Modified");
        }        
    }

    private static void listDepartments() {
        System.out.println("Department's List");
        for(Department department : serviceDepartment.toList()) {
            department.print();
            System.out.println();
        }
        sc.next();
    }
    
}
