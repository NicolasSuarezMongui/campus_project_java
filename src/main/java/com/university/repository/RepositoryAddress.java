
package com.university.repository;

import java.util.List;
import com.university.repository.models.Address;


public interface RepositoryAddress {
        
        List<Address> toList();

        Address findById(int address_id);

        void create(Address address);

        void update(Address address);

        void delete(Address address);

}
