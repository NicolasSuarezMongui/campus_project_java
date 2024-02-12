package com.university.services.impl;

import java.util.List;

import com.university.repository.RepositoryAddress;
import com.university.repository.models.Address;
import com.university.services.ServiceAddress;

public class ServiceAddressImpl implements ServiceAddress {

    private final RepositoryAddress crudRepositoryAddress;

    public ServiceAddressImpl(RepositoryAddress crudRepositoryAddress) {
        this.crudRepositoryAddress = crudRepositoryAddress;
    }
    
    @Override
    public List<Address> toList() {
        return this.crudRepositoryAddress.toList();
    };

    public Address findById(int address_id) {
        return this.crudRepositoryAddress.findById(address_id);
    }

    public void create(Address address) {
        this.crudRepositoryAddress.create(address);
    }

    public void update(Address address){
        this.crudRepositoryAddress.update(address);
    }

    public void delete(Address address){
        this.crudRepositoryAddress.delete(address);
    }

}
