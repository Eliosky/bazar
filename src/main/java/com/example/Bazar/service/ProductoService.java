
package com.example.Bazar.service;

import com.example.Bazar.model.Producto;
import com.example.Bazar.repository.ProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private ProductoRepository prodRepository;

    @Override
    public List<Producto> getProducto() {
        
        List<Producto> listaProductos = prodRepository.findAll();
        return listaProductos;
        
    }

    @Override
    public void saveProducto(Producto prod) {
        
        prodRepository.save(prod);
        
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        
        prodRepository.deleteById(codigo_producto);
        
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        
        Producto pro = prodRepository.findById(codigo_producto).orElse(null);
        return pro;
        
    }

    @Override
    public void editProducto(Long originalCodigo_producto, Long nuevoCodigo_producto, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double nuevaCantidad_Disponible) {
        
        Producto pro = this.findProducto(originalCodigo_producto);
        pro.setCodigo_producto(nuevoCodigo_producto);
        pro.setNombre(nuevoNombre);
        pro.setMarca(nuevaMarca);
        pro.setCosto(nuevoCosto);
        pro.setCantidad_disponible(nuevaCantidad_Disponible);
        
        this.saveProducto(pro);
        
    }

    @Override
    public List<Producto> falta_stock() {
        
        List<Producto> listaProducto = this.getProducto();
        List<Producto> listaFaltante = new ArrayList<Producto>();
        
        for (Producto prod : listaProducto){
            if(prod.getCantidad_disponible() < 6){
                listaFaltante.add(prod);
            }
        }
        
        return listaFaltante;
        
    }

    
    
}
