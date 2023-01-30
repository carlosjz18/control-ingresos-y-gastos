package mx.com.cj.controlingresosygastos;

import mx.com.cj.controlingresosygastos.validation.IngresoValidation;
import org.junit.jupiter.api.*;

public class IngresoTest {

    IngresoValidation ingresoValidation = new IngresoValidation();

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
        ingresoValidation = new IngresoValidation();
    }

    @AfterEach
    void end() {
    }

    @Test
    @DisplayName("Test1")
    void test1() {
    }
}
