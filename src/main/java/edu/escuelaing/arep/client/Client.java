package edu.escuelaing.arep.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Client {
	public static void main(String[] args) throws IOException {
		try {
			URL herokuApp = new URL("https://salty-mesa-17164.herokuapp.com/calculadora");
			HttpsURLConnection conexion = (HttpsURLConnection)  herokuApp.openConnection();
			conexion.setRequestMethod("POST");
			conexion.setDoOutput(true);
			String inputString = "15.0,30.0,51.0,15.15,38.2";

			OutputStream os = conexion.getOutputStream();
			byte[] input = inputString.getBytes("utf-8");
			os.write(input, 0, input.length);
			BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream(),"utf-8"));
			StringBuilder response = new StringBuilder();
			String responseString = null;
			while ((responseString = br.readLine()) != null) {
				response.append(responseString.trim());
			}
			System.out.println(responseString.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
