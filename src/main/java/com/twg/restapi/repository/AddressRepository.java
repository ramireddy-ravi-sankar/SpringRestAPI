package com.twg.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.restapi.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Integer> {

}
