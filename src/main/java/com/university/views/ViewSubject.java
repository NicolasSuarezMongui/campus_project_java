package com.university.views;

import com.university.exceptions.courseexceptions.CourseNullException;
import com.university.exceptions.subjectexceptions.SubjectNullException;
import com.university.repository.models.Signature;

public class ViewSubject extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    createSubject();
                    break;
                case 2:
                    printSubject();
                    break;
                case 3:
                    modifySubject();
                    break;
                case 4:
                    listSubjects();
                    break;
                case 0:
                    break;    
                default:
                    System.out.println("Not Available Choice");
                    sc.next();
            }
            
        }while(opc>0 && opc<4);
    }

        private static int showMenu() {
        System.out.println("*".repeat(10) + " Student's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Subject");
        System.out.println("\t 2) Get Subject by ID");
        System.out.println("\t 3) Edit Subject");
        System.out.println("\t 4) List Subjects");
        System.out.println("\t 0) Return to Main Menu");
        System.out.println("*".repeat(35));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    } 

    private static void createSubject() {
        sc.nextLine();
        System.out.println("Creating new Subject...");
        System.out.print("\t Course ID: ");
        int course = sc.nextInt();
        System.out.print("\t Period ID: ");
        int period = sc.nextInt();
        System.out.print("\t Teacher ID: ");
        int teacher = sc.nextInt();
        System.out.print("\t Num Credits: ");
        int credits = sc.nextInt();
        System.out.print("\t Capacity: ");
        int capacity = sc.nextInt();
        System.out.print("\t Duration: ");
        int duration = sc.nextInt();
        String name = "";
        try {
            name = "C" + course + "-PER" + period + "-" + serviceCourse.findById(course).getName();
        } catch (CourseNullException e) {
            e.printStackTrace();
        }
        Signature subject = new Signature(credits, capacity, duration, name, teacher, course, period);
        serviceSignature.create(subject);
        sc.next();
    }

    private static Signature getSubject() {
        sc.nextLine();
        System.out.print("\t Subject's ID: ");
        int id = sc.nextInt();
        try {
            return serviceSignature.findById(id);
        } catch (SubjectNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void printSubject() {
        System.out.println("Searching a Subject...");
        sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        try {
            Signature subject = serviceSignature.findById(id);
            System.out.println();
            subject.print();
        } catch (SubjectNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifySubject() {
        System.out.println("Modifying a Fare...");
        Signature subject = getSubject();
        if(subject != null) {
            int opc = 0;
            System.out.println(" 1) Period ID");
            System.out.println(" 2) Teacher ID");
            System.out.println(" 3) Course ID");
            System.out.println(" 4) Credits");
            System.out.println(" 5) Capacity");
            opc = sc.nextInt();
            sc.nextLine();
            switch(opc){
                case 1:
                    System.out.print("\t Period ID: ");
                    int period = sc.nextInt();
                    subject.setPeriodId(period);
                    break;
                case 2:
                    System.out.print("\t Teacher ID: ");
                    int teacher = sc.nextInt();
                    subject.setTeacherId(teacher);
                    break;
                case 3:
                    System.out.print("\t Course ID: ");
                    int course = sc.nextInt();
                    subject.setCourseId(course);
                    break;
                case 4:
                    System.out.print("\t Credits: ");
                    int credit = sc.nextInt();
                    subject.setCredits(credit);
                    break;
                case 5:
                    System.out.print("\t Capacity: ");
                    int capacity = sc.nextInt();
                    subject.setCapacity(capacity);
                    break;
                default:
                    System.out.println("Incorrect Choose");
                    break;
                
            }
            serviceSignature.update(subject);
            System.out.println("Subject Modified");
        }
        sc.next();
    }

    private static void listSubjects() {
        System.out.println("Subject's List");
        for(Signature subject : serviceSignature.toList()) {
            subject.print();
            System.out.println();
        }
        sc.next();
    }
    
}
