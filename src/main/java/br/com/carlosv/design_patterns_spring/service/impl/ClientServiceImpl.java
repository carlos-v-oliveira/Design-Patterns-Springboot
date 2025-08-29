package br.com.carlosv.design_patterns_spring.service.impl;

import br.com.carlosv.design_patterns_spring.model.Address;
import br.com.carlosv.design_patterns_spring.model.AddressRepository;
import br.com.carlosv.design_patterns_spring.model.Client;
import br.com.carlosv.design_patterns_spring.model.ClientRepository;
import br.com.carlosv.design_patterns_spring.service.ByZipCodeService;
import br.com.carlosv.design_patterns_spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ByZipCodeService byZipCodeService;

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client searchById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientWithZipCode(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientDB = clientRepository.findById(id);
        if(clientDB.isPresent()) {
            saveClientWithZipCode(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithZipCode(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = byZipCodeService.checkZipCode(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
