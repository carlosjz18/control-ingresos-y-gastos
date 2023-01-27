package mx.com.cj.controlingresosygastos.controller;

import lombok.extern.slf4j.Slf4j;
import mx.com.cj.controlingresosygastos.dto.CuentaDTO;
import mx.com.cj.controlingresosygastos.response.ResponseHandler;
import mx.com.cj.controlingresosygastos.service.ICuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private ICuentaService cuentaService;

    public CuentaController(ICuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerCuentas() {
        try {
            List<CuentaDTO> cuentas = cuentaService.findAll();
            log.info("Cuentas encontradas correctamente.");
            return ResponseHandler.generateResponseSuccess("Successfully retrieved data!", HttpStatus.OK, cuentas);
        } catch (Exception e) {
            return ResponseHandler.generateResponseSuccess(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/{idCuenta}")
    public ResponseEntity<Object> obtenerCuenta(@PathVariable("idCuenta") Long idCuenta) {
        Optional<CuentaDTO> cuentaDTO = cuentaService.findById(idCuenta);
        if (cuentaDTO.isEmpty()) {
            log.info("Cuenta no encontrada con id: {}", idCuenta);
            return ResponseHandler.generateResponseSuccess("Cuenta no encontrada con id: " + idCuenta, HttpStatus.NOT_FOUND, null);
        }

        log.info("Cuenta encontrada corectamente, id {}", idCuenta);
        return ResponseHandler.generateResponseSuccess("Successfully retrieved data!", HttpStatus.OK, cuentaDTO.get());
    }

    @PostMapping
    public ResponseEntity<Object> agregarCuenta(@RequestBody CuentaDTO cuentaDTO) {
        try {
            CuentaDTO cuenta = cuentaService.save(cuentaDTO);
            log.info("Cuenta agregada correctamente.");
            return ResponseHandler.generateResponseSuccess("Cuenta agregada correctamente.", HttpStatus.OK, cuenta);
        } catch (Exception e) {
            log.warn("Ocurrio un error: ", e);
            return ResponseHandler.generateResponseSuccess(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/{idCuenta}")
    public ResponseEntity<Object> actualizarCuenta(@RequestBody CuentaDTO cuentaRequest, @PathVariable("idCuenta") Long idCuenta) {
        try {
            cuentaService.update(idCuenta, cuentaRequest);
            log.info("Cuenta actualizada correctamente.");
            return ResponseHandler.generateResponseSuccess("Cuenta actualizada correctamente.", HttpStatus.OK, null);
        } catch (Exception e) {
            log.warn("Ocurrio un error: ", e);
            return ResponseHandler.generateResponseSuccess(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{idCuenta}")
    public ResponseEntity<Object> eliminarCuenta(@PathVariable("idCuenta") Long idCuenta) {
        try {
            cuentaService.delete(idCuenta);
            log.info("Cuenta eliminada correctamente, id {}", idCuenta);
            return ResponseHandler.generateResponseSuccess("Cuenta eliminada correctamente.", HttpStatus.OK, null);
        } catch (Exception e) {
            log.warn("Ocurrio un error: ", e);
            return ResponseHandler.generateResponseSuccess(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
