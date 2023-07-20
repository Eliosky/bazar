
package com.example.Bazar.controller;

import com.example.Bazar.model.Venta;
import com.example.Bazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService interven;
    
    @PostMapping("/venta/crear")
    public String crearVenta (@RequestBody Venta venta){
        
        interven.saveVenta(venta);
        return "Venta Creada";
        
    }
    
    @GetMapping("/venta/traer")
    public List<Venta> traerVenta(){
        return interven.getVentas();
    }
    
    @DeleteMapping("/venta/borrar/codigo-venta")
    public String deleteVenta (@PathVariable Long codigo_venta){
        interven.deleteVenta(codigo_venta);
        return "Se elimino la venta";
    }
    
    @PutMapping("/venta/edit")
    public String editVenta (@RequestBody Venta venta){
        interven.editeVenta(venta);
        return  "venta editada";
    }
    
    @GetMapping("/venta/{fecha_venta}")
    public String getTotalVentas(@PathVariable LocalDate fechaConsulta){
        return interven.getTotalVenta(fechaConsulta);
    }
    
}
