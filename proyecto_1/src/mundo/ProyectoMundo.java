package mundo;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import data_structures.ListaEncadenada;
import data_structures.NodoListaEncadenada;



public class ProyectoMundo 
{
	private ListaEncadenada <ViajeUber> viajesMensuales; 
	private ListaEncadenada <ViajeUber> viajesSemanales; 
	private ListaEncadenada <ViajeUber> viajesHorarios; 
	private CSVReader lector;
	private CSVReader lector2;
	private CSVReader lector3;
	public ProyectoMundo()
	{
		viajesMensuales = new ListaEncadenada<ViajeUber>();
		viajesSemanales = new ListaEncadenada<ViajeUber>();
		viajesHorarios = new ListaEncadenada<ViajeUber>();
	}
	public String[] agregarDatos(String pTrimestre) throws IOException
	{


		String [] respuestas = new String[5];
		respuestas [0]= cargarViajesMensuales(pTrimestre) + "";
		respuestas [1]= cargarViajesSemanales(pTrimestre) + "";
		respuestas [2]= cargarViajesHorarios(pTrimestre)+"";
		respuestas [3]= buscarMayorIdentificador();
		respuestas [4]= buscarMenorIdentificador();

		return respuestas;
	}
	public int cargarViajesMensuales(String pTrimestre) throws IOException
	{	
		int contador = 0;
		String rutaMensual = "data/bogota-cadastral-2018-"+pTrimestre+"-All-MonthlyAggregate.csv";
		lector = new CSVReader(new FileReader(rutaMensual));
		String [] siguiente;
		while ((siguiente = lector.readNext()) != null) 
		{
			if(contador!=0)
			{
				ViajeUber viajeNuevo = new ViajeUber(siguiente[0],siguiente[1], null, siguiente[3], siguiente[2], null, siguiente[4], siguiente[5], siguiente[6]);
				viajesMensuales.agregarElemento(viajeNuevo);
			}
			contador++;
		}
		lector.close();
		return contador;
	}
	public int cargarViajesSemanales(String pTrimestre) throws IOException
	{
		int contador = 0;
		String rutaSemanal = "data/bogota-cadastral-2018-"+pTrimestre+"-WeeklyAggregate.csv";
		lector2 = new CSVReader(new FileReader(rutaSemanal));
		String [] siguiente;
		while ((siguiente = lector2.readNext()) != null) 
		{
			if(contador!=0)
			{
				ViajeUber viajeNuevo = new ViajeUber(siguiente[0], siguiente[1], null, siguiente[3], null, siguiente[2], siguiente[4], siguiente[5], siguiente[6]);
				viajesSemanales.agregarElemento(viajeNuevo);
			}
			contador++;
		}
		lector2.close();

		return contador;
	}
	public int cargarViajesHorarios(String pTrimestre) throws IOException
	{
		int contador = 0;
		String rutaHoraria = "data/bogota-cadastral-2018-"+pTrimestre+"-All-HourlyAggregate.csv";
		lector3 = new CSVReader(new FileReader(rutaHoraria));
		String [] siguiente;
		while ((siguiente = lector3.readNext()) != null) 
		{
			if(contador!=0)
			{
				ViajeUber viajeNuevo = new ViajeUber(siguiente[0], siguiente[1], siguiente[2], siguiente[3], null, null, siguiente[4], siguiente[5], siguiente[6]);
				viajesHorarios.agregarElemento(viajeNuevo);
			}
			contador++;
		}
		lector3.close();
		return contador;
	}
	public String buscarMayorIdentificador()
	{

		String respuesta = "";
		int x = buscarMayorIdentificadorMeses();

		int y = buscarMayorIdentificadorSemanas();

		int z = buscarMayorIdentificadorHorarios();

		if(x>=y&&x>=z)
		{
			respuesta = x + "";
		}
		else if(y>=x&&y>=z)
		{
			respuesta = y + "";
		}
		else if(z>=x&&z>=y)
		{
			respuesta = z + "";
		}
		return respuesta;
	}
	public int buscarMayorIdentificadorMeses()
	{
		int mayor = 0;
		NodoListaEncadenada<ViajeUber> actual = viajesMensuales.darNodoActual();
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			int sourceActual = Integer.parseInt(viajeActual.darSourceid());
			if(sourceActual>mayor)
			{
				mayor = sourceActual;
			}
			actual = actual.darSiguiente();
		}
		return mayor;	
	}
	public int buscarMayorIdentificadorSemanas()
	{
		int mayor = 0;
		NodoListaEncadenada<ViajeUber> actual = viajesSemanales.darNodoActual();
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			int sourceActual = Integer.parseInt(viajeActual.darSourceid());
			if(sourceActual>mayor)
			{
				mayor = sourceActual;
			}
			actual = actual.darSiguiente();
		}
		return mayor;
	}
	public int buscarMayorIdentificadorHorarios()
	{
		int mayor = 0;
		NodoListaEncadenada<ViajeUber> actual = viajesHorarios.darNodoActual();
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			int sourceActual = Integer.parseInt(viajeActual.darSourceid());
			if(sourceActual>mayor)
			{
				mayor = sourceActual;
			}
			actual = actual.darSiguiente();
		}
		return mayor;
	}
	public String buscarMenorIdentificador()
	{
		String respuesta = "";
		int x = buscarMenorIdentificadorMensual();
		int y = buscarMenorIdentificadorSemanal();
		int z = buscarMenorIdentificadorHorario();
		if(x<=y&&x<=z)
		{
			respuesta = x + "";
		}
		else if(y<=x && y<=z)
		{
			respuesta = y + "";
		}
		else if(z<=x && z<=y)
		{
			respuesta = z + "";
		}
		
		return respuesta;
	}
	public int buscarMenorIdentificadorMensual()
	{
		int menor=0;
		NodoListaEncadenada<ViajeUber> actual = viajesMensuales.darNodoActual();
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			int sourceActual = Integer.parseInt(viajeActual.darSourceid());
			if(menor==0)
			{
				menor = sourceActual;
			}
			else
			{
				if(menor>sourceActual)
				{
					menor = sourceActual;
				}
			}
			actual = actual.darSiguiente();
		}
		return menor;
	}
	public int buscarMenorIdentificadorSemanal()
	{
		int menor=0;
		NodoListaEncadenada<ViajeUber> actual = viajesSemanales.darNodoActual();
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			int sourceActual = Integer.parseInt(viajeActual.darSourceid());
			if(menor==0)
			{
				menor = sourceActual;
			}
			else
			{
				if(menor>sourceActual)
				{
					menor = sourceActual;
				}
			}
			actual = actual.darSiguiente();
		}
		return menor;
	}
	public int buscarMenorIdentificadorHorario()
	{
		int menor=0;
		NodoListaEncadenada<ViajeUber> actual = viajesHorarios.darNodoActual();
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			int sourceActual = Integer.parseInt(viajeActual.darSourceid());
			if(menor==0)
			{
				menor = sourceActual;
			}
			else
			{
				if(menor>sourceActual)
				{
					menor = sourceActual;
				}
			}
			actual = actual.darSiguiente();
		}
		return menor;
	}
	public ListaEncadenada<ViajeUber> consultarTiemposEntreZonasMensual(String pSourceid, String pDestino, String pMes)
	{
		return null;
	}
	public ListaEncadenada<ViajeUber> consultarNViajesMasDemorados(int pN, String pMes)
	{
		return null;
	}
	public String comparacionTiemposPromedio(String pSourceid,String pMes)
	{
		return "";
	}
	public ListaEncadenada<ViajeUber> consultarNViajesMasDemoradosMensual(int pN, String pMes)
	{
		return null;
	}
	public String comparacionTiemposPromedioMes(String pSourceid,String pMes)
	{
		return "";
	}
	public ListaEncadenada<ViajeUber> consultarTiemposEntreZonasDiario(String pSourceid, String pDestino, String pDia)
	{
		return null;
	}
	public ListaEncadenada<ViajeUber> consultarNViajesMasDemoradosDiarios(int pN, String pDia)
	{
		return null;
	}
	public String comparacionTiemposPromedioDia(String pSourceid,String pDia)
	{
		return "";
	}
	public ListaEncadenada<ViajeUber> consultarTiemposEntreZonasHora(String pSourceid, String pDestino, String pHora)
	{
		return null;
	}
	public ListaEncadenada<ViajeUber> consultarCantidadViajesHora(String pOrigen, String pDestino, String pHoraInicio,String pHoraFin)
	{
		return null;
	}
	public void generarTablaAscii(String pSourceId,String pDestino)
	{
		
	}
}
