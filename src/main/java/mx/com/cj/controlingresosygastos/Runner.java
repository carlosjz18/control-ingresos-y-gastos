package mx.com.cj.controlingresosygastos;

import lombok.extern.slf4j.Slf4j;
import mx.com.cj.controlingresosygastos.entity.Cuenta;
import mx.com.cj.controlingresosygastos.entity.Gasto;
import mx.com.cj.controlingresosygastos.entity.Ingreso;
import mx.com.cj.controlingresosygastos.entity.Usuario;
import mx.com.cj.controlingresosygastos.repository.ICuentaRepository;
import mx.com.cj.controlingresosygastos.repository.IGastoRepository;
import mx.com.cj.controlingresosygastos.repository.IIngresoRepository;
import mx.com.cj.controlingresosygastos.repository.IUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
public class Runner implements CommandLineRunner {

    private IUsuarioRepository usuarioRepository;
    private ICuentaRepository cuentaRepository;
    private IIngresoRepository ingresoRepository;
    private IGastoRepository gastoRepository;

    public Runner(IUsuarioRepository usuarioRepository, ICuentaRepository cuentaRepository, IIngresoRepository ingresoRepository, IGastoRepository gastoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cuentaRepository = cuentaRepository;
        this.ingresoRepository = ingresoRepository;
        this.gastoRepository = gastoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("--- Insertando data ---");

        log.info("--- Insert Usuarios ---");
        usuarioRepository.deleteAll();
        List<Usuario> usuarios = List.of(
                new Usuario(1L, "Carlos Jaimez", "carlos@gmail.com", "123"),
                new Usuario(2L, "Pepe Juárez", "pepe@gmail.com", "2322sdds"),
                new Usuario(3L, "Ana López", "ana@gmail.com", "abc123")
        );
        usuarioRepository.saveAll(usuarios);
        /*usuarioRepository.findAll().forEach((user) -> {
            log.info("{}", user);
        });*/

        log.info("--- Insert Cuentas ---");
        cuentaRepository.deleteAll();
        Usuario usuario = new Usuario(1L, "Carlos Jaimez", "carlos@gmail.com", "123");
        List<Cuenta> cuentas = List.of(
                new Cuenta(1L, "Cuenta Corriente", "HSBC", 100.00, 100.00, usuario),
                new Cuenta(2L, "Ahorros", "BBVA", 1000.00, 1000.00, usuario),
                new Cuenta(3L, "Dinero", "Otros", 1800.00, 1800.00, usuario)
        );
        cuentaRepository.saveAll(cuentas);

        log.info("--- Insert Ingresos ---");
        ingresoRepository.deleteAll();
        Cuenta cuenta = new Cuenta(1L, "Cuenta Corriente", "HSBC", 100.00, 100.00, usuario);
        List<Ingreso> ingresos = List.of(
                new Ingreso(1L, "Pago nómina", 2300.00, LocalDate.now(), "Sueldo", cuenta),
                new Ingreso(2L, "Deuda Mario", 500.00, LocalDate.now(), "Otros", cuenta),
                new Ingreso(3L, "Venta coche", 150_000.00, LocalDate.now(), "Otros", cuenta)
        );
        ingresoRepository.saveAll(ingresos);

        log.info("--- Insert Gastos ---");
        gastoRepository.deleteAll();
        List<Gasto> gastos = List.of(
                new Gasto(1L, "Compra de despensa / Walmart", 899.45, LocalDate.now(), "Supermercado", cuenta),
                new Gasto(2L, "Pago Luz", 344.56, LocalDate.now(), "Facturas", cuenta),
                new Gasto(3L, "Netflix", 125.00, LocalDate.now(), "Facturas", cuenta)
        );
        gastoRepository.saveAll(gastos);
    }
}
