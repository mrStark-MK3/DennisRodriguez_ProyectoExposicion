package paquete1;

import java.util.Scanner;

public class Main {
    
    public static void main(String [] args) {
        
        Scanner input = new Scanner(System.in);
        
        Metodos md = new Metodos();
        
        // Arreglo de usuarios
        Usuario [] array = md.Arreglo();
        
        int op, usuariosCreados = 0;
        Gym gym = new Gym(0, 0, 0, 0, 0);
        do {
            System.out.println("------------------------------------");
            System.out.println("MENU");
            System.out.println("1. Regitrar Usuario");
            System.out.println("2. Acceder (Usuario)");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Salir");
            System.out.print("Ingresa el nuemro de la opcion: ");
            op = input.nextInt(); 
            System.out.println("------------------------------------");
            switch (op) {
                case 1:
                    System.out.println("REGISTRARSE");
                    
                    // Proceso de registro
                    System.out.println("Rellene los campos obligatorios");
                    System.out.println("------------------------------------");
                    
                    // Ingresar nombre
                    System.out.print("Ingresa tu nombre: ");
                    input.nextLine();
                    String nombre = input.nextLine();
                    
                    // Ingresar ID
                    System.out.print("Ingresa tu ID: ");
                    String id = input.next();
                    // Confirmar ID
                    id = md.ConfirmarID(id);
                    
                    // ingresar edad
                    System.out.print("Ingresa tu edad: ");
                    int edad = input.nextInt();
                    
                    // Elegir el tipo de plan
                    System.out.println("Elije tu tipo de plan");
                    int plan = md.TipoDePlan();
                    String tipo_de_cliente = md.TipoDeCliente(plan);
                    
                    // Crear contrasenia
                    System.out.println("Crea tu contrasenia");
                    System.out.print("-> ");
                    String password = input.next();
                    // Validar contrasenia
                    password = md.ValidarPassword(password);
                    System.out.println("Confirmar contrasenia");
                    System.out.print("-> ");
                    String confirm = input.next();
                    // Confirmar contrasenia
                    while (!password.equals(confirm)) {
                        System.out.println("Contrasenia incorrecta");
                        System.out.print("-> ");
                        confirm = input.next();
                    }
                    
                    // Guardar usuario en el array de Usuarios
                    array[usuariosCreados] = new Usuario(nombre, id, edad, tipo_de_cliente, password);
                    usuariosCreados ++;
                    System.out.println("---Cuenta creada---");
                    
                    // Actualizar datos del Gym
                    if (tipo_de_cliente.equalsIgnoreCase("Premium")) {
                        gym.VIPs();
                    } else {
                        gym.Normales();
                    }
                    gym.Registros();
                    break;
                case 2:
                    // Mostrar usuarios
                    System.out.println("------------------------------------");
                    md.MostrarUsuarios(array);
                    System.out.println("------------------------------------");
                    // Solicitar datos de confirmacion
                    System.out.print("Ingresa tu nombre: ");
                    input.nextLine();
                    nombre = input.nextLine();
                    // Buscar Usuario
                    nombre = md.BuscarUsuario(nombre, array);
                    int posicionEnArray = md.PosicionEnArray(nombre, array); 
                    System.out.print("Ingresa tu ID: ");
                    id = input.nextLine();
                    id = md.ConfirmarID(id);
                    id = md.VerificarID(id, array, posicionEnArray);
                    // Confirmar con la contrasenia
                    System.out.println("Ingresa tu contrasenia");
                    System.out.print("-> ");
                    password = input.next();
                    boolean confirmarPassword = md.ComprobarPassword(password, posicionEnArray, array);
                    if (confirmarPassword) {
                        System.out.println("Cliente " + array[posicionEnArray].getTipo_de_cliente());
                        if (array[posicionEnArray].getTipo_de_cliente().equalsIgnoreCase("Premium")) {
                            System.out.println("Pago por visita: L. 600");
                            gym.PagosVIP();
                        } else {
                            System.out.println("Pago por visita: L. 500");
                            gym.PagosNormales();
                        }
                        System.out.println("Bienvenido");
                        gym.Visitas();
                    } else {
                        System.out.println("Acceso denegado");
                    }
                    break;
                case 3:
                    // Mostrar usuarios
                    System.out.println("------------------------------------");
                    md.MostrarUsuarios(array);
                    System.out.println("------------------------------------");
                    // Solicitar datos de confirmacion
                    System.out.print("Ingresa tu nombre: ");
                    input.nextLine();
                    nombre = input.nextLine();
                    // Buscar Usuario
                    nombre = md.BuscarUsuario(nombre, array);
                    posicionEnArray = md.PosicionEnArray(nombre, array); 
                    System.out.print("Ingresa tu ID: ");
                    id = input.nextLine();
                    id = md.ConfirmarID(id);
                    id = md.VerificarID(id, array, posicionEnArray);
                    // Confirmar con la contrasenia
                    System.out.println("Ingresa tu contrasenia");
                    System.out.print("-> ");
                    password = input.next();
                    confirmarPassword = md.ComprobarPassword(password, posicionEnArray, array);
                    // Confirmar la eliminacion
                    if (confirmarPassword) {
                        System.out.println(array[posicionEnArray].toString());
                        System.out.println("Seguro de Eliminar tu cuenta?");
                        System.out.print("SI/NO -> ");
                        char eliminar = input.next().charAt(0);
                        if (eliminar == 's' || eliminar == 'S') {
                            array[posicionEnArray] = null;
                            System.out.println("---Cuenta eliminada---");
                        }
                    } else {
                        System.out.println("Has superado el numero de intentos");
                    }
                    break;
                case 4:
                    System.out.println(gym.toString());
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (op != 4);
        
    }
    
}
