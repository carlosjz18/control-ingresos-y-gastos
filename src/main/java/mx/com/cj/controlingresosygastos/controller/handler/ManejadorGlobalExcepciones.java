package mx.com.cj.controlingresosygastos.controller.handler;

import mx.com.cj.controlingresosygastos.exception.ResourceNotFoundException;
import mx.com.cj.controlingresosygastos.response.ResponseHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@RestControllerAdvice
public class ManejadorGlobalExcepciones extends ResponseEntityExceptionHandler {

    // Maneja excepciones validaciones Spring MVC Validation / HTTP CODE: 400
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = "Los campos no cumplen la validación";

        Map<String, String> errors = new TreeMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }

        String path = request.getDescription(false).substring(4);

        return ResponseHandler.generateResponseError(errors, status, path, message);
    }

    // Maneja excepciones del tipo de método soportado por el endpoint solicitado GET/POST/PUT/DELETE / HTTP CODE: 405
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        StringBuilder builder = new StringBuilder();
        builder.append("El método ");
        builder.append(ex.getMethod());
        builder.append(" no está soportado para esta petición. Los métodos soportados son ");

        Objects.requireNonNull(ex.getSupportedHttpMethods()).forEach(t -> builder.append(t).append(", "));

        String message = builder.toString().replaceFirst("..$", "");

        String path = request.getDescription(false).substring(4);

        return ResponseHandler.generateResponseError(null, status, path, message);
    }

    // Maneja recursos no encontrados / HTTP CODE: 404
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String path = request.getDescription(false).substring(4);
        return ResponseHandler.generateResponseError(null, status, path, "No se encontró el recurso solicitado: " + path);
    }

    // Maneja excepciones ResponseStatusException / HTTP CODE: Multi code
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> hadleResponseStatus(ResponseStatusException ex, WebRequest request) {
        String message = ex.getReason();
        String path = request.getDescription(false).substring(4);
        return ResponseHandler.generateResponseError(null, ex.getStatus(), path, message);
    }

    // Maneja todas las demás excepciones que puedan ocurrir / HTTP CODE: 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobal(Exception ex, WebRequest request) {
        String message = ex.getMessage();
        String path = request.getDescription(false).substring(4);
        return ResponseHandler.generateResponseError(null, HttpStatus.INTERNAL_SERVER_ERROR, path, message);
    }

    // Maneja excepciones datos no encontrados BD / HTTP CODE: 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        String message = ex.getMessage();
        String path = request.getDescription(false).substring(4);
        return ResponseHandler.generateResponseError(null, HttpStatus.NOT_FOUND, path, message);
    }
}
