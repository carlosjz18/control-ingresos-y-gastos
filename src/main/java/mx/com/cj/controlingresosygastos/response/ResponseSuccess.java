package mx.com.cj.controlingresosygastos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseSuccess {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String status;
    private int statusCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}
