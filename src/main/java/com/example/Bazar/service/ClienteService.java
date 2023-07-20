
package com.example.Bazar.service;

import com.example.Bazar.model.Cliente;
import com.example.Bazar.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private ClienteRepository cliRepository;

    @Override
    public List<Cliente> getClientes() {
        
        List<Cliente> listaClientes = cliRepository.findAll();
        return listaClientes;
        
    }

    @Override
    public void saveCliente(Cliente cli) {
        
        cliRepository.save(cli);
        
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        
        cliRepository.deleteById(id_cliente);
        
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        
        Cliente cli = cliRepository.findById(id_cliente).orElse(null);
        return cli;
        
    }

    @Override
    public void editCliente(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, String nuevoDni) {
        
        Cliente cli = this.findCliente(idOriginal);
        cli.setId_cliente(idNueva);
        cli.setNombre(nuevoNombre);
        cli.setApellido(nuevoApellido);
        cli.setDni(nuevoDni);
        
        this.saveCliente(cli);
        
    }
    
}
