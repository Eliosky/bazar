
package com.example.Bazar.controller;

import com.example.Bazar.model.Cliente;
import com.example.Bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService interCliente;
    
    @GetMapping("/cliente/traer")
    public List<Cliente> getCliente(){
        
        return interCliente.getClientes();
        
    }
    
    @PostMapping("/cliente/crear")
    public String createCliente(@RequestBody Cliente cli){
        
        interCliente.saveCliente(cli);
        return "El cliente fue creado";
        
    }
    
    @DeleteMapping("/cliente/borrar/{id_cliente}")
    public String deleteCliente (@PathVariable Long id_cliente){
        
        interCliente.deleteCliente(id_cliente);
        return "El cliente fue eliminado";
        
    }
    
    @PutMapping("/cliente/editar/{id-modificar}")
    public Cliente editCliente(@PathVariable Long idOriginal,
                                @RequestParam(required = false,name = "id_cliente")Long idNueva,
                                @RequestParam(required = false,name = "nombre")String nuevoNombre,
                                @RequestParam(required = false,name = "apellido")String nuevoApellido,
                                @RequestParam(required = false,name = "dni")String nuevoDni){
        
        interCliente.editCliente(idOriginal, idNueva, nuevoNombre, nuevoApellido, nuevoDni);
        
        Cliente cli = interCliente.findCliente(idOriginal);
        return cli;
        
    }
    
}
