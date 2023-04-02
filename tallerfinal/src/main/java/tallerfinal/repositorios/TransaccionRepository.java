package tallerfinal.repositorios;

import java.util.List;

import tallerfinal.entidades.Persona;
import tallerfinal.entidades.Transacciones;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TransaccionRepository implements Repositorio {

    private String cadenaConexion = "jdbc:sqlite:banco.db";

    @Override
    public void guardar(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String[] dateStringlist = dateFormat.format(date).split("\\s+");
            Transacciones transaccion = (Transacciones) objeto;
            String sentenciaSql = "INSERT INTO USUARIOS (ID, FECHA, HORA, TIPO_TRANSACCION, MONTO, ID_CUENTA, TIPO_CUENTA_DESTINO) "
                    +
                    " VALUES('" + transaccion.getId() + "', '" + dateStringlist[1] + "', '" + dateStringlist[0]
                    + "', '" + transaccion.getTipo_transaccion() + "', '" + transaccion.getMonto() + "', '"
                    + transaccion.getId_cuenta() + "', '" + transaccion.getTipo_cuenta_destino() + "');";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void eliminar(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public Object buscar(String identificacion) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSQL = "SELECT * FROM TRANSACCIONES WHERE ID = '" + identificacion + "'";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (resultadoConsulta != null && resultadoConsulta.next()) {
                Transacciones transaccion = null;
                String fecha = resultadoConsulta.getString("FECHA");
                String hora = resultadoConsulta.getString("HORA");
                String tipo_transaccion = resultadoConsulta.getString("TIPO_TRANSACCION");
                double monto = resultadoConsulta.getDouble("MONTO");
                int id_cuenta = resultadoConsulta.getInt("ID_CUENTA");
                String tipo_cuenta_destino = resultadoConsulta.getString("TIPO_CUENTA_DESTINO");
                int transaccion_id = resultadoConsulta.getInt("ID");

                transaccion = new Transacciones(fecha, hora, tipo_transaccion, monto, id_cuenta,
                        tipo_cuenta_destino, transaccion_id);
                return transaccion;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public List<Transacciones> listar() {
        List<Transacciones> transacciones = new ArrayList<Transacciones>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM TRANSACCIONES";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Transacciones transaccion = null;
                    String fecha = resultadoConsulta.getString("FECHA");
                    String hora = resultadoConsulta.getString("HORA");
                    String tipo_transaccion = resultadoConsulta.getString("TIPO_TRANSACCION");
                    double monto = resultadoConsulta.getDouble("MONTO");
                    int id_cuenta = resultadoConsulta.getInt("ID_CUENTA");
                    String tipo_cuenta_destino = resultadoConsulta.getString("TIPO_CUENTA_DESTINO");
                    int transaccion_id = resultadoConsulta.getInt("ID");

                    transaccion = new Transacciones(fecha, hora, tipo_transaccion, monto, id_cuenta,
                            tipo_cuenta_destino, transaccion_id);
                    transacciones.add(transaccion);
                }
                return transacciones;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public void actualizarId(Object objeto, int numcuenta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarId'");
    }

    @Override
    public List<Transacciones> listarbyid(int id) {
        List<Transacciones> transacciones = new ArrayList<Transacciones>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM TRANSACCIONES WHERE ID = '" + id + "'";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Transacciones transaccion = null;
                    String fecha = resultadoConsulta.getString("FECHA");
                    String hora = resultadoConsulta.getString("HORA");
                    String tipo_transaccion = resultadoConsulta.getString("TIPO_TRANSACCION");
                    double monto = resultadoConsulta.getDouble("MONTO");
                    int id_cuenta = resultadoConsulta.getInt("ID_CUENTA");
                    String tipo_cuenta_destino = resultadoConsulta.getString("TIPO_CUENTA_DESTINO");
                    int transaccion_id = resultadoConsulta.getInt("ID");

                    transaccion = new Transacciones(fecha, hora, tipo_transaccion, monto, id_cuenta,
                            tipo_cuenta_destino, transaccion_id);
                    transacciones.add(transaccion);
                }
                return transacciones;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public void actualizar(Object objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

}
