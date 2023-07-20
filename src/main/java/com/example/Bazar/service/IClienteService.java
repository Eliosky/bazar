
package com.example.Bazar.service;

import com.example.Bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public List<Cliente> getClientes();
    
    public void saveCliente (Cliente cli);
    
    public void deleteCliente (Long id_cliente);
    
    public Cliente findCliente (Long id_cliente);
    
    public void editCliente (Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido,
                            String nuevoDni);
    
}
