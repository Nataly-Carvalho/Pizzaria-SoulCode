package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.Cliente;
import com.soulcode.pizzaria.models.DTOS.ClienteDTO;
import com.soulcode.pizzaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO save(ClienteDTO clienteDTO) {
        Optional<Cliente> clientes = this.clienteRepository.findByLoginContainingIgnoreCase(clienteDTO.getLogin());
        if (clientes.isEmpty()){
            Cliente cliente = ClienteDTO.converter(clienteDTO);
            clienteRepository.save(cliente);
            return new ClienteDTO(cliente);

        }else {
            throw new RuntimeException("O Email já esta cadastrado");
        }
    }

        public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO findById(Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isEmpty()){
            throw new RuntimeException("O Cliente não foi encontrado");
        }else {
            return new ClienteDTO(cliente.get());
        }
    }

    public ClienteDTO deleteById(Long id) {
        ClienteDTO dto = this.findById(id);
        this.clienteRepository.deleteById(id);
        return dto;
    }

    public ClienteDTO updateById(Long id, ClienteDTO clienteDTO) {
        this.findById(id);
        Optional<Cliente> clienteLogin = this.clienteRepository.findByLoginContainingIgnoreCase(clienteDTO.getLogin());
        if (clienteLogin.isEmpty()){
            Cliente cliente = ClienteDTO.converter(clienteDTO);
            cliente.setId(id);
            clienteRepository.save(cliente);
            return new ClienteDTO(cliente);
        }else {
            throw new RuntimeException("O ja esta cadastrado");
        }
    }

}
