package edu.escuelaing.arep.appp;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import edu.escuelaing.arep.Servicies.Operaciones;
import edu.escuelaing.arep.Servicies.OperacionesImp;


/**
 * Hello world!
 *
 */
public class AppWeb {
	/**
	 * Metodo encargado de hacer el llamado html, enviar y recibir datos. 
	 * @param args
	 */
	private Operaciones operaciones;
	public static void main(String[] args) {
		port(getPort());
		staticFiles.location("/public");
		post("/calculadora", (request, response) -> {
			Operaciones c = new OperacionesImp(request.body());
			c.bubbleSort();
			List<Double> list = c.getDatos();
			return "{\"Lista\":"+list+ ", \"Promedio\":"+ c.promedio() +", \"Sumatoria\":"+ c.sumatoria() + "}";
		});
		//", \"desviacion\":"
	}
	/**
	 * Metodo encargado de indicar el puerto por el que correra.
	 * @return Puerto a utilizar 
	 */
	public static int getPort(){
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; 
	}

}
