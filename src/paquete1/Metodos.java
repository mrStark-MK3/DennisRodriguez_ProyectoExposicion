package paquete1;

import java.util.Scanner;

public class Metodos {
    
    // Metodos de registro
    public Usuario [] Arreglo() {
        
        // Crear arreglo de tipo Usuario
        Usuario [] array = new Usuario[20];
        
        return array;
    }
    public String ValidarPassword(String password) {
        
        Scanner input = new Scanner(System.in);
        
        boolean valida = true;
        do {
            int mayus = 0, minus = 0, nums = 0, especial = 0;
            if (password.length() >= 8) {
                for (int i = 0; i < password.length(); i++) {
                    if (password.charAt(i) > 64 && password.charAt(i) < 91) {
                        mayus ++;
                    } else if (password.charAt(i) > 96 && password.charAt(i) < 123) {
                        minus ++;
                    } else if (password.charAt(i) > 47 && password.charAt(i) < 58) {
                        nums ++;
                    } else {
                        especial ++;
                    }
                }
                if (mayus > 0 && minus > 0 && nums > 0 && especial > 0) {
                    break;
                } else {
                    System.out.println("La contrasenia debe tener mayusculas, minusculas, numero y caracteres especiales");
                    valida = false;
                }
            } else {
                System.out.println("La contrasenia debe tener por lo menos 8 caracteres");
                valida = false;
            }
            System.out.println("Intenta con una nueva");
            System.out.print("-> ");
            password = input.nextLine();
        } while (!valida);
        
        return password;
    }
    public int TipoDePlan() {
        
        Scanner input = new Scanner(System.in);
        
        int plan = 0;
        char confirmPlan = 0;
        do {
            System.out.println("1. Premium - L. 600");
            System.out.println("2. Normal - L. 500");
            System.out.print("Ingresa el numero de la opcion: ");
            plan = input.nextInt();
            // Validar que el usuario ingrese una opcion valida
            while (plan < 1 || plan > 2) {
                System.out.println("Opcion no valida");
                System.out.println("Vuelva a intentarlo");
                System.out.print("-> ");
                plan = input.nextInt();
            }
            switch (plan) {
                case 1:
                    System.out.println("Confirma que desea usar el plan Premium?");
                    System.out.print("(SI/NO) -> ");
                    confirmPlan = input.next().charAt(0);
                    break;
                case 2:
                    System.out.println("Confirma que desea usar el plan Normal?");
                    System.out.print("(SI/NO) -> ");
                    confirmPlan = input.next().charAt(0);
                    break;
            }
        } while (confirmPlan == 'n' || confirmPlan == 'N');

        return plan;
    }
    public String TipoDeCliente(int plan) {
        
        String tipo_de_cliente = "";
        // Agregar tipo de plan al objeto Usuario
        switch (plan) {
            case 1:
                tipo_de_cliente = "Premium";
                break;
            case 2:
                tipo_de_cliente = "Normal";
                break;
        }
        
        return tipo_de_cliente;
    }
    public String ConfirmarID(String id) {
        
        Scanner input = new Scanner(System.in);
        
        boolean valido = true;
         do {
            if (id.length() == 13) {
                int invalidChars = 0;
                for (int i = 0; i < id.length(); i++) {
                    if (id.charAt(i) < 48 || id.charAt(i) > 57) {
                        System.out.println("El ID debe contener solamente numeros");
                        invalidChars ++;
                        valido = false;
                        break;
                    }
                }
                if (invalidChars == 0) {
                    break;
                }
            } else {
                System.out.println("El ID debe tener 13 digitos");
                valido = false;
            }
            System.out.println("Intenta de nuevo");
            System.out.print("-> ");
            id = input.nextLine();
        } while (!valido);
        
        return id;
    }
    
    // Metodos de eliminacion/acceso
    public String BuscarUsuario(String nombre, Usuario [] array) {
        
        Scanner input = new Scanner(System.in);
        
        boolean encontrado = false;
        do {
            for (int i = 0; i <= array.length; i++) {
                if (array[i] != null) {
                    if (nombre.equalsIgnoreCase(array[i].getNombre())) {
                        encontrado = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Usuario no encontrado");
                System.out.println("Ingresa tu nombre de nuevo");
                System.out.print("-> ");
                nombre = input.nextLine();    
            } else {
                break;
            }
        } while (!encontrado);
        
        return nombre;
    }
    public String VerificarID(String id, Usuario [] array, int posicionObjeto) {
        
        Scanner input = new Scanner(System.in);
        
        while (!array[posicionObjeto].getId().equals(id)) {
            System.out.println("ID incorrecto");
            System.out.println("Intenta de nuevo");
            System.out.print("-> ");
            id = input.nextLine();
        }
        
        return id;
    }
    public int PosicionEnArray(String nombre, Usuario [] array) {
        
        int posicion = 0;
        
        for (int i = 0; i <= array.length; i++) {
            if (array[i].getNombre().equalsIgnoreCase(nombre)) {
                posicion = i;
                break;
            }
        }
        
        return posicion;    
    }
    public boolean ComprobarPassword(String password, int posicionEnArray, Usuario [] array) {
        
        Scanner input = new Scanner(System.in);
        
        boolean confirmado = true;
        int cont = 0;
        while (cont < 3) {
            if (!array[posicionEnArray].getPassword().equals(password)) {
                confirmado = false;
            } else {
                confirmado = true;
                break;
            }
            System.out.println("Contrasenia incorrecta");
            System.out.println("Intentalo de nuevo");
            System.out.print("-> ");
            password = input.nextLine();
            cont ++;
        }
        
        return confirmado;
    }
    public void MostrarUsuarios(Usuario [] array) {
        
        System.out.println("Usuarios Registrados");
        for (int i = 0; i <= array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i].getNombre());
            } else {
                break;
            }
        }
    }
}
