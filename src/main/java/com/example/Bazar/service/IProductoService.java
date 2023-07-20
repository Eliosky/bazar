
package com.example.Bazar.service;

import com.example.Bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public List<Producto> getProducto();
    
    public void saveProducto (Producto prod);
    
    public void deleteProducto (Long codigo_producto);
    
    public Producto findProducto (Long codigo_producto);
    
    public void editProducto (Long originalCodigo_producto, Long nuevoCodigo_producto,
                             String nuevoNombre, String nuevaMarca, Double nuevoCosto,
                             Double nuevaCantidad_Disponible);
    
    public List<Producto> falta_stock();
    
}
