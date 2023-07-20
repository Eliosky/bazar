
package com.example.Bazar.service;

import com.example.Bazar.Dto.ClienteVentaDto;
import com.example.Bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public List<Venta> getVentas();
    
    public void saveVenta (Venta vent);
    
    public void deleteVenta (Long codigo_venta);
    
    public Venta findVenta (Long codigo_venta);
    
    public void editeVenta (Venta venta);
    
    public String getTotalVenta(LocalDate fechaConsulta);
    
    public ClienteVentaDto ventaMayor();
    
}
