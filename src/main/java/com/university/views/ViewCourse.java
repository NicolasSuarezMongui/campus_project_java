package com.university.views;

import com.university.exceptions.courseexceptions.CourseNullException;
import com.university.repository.models.Course;

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
                    printCourse();
                    break;
                case 3:
                    modifyCourse();
                    break;
                case 4:
                    listCourses();
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
        System.out.println("\t 4) List Courses");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createCourse(){
        
        sc.nextLine();
        System.out.println("Creating new Course...");
        System.out.println("Enter the Course's name: ");
        String name = sc.nextLine();
        System.out.println("Enter the Course's guide: ");
        String guide = sc.nextLine();
        Course course = new Course(name, guide);
        serviceCourse.create(course);

    }

    private static Course getCourse() {
        sc.nextLine();
        System.out.println("Enter the Course's ID: ");
        int id = sc.nextInt();
        try {
            return serviceCourse.findById(id);
        } catch (CourseNullException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void printCourse() {
        System.out.println("Searching a Course...");
        sc.nextLine();
        System.out.println("Enter the Course's ID: ");
        int id = sc.nextInt();
        try {
            Course course = serviceCourse.findById(id);
            System.out.println();
            course.print();
        } catch (CourseNullException e){
            System.out.println(e.getMessage());
        }
    }

    private static void modifyCourse() {
        System.out.println("Modifying a Course...");
        Course course = getCourse();
        if(course != null) {
            int opc = 0;
            System.out.println(" 1) Name");
            System.out.println(" 2) Guide Document");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc == 1){
                System.out.print("\t New Course's Name: ");
                String name = sc.nextLine();
                course.setName(name);
            }else if(opc == 2){
                System.out.print("\t New Course's Name: ");
                String urlguide = sc.nextLine();
                course.setGuide(urlguide);
            }else{
                System.out.println("Incorrect Choose");
            }
            serviceCourse.update(course);
            System.out.println("Course Modified");
        }
        sc.next(); 
        
    }

    private static void listCourses(){
        System.out.println("Courses List");
        for (Course course : serviceCourse.toList()){
            course.print();
            System.out.println();
        }
        sc.next();
    }
    
}
