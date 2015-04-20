package src.test;

import org.junit.Test;

import ungs.edu.gpsfree.Algoritmos;

public class AlgoritmosTest {

	
	@Test
	public void reglaDelCocenoTest(){
		
		//double prueba= 0.1111 ;//* (Math.PI/180);
		
		
	//	System.out.println(Math.acos(prueba)* (180/Math.PI));
		double angulo=      Algoritmos.reglaDelCoceno(12.0, 12.0, 16.0);
		System.out.println((angulo));
	}
}
