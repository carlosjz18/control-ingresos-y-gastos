package mx.com.cj.controlingresosygastos.controller;

import mx.com.cj.controlingresosygastos.entity.Cuenta;
import mx.com.cj.controlingresosygastos.entity.Gasto;
import mx.com.cj.controlingresosygastos.entity.Usuario;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/gasto")
public class GastoController {

    private List<Gasto> gastos;
    private Usuario usuario = new Usuario(1L, "Carlos Jaimez", "carlos@gmail.com", "123");
    private Cuenta cuenta = new Cuenta(1L, "Cuenta Corriente", "HSBC", 100.00, 100.00, usuario);

    public GastoController() {
        gastos = new ArrayList<>();
        gastos.add(new Gasto(1L, "Compra de despensa / Walmart", 899.45, LocalDate.now(), "Supermercado", cuenta));
        gastos.add(new Gasto(2L, "Pago Luz", 344.56, LocalDate.now(), "Facturas", cuenta));
        gastos.add(new Gasto(3L, "Netflix", 125.00, LocalDate.now(), "Facturas", cuenta));
    }

    @GetMapping({"", "/"})
    public List<Gasto> obtenerGastos() {
        return gastos;
    }

    @GetMapping("/{idGasto}")
    public Gasto obtenerGasto(@PathVariable("idGasto") Long idGasto) {
        return gastos.stream().filter(gasto -> gasto.getGastoId().equals(idGasto)).findFirst().orElse(null);
    }

    @PostMapping({"", "/"})
    public Gasto agregarGasto(@RequestBody Gasto gasto) {
        Long ultimoId = gastos.get(gastos.size() - 1).getGastoId();
        gasto.setGastoId(++ultimoId);
        // TODO: obtener cuentaId del request y obtenerlo para agregarlo
        gasto.setCuenta(cuenta);
        gastos.add(gasto);
        return gasto;
    }

    @PutMapping("/{idGasto}")
    public Gasto actualizarGasto(@RequestBody Gasto gastoRequest, @PathVariable("idGasto") Long idGasto) {
        Gasto gasto = obtenerGasto(idGasto);

        if (gasto != null) {
            gasto.setDescripcion(gastoRequest.getDescripcion());
            gasto.setMonto(gastoRequest.getMonto());
            gasto.setFecha(gastoRequest.getFecha());
            gasto.setCategoria(gastoRequest.getCategoria());
            // TODO: obtener cuentaId del request y obtenerlo para agregarlo
            gasto.setCuenta(cuenta);
        }

        return gasto;
    }

    @DeleteMapping("/{idGasto}")
    public Gasto eliminarGasto(@PathVariable("idGasto") Long idGasto) {
        Gasto gasto = obtenerGasto(idGasto);

        if (gasto != null) {
            gastos.remove(gasto);
        }

        return gasto;
    }

}
