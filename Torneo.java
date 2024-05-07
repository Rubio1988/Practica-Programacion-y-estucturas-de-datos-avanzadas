public class Torneo {
	int ju;
	int di;
	Ejecucion eje;
	public Torneo(int numJugadores) {
		ju = numJugadores;
		
		if(par(ju)) {
			di = ju-1;
		}else {
			di = ju;
		}
		
		int[][] tabla = new int[ju+2][di+1];
		
		crearTabla(ju,tabla);
		if(!eje.traza) {
			Tabla imprimirTabla = new Tabla(ju,di,tabla);
		}
	}
	public void crearTabla(int numJugadores,int[][] tabla) {
		int aux;
		int jug = numJugadores;
		int dia;
		
		if(par(jug)) {
			dia = jug-1;
		}else {
			dia = jug;
		}
		
		//Caso base
		if(jug == 2) {
			tabla[1][1] = 2;
			tabla[2][1] = 1;
			if(eje.traza) {
				Tabla imprimirTabla = new Tabla(ju,di,tabla);
			}
		}
		//Numero impar de jugadores
		else if(!par(jug)) {
			//llamada recursiva
			crearTabla(jug+1,tabla);
			//Vaciamos el jugador jug+1
			for(int i=1;i<=jug;i++) {
				for(int j=1;j<=jug;j++) {
					if(tabla[i][j]==jug+1) {
						tabla[i][j]=0;
					}
				}
			}
			if(eje.traza) {
				Tabla imprimirTabla = new Tabla(ju,di,tabla);
			}
		}
		//numero par de jugadores
		else {
			aux = jug/2;
			
			//cuadrante superior izquierdo
			crearTabla(aux,tabla);
			if(par(aux)) {
				//cuadrante inferior izquierdo
				for(int i=aux+1;i<=jug;i++) {
					for(int j=1;j<=aux-1;j++) {
						tabla[i][j]=tabla[i-aux][j]+aux;
					}
				}
			//cuadrante superior derecho
				for(int i=1;i<=aux;i++) {
					for(int j=aux;j<=jug-1;j++) {
						if((i+j)<=jug) {
							tabla[i][j]=i+j;
						}else {
							tabla[i][j]=i+j-aux;
						}
					}
				}
				//cuadrante inferior derecho
				for(int i=aux+1;i<=jug;i++) {
					for(int j=aux;j<=jug-1;j++) {
						if(i>j) {
							tabla[i][j]=i-j;
						}else {
							tabla[i][j]=(i+aux)-j;
						}
					}
				}
			}//aux impar
			else {
				//cuadrante inferior izquierdo
				for(int i=aux+1;i<=jug;i++) {
					for(int j=1;j<=aux;j++) {
						if(tabla[i-aux][j]==0) {
							tabla[i][j]=0;
						}else {
							tabla[i][j]=tabla[i-aux][j]+aux;
						}
					}
				}
				//ceros del cuadrante izquierdo
				for(int i=1;i<=aux;i++) {
					for(int j=1;j<=aux;j++) {
						if(tabla[i][j]==0) {
							tabla[i][j]=i+aux;
							tabla[i+aux][j]=i;
						}
					}
				}
				//cuadrante superior derecho
				for(int i=1;i<=aux;i++) {
					for(int j=aux+1;j<=jug-1;j++) {
						if((i+j)<=jug) {
							tabla[i][j]=i+j;
						}else {
							tabla[i][j]=i+j-aux;
						}
					}
				}
				//cuadrante inferior derecho
				for(int i=aux+1;i<=jug;i++) {
					for(int j=aux+1;j<=jug-1;j++) {
						if(i>j) {
							tabla[i][j]=i-j;
						}else {
						tabla[i][j]=(i+aux)-j;
						}
					}
				}
			}
			if(eje.traza) {
				Tabla imprimirTabla = new Tabla(ju,di,tabla);
			}
		}
	}
	
	//Metodo para comprobar si un nuemro es par
	public boolean par(int numero) {
		if(numero%2==0) {
			return true;
		}
		return false;
	}
}
