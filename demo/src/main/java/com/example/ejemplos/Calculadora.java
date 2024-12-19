package com.example.ejemplos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {
	public double suma(double a, double b) {
		return roundIEEE754(a + b);
	}
	
	public int suma(int a, int b) {
		return a + b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

	public double divide(double a, double b) {
		if(b == 0)
			throw new ArithmeticException("/ by zero");
		return roundIEEE754(a / b);
//		return a / b;
	}

	private double roundIEEE754(double o) {
		return BigDecimal.valueOf(o)
				.setScale(16, RoundingMode.HALF_UP)
				.doubleValue();
	}

	public boolean esBisiesto(int año) {
		return esMultiploDe400(año) || esMultiploDe4(año) && noEsMultiploDe100(año);
//		return año % 400 == 0 || año % 4 == 0 && año % 100 != 0;
	}

	private boolean noEsMultiploDe100(int año) {
		return año % 100 != 0;
	}

	private boolean esMultiploDe100(int año) {
		return !noEsMultiploDe100(año);
	}

	private boolean esMultiploDe4(int año) {
		return año % 4 == 0;
	}

	private boolean esMultiploDe400(int año) {
		return año % 400 == 0;
	}

}
