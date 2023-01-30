package mx.com.cj.controlingresosygastos;

import mx.com.cj.controlingresosygastos.validation.GastoValidation;
import org.junit.jupiter.api.*;

public class GastoTest {

    GastoValidation gastoValidation = new GastoValidation();

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
        gastoValidation = new GastoValidation();
    }

    @AfterEach
    void end() {
    }

    @Test
    @DisplayName("Test1")
    void test1() {
    }
}
