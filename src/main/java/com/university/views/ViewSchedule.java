package com.university.views;

import com.university.exceptions.scheduleexceptions.ScheduleNullException;
import com.university.repository.models.Schedule;

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
                    printSchedule();
                    break;
                case 3:
                    modifySchedule();
                    break;
                default:
                    break;
            }
        }while(opc>0 && opc<3);
    }

    private static int showMenu() {
        System.out.println("*".repeat(10) + " Student's Menu " + "*".repeat(10));
        System.out.println("\t 1) Asign a new Schedule");
        System.out.println("\t 2) Get Schedule by ID");
        System.out.println("\t 3) Edit Schedule");
        System.out.println("\t 0) Return to Main Menu");
        return sc.nextInt();
    } 

    private static String showDays() {
        int opc = 0;
        String day = "";
        do {
            System.out.println("\t 1) Lunes");
            System.out.println("\t 2) Martes");
            System.out.println("\t 3) Miercoles");
            System.out.println("\t 4) Jueves");
            System.out.println("\t 5) Viernes");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    day = "Lunes";
                    break;
                case 2:
                    day = "Martes";
                    break;
                case 3:
                    day = "Miercoles";
                    break;
                case 4:
                    day = "Jueves";
                    break;
                case 5:
                    day = "Viernes";
                    break;
                default:
                    System.out.println("Not Available Choice");
                    sc.next();
            }
        }while(opc <= 0 || opc > 5);
        return day;
    }

    private static void createSchedule(){
        
        sc.nextLine();
        System.out.println("Creating new Schedule...");
        System.out.print("\t Day: ");
        String day = showDays();
        System.out.print("\t Start Hour: ");
        String start = sc.nextLine();
        System.out.print("\t Finish Hour: ");
        String end = sc.nextLine();
        System.out.print("\t Classroom ID: ");
        int classroom = sc.nextInt();
        System.out.print("\t Subject ID: ");
        int subject = sc.nextInt();
        Schedule schedule = new Schedule(day, start, end, classroom, subject);
        serviceSchedule.create(schedule);
    }

    private static Schedule getSchedule() {
                sc.nextLine();
        System.out.print("\t Schedule's ID: ");
        int id = sc.nextInt();
        try {
            return serviceSchedule.findById(id);
        } catch (ScheduleNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void printSchedule() {
        System.out.println("Searching a Schedule...");
        sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        try {
            Schedule schedule = serviceSchedule.findById(id);
            System.out.println();
            schedule.print();
        } catch (ScheduleNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifySchedule() {
        System.out.println("Modifying a Schedule...");
        Schedule schedule = getSchedule();
        if(schedule != null) {
            int opc = 0;
            System.out.println(" 1) Day");
            System.out.println(" 2) Start Hour");
            System.out.println(" 3) Finish Hour");
            System.out.println(" 4) Classroom ID");
            System.out.println(" 5) Subject ID");
            opc = sc.nextInt();
            sc.nextLine();
            switch(opc){
                case 1:
                    System.out.print("\t New Day: ");
                    String day = showDays();
                    schedule.setDay(day);
                    break;
                case 2:
                    System.out.print("\t New Start Hour: ");
                    String start = sc.nextLine();
                    schedule.setStart(start);
                    break;
                case 3:
                    System.out.print("\t New Final Hour: ");
                    String end = sc.nextLine();
                    schedule.setEnd(end);
                    break;
                case 4:
                    System.out.print("\t New Classroom ID: ");
                    int room = sc.nextInt();
                    schedule.setClassroomId(room);
                    break;
                case 5:
                    System.out.print("\t New Subject ID: ");
                    int subject = sc.nextInt();
                    schedule.setSignatureId(subject);
                    break;
                default:
                    System.out.println("Incorrect Choose");
                    break;
                
            }
            serviceSchedule.update(schedule);
            System.out.println("Schedule Modified");
        }
        sc.next();
    }
    
}
