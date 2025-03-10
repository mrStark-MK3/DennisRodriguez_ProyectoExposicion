package paquete1;

public class Gym {
    
    // Atributos
    private int usersCreados;
    private int clientesVIP;
    private int clientesNormales;
    private int visitas;
    private int dinero;
    
    // Constructor
    public Gym(int usersCreados, int clientesVIP, int clientesNormales, int visitas, int dinero) {
        this.usersCreados = usersCreados;
        this.clientesVIP = clientesVIP;
        this.clientesNormales = clientesNormales;
        this.visitas = visitas;
        this.dinero = dinero;
    }
    
    // Funciones
    public void VIPs() {
        this.clientesVIP ++;
    }
    public void Normales() {
        this.clientesNormales ++;
    }
    public void Registros() {
        this.usersCreados ++;
    }
    public void Visitas() {
        this.visitas ++;
    }
    public void PagosVIP() {
        this.dinero += 600;
    }
    public void PagosNormales() {
        this.dinero += 500;
    }
    
    // Getters y Setters
    public int getUsersCreados() {
        return usersCreados;
    }

    public void setUsersCreados(int usersCreados) {
        this.usersCreados = usersCreados;
    }

    public int getClientesVIP() {
        return clientesVIP;
    }

    public void setClientesVIP(int clientesVIP) {
        this.clientesVIP = clientesVIP;
    }

    public int getClientesNormales() {
        return clientesNormales;
    }

    public void setClientesNormales(int clientesNormales) {
        this.clientesNormales = clientesNormales;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    // ToString

    @Override
    public String toString() {
        return "GIMNASIO" + 
                "\nUsuarios Creados/Registrados: " + usersCreados + 
                "\nClientes Premium: " + clientesVIP + 
                "\nClientes Normales: " + clientesNormales + 
                "\n Visitas Totales: " + visitas + 
                "\nGenerado: L." + dinero + 
                '}';
    }
    
}
