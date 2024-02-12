package com.university.views;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.repository.impl.impladdress.RepositoryAddressMysqlImpl;
import com.university.repository.impl.implcity.RepositoryCityMysqlImpl;
import com.university.repository.models.Address;
import com.university.repository.models.City;
import com.university.repository.models.Department;
import com.university.repository.models.Person;
import com.university.services.ServiceAddress;
import com.university.services.ServiceCity;
import com.university.services.impl.ServiceAddressImpl;
import com.university.services.impl.ServiceCityImpl;

public class ViewTeacher extends ViewMain{

    private static final ServiceAddress serviceAddress = new ServiceAddressImpl(new RepositoryAddressMysqlImpl());
    private static final ServiceCity serviceCity = new ServiceCityImpl(new RepositoryCityMysqlImpl());

    public static void startMenu() {

        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createTeacher();
                    break;
                case 2:
                    getTeacher();
                    break;
                case 3:
                    modifyTeacher();
                    break;
                case 4:
                    deleteTeacher();
                    break;
                case 5:
                    listTeachers();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<5);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Student's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Teacher");
        System.out.println("\t 2) Get Teacher by ID");
        System.out.println("\t 3) Edit Teacher");
        System.out.println("\t 4) Delete Teacher");
        System.out.println("\t 5) List Teachers");
        System.out.println("\t 6) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createTeacher() {
        sc.nextLine();
        System.out.println("*".repeat(40));
        System.out.println("Create a new Student");
        int typeId = 0;
        do{
            System.out.println("- ID Type");
            System.out.println("\t- 1) CC");
            System.out.println("\t- 2) TI");
            System.out.print("- Choose: ");
            typeId = sc.nextInt();
        }while(typeId < 1 || typeId > 2);
        sc.nextLine();
        String type = (typeId == 1) ? "C.C" : "T.I";
        System.out.print("- Id Number: ");
        String id = sc.nextLine();
        System.out.print("- Name: ");
        String name = sc.nextLine();
        System.out.print("- LastName: ");
        String lastName = sc.nextLine();
        System.out.println("- Phone Number: ");
        String phone = sc.nextLine();
        System.out.println("- Date of Birth");
        System.out.print("\t- Year: ");
        int age = sc.nextInt();
        System.out.print("\t- Month: ");
        int month = sc.nextInt();
        System.out.print("\t- Day: "); 
        int day = sc.nextInt();
        String date = age + "-" + month + "-" + day;
        int gender = 0;
        do{
            System.out.println("- Gender");
            System.out.println("\t- 1) Male");
            System.out.println("\t- 2) Female");
            System.out.print("- Choose: ");
            gender = sc.nextInt();
        }while(gender < 1 || gender > 2);
        String gender_s = (gender == 1) ? "M" : "F";

        List<City> cities = serviceCity.toList();
        System.out.println("Cities List");
        for (int i=0; i<cities.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + cities.get(i).getName());
        }
        int op_city = 0;
        do{
            System.out.print("\t Choose a City: ");
            op_city = sc.nextInt();
        }while(op_city < 1 || op_city > cities.size());
        int city = cities.get(op_city-1).getId();
        List<Address> addresses = serviceAddress.toList();
        System.out.println("Address List");
        int op_address = 0;
        for (int i=0; i<addresses.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + addresses.get(i).getAddress());
        }
        do{
            System.out.print("\t Choose an Address: ");
            op_address = sc.nextInt();
        }while(op_address < 1 || op_address > addresses.size());
        int address = addresses.get(op_address-1).getId();
        System.out.println("Departments List");
        List<Department> departments = serviceDepartment.toList();
        for (int i=0; i<departments.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + departments.get(i).getName());
        }
        int op_department = 0;
        do{
            System.out.print("\t Choose a Department: ");
            op_department = sc.nextInt();
        }while(op_department < 1 || op_department > departments.size());
        int department = departments.get(op_department-1).getId();
        Person person = new Person(type, id, name, lastName, phone, date, gender_s, city, address);
        try {
            serviceTeacher.create(person, department);
            System.out.println("Teacher created successfully!");
        } catch (PersonExceptionInsertDataBase e) {
            System.out.println(e.getMessage());
        }
        sc.next();
    }

    private static void getTeacher() {

        System.out.println("Searching a Teacher...");
        sc.nextLine();
        System.out.print("\t Teacher's Document: ");
        String document = sc.nextLine();
        try {
            Person teacher = serviceTeacher.findByDocument(document);
            teacher.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.next();
    }

    private static void modifyTeacher() {
        
    }

    private static void deleteTeacher() {

    }
    
    private static void listTeachers() {
        System.out.println("Teachers List");
        for (Person teacher : serviceTeacher.toList()){
            teacher.print();
        }
        sc.next();
    }

}
