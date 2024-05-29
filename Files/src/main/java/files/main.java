package files;

import java.io.PrintStream;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintStream ps = new PrintStream(System.out);
		ficheros archivo = new ficheros();
		
		//archivo.createFilePrintStream(archivo.getArchivo());
		//archivo.createFilePrintStream(archivo.getArchivo());
		archivo.createFilePrinter(archivo.getArchivo());
		//archivo.datosArchivos();
		//ps.println( archivo.leerCharByChar(archivo.getArchivo()) );
		ps.println( archivo.leerConReader(archivo.getArchivo()) );
	}

}
