package tallerfinal.entidades;

public class Transacciones {
    private String fecha;
    private String hora;
    private String tipo_transaccion;
    private double monto;
    private int id_cuenta;
    private String tipo_cuenta_destino;
    private int id;

    public Transacciones(String fecha, String hora, String tipo_transaccion, double monto, int id_cuenta,
            String tipo_cuenta_destino, int id) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo_transaccion = tipo_transaccion;
        this.monto = monto;
        this.id_cuenta = id_cuenta;
        this.tipo_cuenta_destino = tipo_cuenta_destino;
        this.id = id;
    }
    // Getter and Setters

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getTipo_cuenta_destino() {
        return tipo_cuenta_destino;
    }

    public void setTipo_cuenta_destino() {
        this.tipo_cuenta_destino = tipo_cuenta_destino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
