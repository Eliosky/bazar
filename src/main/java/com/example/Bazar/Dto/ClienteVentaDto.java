
package com.example.Bazar.Dto;

import com.example.Bazar.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteVentaDto {
    
    private Long codigo_venta;
    private String nombre;
    private String apellido;
    private Double total;
    private List<Producto> cantidadProductos;

    public ClienteVentaDto() {
    }

    public ClienteVentaDto(Long codigo_venta, String nombre, String apellido, Double total, List<Producto> cantidadProductos) {
        this.codigo_venta = codigo_venta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
    }

    

       
    
    
}
