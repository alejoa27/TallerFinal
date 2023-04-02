package tallerfinal.servicios;

import java.util.List;
import java.util.Map;

import tallerfinal.entidades.Persona;
import tallerfinal.repositorios.PersonaRepository;
import tallerfinal.repositorios.Repositorio;

public class PersonaService {
    private Repositorio repositorioPersona;

    public PersonaService() {
        repositorioPersona = new PersonaRepository();
    }

    public void guardarPersona(Map datos) {
        String nombre = (String) datos.get("NOMBRE");
        String apellido = (String) datos.get("APELLIDO");
        String cedula = (String) datos.get("CEDULA");
        int id = (int) datos.get("ID");
        
        Persona newPerson = new Persona(nombre, apellido, cedula, id);
        repositorioPersona.guardar(newPerson);
    }

    public List<Persona> listarPersonas() {
        return (List<Persona>) repositorioPersona.listar();
    }

    public Persona buscarPersona(String identificador) throws Exception {
        Object persona = repositorioPersona.buscar(identificador);
        if (persona == null) {
            throw new Exception("No se encontro la persona" + persona);
        }
        return (Persona) persona;
    }

    public void eliminarPersona(String identificador) {
        repositorioPersona.eliminar(identificador);
    }

    public void actualizarPersona(Map datos) {
        String nombre = (String) datos.get("NOMBRE");
        String apellido = (String) datos.get("APELLIDO");
        String cedula = (String) datos.get("CEDULA");
        int id = (int) datos.get("ID");
        
        Persona newPerson = new Persona(nombre, apellido, cedula, id);
        repositorioPersona.actualizar(newPerson);
    }

    public void actualizarPersonaId(Map datos, int numid) {
        String nombre = (String) datos.get("NOMBRE");
        String apellido = (String) datos.get("APELLIDO");
        String cedula = (String) datos.get("CEDULA");
        int id = (int) datos.get("ID");
        
        Persona newPerson = new Persona(nombre, apellido, cedula, id);
        repositorioPersona.actualizarId(newPerson, numid);
    }

    
}
