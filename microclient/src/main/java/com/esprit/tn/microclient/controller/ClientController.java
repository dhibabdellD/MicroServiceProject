package com.esprit.tn.microclient.controller;

import com.esprit.tn.microclient.entities.Client;
import com.esprit.tn.microclient.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createCustomer(@RequestBody Client customer) {
        Client createdCustomer = clientService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getCustomerById(@PathVariable Long id) {
        Optional<Client> customer = clientService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Client> getCustomerByEmail(@PathVariable String email) {
        Optional<Client> customer = clientService.getCustomerByEmail(email);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Client> getAllCustomers() {
        return clientService.getAllCustomers();
    }
}
