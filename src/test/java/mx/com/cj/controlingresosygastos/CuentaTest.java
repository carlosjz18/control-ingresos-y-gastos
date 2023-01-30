package mx.com.cj.controlingresosygastos;

import mx.com.cj.controlingresosygastos.validation.CuentaValidation;
import org.junit.jupiter.api.*;

public class CuentaTest {

    CuentaValidation cuentaValidation;

    @BeforeAll
    static void setUp() {
        System.out.println("Iniciando pruebas de Cuenta");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Finalización pruebas de Cuenta");
    }

    @BeforeEach
    void init() {
        cuentaValidation = new CuentaValidation();
    }

    @AfterEach
    void end() {
    }

    @Test
    @DisplayName("Test1")
    void test1() {
    }
}
