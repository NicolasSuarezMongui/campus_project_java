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
    private int addressId;
    private int cityId;

    public Person(String docuemntType, String documentNumber, String firstName, String lastName, int addressId, int cityId) {
        this.docuemntType = docuemntType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
        this.cityId = cityId;
    }


}
