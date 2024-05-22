package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

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
	
	public File getArchivo()
	{
		return this.archivo;
	}
	
	public void createFilePrinter(File a) //clase para escribir en archivos
	{
		FileWriter fw = null;
		PrintWriter pw = null; //equivalente al printStream
		
		try 
		{
			if ( !a.exists() )
			{
				a.createNewFile();
			}
			fw = new FileWriter( a , true);
			pw = new PrintWriter(fw);
			
			pw.println("Otro MUNDO");		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if( pw != null)
					pw.close();
				
				if( fw != null)
					fw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void createFilePrintStream(File a)
	{
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(a, false);
			ps = new PrintStream(fos); //mode append true = no sobreescribe
			
			ps.println("holaa mundo");
			ps.println("chau mundo");
			
			ps.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void CreateFileBuffered(File a) 
	{
		
	}
	
}
