package mx.com.cj.controlingresosygastos.controller;

import mx.com.cj.controlingresosygastos.entity.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private List<Usuario> usuarios;

    public UsuarioController() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "Carlos Jaimez", "carlos@gmail.com", "123"));
        usuarios.add(new Usuario(2L, "Pepe Juárez", "pepe@gmail.com", "2322sdds"));
        usuarios.add(new Usuario(3L, "Ana López", "ana@gmail.com", "abc123"));
    }

    @GetMapping({"", "/"})
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @GetMapping("/{idUsuario}")
    public Usuario obtenerUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return usuarios.stream().filter(curso -> curso.getUsuarioId().equals(idUsuario)).findFirst().orElse(null);
    }

    @PostMapping({"", "/"})
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        Long ultimoId = usuarios.get(usuarios.size() - 1).getUsuarioId();
        usuario.setUsuarioId(++ultimoId);
        usuarios.add(usuario);
        return usuario;
    }

    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioRequest, @PathVariable("idUsuario") Long idUsuario) {
        Usuario usuario = obtenerUsuario(idUsuario);

        if (usuario != null) {
            usuario.setNombre(usuarioRequest.getNombre());
            usuario.setCorreo(usuarioRequest.getNombre());
        }

        return usuario;
    }

    @DeleteMapping("/{idUsuario}")
    public Usuario eliminarUsuario(@PathVariable("idUsuario") Long idUsuario) {
        Usuario usuario = obtenerUsuario(idUsuario);

        if (usuario != null) {
            usuarios.remove(usuario);
        }

        return usuario;
    }
}
