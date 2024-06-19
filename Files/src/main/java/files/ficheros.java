package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ficheros {
	
	private File archivo;
	private PrintStream ps;
	
	public ficheros() 
	{
		String ruta = ""; // "c:\\User\\"
		String nombre = "mario";
		String extencion = ".txt";
		
		
		archivo = new File( ruta.concat(nombre).concat(extencion) );
		//canal de salida de errores
		try {
			System.setErr( new PrintStream ( 
						   new FileOutputStream( 
					       new File("Erroes.log") , true )) 
					     );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public File getArchivo()
	{
		return this.archivo;
	}
	
	public void datosArchivos() 
	{
		try {
			ps = new PrintStream(System.out);
			ps.println( "Nombre del archivo: " + archivo.getName() );
			ps.println( "Path: " + archivo.getPath() );
			ps.println( "Path Abs: " + archivo.getAbsolutePath() );
			ps.println( "Path Cannon: " + archivo.getCanonicalPath() );
			ps.println( "Contenedir del archivo: " + archivo.getParentFile() );
			ps.println( "Parent: " + archivo.getParent());
			ps.println( "Tamaño: " + archivo.getTotalSpace());
			ps.println( "Ejecutable:" + archivo.canExecute());
			ps.println( "Acceso de lectura:" + archivo.canRead() );
			ps.println( "Acceso de escritura:" + archivo.canWrite() );
			ps.println( "Esta oculto:" + archivo.isHidden() );
			ps.println( "Existe:" + archivo.exists() );
			ps.println( "Es archivo:" + archivo.isFile() );
			ps.println( "Es carpeta:" + archivo.isDirectory() );
			//ps.println( ":" + archivo.createNewFile() ); <- Crea archivos
			//ps.println( ":" + archivo.mkdir() ); <- Crea carpetas
			//ps.println( "Renombrar:" + archivo.renameTo("NuevoNombre.txt") ); <- Renombra el archivo
			//ps.println( "Eliminar cuando se cierre el programa:" + archivo.deleteOnExit() );
			//ps.println( ":" + archivo.set ); Nos deja setear el archivo como leible, ejecutable, read only, etc
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	//lectura de archivos:
	public String  leerCharByChar(File a) 
	{	
		FileReader fr = null;
		String texto = "";
		
		try {
			fr= new FileReader(a);
			
			int letra;
			
			while ( (letra = fr.read()) != -1  ) 
			{
				texto += (char)letra;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return texto;
	}
	
	public String leerConReader(File a) 
	{
		FileReader fr = null;
		BufferedReader br = null;
		String texto = "";
		
		try {
			fr = new FileReader(a);
			br = new BufferedReader(fr);
			
			String linea="";
			while ( (br.readLine() ) != null ) 
			{
				texto += linea.concat("\n") + utils.ANSI_MAGENTA;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return texto;
	}
		
	public void editarArchivo(File original) 
	{
		
		File copia = new File("copia.tmp");
		
		//temp.deleteOnExit(); //cuando se deja de usar, se borra (PIPI)
		
		FileWriter Fw = null;
		PrintWriter Pw = null;
		FileReader Fr = null;
		BufferedReader Br = null;
		
		
		try {
			Fr = new FileReader(original);
			Br = new BufferedReader(Fr);
			
			if( !copia.exists() ) {
				Fw = new FileWriter(copia, true);
				Pw = new PrintWriter(Fw);
				
				String renglon ="";
				while ( (renglon = Br.readLine() ) !=null ) {
					
					//sobre el STRING renglon puedo trabajar
					//mantengo los datos?
					//elimino  los datos?
					//edito    los datos?
					
					Pw.println( renglon.toUpperCase() );
					
					
					//Pw.println( renglon.replaceAll(";", ",") );
					//renglon       = "hola munbdo; me estoy tirando de un edificio;"
					//renglon nuevo = "hola munbdo, me estoy tirando de un edificio,"
					
				}
				Pw.close();
				Fw.close();
			}
			Br.close();
			Fr.close();
			
			if( original.exists() )
				original.delete();
			
			if(copia.exists() )
				copia.renameTo(original); //una modificacion de los datos
		
		}catch(FileNotFoundException e){
			Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
		}catch (IOException e) {
			Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
		}finally {
			
			
		}
		
		
	}	

	public void eliminarArchivo(File original) {
		
		File copia = new File("copia.dat");
		
		FileReader Fr = null;
		BufferedReader Br = null;
		FileWriter Fw = null;
		PrintWriter Pw = null;
		ArrayList<String> renglones = new ArrayList<>();
		
		
		try {
			Fr = new FileReader(original);
			Br = new BufferedReader(Fr);
			
			String renglon ="";
			while( ( renglon = Br.readLine() ) !=null ) 
			{		
					//renglones.add(renglon);
					if( !renglon.contains("1") )
						renglones.add(renglon.toLowerCase());
					
			}
			Fr.close();
			Br.close();
			
			if( original.exists() )
				original.delete();
			
			if(copia.exists() )
				copia.renameTo(original);
			/*
			for( String r : renglones ) 
			{
				if( r.contains("1") )
					renglones.remove(r);
			}
			*/
			
			Fw = new FileWriter(copia, true);
			Pw = PrintWriter(Fw);
			
			for(String r : renglones)
			{
				Pw.println(r);
			}
			Fw.close();
			Pw.close();
			
			Pw.println( renglones );
			
		}catch(FileNotFoundException e) {
			Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
		}catch(IOException e) {
			Logger.getLogger(ficheros.class.getName()).log(Level.WARNING,null, e );
		}finally {
			
		}
	}
}
