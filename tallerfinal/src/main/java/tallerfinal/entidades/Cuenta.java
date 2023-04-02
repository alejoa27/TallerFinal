package tallerfinal.entidades;

public class Cuenta {
    private String numero_cuenta;
    private double saldo;
    private String tipo_cuenta;
    private int id_usuario;
    private int id;

    public Cuenta(String numero_cuenta, double saldo, String tipo_cuenta, int id_usuario, int id) {
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.tipo_cuenta = tipo_cuenta;
        this.id_usuario = id_usuario;
        this.id = id;
    }
    // Getter and Setters

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
