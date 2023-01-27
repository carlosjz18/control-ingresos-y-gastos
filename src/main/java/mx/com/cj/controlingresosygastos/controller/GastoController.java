package mx.com.cj.controlingresosygastos.controller;

import mx.com.cj.controlingresosygastos.dto.GastoDTO;
import mx.com.cj.controlingresosygastos.response.ResponseHandler;
import mx.com.cj.controlingresosygastos.service.IGastoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    private IGastoService gastoService;

    public GastoController(IGastoService gastoService) {
        this.gastoService = gastoService;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerGastos() {
        try {
            List<GastoDTO> gastos = gastoService.findAll();
            return ResponseHandler.generateResponseSuccess("Successfully retrieved data!", HttpStatus.OK, gastos);
        } catch (Exception e) {
            return ResponseHandler.generateResponseSuccess(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/{idGasto}")
    public ResponseEntity<Object> obtenerGasto(@PathVariable("idGasto") Long idGasto) {
        Optional<GastoDTO> gastoDTO = gastoService.findById(idGasto);
        if (gastoDTO.isEmpty()) {
            return ResponseHandler.generateResponseSuccess("Gasto no encontrada con id: " + idGasto, HttpStatus.NOT_FOUND, null);
        }

        return ResponseHandler.generateResponseSuccess("Successfully retrieved data!", HttpStatus.OK, gastoDTO.get());
    }

    @PostMapping
    public ResponseEntity<Object> agregarGasto(@RequestBody GastoDTO gastoDTO) {
        try {
            GastoDTO gasto = gastoService.save(gastoDTO);
            return ResponseHandler.generateResponseSuccess("Gasto agregado correctamente.", HttpStatus.OK, gasto);
        } catch (Exception e) {
            return ResponseHandler.generateResponseSuccess(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/{idGasto}")
    public ResponseEntity<Object> actualizarGasto(@RequestBody GastoDTO gastoRequest, @PathVariable("idGasto") Long idGasto) {
        try {
            gastoService.update(idGasto, gastoRequest);
            return ResponseHandler.generateResponseSuccess("Gasto actualizado correctamente.", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponseSuccess(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{idGasto}")
    public ResponseEntity<Object> eliminarGasto(@PathVariable("idGasto") Long idGasto) {
        try {
            gastoService.delete(idGasto);
            return ResponseHandler.generateResponseSuccess("Gasto eliminado correctamente.", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponseSuccess(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
