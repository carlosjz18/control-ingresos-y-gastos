package mx.com.cj.controlingresosygastos.controller;

import mx.com.cj.controlingresosygastos.dto.IngresoDTO;
import mx.com.cj.controlingresosygastos.response.ResponseHandler;
import mx.com.cj.controlingresosygastos.service.IIngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    private IIngresoService ingresoService;

    public IngresoController(IIngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerIngresos() {
        try {
            List<IngresoDTO> ingresos = ingresoService.findAll();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, ingresos);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/{idIngreso}")
    public ResponseEntity<Object> obtenerIngreso(@PathVariable("idIngreso") Long idIngreso) {
        Optional<IngresoDTO> ingresoDTO = ingresoService.findById(idIngreso);
        if (ingresoDTO.isEmpty()) {
            return ResponseHandler.generateResponse("Ingreso no encontrada con id: " + idIngreso, HttpStatus.NOT_FOUND, null);
        }

        return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, ingresoDTO.get());
    }

    @PostMapping
    public ResponseEntity<Object> agregarIngreso(@RequestBody IngresoDTO ingresoDTO) {
        try {
            IngresoDTO ingreso = ingresoService.save(ingresoDTO);
            return ResponseHandler.generateResponse("Ingreso agregado correctamente.", HttpStatus.OK, ingreso);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/{idIngreso}")
    public ResponseEntity<Object> actualizarIngreso(@RequestBody IngresoDTO ingresoRequest, @PathVariable("idIngreso") Long idIngreso) {
        try {
            ingresoService.update(idIngreso, ingresoRequest);
            return ResponseHandler.generateResponse("Ingreso actualizado correctamente.", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{idIngreso}")
    public ResponseEntity<Object> eliminarIngreso(@PathVariable("idIngreso") Long idIngreso) {
        try {
            ingresoService.delete(idIngreso);
            return ResponseHandler.generateResponse("Ingreso eliminado correctamente.", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
