package files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
			
		} catch (IOException e) {
			Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
		}
		finally {
			try {
				if( pw != null)
					pw.close();
				
				if( fw != null)
					fw.close();
				
			} catch (IOException e) {
				Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
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
			Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
		}
		
	}

	public void createFileBuffered(File a) //el goat
	{
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(a,false);
			bw = new BufferedWriter(fw);
			
			bw.write("un");
			bw.newLine();
			bw.write("ppt");
			bw.newLine();
			bw.write("ME VAS A HACER");
			bw.newLine();
			
			bw.flush();
			
			
		} catch (IOException e) {
			Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
		} finally {
			try {
				if( fw != null )
					fw.close();
				
				if( bw != null )
					bw.close();
			} catch (IOException e) {
				Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
			}
			//logger ayuda a trackear el error (mejor que printStackTrace)
		}
		
	}
	
}
