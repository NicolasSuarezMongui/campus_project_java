package com.university.views;

import java.util.List;

import com.university.exceptions.classroomexceptions.ClassroomExceptionInsertDataBase;
import com.university.exceptions.classroomexceptions.ClassroomNullException;
import com.university.repository.impl.implbuilding.RepositoryBuildingMysqlImpl;
import com.university.repository.models.Building;
import com.university.repository.models.Classroom;
import com.university.services.ServiceBuilding;
import com.university.services.impl.ServiceBuildingImpl;

public class ViewClassroom extends ViewMain{

    private static final ServiceBuilding serviceBuilding = new ServiceBuildingImpl(new RepositoryBuildingMysqlImpl());

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createClassroom();
                    break;
                case 2:
                    getClassroom();
                    break;
                case 3:
                    modifyClassroom();
                    break;
                case 4:
                    listClassrooms();
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
        System.out.println("\t 1) Create a new Classroom");
        System.out.println("\t 2) Get Classroom by ID");
        System.out.println("\t 3) Edit Classroom");
        System.out.println("\t 4) List Classrooms");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createClassroom(){
        sc.nextLine();
        System.out.println("Creating new Classroom...");
        System.out.print("\t Classroom's Name: ");
        String name = sc.nextLine();
        int capacity = 0;
        do {
            System.out.print("\t Classroom's Capacity: ");
            capacity = sc.nextInt();
        }while(capacity <= 0);
        int level = 0;
        do {
            System.out.print("\t Classroom's Level: ");
            level = sc.nextInt();
        }while(level <= 0);
        List<Building> buildings = serviceBuilding.toList();
        System.out.println("Building List");
        for (int i=0; i<buildings.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + buildings.get(i).getName());
        }
        int opc = 0;
        do {
            System.out.print("\t Choose a Building: ");
            opc = sc.nextInt();
        }while(opc < 0 || opc > buildings.size());
        int buildingId = buildings.get(opc-1).getId();
        Classroom classroom = new Classroom(capacity, level, name, buildingId);
        try {
            serviceClassroom.create(classroom);
            System.out.println("Classroom created successfully!");
        } catch (ClassroomExceptionInsertDataBase e) {
            System.out.println(e.getMessage());
        }
        sc.next();
        
    }

    private static void getClassroom() {
        System.out.println("Searching a Classroom...");
        sc.nextLine();
        System.out.print("\t Classroom's ID: ");
        int id = sc.nextInt();
        try {
            Classroom classroom = serviceClassroom.findById(id);
            System.out.println();
            classroom.print();
        } catch (ClassroomNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifyClassroom() {
        
    }

    private static void deleteClassroom() {
      
    }

    private static void listClassrooms() {
        System.out.println("Classrooms List");
        for (Classroom classroom : serviceClassroom.toList()) {
            classroom.print();
            System.out.println();
        }
        sc.next();
    }
    
}
