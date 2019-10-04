
//Michele Pardo
import java.io.*;

class JavaPing {
	public static void main(String[] args) {
		// Creamos nuestros objetos runtime y process ya que sien ellos no podriamos
		// hacer nada
		Runtime runTime = Runtime.getRuntime();
		Process process = null;
		try {
			// ejecutamos el proceso pasandole por parametro el comando a ejecutar(si
			// eliminamos la palabra clave "Ping" entrariamos al catch y saldria "No pudimos
			// correr el ping")
			process = runTime.exec("Ping " + args[0]);
			// leemos el resultado que nos devuelve el comando ejecutado y lo guardamos en
			// "in" para usarlo despues
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			// en este for no tienen que ser 10, pueden ser mas pero lo que hace es que
			// imprimimos 10 veces nuestro "in"
			for (int i = 0; i < 10; i++)
				System.out.println("Saludo " + in.readLine());
		} catch (IOException e) {
			// Aqui entraria si en algun momento explota en el try de arriba, por ejemplo si
			// ponemos un ping invalido
			System.out.println("No pudimos correr el ping");
			// Se saldria del programa
			System.exit(-1);
		}
		// Verificamos "runTime.exec("ping " + args[0])" nos devolvio algo.
		// La funcion del if basicamente es ver si tiene contenido, en ese caso destruye
		// el programa
		if (process != null) {
			System.out.println("--------------------------------");
			process.destroy();
		}
		try {
			// Se encarga de hacer esperar el proceso, pero esto no es lo que causa que
			// nuestro programa tarde en ejecutarse
			// si comentamos esto el programa sigue ejecutandose igual, porque va por una
			// funcion ya interna del propio comando que introducimos

			process.waitFor();
			
		} catch (InterruptedException e) {
			System.out.println("No pudimos esperar por témino");
			System.exit(-1);
		}
		// imprimimos si el proceso termina bien, imprimimos el valor de salida, si el
		// valor es 0 es que todo esta normal de lo contrario no
		System.out.println("Estatus de témino: " + process.exitValue());
		System.exit(0);
	}
}
//lo primero es que si ejecutamos con el args vacio nos suelta un error en la linea donde "process = runTime.exec("Ping " + args[0])", porque no podemos llamar a args[0] si esta vacio

/*
 * Saludo Saludo Pinging 255.255.255.0 with 32 bytes of data: Saludo PING:
 * transmit failed. General failure. Saludo PING: transmit failed. General
 * failure. Saludo PING: transmit failed. General failure. Saludo PING: transmit
 * failed. General failure. Saludo Saludo Ping statistics for 255.255.255.0:
 * Saludo Packets: Sent = 4, Received = 0, Lost = 4 (100% loss), Saludo null
 * Estatus de témino: 1
 */

/*
 * Saludo Saludo Pinging 127.0.0.1 with 32 bytes of data: Saludo Reply from
 * 127.0.0.1: bytes=32 time<1ms TTL=128 Saludo Reply from 127.0.0.1: bytes=32
 * time<1ms TTL=128 Saludo Reply from 127.0.0.1: bytes=32 time<1ms TTL=128
 * Saludo Reply from 127.0.0.1: bytes=32 time<1ms TTL=128 Saludo Saludo Ping
 * statistics for 127.0.0.1: Saludo Packets: Sent = 4, Received = 4, Lost = 0
 * (0% loss), Saludo Approximate round trip times in milli-seconds: Estatus de
 * témino: 0
 */

/*
 * Saludo Saludo Pinging 10.1.200.1 with 32 bytes of data: Saludo Request timed
 * out. Saludo Request timed out. Saludo Request timed out. Saludo Request timed
 * out. Saludo Saludo Ping statistics for 10.1.200.1: Saludo Packets: Sent = 4,
 * Received = 0, Lost = 4 (100% loss), Saludo null Estatus de témino: 1
 */
