package com.university.views;

import java.util.Scanner;

import com.university.repository.impl.implclassroom.RepositoryClassroomMysqlImpl;
import com.university.repository.impl.implcourse.RepositoryCourseMysqlImpl;
import com.university.repository.impl.impldepartment.RepositoryDepartmentMysqlImpl;
import com.university.repository.impl.implperiod.RepositoryPeriodMysqlImpl;
import com.university.repository.impl.implprogram.RepositoryProgramMysqlImpl;
import com.university.repository.impl.implschedule.RepositoryScheduleMysqlImpl;
import com.university.repository.impl.implsignature.RepositorySignatureMysqlImpl;
import com.university.repository.impl.implstudent.RepositoryStudentMysqlImpl;
import com.university.repository.impl.implteacher.RepositoryTeacherMysqlImpl;
import com.university.repository.impl.impltuition.RepositoryTuitionMysqlImpl;
import com.university.services.ServiceClassroom;
import com.university.services.ServiceCourse;
import com.university.services.ServiceDepartment;
import com.university.services.ServicePeriod;
import com.university.services.ServiceProgram;
import com.university.services.ServiceSchedule;
import com.university.services.ServiceSignature;
import com.university.services.ServiceStudent;
import com.university.services.ServiceTeacher;
import com.university.services.ServiceTuition;
import com.university.services.impl.ServiceClassroomImpl;
import com.university.services.impl.ServiceCourseImpl;
import com.university.services.impl.ServiceDepartmentImpl;
import com.university.services.impl.ServicePeriodImpl;
import com.university.services.impl.ServiceProgramImpl;
import com.university.services.impl.ServiceScheduleImpl;
import com.university.services.impl.ServiceSignatureImpl;
import com.university.services.impl.ServiceStudentImpl;
import com.university.services.impl.ServiceTeacherImpl;
import com.university.services.impl.ServiceTuitionImpl;

public class ViewMain {

    public static final ServiceClassroom serviceClassroom = new ServiceClassroomImpl(new RepositoryClassroomMysqlImpl());
    public static final ServiceCourse serviceCourse = new ServiceCourseImpl(new RepositoryCourseMysqlImpl());
    public static final ServiceStudent serviceStudent = new ServiceStudentImpl(new RepositoryStudentMysqlImpl());
    public static final ServiceTeacher serviceTeacher = new ServiceTeacherImpl(new RepositoryTeacherMysqlImpl());
    public static final ServiceProgram serviceProgram = new ServiceProgramImpl(new RepositoryProgramMysqlImpl());
    public static final ServiceDepartment serviceDepartment = new ServiceDepartmentImpl(new RepositoryDepartmentMysqlImpl());
    public static final ServicePeriod servicePeriod = new ServicePeriodImpl(new RepositoryPeriodMysqlImpl());
    public static final ServiceTuition serviceTuition = new ServiceTuitionImpl(new RepositoryTuitionMysqlImpl());
    public static final ServiceSchedule serviceSchedule = new ServiceScheduleImpl(new RepositoryScheduleMysqlImpl());
    public static final ServiceSignature serviceSignature = new ServiceSignatureImpl(new RepositorySignatureMysqlImpl());
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        int opc = 0;

        do {
            opc = mainMenu();
            switch (opc) {
                case 1:
                    ViewStudent.startMenu();
                    break;
                case 2:
                    ViewTeacher.startMenu();
                    break;
                case 3:
                    ViewProgram.startMenu();
                    break;
                case 4:
                    ViewCourse.startMenu();
                    break;
                case 5:
                    ViewSubject.startMenu();
                    break;
                case 6:
                    ViewPeriod.startMenu();
                    break;
                case 7:
                    ViewFare.startMenu();
                    break;
                case 8:
                    ViewDepartment.startMenu();
                    break;
                case 9:
                    ViewClassroom.startMenu();
                    break;
                case 10:
                    ViewSchedule.startMenu();    
                    break;
                case 11:
                    ViewReports.startMenu();
                    break;
                default:
                    break;
            }
        }while(opc>0 && opc<12);
    }

    public static int mainMenu() {
        clear();
        System.out.println("*".repeat(10) + " SABIO'S UNIVERSITY SYSTEM " + "*".repeat(10));
        System.out.println("\t 1) Students Management");
        System.out.println("\t 2) Teachers Management");
        System.out.println("\t 3) Programs Management");
        System.out.println("\t 4) Courses Management");
        System.out.println("\t 5) Subjects Management");
        System.out.println("\t 6) Periods Management");
        System.out.println("\t 7) Fares Management");
        System.out.println("\t 8) Departments Management");
        System.out.println("\t 9) Classroom Management");
        System.out.println("\t10) Schedules Management");
        System.out.println("\t11) Reports");
        System.out.println("\t 0) Exit");
        System.out.println("*".repeat(47));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}