package tallerfinal.servicios;

import java.util.List;
import java.util.Map;

import tallerfinal.entidades.Cuenta;
import tallerfinal.entidades.Transacciones;
import tallerfinal.repositorios.CuentaRepository;
import tallerfinal.repositorios.Repositorio;
import tallerfinal.repositorios.TransaccionRepository;

public class TransaccionesService {
    private Repositorio repositorioTransaccion;
    private Repositorio repositorioCuenta;

    public TransaccionesService() {
        repositorioTransaccion = new TransaccionRepository();
        repositorioCuenta = new CuentaRepository();
    }

    public void crearTransaccion(Map datos) {
        String fecha = (String) datos.get("FECHA");
        String hora = (String) datos.get("HORA");
        String tipo_transaccion = (String) datos.get("TIPO_TRANSACCION");
        double monto = (double) datos.get("MONTO");
        int id_cuenta = (int) datos.get("ID_CUENTA");
        String tipo_cuenta_destino = (String) datos.get("TIPO_CUENTA_DESTINO");
        int transaccion_id = (int) datos.get("ID");

        Cuenta cuenta = (Cuenta) repositorioCuenta.buscar(String.valueOf(id_cuenta));

        if(cuenta != null) {
            Transacciones newTransaccion = new Transacciones(fecha, hora, tipo_transaccion, monto, id_cuenta,
            tipo_cuenta_destino, transaccion_id);
    repositorioTransaccion.guardar(newTransaccion);
        }
        else {
            throw new Error("Usuario no existe");
        }

        
    }

    public List<Transacciones> listarTransacciones() {
        return (List<Transacciones>) repositorioTransaccion.listar();
    }

    public List<Transacciones> listarTransaccionesId(int id) {
        return (List<Transacciones>) repositorioTransaccion.listarbyid(id);
    }
}
