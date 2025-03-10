package paquete1;

import java.util.Scanner;

public class Main {
    
    public static void main(String [] args) {
        
        Scanner input = new Scanner(System.in);
        
        Metodos md = new Metodos();
        
        // Arreglo de usuarios
        Usuario [] array = md.Arreglo();
        
        int op, usuariosCreados = 0;
        do {
            System.out.println("------------------------------------");
            System.out.println("MENU");
            System.out.println("1. Acceder (Usuario)");
            System.out.println("2. Regitrar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Salir");
            System.out.print("Ingresa el nuemro de la opcion: ");
            op = input.nextInt(); 
            System.out.println("------------------------------------");
            switch (op) {
                case 1:
                    break;
                case 2:
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
                    System.out.println("---Cuenta creada---");
                    usuariosCreados ++;
                    break;
                case 3:
                    // Solicitar datos de confirmacion
                    System.out.print("Ingresa tu nombre: ");
                    input.nextLine();
                    nombre = input.nextLine();
                    System.out.print("Ingresa tu ID: ");
                    id = input.next();
                    id = md.ConfirmarID(id);
                    // Validar si existe
                    boolean existe = md.BuscarUsuario(nombre, id, array);
                    if (existe) {
                        // Confirmar con la contrasenia
                        System.out.println("Ingresa tu contrasenia");
                        System.out.print("-> ");
                        password = input.next();
                        int posicionEnArray = md.PosicionEnArray(nombre, id, array);
                        boolean confirmarPassword = md.ComprobarPassword(password, posicionEnArray, array);
                        // Confirmar la eliminacion
                        if (confirmarPassword) {
                            System.out.println(array[posicionEnArray].toString());
                            System.out.println("Confirmar");
                            System.out.print("SI/NO -> ");
                            char eliminar = input.next().charAt(0);
                            if (eliminar == 's' || eliminar == 'S') {
                                array[usuariosCreados] = null;
                                System.out.println("---Cuenta eliminada---");
                            }   
                        }
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 4:
                    System.out.println("---");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (op != 4);
        
    }
    
}
