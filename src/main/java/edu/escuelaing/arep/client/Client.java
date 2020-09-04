package edu.escuelaing.arep.client;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
		BufferedReader in = null;
		List<Double> numeros = new ArrayList<Double>();
		numeros.add(9.0);
		numeros.add(8.5);
		numeros.add(2.6);
		numeros.add(18.1);
		numeros.add(73.2);
		numeros.add(25.54);
		numeros.add(15.26);
		String query =  numeros.toString().replace("[", "").replace("]", "").replace(" ", "");
		//URL herokuApp = new URL();
	}
}
