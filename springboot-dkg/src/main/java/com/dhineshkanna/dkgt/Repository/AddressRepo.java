package com.dhineshkanna.dkgt.Repository;

import com.dhineshkanna.dkgt.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{
}
