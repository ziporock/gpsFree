package ungs.edu.gpsfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math.util.MathUtils;

public class Nodo {

	private String nombre;
	private Coordenada coordenada;
	private Map<Nodo, Double> vecinos;

	public Nodo(String nombre) {
		super();
		this.nombre = nombre;
		this.vecinos = new HashMap<Nodo, Double>();
	}

	public String getNombre() {
		return nombre;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Map<Nodo, Double> getVecinos() {
		return vecinos;
	}

	public void agregarVecino(Nodo nodo, Double distancia) {
		this.vecinos.put(nodo, distancia);
	}

	public String mostrarVecinos() {
		String vecinos = "Vecinos {";
		for (Nodo vecino : this.vecinos.keySet()) {
			vecinos += vecino.getNombre() + ";";
		}
		vecinos += "}";
		return vecinos;
	}

	@Override
	public String toString() {
		return "Nodo [nombre=" + nombre + ", coordenada=" + coordenada + "] ";

	}

	public List<Nodo> getTresVecinosAdentro() {
		List<Nodo> resultado = new ArrayList<Nodo>();
		for (Nodo nodo : this.vecinos.keySet()) {
			if (nodo.getCoordenada() != null) {
				if (resultado.size() == 2) {
					if (!Algoritmos.coolineales(resultado.get(0)
							.getCoordenada(), resultado.get(1).getCoordenada(),
							nodo.getCoordenada())) {
						resultado.add(nodo);
					}
				} else {
					resultado.add(nodo);
				}

			}
			if (resultado.size() == 3) {
				break;
			}
		}
		return resultado;
	}

	public void calcularCoordenada() {
		List<Nodo> tresVecinosAdentro = getTresVecinosAdentro();

		// asigno nodos
		System.out.println("TOMO COMO C1 A " + tresVecinosAdentro.get(0));
		Coordenada C1 = new Coordenada(0.0, 0.0);
		System.out.println("TOMO COMO C2 A " + tresVecinosAdentro.get(1));
		Coordenada C2 = tresVecinosAdentro.get(1).getCoordenada();
		System.out.println("TOMO COMO C3 A " + tresVecinosAdentro.get(2));
		Coordenada C3 = tresVecinosAdentro.get(2).getCoordenada();

		// calculo las distancias
		Double dc1c2 = Algoritmos.distanciaEntrePuntos(tresVecinosAdentro
				.get(0).getCoordenada(), tresVecinosAdentro.get(1)
				.getCoordenada());
		Double dc1c3 = Algoritmos.distanciaEntrePuntos(tresVecinosAdentro
				.get(0).getCoordenada(), tresVecinosAdentro.get(2)
				.getCoordenada());
		Double dc2c3 = Algoritmos.distanciaEntrePuntos(tresVecinosAdentro
				.get(1).getCoordenada(), tresVecinosAdentro.get(2)
				.getCoordenada());
		Double dc1c4 = vecinos.get(tresVecinosAdentro.get(0));
		Double dc2c4 = vecinos.get(tresVecinosAdentro.get(1));
		Double dc3c4 = vecinos.get(tresVecinosAdentro.get(2));

		// seteo a c2 sobre el eje y
		C2.setX(0.0);
		C2.setY(dc1c2);

		Double angulo_ghama = Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3);

		// seteo a la coordenada c3 su x e y
		C3.setX(dc1c3 * MathUtils.round(Math.cos(angulo_ghama), 8));
		C3.setY(dc1c3 * MathUtils.round(Math.sin(angulo_ghama), 8));

		// Muestro las nuevas coordenadas
		System.out.println("*******************************");
		System.out.println("C1 " + C1.toString());
		System.out.println("C2 " + C2.toString());
		System.out.println("C3 " + C3.toString());
		System.out.println("*******************************");

		// busco el angulo y genero la coordenada

		Double anguloLanda = Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3);
		Double anguloBetha = Algoritmos.reglaDelCoceno(dc1c3, dc1c4, dc3c4);
		Double anguloAlpha = Algoritmos.reglaDelCoceno(dc1c4, dc1c2, dc2c4);

