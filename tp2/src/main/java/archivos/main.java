package archivos;

import java.io.PrintStream;

public class main {

	public static void main(String[] args) {
		
		PrintStream ps = new PrintStream(System.out);
		
		menu MenuPrincipal = new menu();
		MenuPrincipal.menu();
		
		
		
	}

}
