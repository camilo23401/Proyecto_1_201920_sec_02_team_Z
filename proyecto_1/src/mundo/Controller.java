package mundo;

import java.util.Scanner;

import consola.InteraccionConsola;
import data_structures.ArregloDinamico;
import data_structures.ListaEncadenada;
import data_structures.NodoListaEncadenada;

public class Controller 
{
	private ProyectoMundo proyecto;
	private InteraccionConsola consola;

	public Controller()
	{
		proyecto = new ProyectoMundo();
		consola = new InteraccionConsola();
	}
	public void run()
	{
		Scanner lector = new Scanner(System.in);
		boolean finalizado = false;
		while(finalizado!=true)
		{
			consola.impresionMenu();

			int opcionEscogida = lector.nextInt();

			switch(opcionEscogida)
			{
			case 1:
				System.out.println("Digite el número del trimestre a consultar: ");
				String semestrePorRevisar = "";
				semestrePorRevisar = lector.next();
				if(Integer.parseInt(semestrePorRevisar)<0 || Integer.parseInt(semestrePorRevisar)>4)
				{
					System.out.println("Digite un dato válido. Un año solo tiene 4 trimestres.");	
				}
				else
				{
					try
					{
						String[] rta = proyecto.agregarDatos(semestrePorRevisar);
						for(int i=0;i<rta.length;i++)
						{
							System.out.println(rta[i]);
						}
					}
					catch (Exception e)
					{
						System.out.println("Error fatal. No se pudo leer el archivo deseado");
					}
				}

				break;

			case 2:
				System.out.println("Digite el mes a consultar");
				String mes = lector.next();
				System.out.println("Digite el número de la zona de origen");
				String sourceId = lector.next();
				System.out.println("Digite el número de la zona de destino");
				String dstid = lector.next();
				ListaEncadenada<ViajeUber> consultados = new ListaEncadenada<ViajeUber>();
				consultados = proyecto.consultarTiemposEntreZonasMensual(sourceId, dstid, mes);
				NodoListaEncadenada<ViajeUber> actual = consultados.darNodoActual();
				int contador = 0;
				if(consultados!=null)
				{
					while(actual!=null)
					{
						contador++;
						ViajeUber elementoActual = actual.darElemento();
						System.out.println("---------------------------------------------------------------------------------------");
						System.out.println("Número de viaje: " + contador);
						System.out.println("Tiempo promedio: " + elementoActual.darTiempoPromedio());
						System.out.println("Desviación estándar: " + elementoActual.darDesviacionEstandarTiempo());
						System.out.println("---------------------------------------------------------------------------------------");
						actual = actual.darSiguiente();
					}	
				}
				else
				{
					System.out.println("No se encontró información que coincida con los parámetros ingresados");
				}
				break;

			case 3:
				System.out.println("Digite número de datos a buscar");
				int num = Integer.parseInt(lector.next());
				System.out.println("Digite el mes a consultar");
				String mesConsulta = lector.next();
				ArregloDinamico rta = proyecto.consultarNViajesMasDemoradosMensual(num, mesConsulta);
				System.out.println(rta.darTamano());
				int contador2 = 0;
				for(int i=0;i<rta.darTamano();i++)
				{
					contador2++;
					ViajeUber elementoActual = rta.darElemento(i);
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println("Número de viaje: " + contador2);
					System.out.println("Zona de origen: " + elementoActual.darSourceid());
					System.out.println("Zona de destino: " + elementoActual.darDstid());
					System.out.println("Tiempo promedio: " + elementoActual.darTiempoPromedio());
					System.out.println("Desviación estándar: " + elementoActual.darDesviacionEstandarTiempo());
					System.out.println("---------------------------------------------------------------------------------------");
				}	

				break;
				
			case 4:
				break;
				
			case 5:
				break;
				
			case 6:
				break;
				
			case 7:
				break;
				
			case 8:
				System.out.println("Digite la hora de inicio");
				String horaInicio = lector.next();
				System.out.println("Digite la zona de origen");
				String origen = lector.next();
				System.out.println("Digite la hora de fin");
				String horaFin = lector.next();
				System.out.println("Digite la zona de destino");
				String destino = lector.next();

				ListaEncadenada<ViajeUber> resultados = proyecto.consultarCantidadViajesHora(origen, destino, horaInicio, horaFin);
				NodoListaEncadenada<ViajeUber> actualResultados = resultados.darNodoActual();
				int contadorMetodoHoras = 0;
				while(actualResultados!=null)
				{
					contadorMetodoHoras++;
					ViajeUber actualResultado = actualResultados.darElemento();
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println("Número de viaje: " + contadorMetodoHoras);
					System.out.println("Tiempo promedio: " + actualResultado.darTiempoPromedio());
					System.out.println("Desviación estándar: " + actualResultado.darDesviacionEstandarTiempo());
					System.out.println("---------------------------------------------------------------------------------------");
					actualResultados = actualResultados.darSiguiente();
				}
				break;

			case 9:

				System.out.println("Digite número de datos a buscar");
				int numDatos = Integer.parseInt(lector.next());
				System.out.println("Digite la hora a consultar");
				String horaConsulta = lector.next();
				ArregloDinamico respuesta = proyecto.consultarNViajesMasDemoradosHora(numDatos, horaConsulta);
				int contador3 = 0;
				for(int i=0;i<respuesta.darTamano();i++)
				{
					contador3++;
					ViajeUber elementoActual = respuesta.darElemento(i);
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println("Número de viaje: " + contador3);
					System.out.println("Zona de origen: " + elementoActual.darSourceid());
					System.out.println("Zona de destino: " + elementoActual.darDstid());
					System.out.println("Tiempo promedio: " + elementoActual.darTiempoPromedio());
					System.out.println("Desviación estándar: " + elementoActual.darDesviacionEstandarTiempo());
					System.out.println("---------------------------------------------------------------------------------------");
				}	

				break;
				
			case 10:
				break;
				
			case 11:
				System.out.println("--------------------------------------- \n Adiós \n ---------------------------------------"); 
				lector.close();
				finalizado = true;
				break;	


			}
		}
	}
}
