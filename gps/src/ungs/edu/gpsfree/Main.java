package ungs.edu.gpsfree;

import java.math.BigDecimal;

import org.apache.commons.math.util.MathUtils;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		/*
		//CREO NODO I
		Nodo i = new Nodo();
		i.setNombre("NODO I");
		Coordenada c_i=new Coordenada(0,0);
		i.setCoordenada(c_i);
		//CREO NODO P		
		Nodo p = new Nodo();
		p.setNombre("NODO P");
		Coordenada c_p=new Coordenada(5,0);
		p.setCoordenada(c_p);
		//CREO NODO Q
		Nodo q = new Nodo();
		q.setNombre("NODO Q");
		Coordenada c_q=new Coordenada(2,5);
		q.setCoordenada(c_q);
		//CREO NODO J
		Nodo j = new Nodo();
		j.setNombre("NODO J");
		Coordenada c_j=new Coordenada(3,-3);
		j.setCoordenada(c_j);
		
		i.agregarVecino(p);
		i.agregarVecino(q);
		i.agregarVecino(j);
		
		p.agregarVecino(i);
		p.agregarVecino(q);
		p.agregarVecino(j);
		
		q.agregarVecino(i);
		
		j.agregarVecino(i);
		
		System.out.println("MUESTRO LOS NODOS CON SU POSICION ANteS DE CALCULARLO");
		
		System.out.println(i);
		System.out.println(p);
		System.out.println(q);
		System.out.println(j);
		
		System.out.println("======================================================");
	
		Double Dip= distanciaEntrePuntos(i.getCoordenada(), p.getCoordenada());
		Double Diq= distanciaEntrePuntos(i.getCoordenada(), q.getCoordenada());
		Double Dpq= distanciaEntrePuntos(p.getCoordenada(), q.getCoordenada());
		Double Dij= distanciaEntrePuntos(i.getCoordenada(), j.getCoordenada());
		Double Dpj= distanciaEntrePuntos(p.getCoordenada(), j.getCoordenada());
		Double Dqj= distanciaEntrePuntos(q.getCoordenada(), j.getCoordenada());
	
		System.out.println("DISTANCIAS ENTRE NODOS: ");
		
		System.out.println("IP: "+Dip);
		System.out.println("IQ: "+Diq);
		System.out.println("PQ: "+Dpq);
		System.out.println("IJ: "+Dij);
		System.out.println("PJ: "+Dpj);
		System.out.println("QJ: "+Dqj);
		
		System.out.println("======================================================");
				
		Double anguloLanda= reglaDelCoceno(Dip, Diq, Dpq);
		p.getCoordenada().setX(Dip);
		p.getCoordenada().setY(0);
		q.getCoordenada().setX(Diq*Math.cos(anguloLanda));
		q.getCoordenada().setY(Diq*Math.sin(anguloLanda));

		Double anguloAlpha=reglaDelCoceno(Dij, Dip, Dpj);
		Double anguloBetha=reglaDelCoceno(Diq, Dij, Dqj);
		
		j.getCoordenada().setX(Dij*Math.cos(anguloAlpha));
		if (anguloBetha== Math.abs(anguloAlpha-anguloLanda)){
			j.getCoordenada().setY(Dij* Math.sin(anguloAlpha));
		}else{
			j.getCoordenada().setY(-Dij* Math.sin(anguloAlpha));
		}
		

		System.out.println("MUESTRO LOS NODOS CON SU POSICION DESPUES DE CALCULARLO");
		
		System.out.println(i);
		System.out.println(p);
		System.out.println(q);
		System.out.println(j);
		
		
		System.out.println(" ==========================================================================");
		
		Grafo grafo=new Grafo(10);
		grafo.MostrarMatrizAdy();
		
		
		/*
		
		Coordenada [][] matriz = new Coordenada[5][5];
		
	
		System.out.println(i);
		System.out.println(p);
		System.out.println(q);
		System.out.println(j);
		
		
		
		//c1.setX(-c1.getX());
		//c1.setY(-c1.getY());
		
		System.out.println("=====================	Coordenada Original	=========================");
		
		Coordenada c1= new Coordenada(3.0,0.0);
		Coordenada c2= new Coordenada(7.0,0.0);
		Coordenada c3= new Coordenada(5.0,2.0);
		
		Coordenada c4=new Coordenada(5.0, -2);
		
		System.out.println("original c1 "+c1);
		System.out.println("original c2"+c2);
		System.out.println("original c3 "+c3);
		System.out.println("(Es la que busco) original "+c4);
		
		System.out.println("=====================	Distancias Original	=========================");
		
		Double dc1c2=distanciaEntrePuntos(c1, c2);
		Double dc1c3=distanciaEntrePuntos(c1, c3);
		Double dc2c3=distanciaEntrePuntos(c2, c3);
		
		System.out.println("Distancia c1 c2 "+dc1c2);
		System.out.println("Distancia c1 c3 "+dc1c3);
		System.out.println("Distancia c2 c3 "+dc2c3);
		
		Double dc1c4_c=distanciaEntrePuntos(c1, c4);
		Double dc2c4_c=distanciaEntrePuntos(c2, c4);
		Double dc3c4_c=distanciaEntrePuntos(c3, c4);
		
		System.out.println("Distancia c1 c4 "+dc1c4_c);
		System.out.println("Distancia c2 c4 "+dc2c4_c);
		System.out.println("Distancia c3 c4 "+dc3c4_c);
		
		
		System.out.println("==================	Calculada ============================");
		Coordenada v_t= new Coordenada(-1*c1.getX(), -1*c1.getY());
		
		Coordenada c1_n= translate(c1, v_t); 
		
		Coordenada c2_n= new Coordenada(distanciaEntrePuntos(c1, c2),0);
				
		Double angulo_ghama= reglaDelCoceno(dc1c2, dc1c3, dc2c3);
		
		Coordenada c3_n= new Coordenada(dc1c3*Math.cos(angulo_ghama), dc1c3*Math.sin(angulo_ghama));
		
		System.out.println(c1_n);
		System.out.println(c2_n);
		System.out.println(c3_n);
		
		System.out.println("=====================	Distancias 3 originales trasladados	=========================");
		
		Double dc1c2_n=distanciaEntrePuntos(c1_n, c2_n);
		Double dc1c3_n=distanciaEntrePuntos(c1_n, c3_n);
		Double dc2c3_n=distanciaEntrePuntos(c2_n, c3_n);
		
		System.out.println("Distancia c1 c2 "+dc1c2_n);
		System.out.println("Distancia c1 c3 "+dc1c3_n);
		System.out.println("Distancia c2 c3 "+dc2c3_n);
		
		
		
		System.out.println("==================	Calculo la 4ta Coordenada ============================");
		
		Double anguloLanda= reglaDelCoceno(dc1c2, dc1c3, dc2c3);
		
		//angulo con el nuevo punto
		Double anguloBetha=reglaDelCoceno(dc1c3, dc1c4_c, dc3c4_c);
		
		Double anguloAlpha=reglaDelCoceno(dc1c4_c, dc1c2, dc2c4_c);
			
		c4.setX(dc1c4_c*Math.cos(anguloAlpha));
		
		if (anguloBetha== Math.abs(anguloAlpha-anguloLanda)){
			c4.setY(dc1c4_c* Math.sin(anguloAlpha));
		}else{
			c4.setY(-1*dc1c4_c* Math.sin(anguloAlpha));
		}
		
		
		System.out.println("C4 obtenida "+ c4);
		
		
		System.out.println("=====================	Traslacion c4 original	=========================");
		
		Coordenada c4_t= translate(c4, c1);
		System.out.println("Tralado c4 "+c4_t);
		
		//angulo triangulo conocido
		
		System.out.println("==================	verifico las distancias con la coordenada c4===================");
		
		Double dc1c4=distanciaEntrePuntos(c1_n, c4);
		Double dc2c4=distanciaEntrePuntos(c2_n, c4);
		Double dc3c4=distanciaEntrePuntos(c3_n, c4);
		System.out.println("Distancia c1 c4 "+dc1c4);
		System.out.println("Distancia c2 c4 "+dc2c4);
		System.out.println("Distancia c3 c4 "+dc3c4);
		
		
		System.out.println("==================	c2 sobre el eje y	============================");
		//Coordenada c2_n= new Coordenada(0,distanciaEntrePuntos(c1, c2));
		//System.out.println(c2_n);
		System.out.println("==============================================");
		
		
		System.out.println("original "+c3);
		
		
		
		Coordenada c3_t= translate(c3_n, c1);
		System.out.println(c3_t);
		System.out.println("=====================	Rotacion	=========================");
		Coordenada c1_r= new Coordenada(c1.getX() * Math.cos(Math.PI/2) - c1.getY() * Math.sin(Math.PI/2), c1.getX() * Math.sin(Math.PI/2) - c1.getY() * Math.cos(Math.PI/2));
		System.out.println(c1_r);
		Coordenada c2_r= new Coordenada(c2.getX() * Math.cos(Math.PI/2) - c2.getY() * Math.sin(Math.PI/2), c2.getX() * Math.sin(Math.PI/2) - c2.getY() * Math.cos(Math.PI/2));
		System.out.println(c2_r);
		Coordenada c3_r= new Coordenada(c3.getX() * Math.cos(Math.PI/2) - c3.getY() * Math.sin(Math.PI/2), c3.getX() * Math.sin(Math.PI/2) - c3.getY() * Math.cos(Math.PI/2));
		System.out.println(c3_r);
		

		Coordenada a=new Coordenada(-1.0,4.0);
		Coordenada b=new Coordenada(3.0,0.0);
		Coordenada c=new Coordenada(0.0,3.0);
		System.out.println(Algoritmos.coolineales(a, b, c));
		
		
		Coordenada a=new Coordenada(3.0,0.0);
		System.out.println(a);

	    double angulo = 90 * Math.PI/180.0;
	    BigDecimal bigDecimal= new BigDecimal(Math.cos(angulo));
	    System.out.println(bigDecimal);
	    System.out.println("cos(" + angulo + ") es " + 		Math.round( Math.cos(angulo)));
		System.out.println(Algoritmos.rotarCoordenada(a, angulo));
		
		
		
		double valor = 0;
		 
		double angulo2 = 45; //grados
		double anguloRadianes = Math.toRadians(angulo2);
		 
		valor = Math.cos(anguloRadianes);
		System.out.println("Coseno de " + angulo + "º = " + valor);
		 
		valor = Math.sin(anguloRadianes);
		System.out.println("Seno de " + angulo + "º = " + valor);
		 
		valor = Math.tan(anguloRadianes);
		System.out.println("Tangente de " + angulo + "º = " + valor);
		 
		valor = 0.707;
		 
		anguloRadianes = Math.acos(valor);
		angulo = Math.toDegrees(anguloRadianes);
		System.out.println("Arco Coseno de " + valor + " = " + angulo + "º");
		*/ 
		
		
		    double seno;
		    double coseno;
		    for(int i=0;i<=360;i+=90){
		     seno=Math.round(Math.sin(i*Math.PI/180));
		     System.out.println("El seno de "+i+" usando PI/180 es: "+seno);       
		     seno=Math.round(Math.sin(Math.toRadians(i)));
		     System.out.println("El seno de "+i+" usando toRadians es: "+seno);       
		     coseno=Math.round(Math.cos(i*Math.PI/180));
		     System.out.println("El coseno de "+i+" usando PI/180 es: "+coseno);       
		     coseno=Math.round(Math.cos(Math.toRadians(i)));
		     System.out.println("El coseno de "+i+" usando toRadians es: "+coseno);       
		    }
		  }
		
		

	
	
	
	
	
}

