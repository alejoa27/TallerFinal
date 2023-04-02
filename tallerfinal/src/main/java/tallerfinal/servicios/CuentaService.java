package tallerfinal.servicios;

import java.util.List;
import java.util.Map;

import tallerfinal.entidades.Cuenta;
import tallerfinal.entidades.Persona;
import tallerfinal.repositorios.Repositorio;
import tallerfinal.repositorios.CuentaRepository;
import tallerfinal.repositorios.PersonaRepository;

public class CuentaService {
    private Repositorio repositorioCuenta;
    private Repositorio repositorioPersona;

    public CuentaService() {
        repositorioCuenta = new CuentaRepository();
        repositorioPersona = new PersonaRepository();
    }

    public void crearCuenta(Map datos) {
        String numero_cuenta = (String) datos.get("NUMERO_CUENTA");
        double saldo = (double) datos.get("SALDO");
        String tipo_cuenta = (String) datos.get("TIPO_CUENTA");
        int id_usuario = (int) datos.get("ID_USUARIO");
        int id = (int) datos.get("ID");


        Persona persona = (Persona) repositorioPersona.buscar(String.valueOf(id_usuario));

        if(persona != null) {
        Cuenta newCuenta = new Cuenta(numero_cuenta, saldo, tipo_cuenta, id_usuario, id);
        repositorioCuenta.guardar(newCuenta);
        }
        else {
            throw new Error("Usuario no existe");
        }
    }

    public List<Cuenta> listarCuentas() {
        return (List<Cuenta>) repositorioCuenta.listar();
    }

    public List<Cuenta> listarCuentasId(int id) {
        return (List<Cuenta>) repositorioCuenta.listarbyid(id);
    }

    public void eliminarCuenta(String identificador) {
        repositorioCuenta.eliminar(identificador);
    }
}
