package mx.com.cj.controlingresosygastos.controller;

import mx.com.cj.controlingresosygastos.entity.Cuenta;
import mx.com.cj.controlingresosygastos.entity.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {

    private List<Cuenta> cuentas;
    private Usuario usuario = new Usuario(1L, "Carlos Jaimez", "carlos@gmail.com", "123");

    public CuentaController() {
        cuentas = new ArrayList<>();
        cuentas.add(new Cuenta(1L, "Cuenta Corriente", "HSBC", 100.00, 100.00, usuario));
        cuentas.add(new Cuenta(2L, "Ahorros", "BBVA", 1000.00, 1000.00, usuario));
        cuentas.add(new Cuenta(3L, "Dinero", "Otros", 1800.00, 1800.00, usuario));
    }

    @GetMapping({"", "/"})
    public List<Cuenta> obtenerCuentas() {
        return cuentas;
    }

    @GetMapping("/{idCuenta}")
    public Cuenta obtenerCuenta(@PathVariable("idCuenta") Long idCuenta) {
        return cuentas.stream().filter(cuenta -> cuenta.getCuentaId().equals(idCuenta)).findFirst().orElse(null);
    }

    @PostMapping({"", "/"})
    public Cuenta agregarCuenta(@RequestBody Cuenta cuenta) {
        Long ultimoId = cuentas.get(cuentas.size() - 1).getCuentaId();
        cuenta.setCuentaId(++ultimoId);
        // TODO: obtener usuarioId del request y obtenerlo para agregarlo
        cuenta.setUsuario(usuario);
        cuentas.add(cuenta);
        return cuenta;
    }

    @PutMapping("/{idCuenta}")
    public Cuenta actualizarCuenta(@RequestBody Cuenta cuentaRequest, @PathVariable("idCuenta") Long idCuenta) {
        Cuenta cuenta = obtenerCuenta(idCuenta);

        if (cuenta != null) {
            cuenta.setInstitucionFinanciera(cuentaRequest.getInstitucionFinanciera());
            cuenta.setTipoCuenta(cuentaRequest.getTipoCuenta());
            cuenta.setSaldoInicial(cuentaRequest.getSaldoInicial());
            cuenta.setSaldoActual(cuentaRequest.getSaldoActual());
            // TODO: obtener usuarioId del request y obtenerlo para agregarlo
            cuenta.setUsuario(usuario);
        }

        return cuenta;
    }

    @DeleteMapping("/{idCuenta}")
    public Cuenta eliminarCuenta(@PathVariable("idCuenta") Long idCuenta) {
        Cuenta cuenta = obtenerCuenta(idCuenta);

        if (cuenta != null) {
            cuentas.remove(cuenta);
        }

        return cuenta;
    }
}
