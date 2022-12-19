package mx.com.cj.controlingresosygastos.controller;

import mx.com.cj.controlingresosygastos.dto.UsuarioDTO;
import mx.com.cj.controlingresosygastos.response.ResponseHandler;
import mx.com.cj.controlingresosygastos.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerUsuarios() {
        try {
            List<UsuarioDTO> usuarios = usuarioService.findAll();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, usuarios);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Object> obtenerUsuario(@PathVariable("idUsuario") Long idUsuario) {
        Optional<UsuarioDTO> usuarioDTO = usuarioService.findById(idUsuario);
        if (usuarioDTO.isEmpty()) {
            return ResponseHandler.generateResponse("Usuario no encontrado con id: " + idUsuario, HttpStatus.NOT_FOUND, null);
        }

        return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, usuarioDTO.get());
    }

    @PostMapping
    public ResponseEntity<Object> agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO usuario = usuarioService.save(usuarioDTO);
            return ResponseHandler.generateResponse("Usuario agregado correctamente.", HttpStatus.OK, usuario);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Object> actualizarUsuario(@RequestBody UsuarioDTO usuarioRequest, @PathVariable("idUsuario") Long idUsuario) throws Exception {
        try {
            usuarioService.update(idUsuario, usuarioRequest);
            return ResponseHandler.generateResponse("Usuario actualizado correctamente.", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable("idUsuario") Long idUsuario) {
        try {
            usuarioService.delete(idUsuario);
            return ResponseHandler.generateResponse("Usuario eliminado correctamente.", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
