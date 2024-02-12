package com.university.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    
    private int id;
    private String road;
    private int roadNumber;
    private int roadCross;
    private int roadDist;

    public Address(String road, int roadNumber, int roadCross, int roadDist) {
        this.road = road;
        this.roadNumber = roadNumber;
        this.roadCross = roadCross;
        this.roadDist = roadDist;
    }

    public String getAddress(){
        return getRoad() + " " + getRoadNumber() + "#" + getRoadCross() + " - " + getRoadDist();
    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Road: " + getRoad() + " " + getRoadNumber());
        System.out.println("\tCross: " + getRoadCross());
        System.out.println("\tDist.: " + getRoadDist());
        System.out.println("-".repeat(30));
    }
}
