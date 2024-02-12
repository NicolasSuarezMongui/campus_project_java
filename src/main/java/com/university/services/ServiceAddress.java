package com.university.services;

import java.util.List;

import com.university.repository.models.Address;

public interface ServiceAddress {
    
    List<Address> toList();

    Address findById(int address_id);

    void create(Address address);

    void update(Address address);

    void delete(Address address);

}
