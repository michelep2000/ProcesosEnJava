import java.io.IOException;
import java.util.Arrays;

public class RunProcess { // DANIEL VERA MARTINEZ
	public static void main(String[] args) throws IOException {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		try {
			Process process = pb.start();
			int retorno = process.waitFor();
			System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
			System.exit(-1);
		}
	}
}

	// a) He ejecutado por primera vez el programa y me ha pedido por consola escribir un programa,
	// He seleccionado Run Configurations y dentro de este la pestana Arguments,
	// En el espacio de escritura de Program arguments he escrito calc.exe y lo he ejecutado con run.

	// b) Al ejecutar sin poner argumentos lo que sucede es que no se ejecuta y te pide por pantalla,
	// Que se necesita un programa para ejecutar, se cumple el primer if, printeando un texto como error en color rojo

	// c) He escrito en los argumentos notepad.exe y separado por un espacio hola,
	// Al ejecutarlo lo que ha sucedido es que abrio el programa pero me salio un aviso ya que no existe,
	// ningun archivo .txt de nombre hola, probando con un archivo existente abre ese archivo del programa seleccionado.

	// d) He creado un bucle infinito que permite que se ejecute una detras de otra pero debe ser parado rapido ya que si no colapsa el ordenador.
	// int a=0;
	//for (int i = 1; i > a; i++) {
	//Process process = pb.start();
	//int retorno = process.waitFor();
	//System.out.println("La ejecución de " + Arrays.toString(args) + "devuelve " + retorno);
	//}
