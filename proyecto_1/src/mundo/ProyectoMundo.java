package mundo;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import data_structures.ArregloDinamico;
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
		respuestas [0]= "Número de viajes encontrados para el trimestre en el archivo mensual: " + cargarViajesMensuales(pTrimestre);
		respuestas [1]= "Número de viajes encontrados para el trimestre en el archivo semanal: " + cargarViajesSemanales(pTrimestre);
		respuestas [2]= "Número de viajes encontrados para el trimestre en el archivo por horas: " + cargarViajesHorarios(pTrimestre);
		respuestas [3]= "Mayor identificador de zona encontrado: " + buscarMayorIdentificador();
		respuestas [4]= "Menor identificador de zona encontrado: "+ buscarMenorIdentificador();

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
				ViajeUber viajeNuevo = new ViajeUber(Integer.parseInt(siguiente[0]),Integer.parseInt(siguiente[1]), Short.parseShort("-1"), Double.parseDouble(siguiente[3]), Short.parseShort(siguiente[2]),Short.parseShort("-1"), Double.parseDouble(siguiente[4]), Double.parseDouble(siguiente[5]), Double.parseDouble(siguiente[6]));
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
				ViajeUber viajeNuevo = new ViajeUber(Integer.parseInt(siguiente[0]), Integer.parseInt(siguiente[1]), Short.parseShort("-1"), Double.parseDouble(siguiente[3]), Short.parseShort("-1"), Short.parseShort(siguiente[2]), Double.parseDouble(siguiente[4]), Double.parseDouble(siguiente[5]), Double.parseDouble(siguiente[6]));
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
				ViajeUber viajeNuevo = new ViajeUber(Integer.parseInt(siguiente[0]), Integer.parseInt(siguiente[1]), Short.parseShort(siguiente[2]), Double.parseDouble(siguiente[3]), Short.parseShort("-1"), Short.parseShort("-1"), Double.parseDouble(siguiente[4]), Double.parseDouble(siguiente[5]), Double.parseDouble(siguiente[6]));
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
			int sourceActual = viajeActual.darSourceid();
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
			int sourceActual = viajeActual.darSourceid();
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
			int sourceActual = viajeActual.darSourceid();
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
			int sourceActual = viajeActual.darSourceid();
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
			int sourceActual = viajeActual.darSourceid();
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
			int sourceActual =viajeActual.darSourceid();
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
	public ListaEncadenada<ViajeUber> consultarTiemposEntreZonasHora(String pSourceid, String pDestino, int pHora)
	{
		ListaEncadenada<ViajeUber> rta = new ListaEncadenada<ViajeUber>();
		NodoListaEncadenada<ViajeUber> actual = viajesHorarios.darNodoActual();
		while(actual!=null)
		{
			ViajeUber elementoActual = actual.darElemento();
			if(pHora==elementoActual.darHora())
			{
				if(Integer.parseInt(pSourceid)==elementoActual.darSourceid()&&Integer.parseInt(pDestino)==elementoActual.darDstid())
				{
					rta.agregarElemento(elementoActual);
				}
			}
			actual = actual.darSiguiente();
		}
		return rta;
	}
	public ListaEncadenada<ViajeUber> consultarTiemposEntreZonasMensual(String pSourceid, String pDestino, String pMes)
	{
		ListaEncadenada<ViajeUber> rta = new ListaEncadenada<ViajeUber>();
		NodoListaEncadenada<ViajeUber> actual = viajesMensuales.darNodoActual();
		while(actual!=null)
		{
			ViajeUber elementoActual = actual.darElemento();
			if(Integer.parseInt(pMes)==elementoActual.darMes())
			{
				if(Integer.parseInt(pSourceid)==elementoActual.darSourceid()&&Integer.parseInt(pDestino)==elementoActual.darDstid())
				{
					rta.agregarElemento(elementoActual);
				}
			}
			actual = actual.darSiguiente();
		}
		return rta;
	}
	public ListaEncadenada<ViajeUber> consultarTiemposEntreZonasDiario(String pSourceid, String pDestino, String pDia)
	{
		ListaEncadenada<ViajeUber> rta = new ListaEncadenada<ViajeUber>();
		NodoListaEncadenada<ViajeUber> actual = viajesSemanales.darNodoActual();
		while(actual!=null)
		{
			ViajeUber elementoActual = actual.darElemento();
			if(Integer.parseInt(pDia)==elementoActual.darDia())
			{
				if(Integer.parseInt(pSourceid)==elementoActual.darSourceid()&&Integer.parseInt(pDestino)==elementoActual.darDstid())
				{
					rta.agregarElemento(elementoActual);
				}
			}
			actual = actual.darSiguiente();
		}
		return rta;
	}
	public String comparacionTiemposPromedio(String pSourceid,String pMes)
	{
		return "";
	}
	public String comparacionTiemposPromedioMes(String pSourceid,String pMes)
	{
		return "";
	}
	public ArregloDinamico consultarNViajesMasDemoradosMensual(int pN, String pMes)
	{
		NodoListaEncadenada<ViajeUber> actual = viajesMensuales.darNodoActual();
		ArregloDinamico copiaPorOrganizar = this.pasarAArregloDinamicoMes(actual, pMes);
		copiaPorOrganizar.quickSort(copiaPorOrganizar, 0, copiaPorOrganizar.darTamano()-1);
		ArregloDinamico nElementos=new ArregloDinamico(500000);
		for(int i=0;i<pN;i++) 
		{
			nElementos.agregar(copiaPorOrganizar.darElemento(i));
		}
		return nElementos;
	}
	public ArregloDinamico consultarNViajesMasDemoradosDiarios(int pN, String pDia)
	{
		NodoListaEncadenada<ViajeUber> actual = viajesSemanales.darNodoActual();
		ArregloDinamico copiaPorOrganizar = this.pasarAArregloDinamicoDia(actual, pDia);
		copiaPorOrganizar.quickSort(copiaPorOrganizar, 0, copiaPorOrganizar.darTamano()-1);
		ArregloDinamico nElementos=new ArregloDinamico(500000);
		for(int i=0;i<pN;i++) 
		{
			nElementos.agregar(copiaPorOrganizar.darElemento(i));
		}
		return nElementos;
	}



	public double regresarTiempoPromedioSegundos(ListaEncadenada<ViajeUber>consulta) {
		NodoListaEncadenada<ViajeUber>act=consulta.darNodoActual();
		double tiempo=0.0;
		while(act!=null) {
			tiempo+=act.darElemento().darTiempoPromedio();
			act=act.darSiguiente();
		}
		if(consulta.darTamano()>0) {
			tiempo=tiempo/consulta.darTamano();

		}
		return tiempo/60 ;

	}
	public ListaEncadenada<ViajeUber> consultarCantidadViajesHora(String pOrigen, String pDestino, String pHoraInicio,String pHoraFin)
	{
		ListaEncadenada<ViajeUber> rta = new ListaEncadenada<ViajeUber>();
		NodoListaEncadenada<ViajeUber> actual = viajesHorarios.darNodoActual();
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			if(viajeActual.darHora()>=Integer.parseInt(pHoraInicio)&&viajeActual.darHora()<=Integer.parseInt(pHoraFin))
			{
				if(Integer.parseInt(pOrigen)==viajeActual.darSourceid()&&Integer.parseInt(pDestino)==viajeActual.darDstid())
				{
					rta.agregarElemento(viajeActual);
				}
			}
			actual = actual.darSiguiente();
		}
		return rta;
	}
	public ArregloDinamico consultarNViajesMasDemoradosHora(int pN, String pHora)
	{
		NodoListaEncadenada<ViajeUber> actual = viajesHorarios.darNodoActual();
		ArregloDinamico copiaPorOrganizar = this.pasarAArregloDinamicoHora(actual, pHora);
		copiaPorOrganizar.quickSort(copiaPorOrganizar, 0, copiaPorOrganizar.darTamano()-1);
		ArregloDinamico nElementos=new ArregloDinamico(500000);
		for(int i=0;i<pN;i++) 
		{
			nElementos.agregar(copiaPorOrganizar.darElemento(i));
		}
		return nElementos;
	}
	public void generarTablaAscii(String pSourceId,String pDestino)
	{

	}
	public ArregloDinamico pasarAArregloDinamicoDia(NodoListaEncadenada<ViajeUber>actual,String dia) {
		ArregloDinamico nuevo=new ArregloDinamico(1000000);
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			if(viajeActual.darDia()==Integer.parseInt(dia)) {
				nuevo.agregar(viajeActual);
			}
			actual = actual.darSiguiente();
		}
		return nuevo;
	}
	public ArregloDinamico pasarAArregloDinamicoMes(NodoListaEncadenada<ViajeUber>actual,String mes) {
		ArregloDinamico nuevo=new ArregloDinamico(500000);
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();
			if(viajeActual.darMes()==Integer.parseInt(mes)) {
				nuevo.agregar(viajeActual);
			}
			actual = actual.darSiguiente();
		}
		return nuevo;
	}
	public ArregloDinamico pasarAArregloDinamico(NodoListaEncadenada<ViajeUber>actual) {
		ArregloDinamico nuevo=new ArregloDinamico(500000);
		while(actual!=null)
		{
			ViajeUber viajeActual = actual.darElemento();

			nuevo.agregar(viajeActual);

			actual = actual.darSiguiente();
		}
		return nuevo;
	}
	public ArregloDinamico pasarAArregloDinamicoHora(NodoListaEncadenada<ViajeUber>pActual, String pHora)
	{
		ArregloDinamico nuevo = new ArregloDinamico(500000);
		while(pActual!=null)
		{
			ViajeUber viajeActual = pActual.darElemento();
			if(viajeActual.darHora()==Short.parseShort(pHora)) {
				nuevo.agregar(viajeActual);
			}
			pActual = pActual.darSiguiente();
		}
		return nuevo;
	}
	public ListaEncadenada<ViajeUber> regresarZonasFranjaMes(int zonaMenor, int zonaMayor, String pMes)
	{
		ListaEncadenada<ViajeUber> rta = new ListaEncadenada<ViajeUber>();
		NodoListaEncadenada<ViajeUber> actual = viajesMensuales.darNodoActual();
		while(actual!=null)
		{
			ViajeUber elementoActual = actual.darElemento();
			if(Integer.parseInt(pMes)==elementoActual.darMes())
			{
				if((elementoActual.darSourceid()>=zonaMenor&&elementoActual.darSourceid()<=zonaMayor)||(elementoActual.darDstid()>=zonaMenor&&elementoActual.darDstid()<=zonaMayor))
				{
					rta.agregarElemento(elementoActual);
				}
			}
			actual = actual.darSiguiente();
		}
		return rta;
	}
	public double regresarTiempoPromedioViajeIdaDesdeZonaX(int zonaX,ArregloDinamico lista,int comp) {
		int contador=0;
		double tiempoPromedio=0.0;
		for(int i=0;i<lista.darTamano();i++) {
			ViajeUber actual=lista.darElemento(i);
			if(actual.darDstid()==zonaX&&actual.darSourceid()==comp) {
				tiempoPromedio+=actual.darTiempoPromedio();
				contador++;
			}
		}
		if(contador>0) {
			return tiempoPromedio/contador;
		}
		else {
			return 0.0;
		}
	}

	public double regresarTiempoPromedioViajeRegresoDesdeZonaX(int zonaX,ArregloDinamico lista,int comp) {
		int contador=0;
		double tiempoPromedio=0.0;
		for(int i=0;i<lista.darTamano();i++) {
			ViajeUber actual=lista.darElemento(i);
			if(actual.darSourceid()==zonaX&&actual.darDstid()==comp) {
				tiempoPromedio+=actual.darTiempoPromedio();
				contador++;
			}
		}
		if(contador>0) {
			return tiempoPromedio/contador;
		}
		else {
			return 0.0;
		}
	}

public ListaEncadenada<ViajeUber> regresarZonasFranjaDia(int zonaMenor, int zonaMayor, String pDia)
{
	ListaEncadenada<ViajeUber> rta = new ListaEncadenada<ViajeUber>();
	NodoListaEncadenada<ViajeUber> actual = viajesSemanales.darNodoActual();
	while(actual!=null)
	{
		ViajeUber elementoActual = actual.darElemento();
		if(Integer.parseInt(pDia)==elementoActual.darDia())
		{
			if((elementoActual.darSourceid()>=zonaMenor&&elementoActual.darSourceid()<=zonaMayor)||(elementoActual.darDstid()>=zonaMenor&&elementoActual.darDstid()<=zonaMayor))
			{
				rta.agregarElemento(elementoActual);
			}
		}
		actual = actual.darSiguiente();
	}
	return rta;
}

}
