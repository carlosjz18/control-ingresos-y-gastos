package mx.com.cj.controlingresosygastos.validation;

public class UsuarioValidation {

    public boolean validNombreUser(String nombre) {
        return nombre != null;
    }

    public boolean registroLogin(String username, String password, String confirmP) {
        if (username.isEmpty() || password.isEmpty() || confirmP.isEmpty()) return false;
        if (username.contains("#")) return false;
        if (!password.equals(confirmP)) return false;
        return password.length() >= 8;
    }

}
