import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejecucion {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		traza = false;
		ayuda = false;
		lista = false;
		switch(args[0]){
		case "-h":
			ayuda = true;
			System.out.println("SINTAXIS:torneo[-t][-h] n [fichero entrada]");
			System.out.println("  -t                 Traza la parametrización de cada invocación recursiva");
			System.out.println("  -h                 Muestra esta ayuda");
			System.out.println("   n                 Número de jugadores");
			System.out.println("[fichero entrada]    Listado de los nombres de los jugadores del torneo");
			break;
		case "-t":
			traza = true;
			jugadores = Integer.parseInt(args[1]);
			break;
		default:
			jugadores = Integer.parseInt(args[0]);
		}					
		//fichero de jugadores 
		String jug = "";
		if(traza) {
			if(args.length>2) {
				if(!args[2].isEmpty()) {
					jug = args[2];
					lista = true;
				}
			}
		}else {
			if(args.length>1) {
				if(!args[1].isEmpty()) {
					jug = args[1];
					lista = true;
				}
			}
		}
		
		if(lista){
		try {		
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(jug), "UTF-8"));					
			String exp;			
			while((exp = in.readLine())!=null) {										
				listaJugadores.add(exp);			
			}			
			in.close();			
		} catch (IOException ex) {			
			System.err.println("No se puede abrir el fichero de jugadores para su lectura.");			
		}		
	}
		if(!ayuda) {
			Torneo torneo = new Torneo(jugadores);
		}
    }
	
	public static ArrayList<String> listaJugadores = new ArrayList<String>();
	static int jugadores;	
	public static boolean traza;
	public static boolean ayuda;
	public static boolean lista;
}
