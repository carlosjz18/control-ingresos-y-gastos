package mx.com.cj.controlingresosygastos.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponseSuccess(String message, HttpStatus status, Object responseObj) {

        ResponseSuccess responseSuccess = new ResponseSuccess();
        responseSuccess.setStatusCode(status.value());
        responseSuccess.setStatus(status.getReasonPhrase());
        responseSuccess.setMessage(message);
        responseSuccess.setData(responseObj);

        return new ResponseEntity<>(responseSuccess, status);
    }

    public static ResponseEntity<Object> generateResponseError(Map<String, String> errors, HttpStatus status, String path, String message) {

        ResponseError responseError = new ResponseError();
        responseError.setStatusCode(status.value());
        responseError.setStatus(status.getReasonPhrase());
        responseError.setErrors(errors);
        responseError.setMessage(message);
        responseError.setPath(path);

        return new ResponseEntity<>(responseError, status);
    }
}
