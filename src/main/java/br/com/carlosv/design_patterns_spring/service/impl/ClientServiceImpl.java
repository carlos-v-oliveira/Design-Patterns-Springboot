package br.com.carlosv.design_patterns_spring.service.impl;

import br.com.carlosv.design_patterns_spring.model.AddressRepository;
import br.com.carlosv.design_patterns_spring.model.Client;
import br.com.carlosv.design_patterns_spring.model.ClientRepository;
import br.com.carlosv.design_patterns_spring.service.ByZipCodeService;
import br.com.carlosv.design_patterns_spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public Client searchById(Long id) {
        return null;
    }

    @Override
    public void insert(Client client) {

    }

    @Override
    public void update(Long id, Client client) {

    }

    @Override
    public void delete(Long id) {

    }
}
