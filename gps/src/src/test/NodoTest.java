package src.test;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.gpsfree.Algoritmos;
import ungs.edu.gpsfree.Coordenada;
import ungs.edu.gpsfree.Nodo;

public class NodoTest {
	
	private Nodo nodoActual; 

	
	@Before
	public void init(){
		nodoActual	=new Nodo("N1");	
		Coordenada n1_coordenada=new Coordenada(5.0,2.0);
		System.out.println("ESPERO "+n1_coordenada);
		
		Nodo n2=new Nodo("N2");
		Coordenada n2_coordenada=new Coordenada(1.0, 1.0);	
		n2.setCoordenada(n2_coordenada);
		nodoActual.agregarVecino(n2, Algoritmos.distanciaEntrePuntos(n1_coordenada, n2_coordenada));
		
		Nodo n5=new Nodo("N5");
		Coordenada n5_coordenada=new Coordenada(3.0, 1.0);	
		n5.setCoordenada(n5_coordenada);
		nodoActual.agregarVecino(n5,  Algoritmos.distanciaEntrePuntos(n1_coordenada, n5_coordenada));
			
		Nodo n3=new Nodo("N3");
		Coordenada n3_coordenada=new Coordenada(2.0, 4.0);	
		n3.setCoordenada(n3_coordenada);
		nodoActual.agregarVecino(n3,  Algoritmos.distanciaEntrePuntos(n1_coordenada, n3_coordenada));
		
		Nodo n4=new Nodo("N4");
		Coordenada n4_coordenada=new Coordenada(0.5, 2.0);	
		n4.setCoordenada(n4_coordenada);
		//nodoActual.agregarVecino(n4,  Algoritmos.distanciaEntrePuntos(n1_coordenada, n4_coordenada));
		
		Nodo n6=new Nodo("N6");
		nodoActual.agregarVecino(n6,3.0);
		

		
	}
	
	@Test
	public void obtenerTresVecinos(){
		//List<Nodo> vecinosAdentro= nodoActual.getTresVecinosAdentro();
		//System.out.println(vecinosAdentro);
		nodoActual.calcularCoordenada();
		System.out.println("NODO CALCULADO" + nodoActual.getCoordenada());
		
	}
	
	
}
