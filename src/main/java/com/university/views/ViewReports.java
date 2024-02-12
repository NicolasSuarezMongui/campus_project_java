package com.university.views;

import java.util.List;

import com.university.exceptions.personexceptions.PersonNullException;
import com.university.repository.models.Schedule;

public class ViewReports extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    studentByCourse();
                    break;
                case 2:
                    studentSemesterCost();
                    break;
                case 3:
                    incomePerSemester();
                    break;
                case 4:
                    studentSchedule();
                    break;
                case 5:
                    studentsByProgram();
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

    private static void studentByCourse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'studentByCourse'");
    }

    private static void studentSemesterCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'studentSemesterCost'");
    }

    private static void incomePerSemester() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incomePerSemester'");
    }

    private static void studentSchedule() {
        sc.nextLine();
        List<Schedule> schedules = null;
        System.out.println("Enter the student's document: ");
        String document = sc.nextLine();
        int studentId;
        try {
            studentId = serviceStudent.findByDocument(document).getId();
            schedules = serviceSchedule.toListByStudentId(studentId);
            if(schedules != null) {
                for(Schedule schedule : schedules) {
                    schedule.print();
                    System.out.println();
                }
            } else {
                System.out.println("No schedules found for student with ID: " + studentId);
            }
        } catch (PersonNullException e) {
            e.printStackTrace();
        }
        sc.next();
    }

    private static void studentsByProgram() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'studentsByProgram'");
    }
    
}
