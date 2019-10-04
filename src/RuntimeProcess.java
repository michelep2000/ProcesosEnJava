
//Michele Pardo
import java.io.IOException;

public class RuntimeProcess {
	public static void main(String[] args) {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(args);
			process.destroy();
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}
	}
}

//a) El programa se ejecuta lo que pasa es que con el metodo destroy destruimos el proceso es forzado a terminar, por lo cual por eso no aparece
//b) Ya comentando esa linea "process.destroy();" el programa se ejecuta correctamente
