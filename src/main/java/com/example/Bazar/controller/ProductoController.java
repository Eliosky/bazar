
package com.example.Bazar.controller;

import com.example.Bazar.model.Producto;
import com.example.Bazar.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    private IProductoService interProducto;
    
    @GetMapping("/producto/traer")
    public List<Producto> getProducto(){
        
        return interProducto.getProducto();
        
    }
    
    @PostMapping("/producto/crear")
    public String createProducto(@RequestBody Producto prod){
        
        interProducto.saveProducto(prod);
        return "El producto se creo";
        
    }
    
    @DeleteMapping("/producto/borrar/{codigo_producto}")
    public String deleteProducto (@PathVariable Long codigo_producto){
        
        interProducto.deleteProducto(codigo_producto);
        return "Se elimino el producto";
        
    }
    
    @PutMapping("/producto/editar/{id-modificar}")
    public Producto editProducto(@PathVariable Long idOriginal,
            @RequestParam(required = false,name = "codigo_producto")Long nuevoCodigo_producto,
            @RequestParam(required = false,name = "nombre")String nuevoNombre,
            @RequestParam(required = false,name = "marca")String nuevaMarca,
            @RequestParam(required = false,name = "costo")Double nuevoCosto,
            @RequestParam(required = false,name = "cantidad")Double nuevaCantidad_Disponible){
        
        interProducto.editProducto(nuevoCodigo_producto, nuevoCodigo_producto, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad_Disponible);
        
        Producto pro = interProducto.findProducto(idOriginal);
        return pro;
        
    }
    
    
}
