package com.university.views;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.exceptions.personexceptions.PersonNullException;
import com.university.repository.impl.impladdress.RepositoryAddressMysqlImpl;
import com.university.repository.impl.implcity.RepositoryCityMysqlImpl;
import com.university.repository.impl.implperson.RepositoryPersonMysqlImpl;
import com.university.repository.models.Address;
import com.university.repository.models.City;
import com.university.repository.models.Person;
import com.university.repository.models.Program;
import com.university.repository.models.Student;
import com.university.services.ServiceAddress;
import com.university.services.ServiceCity;
import com.university.services.ServicePerson;
import com.university.services.impl.ServiceAddressImpl;
import com.university.services.impl.ServiceCityImpl;
import com.university.services.impl.ServicePersonImpl;

public class ViewStudent extends ViewMain{

    private static final ServiceAddress serviceAddress = new ServiceAddressImpl(new RepositoryAddressMysqlImpl());
    private static final ServiceCity serviceCity = new ServiceCityImpl(new RepositoryCityMysqlImpl());
    private static final ServicePerson servicePerson = new ServicePersonImpl(new RepositoryPersonMysqlImpl());

    public static void startMenu() {

        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    getStudent();
                    break;
                case 3:
                    modifyStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    listStudents();
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
        System.out.println("\t 1) Create a new Student");
        System.out.println("\t 2) Get Student by ID");
        System.out.println("\t 3) Edit Student");
        System.out.println("\t 4) Delete Student");
        System.out.println("\t 5) List Students");
        System.out.println("\t 6) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createStudent() {
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
        List<Program> programs = serviceProgram.toList();
        int op_program = 0;
        System.out.println("Program List");
        for (int i=0; i<programs.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + programs.get(i).getName());
        }
        do{
            System.out.print("\t Choose a Program: ");
            
            op_program = sc.nextInt();
        }while(op_program < 1 || op_program > programs.size());
        int program = programs.get(op_program-1).getId();
        Person person = new Person(type, id, name, lastName, phone, date, gender_s, city, address);
        try {
            serviceStudent.create(person, program);
            System.out.println(person.getId());
            System.out.println("Student created successfully!");
        } catch (PersonExceptionInsertDataBase e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        sc.next();
    }

    private static void getStudent() {

        System.out.println("Searching a Student...");
        sc.nextLine();
        System.out.print("\t Student's Document: ");
        String document = sc.nextLine();
        try {
            Person student = serviceStudent.findByDocument(document);
            System.out.println();
            student.print();
        } catch (PersonNullException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        sc.next();
    }

    private static void modifyStudent() {
        sc.nextLine();
        System.out.println("Editing a Student...");
        System.out.print("\t Student's Document: ");
        String document = sc.nextLine();
        try {
            Person student = serviceStudent.findByDocument(document);

            System.out.println("Editing Student: ");
            System.out.print("Name: ");
            String newName = sc.nextLine();
            student.setFirstName((newName.length() > 0) ? newName : student.getFirstName());
            System.out.print("Last Name: ");
            String newLastName = sc.nextLine();
            student.setLastName((newLastName.length() > 0) ? newLastName : student.getLastName());
            System.out.print("Phone: ");
            String newPhone = sc.nextLine();
            student.setPhone((newPhone.length() > 0) ? newPhone : student.getPhone());
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
            student.setAddressId(address);
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
            student.setCityId(city);

            student.print();

            servicePerson.update(student);
            List<Program> programs = serviceProgram.toList();
            int op_program = 0;
            System.out.println("Program List");
            for (int i=0; i<programs.size(); i++) {
                System.out.println("\t" + (i+1) + ") " + programs.get(i).getName());
            }
            do{
                System.out.print("\t Choose a Program: ");
                op_program = sc.nextInt();
            }while(op_program < 1 || op_program > programs.size());
            int program = programs.get(op_program-1).getId();
            serviceStudent.update(new Student(program, student.getId()));

        }catch (PersonNullException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static void deleteStudent() {
        System.out.println("Deleting a Student...");
        sc.nextLine();
        System.out.print("\t Student's Document: ");
        String document = sc.nextLine();
        try {
            serviceStudent.delete(document);
            System.out.println("Student deleted successfully!");
        } catch (PersonNullException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void listStudents() {
        System.out.println("Students List");
        for (Person student : serviceStudent.toList()) {
            student.print();
        }
        sc.next();
    }
}
