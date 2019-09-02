package mundo;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;



public class ProyectoMundo 
{
	public ProyectoMundo()
	{

	}
	public String agregarDatos(String pTrimestre) throws IOException
	{
		String rutaMensual = "";
		String rutaSemanal = "";
		String rutaHoraria = "";
		int trimestreBuscado = Integer.parseInt(pTrimestre);
		String rta = "";
		if(trimestreBuscado ==1)
		{
			rutaHoraria = "data/bogota-cadastral-2018-1-All-HourlyAggregate.csv";
			rutaMensual = "data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv";
			rutaSemanal = "data/bogota-cadastral-2018-1-WeeklyAggregate.csv";
		}
		else if(trimestreBuscado ==2)
		{
			rutaHoraria = "data/bogota-cadastral-2018-2-All-HourlyAggregate.csv";
			rutaMensual = "data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv";
			rutaSemanal = "data/bogota-cadastral-2018-2-WeeklyAggregate.csv";
		}
		else if(trimestreBuscado ==3)
		{
			rutaHoraria = "data/bogota-cadastral-2018-3-All-HourlyAggregate.csv";
			rutaMensual = "data/bogota-cadastral-2018-3-All-MonthlyAggregate.csv";
			rutaSemanal = "data/bogota-cadastral-2018-3-WeeklyAggregate.csv";
		}
		else if(trimestreBuscado ==4)
		{
			rutaHoraria = "data/bogota-cadastral-2018-4-All-HourlyAggregate.csv";
			rutaMensual = "data/bogota-cadastral-2018-4-All-MonthlyAggregate.csv";
			rutaSemanal = "data/bogota-cadastral-2018-4-WeeklyAggregate.csv";
		}
		else
		{
			rta = "No se introdujo un dato válido";
		}
		int contador = 0;
		int contador2 = 0;
		int contador3 = 0;
		CSVReader lector = new CSVReader(new FileReader(rutaMensual));
		CSVReader lector2 = new CSVReader(new FileReader(rutaSemanal));
		CSVReader lector3 = new CSVReader(new FileReader(rutaHoraria));
		String [] siguiente;
		ViajeUber ultimoLeido = null;
		while ((siguiente = lector.readNext()) != null) 
		{
			if(contador!=0)
			{

			}
			contador++;
		}
		while ((siguiente = lector2.readNext()) != null) 
		{
			if(contador2!=0)
			{

			}
			contador2++;
		}
		while ((siguiente = lector3.readNext()) != null) 
		{
			if(contador3!=0)
			{

			}
			contador3++;
		}
		return rta;
	}
}
