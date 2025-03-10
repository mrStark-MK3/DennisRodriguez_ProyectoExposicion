package paquete1;

public class Usuario {

    // Atributos
    private String nombre;
    private String id;
    private int edad;
    private String tipo_de_cliente;
    private String password;
    
    // Constructor
    public Usuario(String nombre, String id, int edad, String tipo_de_cliente, String password) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.tipo_de_cliente = tipo_de_cliente;
        this.password = password;
    }
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo_de_cliente() {
        return tipo_de_cliente;
    }
    
    public void setTipo_de_cliente(String tipo_de_cliente) {
        this.tipo_de_cliente = tipo_de_cliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
