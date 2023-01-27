package mx.com.cj.controlingresosygastos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ResponseError {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errors;
    private String message;
    private String path;
}
