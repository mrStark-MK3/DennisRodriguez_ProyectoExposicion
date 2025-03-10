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
                    System.out.print("Ingresa tu nombre: ");
                    input.nextLine();
                    String nombre = input.nextLine();
                    System.out.print("Ingresa tu ID: ");
                    String id = input.nextLine();
                    System.out.print("Ingresa tu edad: ");
                    int edad = input.nextInt();
                    System.out.print("Elije tu tipo de plan");
                    System.out.println("1. Premium - L. 600");
                    System.out.println("2. Normal - L. 500");
                    System.out.print("Ingresa el e numero de la opcion: ");
                    int plan = input.nextInt();
                    // Validar que el usuario ingrese una opcion valida
                    while (plan < 1 || plan > 2) {
                        System.out.println("Opcion no valida");
                        System.out.println("Vuelva a intentarlo");
                        System.out.print("-> ");
                        plan = input.nextInt();
                    }
                    String tipo_de_cliente = "";
                    // Finalizar de crear el objeto tipo Usuario dependiendo el plan
                    switch (plan) {
                        case 1:
                            tipo_de_cliente = "Premium";
                            break;
                        case 2:
                            tipo_de_cliente = "Normal";
                            break;
                    }
                    // Crear contrasenia
                    System.out.println("Crea tu contrasenia");
                    System.out.print("-> ");
                    String password = input.nextLine();
                    // Validar contrasenia
                    
                    System.out.println("Confirmar contrasenia");
                    System.out.print("-> ");
                    String confirm = input.nextLine();
                    // Confirmar contrasenia
                    while (password.equals(confirm)) {
                        System.out.println("Contrasenia incorrecta");
                        System.out.println("-> ");
                        confirm = input.nextLine();
                    }
                    // Guardar usuario en el array de Usuarios
                    array[usuariosCreados] = new Usuario(nombre, id, edad, tipo_de_cliente, password);
                    usuariosCreados ++;
                    // Usuario registrado
                    break;
                case 3:
                    // Solicitar el nombre
                    System.out.print("Ingresa tu nombre: ");
                    // Validar si existe
                    //------------
                    System.out.println("Confirmar");
                    System.out.print("SI/NO -> ");
                    char eliminar = input.nextLine().charAt(0);
                    if (eliminar == 's' || eliminar == 'S') {
                        array[elegido] = null;
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
