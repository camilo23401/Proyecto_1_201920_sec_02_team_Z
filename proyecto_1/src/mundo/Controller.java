package mundo;

import java.util.Scanner;

import consola.InteraccionConsola;
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
				System.out.println("Digite el n�mero del trimestre a consultar: ");
				String semestrePorRevisar = "";
				semestrePorRevisar = lector.next();
				if(Integer.parseInt(semestrePorRevisar)<0 || Integer.parseInt(semestrePorRevisar)>4)
				{
					System.out.println("Digite un dato v�lido. Un a�o solo tiene 4 trimestres.");	
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
				System.out.println("Digite el n�mero de la zona de origen");
				String sourceId = lector.next();
				System.out.println("Digite el n�mero de la zona de destino");
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
						System.out.println("N�mero de viaje: " + contador);
						System.out.println("Tiempo promedio: " + elementoActual.darTiempoPromedio());
						System.out.println("Desviaci�n est�ndar: " + elementoActual.darDesviacionEstandarTiempo());
						System.out.println("---------------------------------------------------------------------------------------");
						actual = actual.darSiguiente();
					}	
				}
				else
				{
					System.out.println("No se encontr� informaci�n que coincida con los par�metros ingresados");
				}
				break;

			case 3:
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
					System.out.println("N�mero de viaje: " + contadorMetodoHoras);
					System.out.println("Tiempo promedio: " + actualResultado.darTiempoPromedio());
					System.out.println("Desviaci�n est�ndar: " + actualResultado.darDesviacionEstandarTiempo());
					System.out.println("---------------------------------------------------------------------------------------");
					actualResultados = actualResultados.darSiguiente();
				}
				break;


			case 4:
				System.out.println("--------------------------------------- \n Adi�s \n ---------------------------------------"); 
				lector.close();
				finalizado = true;
				break;	


			}
		}
	}
}
