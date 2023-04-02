package tallerfinal.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tallerfinal.entidades.Cuenta;

public class CuentaRepository implements Repositorio {
    private String cadenaConexion = "jdbc:sqlite:banco.db";

    @Override
    public void guardar(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Cuenta cuenta = (Cuenta) objeto;
            String sentenciaSql = "INSERT INTO CUENTAS (ID, NUMERO_CUENTA, SALDO, TIPO_CUENTA, ID_USUARIO) " +
                    " VALUES('" + cuenta.getId() + "', '" + cuenta.getNumero_cuenta() + "', '" + cuenta.getSaldo()
                    + "', '" + cuenta.getTipo_cuenta() + "', '" + cuenta.getId_usuario()
                    + "');";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void eliminar(String id) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "DELETE FROM CUENTAS WHERE NUMERO_CUENTA = '" + id + "';";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Object objeto) {

    }

    @Override
    public Object buscar(String identificacion) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSQL = "SELECT * FROM CUENTAS WHERE ID = '" + identificacion + "'";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (resultadoConsulta != null && resultadoConsulta.next()) {
                Cuenta cuenta = null;
                String numero_cuenta = resultadoConsulta.getString("NUMERO_CUENTA");
                Double saldo = resultadoConsulta.getDouble("SALDO");
                String tipo_cuenta = resultadoConsulta.getString("TIPO_CUENTA");
                int id_usuario = resultadoConsulta.getInt("ID_USUARIO");
                int id = resultadoConsulta.getInt("ID");
                cuenta = new Cuenta(numero_cuenta, saldo, tipo_cuenta, id_usuario, id);
                return cuenta;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public List<Cuenta> listar() {
        List<Cuenta> cuentas = new ArrayList<Cuenta>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM CUENTAS";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Cuenta cuenta = null;
                    String numero_cuenta = resultadoConsulta.getString("NUMERO_CUENTA");
                    double saldo = resultadoConsulta.getDouble("SALDO");
                    String tipo_cuenta = resultadoConsulta.getString("TIPO_CUENTA");
                    int id_cuenta = resultadoConsulta.getInt("ID_CUENTA");
                    int id = resultadoConsulta.getInt("ID");

                    cuenta = new Cuenta(numero_cuenta, saldo, tipo_cuenta, id_cuenta, id);
                    cuentas.add(cuenta);
                }
                return cuentas;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public void actualizarId(Object objeto, int numcuenta) {

    }

    @Override
    public List<Cuenta> listarbyid(int id) {
        List<Cuenta> cuentas = new ArrayList<Cuenta>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM CUENTAS WHERE ID = '" + id + "'";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Cuenta cuenta = null;
                    String numero_cuenta = resultadoConsulta.getString("NUMERO_CUENTA");
                    double saldo = resultadoConsulta.getDouble("SALDO");
                    String tipo_cuenta = resultadoConsulta.getString("TIPO_CUENTA");
                    int id_cuenta = resultadoConsulta.getInt("ID_CUENTA");
                    int cuenta_id = resultadoConsulta.getInt("ID");

                    cuenta = new Cuenta(numero_cuenta, saldo, tipo_cuenta, id_cuenta, cuenta_id);
                    cuentas.add(cuenta);
                }
                return cuentas;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

}
