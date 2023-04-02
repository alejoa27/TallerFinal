package tallerfinal.entidades;

public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int id;

    public Persona(String nombre, String apellido, String cedula, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.id = id;
    }
    

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula(){
        return cedula;
    }

    public void setCedula(String cedula){
        this.cedula = cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
