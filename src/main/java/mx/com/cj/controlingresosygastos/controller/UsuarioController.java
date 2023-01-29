package mx.com.cj.controlingresosygastos.controller;

import jakarta.validation.Valid;
import mx.com.cj.controlingresosygastos.dto.UsuarioDTO;
import mx.com.cj.controlingresosygastos.exception.ResourceNotFoundException;
import mx.com.cj.controlingresosygastos.response.ResponseHandler;
import mx.com.cj.controlingresosygastos.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.findAll();

        if (usuarios.isEmpty()) {
            return ResponseHandler.generateResponseSuccess("No hay usuarios!", HttpStatus.NO_CONTENT, usuarios);
        }

        return ResponseHandler.generateResponseSuccess("Información recuperada con éxito!", HttpStatus.OK, usuarios);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Object> obtenerUsuario(@PathVariable("idUsuario") Long idUsuario) {
        UsuarioDTO usuarioDTO = usuarioService.findById(idUsuario).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id:  " + idUsuario));
        return ResponseHandler.generateResponseSuccess("Información recuperada con éxito!", HttpStatus.OK, usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<Object> agregarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioService.save(usuarioDTO);
        return ResponseHandler.generateResponseSuccess("Usuario agregado correctamente.", HttpStatus.OK, usuario);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Object> actualizarUsuario(@Valid @RequestBody UsuarioDTO usuarioRequest, @PathVariable("idUsuario") Long idUsuario) throws Exception {
        usuarioService.update(idUsuario, usuarioRequest);
        return ResponseHandler.generateResponseSuccess("Usuario actualizado correctamente.", HttpStatus.OK, null);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable("idUsuario") Long idUsuario) {
        //throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No tiene permiso para visualizar al cliente indicado.");
        usuarioService.delete(idUsuario);
        return ResponseHandler.generateResponseSuccess("Usuario eliminado correctamente.", HttpStatus.OK, null);
    }
}
