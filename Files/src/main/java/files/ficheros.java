package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ficheros {
	
	private File archivo;
	private PrintStream ps;
	
	public ficheros() 
	{
		String ruta = ""; // "c:\\User\\"
		String nombre = ",mario";
		String extencion = ".txt";
		
		archivo = new File( ruta.concat(nombre.concat(extencion)) );
		
	}
	
	public void createFilePrintStream(File a) 
	{
		
		FileOutputStream fos = null;
		
		
		try {

			fos = new FileOutputStream(a);
			ps = new PrintStream(fos,true); //append (modo de SOBRE escritura)
											
			ps.println("Si Si, Ñam Ñam");
			ps.println("MAMA");
			
			ps.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		
		
	}
	
}
