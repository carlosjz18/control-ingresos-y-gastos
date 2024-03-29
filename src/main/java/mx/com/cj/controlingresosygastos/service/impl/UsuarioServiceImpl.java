package mx.com.cj.controlingresosygastos.service.impl;

import mx.com.cj.controlingresosygastos.dto.UsuarioDTO;
import mx.com.cj.controlingresosygastos.entity.Usuario;
import mx.com.cj.controlingresosygastos.exception.ResourceNotFoundException;
import mx.com.cj.controlingresosygastos.mapper.IUsuarioMapper;
import mx.com.cj.controlingresosygastos.repository.IUsuarioRepository;
import mx.com.cj.controlingresosygastos.service.IUsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioMapper usuarioMapper;
    private IUsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(IUsuarioMapper usuarioMapper, IUsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuarioMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDTO> findById(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Optional<UsuarioDTO> usuarioDTO = Optional.empty();
        if (usuario.isPresent()) {
            usuarioDTO = Optional.of(usuarioMapper.toDTO(usuario.get()));
        }
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setContrasena(new BCryptPasswordEncoder().encode(usuario.getContrasena()));
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    @Override
    public void update(long id, UsuarioDTO usuarioDTO) throws Exception {
        Optional<Usuario> result = usuarioRepository.findById(id);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Usuario no encontrado con id: " + id);
        }

        Usuario usuario = result.get();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setContrasena(new BCryptPasswordEncoder().encode(usuarioDTO.getContrasena()));
        usuario.setRol(usuarioDTO.getRol());
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new ResourceNotFoundException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
