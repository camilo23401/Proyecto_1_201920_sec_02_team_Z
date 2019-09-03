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


		String [] respuestas = new String[4];
		cargarViajesMensuales(pTrimestre);
		cargarViajesSemanales(pTrimestre);
		//cargarViajesHorarios(pTrimestre);
		buscarMayorIdentificador();
		buscarMenorIdentificador();

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
		System.out.println(contador);
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
		System.out.println(contador);
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
		System.out.println(contador);
		lector3.close();
		return contador;
	}
	public String buscarMayorIdentificador()
	{
		String respuesta = "";
		return respuesta;
	}
	public String buscarMenorIdentificador()
	{
		String respuesta = "";
		return respuesta;
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
}
