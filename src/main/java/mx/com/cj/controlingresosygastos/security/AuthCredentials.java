package mx.com.cj.controlingresosygastos.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
