package ungs.edu.gpsfree;

import org.apache.commons.math.util.MathUtils;

public class Algoritmos {

	public static double distanciaEntrePuntos(Coordenada c1, Coordenada c2) {
		return Math.sqrt(Math.pow((c2.getX() - c1.getX()), 2)
				+ (Math.pow((c2.getY() - c1.getY()), 2)));

	}

	public static void dibujarMatrizAdyacencias(Coordenada[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("NODO/NODO	| ");
			// matriz[0][i].getNombre();
		}

	}

	public static Double reglaDelCoceno(Double Dip, Double Diq, Double Dpq) {
		Double numerando = (Math.pow(Dip, 2) + Math.pow(Diq, 2) - Math.pow(Dpq,
				2));
		Double denominador = 2 * Dip * Diq;
		Double divicion =( numerando / denominador ) ;// (Math.PI/180);
		double result=Math.acos(divicion)* (180/Math.PI);
		return result;
		
	}

	public static Coordenada translate(Coordenada c1, Coordenada c2) {
		double x = c1.getX() + c2.getX();
		double y = c1.getY() + c2.getY();
		Coordenada coordenada = new Coordenada(x, y);
		return coordenada;

	}
	
	
	public static boolean coolineales(Coordenada a,Coordenada b, Coordenada c){
		boolean result=false;
		Double mab= (b.getY() - a.getY()) / (b.getX()-a.getX());
		Double mac= (c.getY() - a.getY()) / (c.getX()-a.getX());
		if (mab.equals(mac)){
			result=true;
		}
		return result;
	}
	
	public static Coordenada rotarCoordenada(Coordenada coordenada, Double angulo){
		
		Double x= coordenada.getX() * MathUtils.round(Math.cos(angulo),8) - coordenada.getY() * MathUtils.round(Math.sin(angulo),8);
		Double y= coordenada.getX() * MathUtils.round(Math.sin(angulo),8) + coordenada.getY() * MathUtils.round(Math.cos(angulo),8);
		
		Coordenada resultado= new Coordenada(x, y);
		return resultado;
		
	}
	
	public static Double obtenerAnguloDeRotacion(){
		return null;
		
	}
}
