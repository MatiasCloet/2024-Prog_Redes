package threads;

public class main {

	public static void main(String[] args) {
		
		
		
		long tiempoInicial = System.currentTimeMillis(); 
		
		persona cli1  = new persona(
				"Javi",
				25632568,
				new String[] {"Arroz","Coca-Cola","Vela Cumple", "Globos"},
				new int[]    { 10    ,     5     ,     2       ,    3   }
				);
		persona cli2  = new persona(
				"Juan",
				36589741,
				new String[] {"Taza", "Cuchara", "Cafe"},
				new int[]    { 1    ,    1     ,   1}
				);
		
		persona cli3  = new persona(
				"Enrique",
				69874521,
				new String[] {"Pan", "Manteca" , "Cuchillo de Untar"},
				new int[]    {  2  ,     1     ,         1      }
				);
		persona cli4  = new persona(
				"Maria",
				45534578,
				new String[] {"Vodka", "Fernet" , "Speed", "Jugo de Naranja", "Coca-Cola"},
				new int[]    {   2   ,    2     ,    8   ,      5          ,   4   }
				);
		
		persona cli5  = new persona(
				"Sofia",
				63642158,
				new String[] {"Pritty-Limon" , "Esponja" , "Guante" , "Detergente"},
				new int[]    {      3       ,     2     ,     2       ,    1   }
				);
		persona cli6  = new persona(
				"Hector",
				25632568,
				new String[] {"Mandioca","Papayas","Biscochitos"},
				new int[]    {   3    ,     2     ,     2       }
				);
		
		persona cli7  = new persona(
				"Maxi",
				68574125,
				new String[] {"yerba","Azucar","Edulcurante", "Yuyos varios"},
				new int[]    {   2    ,   1     ,     2       ,    3   }
				);
		persona cli8  = new persona(
				"Laura",
				25632568,
				new String[] {"Tomates","Budin","Nesquik", "Leche"},
				new int[]    { 3       ,   2   ,     1   ,    3   }
				);
		
		persona cli9  = new persona(
				"Matias",
				12458524,
				new String[] {"Medialuna","Pepino","Bagio"},
				new int[]    {     12     ,  3     ,  2    }
				);
		persona cli10 = new persona(
				"Renzo",
				25632568,
				new String[] {"Test Embarazo", "Lubricante", "Hoas A4" , "Pañales"},
				new int[]    {    1          ,    3        ,     2     ,    3   }
				);
		//Ciclo de vida: NEW
		Thread caja1 = new Thread();
		
		caja1.getName(); //Nos da el nombre del hilo
		caja1.setName(null); //Nos deja darle nombre al hilo
		caja1.getPriority(); //Nos devuelve la prioridad de un hilo
		caja1.setPriority(Thread.MAX_PRIORITY); //Nos deja darle un nivel de prioridad a un hilo
		caja1.getState(); //Nos dice en que parte del CICLO de vida esta
		caja1.getThreadGroup();
		caja1.isAlive();
		
		caja1.isInterrupted(); //Si esta bloqueado o no
		caja1.interrupted(); //Nos deja bloquear el hilo
		caja1.interrupt(); //Revisar el estado del hilo (si esta interumpido o no)
		caja1.join(); //Bloquea un hilo hasta que otra tarea este completa
		caja1.wait();
		caja1.resume();
		caja1.notify();
		caja1.notifyAll();
		caja1.run();
		caja1.start();
		caja1.stop();
		caja1.suspend();
		caja1.currentThread();
		caja1.wait(tiempoInicial);   
		caja1.sleep(tiempoInicial);
		
		
		
	}

}
