package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    
    private int id;
    private String docuemntType;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String birthdate;
    private String gender;
    private int addressId;
    private int cityId;
    
    public Person(String docuemntType, String documentNumber, String firstName, String lastName, String phone,
            String birthdate, String gender, int addressId, int cityId) {
        this.docuemntType = docuemntType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthdate = birthdate;
        this.gender = gender;
        this.addressId = addressId;
        this.cityId = cityId;
    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Name: " + getFirstName() + " " + getLastName());
        System.out.println("\t  Type: " + getDocuemntType());
        System.out.println("\t  Doc#: " + getDocumentNumber());
        System.out.println("\t Phone: " + getPhone());
        System.out.println("\t Birth: " + getBirthdate());
        System.out.println("\tGender: " + getGender());
        System.out.println("-".repeat(30));
    }

}
