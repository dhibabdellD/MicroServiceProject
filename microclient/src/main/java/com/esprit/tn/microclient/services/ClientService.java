package com.esprit.tn.microclient.services;

import com.esprit.tn.microclient.entities.Client;
import com.esprit.tn.microclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository customerRepository;

    public Client createCustomer(Client customer) {
        return customerRepository.save(customer);
    }

    public Optional<Client> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<Client> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public List<Client> getAllCustomers() {
        return customerRepository.findAll();
    }
}
