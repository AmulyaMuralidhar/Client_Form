package com.crud.repository;

import com.crud.model.Client;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {

	 List<Client> findByClientName(String clientName); // Method to find clients by name
}


