package tallerfinal.repositorios;

import java.util.List;

import tallerfinal.entidades.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonaRepository implements Repositorio {

    private String cadenaConexion = "jdbc:sqlite:banco.db";

    @Override
    public void guardar(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Persona persona = (Persona) objeto;
            String sentenciaSql = "INSERT INTO USUARIOS (ID, NOMBRE, APELLIDO, CEDULA) " +
                    " VALUES('" + persona.getId() + "', '" + persona.getNombre() + "', '" + persona.getApellido()
                    + "', '" + persona.getCedula() + "');";
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
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "DELETE FROM USUARIOS WHERE ID = '" + identificador + "';";
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
            String sentenciaSQL = "SELECT * FROM USUARIOS WHERE ID = '" + identificacion + "'";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            System.out.println(resultadoConsulta);
            if (resultadoConsulta != null && resultadoConsulta.next()) {
                Persona persona = null;
                String nombre = resultadoConsulta.getString("NOMBRE");
                String apellido = resultadoConsulta.getString("APELLIDO");
                String cedula = resultadoConsulta.getString("CEDULA");
                int id = resultadoConsulta.getInt("ID");
                persona = new Persona(nombre, apellido, cedula, id);
                System.out.println("persona" + persona);
                return persona;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public List<Persona> listar() {
        List<Persona> personas = new ArrayList<Persona>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM USUARIOS";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Persona persona = null;
                    String nombre = resultadoConsulta.getString("NOMBRE");
                    String apellido = resultadoConsulta.getString("APELLIDO");
                    String cedula = resultadoConsulta.getString("CEDULA");
                    int id = resultadoConsulta.getInt("ID");

                    persona = new Persona(nombre, apellido, cedula, id);
                    personas.add(persona);
                }
                return personas;
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
    public List<Persona> listarbyid(int idPersona) {
        List<Persona> personas = new ArrayList<Persona>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM USUARIOS WHERE ID_USUARIO = '" + idPersona + "';";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Persona persona = null;
                    String nombre = resultadoConsulta.getString("NOMBRE");
                    String apellido = resultadoConsulta.getString("APELLIDO");
                    String cedula = resultadoConsulta.getString("CEDULA");
                    int id = resultadoConsulta.getInt("ID");

                    persona = new Persona(nombre, apellido, cedula, id);
                    personas.add(persona);
                }
                return personas;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

}
