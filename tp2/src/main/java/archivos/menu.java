package archivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class menu {

	static boolean continuar = true;
	static PrintStream ps = new PrintStream(System.out);
	
	static void menu() {
		
		while (continuar) {
			ps.println( Utils.ANSI_GREEN + "Que desea hacer:" + Utils.ANSI_RESET);
			ps.println( Utils.ANSI_CYAN + "1- Agregar producto" + Utils.ANSI_RESET);
			ps.println( Utils.ANSI_CYAN + "2- Relleno" + Utils.ANSI_RESET);
			ps.println( Utils.ANSI_CYAN + "3- Relleno" + Utils.ANSI_RESET);
			ps.println( Utils.ANSI_CYAN + "0- Salir" + Utils.ANSI_RESET);

			int opcion = menu.leerOpcion();

			switch (opcion) {
			case 1:
				ps.println("Agregando producto");
				// Lógica del ejercicio 1 (1)
					// aca llamar al metodo que resuelve el ejercicio
					// el metodo esta en otra Class y recominedo que el metodo sea
					// de tipo Static, asi no hay que Instanciarlo (crear el objeto)
				break;
			case 2:
				ps.println("Relleno (nada pibe)");
				// Lógica del ejercicio 1 (b)
				break;
			case 3:
				ps.println("Relleno (nada pibe)");
				// Lógica del ejercicio 2
				break;
			case 0:
				ps.println("Saliste del menu");
				continuar = false;
				break;
			default:
				ps.println("Opción inválida. Por favor, ingrese una opción válida.");
				break;
			}
		}
	}

    static int leerOpcion() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            ps.println( Utils.ANSI_RED + "Ingrese la opción:" + Utils.ANSI_RESET);
            try {
                String input = reader.readLine(); 
                opcion = Integer.parseInt(input); 

                
                if (opcion >= 0) {
                    entradaValida = true; 
                } else {
                    ps.println("Error: Por favor, ingrese un número entero positivo.");
                }
            } catch (NumberFormatException | IOException e) {
                ps.println("Error: Por favor, ingrese un número entero válido.");
            }
        }

        return opcion;
    }
	
	
}
