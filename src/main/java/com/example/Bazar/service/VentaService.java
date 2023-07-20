package com.example.Bazar.service;

import com.example.Bazar.Dto.ClienteVentaDto;
import com.example.Bazar.model.Venta;
import com.example.Bazar.repository.VentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository venRepository;

    @Override
    public List<Venta> getVentas() {

        List<Venta> listaVentas = venRepository.findAll();
        return listaVentas;

    }

    @Override
    public void saveVenta(Venta vent) {

        venRepository.save(vent);

    }

    @Override
    public void deleteVenta(Long codigo_venta) {

        venRepository.deleteById(codigo_venta);

    }

    @Override
    public Venta findVenta(Long codigo_venta) {

        Venta ven = venRepository.findById(codigo_venta).orElse(null);
        return ven;

    }

    @Override
    public void editeVenta(Venta venta) {

        this.saveVenta(venta);

    }

    @Override
    public String getTotalVenta(LocalDate fechaConsulta) {

        List<Venta> listaVentas = this.getVentas();
        int cantidadVentas = 0;
        double montoTotal = 0.0;

        for (Venta venta : listaVentas) {
            if (venta.getFecha_venta().equals(fechaConsulta)) {
                cantidadVentas++;
                montoTotal += venta.getTotal();
            }
        }
        return "Tuviste " + cantidadVentas + " y ganaste " + montoTotal;

    }

    @Override
    public ClienteVentaDto ventaMayor() {

        List<Venta> listaVenta = this.getVentas();
        ClienteVentaDto cliven = new ClienteVentaDto();
        double montoMayor = Double.MIN_VALUE;

        for (Venta ventaActual : listaVenta) {
            if (ventaActual.getTotal() > montoMayor) {
                montoMayor = ventaActual.getTotal();
                cliven.setCodigo_venta(ventaActual.getCodigo_venta());
                cliven.setNombre(ventaActual.getUnCliente().getNombre());
                cliven.setApellido(ventaActual.getUnCliente().getApellido());
                cliven.setTotal(ventaActual.getTotal());
                cliven.setCantidadProductos(ventaActual.getListaProducto());
            }
        }

        return cliven;

    }

}
