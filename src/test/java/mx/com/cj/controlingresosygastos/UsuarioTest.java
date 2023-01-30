package mx.com.cj.controlingresosygastos;

import mx.com.cj.controlingresosygastos.validation.UsuarioValidation;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioTest {

    UsuarioValidation usuarioValidation;

    @BeforeAll
    static void setUp() {
        System.out.println("Iniciando pruebas de Usuario");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Finalización pruebas de Usuario");
    }

    @BeforeEach
    void init() {
        usuarioValidation = new UsuarioValidation();
    }

    @AfterEach
    void end() {
    }

    @Test
    @DisplayName("Verificar nombre usuario")
    void verficarNombre() {
        boolean validNombreUsuario = usuarioValidation.validNombreUser("Carlos Jaimez");
        assertTrue(validNombreUsuario, "Carlos Jaimez");
    }

    @Test
    @DisplayName("Verificar nombre usuario null")
    void verficarNombreNull() {
        boolean validNombreUsuario = usuarioValidation.validNombreUser(null);
        assertFalse(validNombreUsuario, "Carlos Jaimez");
    }

    @Test
    @DisplayName("Usuario o contraseña no vacios")
    public void username1() {
        boolean result = usuarioValidation.registroLogin("", "123", "123");
        assertFalse(result);
    }

    @Test
    @DisplayName("El username no contiene el caracter #")
    public void username2() {
        boolean result = usuarioValidation.registroLogin("carlos#@gmail.com", "123", "123");
        assertFalse(result);
    }

    @Test
    @DisplayName("La contraseña no tiene una longitud menor a 8 caracteres")
    public void password1() {
        boolean result = usuarioValidation.registroLogin("Jose", "123", "123");
        assertFalse(result);
    }

    @Test
    @DisplayName("Las contraseñas no coinciden")
    public void password2() {
        boolean result = usuarioValidation.registroLogin("carlos@gmail.com", "12345678", "abcdefghi");
        assertFalse(result);
    }

    @Test
    @DisplayName("Pasa todos los criterios")
    public void password3() {
        boolean result = usuarioValidation.registroLogin("carlos@gmail.com", "12345678", "12345678");
        assertTrue(result);
    }

}
