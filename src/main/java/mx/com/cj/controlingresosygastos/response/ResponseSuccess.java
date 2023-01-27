package mx.com.cj.controlingresosygastos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseSuccess {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private int status;
    private Object data;
}
