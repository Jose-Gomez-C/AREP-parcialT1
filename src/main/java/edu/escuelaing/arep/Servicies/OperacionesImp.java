package edu.escuelaing.arep.Servicies;

import java.util.ArrayList;
import java.util.List;


public class OperacionesImp implements Operaciones {

	private List<Double> datos ;

	public OperacionesImp(String json) {

		String[] jsonList = json.replace("\"", "").replace("]", "").replace("[", "").split(",");
		datos = new ArrayList<Double>();
		for (int i = 0; i < jsonList.length; i++) {
			Double value = Double.parseDouble(jsonList[i]);
			datos.add(value);
		}
	}

	@Override
	public void bubbleSort() { 
		int n = datos.size(); 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				System.out.println("Entre");
				if (datos.get(j) > datos.get(j+1)) { 
					double temp = datos.get(j);
					datos.set(j, datos.get(j+1));
					datos.set(j+1, temp);
				} 
			}
		}
	}

		@Override
		public double sumatoria() {
			double resultado = 0;
			for (int i = 0 ; i< datos.size();i++) {
				resultado+=datos.get(i);
			}
			return resultado;
		}

		@Override
		public double promedio() {
			double sumatoria = sumatoria();

			return sumatoria / datos.size();
		}

		@Override
		public List<Double> getDatos() {
			return datos;
		}

		@Override
		public void setDatos(List<Double> datos) {
			this.datos = datos;
		}

	}
