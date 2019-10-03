import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ComunicationBetweenProcess {
	public static void main(String args[]) {
		try { // C) Creo el Try
			Process process = new ProcessBuilder(args).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8"); // B) Escribo UTF-8
			BufferedReader br = new BufferedReader(isr);
			String line;
			System.out.println("Salida del proceso " + Arrays.toString(args) + ":");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			is.close(); // C) Cierro is InputStream is
		} catch (Exception e) { // C) Capta la exception 
			e.printStackTrace();
		}
	}
}

// A) Se obtiene lo siguiente:
// Salida del proceso [cmd.exe]:
// Microsoft Windows [Versi¢n 10.0.18362.356]
// (c) 2019 Microsoft Corporation. Todos los derechos reservados.
