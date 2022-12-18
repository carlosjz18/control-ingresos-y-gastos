package mx.com.cj.controlingresosygastos.controller;

import mx.com.cj.controlingresosygastos.entity.Cuenta;
import mx.com.cj.controlingresosygastos.entity.Ingreso;
import mx.com.cj.controlingresosygastos.entity.Usuario;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ingreso")
public class IngresoController {

    private List<Ingreso> ingresos;
    private Usuario usuario = new Usuario(1L, "Carlos Jaimez", "carlos@gmail.com", "123");
    private Cuenta cuenta = new Cuenta(1L, "Cuenta Corriente", "HSBC", 100.00, 100.00, usuario);

    public IngresoController() {
        ingresos = new ArrayList<>();
        ingresos.add(new Ingreso(1L, "Pago nómina", 2300.00, LocalDate.now(), "Sueldo", cuenta));
        ingresos.add(new Ingreso(2L, "Deuda Mario", 500.00, LocalDate.now(), "Otros", cuenta));
        ingresos.add(new Ingreso(3L, "Venta coche", 150_000.00, LocalDate.now(), "Otros", cuenta));
    }

    @GetMapping({"", "/"})
    public List<Ingreso> obtenerIngresos() {
        return ingresos;
    }

    @GetMapping("/{idIngreso}")
    public Ingreso obtenerIngreso(@PathVariable("idIngreso") Long idIngreso) {
        return ingresos.stream().filter(ingreso -> ingreso.getIngresoId().equals(idIngreso)).findFirst().orElse(null);
    }

    @PostMapping({"", "/"})
    public Ingreso agregarIngreso(@RequestBody Ingreso ingreso) {
        Long ultimoId = ingresos.get(ingresos.size() - 1).getIngresoId();
        ingreso.setIngresoId(++ultimoId);
        // TODO: obtener cuentaId del request y obtenerlo para agregarlo
        ingreso.setCuenta(cuenta);
        ingresos.add(ingreso);
        return ingreso;
    }

    @PutMapping("/{idIngreso}")
    public Ingreso actualizarIngreso(@RequestBody Ingreso ingresoRequest, @PathVariable("idIngreso") Long idIngreso) {
        Ingreso ingreso = obtenerIngreso(idIngreso);

        if (ingreso != null) {
            ingreso.setDescripcion(ingresoRequest.getDescripcion());
            ingreso.setMonto(ingresoRequest.getMonto());
            ingreso.setFecha(ingresoRequest.getFecha());
            ingreso.setCategoria(ingresoRequest.getCategoria());
            // TODO: obtener cuentaId del request y obtenerlo para agregarlo
            ingreso.setCuenta(cuenta);
        }

        return ingreso;
    }

    @DeleteMapping("/{idIngreso}")
    public Ingreso eliminarIngreso(@PathVariable("idIngreso") Long idIngreso) {
        Ingreso ingreso = obtenerIngreso(idIngreso);

        if (ingreso != null) {
            ingresos.remove(ingreso);
        }

        return ingreso;
    }

}