		if (anguloBetha == Math.abs(anguloAlpha - anguloLanda)) {
			this.coordenada = new Coordenada(dc1c4
					* MathUtils.round(Math.cos(anguloAlpha), 8), dc1c4
					* MathUtils.round(Math.sin(anguloAlpha), 8));
		} else {
			this.coordenada = new Coordenada(dc1c4
					* MathUtils.round(Math.cos(anguloAlpha), 8), -1 * dc1c4
					* MathUtils.round(Math.sin(anguloAlpha), 8));
		}

		// Rotar los vectores
		// supongo la coordenada j de ajuste
		Coordenada j = new Coordenada(3.0, 0.5);

		Double distanciaOJ = Algoritmos.distanciaEntrePuntos(C1, j);
		Double anguloDeRotacionAlphaJ = Algoritmos.reglaDelCoceno(j.getX(),
				distanciaOJ, j.getY());

		Double distanciaKJ = Algoritmos.distanciaEntrePuntos(tresVecinosAdentro
				.get(0).getCoordenada(), j);
		Coordenada coordenadaSobrey= tresVecinosAdentro.get(0).getCoordenada();
		coordenadaSobrey.setX(0.0);
		double distanciaAkSobreEjey=Algoritmos.distanciaEntrePuntos(j,coordenadaSobrey);
		Double anguloDeRotacionBethaJ = Algoritmos.reglaDelCoceno(distanciaKJ,
				distanciaAkSobreEjey, tresVecinosAdentro.get(0).getCoordenada().getX());

		double distanciak = Algoritmos.distanciaEntrePuntos(C1,
				tresVecinosAdentro.get(0).getCoordenada());

		Double anguloDeRotacionAlphak = Algoritmos.reglaDelCoceno(
				tresVecinosAdentro.get(0).getCoordenada().getX(), distanciak,
				tresVecinosAdentro.get(0).getCoordenada().getY());

		Double anguloDeRotacionBetha = Algoritmos.reglaDelCoceno(
				tresVecinosAdentro.get(0).getCoordenada().getY(), distanciak,
				tresVecinosAdentro.get(0).getCoordenada().getX());

		double anguloDeRotacion = 0.0;

		if (anguloDeRotacionAlphaJ - anguloDeRotacionAlphak < Math.PI
				&& (anguloDeRotacionBethaJ - anguloDeRotacionBetha) > Math.PI
				|| anguloDeRotacionAlphaJ - anguloDeRotacionAlphak > Math.PI
				&& (anguloDeRotacionBethaJ - anguloDeRotacionBetha) < Math.PI) {
			anguloDeRotacion = anguloDeRotacionBetha - anguloDeRotacionAlphak
					+ Math.PI;
		} else if (anguloDeRotacionAlphaJ - anguloDeRotacionAlphak < Math.PI
				&& (anguloDeRotacionBethaJ - anguloDeRotacionBetha) < Math.PI
				|| anguloDeRotacionAlphaJ - anguloDeRotacionAlphak > Math.PI
				&& (anguloDeRotacionBethaJ - anguloDeRotacionBetha) > Math.PI) {
			anguloDeRotacion = anguloDeRotacionBetha + anguloDeRotacionAlphak;
		}

		// Double anguloDeRotacion= 90 * Math.PI/180.0;

		C1 = Algoritmos.rotarCoordenada(C1, anguloDeRotacion);
		C2 = Algoritmos.rotarCoordenada(C2, anguloDeRotacion);
		C3 = Algoritmos.rotarCoordenada(C3, anguloDeRotacion);
		this.coordenada = Algoritmos.rotarCoordenada(this.coordenada,
				anguloDeRotacion);

		// Traslado todos los vectores
		Coordenada origen = new Coordenada(0.0, 0.0);
		Coordenada vectorTraslacion = new Coordenada(tresVecinosAdentro.get(0)
				.getCoordenada().getX()
				- origen.getX(), tresVecinosAdentro.get(0).getCoordenada()
				.getY()
				- origen.getY());

		C1 = Algoritmos.translate(C1, vectorTraslacion);
		C2 = Algoritmos.translate(C2, vectorTraslacion);
		C3 = Algoritmos.translate(C3, vectorTraslacion);
		this.coordenada = Algoritmos.translate(this.coordenada,
				tresVecinosAdentro.get(0).getCoordenada());

		System.out.println("C1 " + C1);
		System.out.println("C2 " + C2);
		System.out.println("C3 " + C3);
	}

}
