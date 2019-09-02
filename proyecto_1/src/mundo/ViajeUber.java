package mundo;

public class ViajeUber 
{

	private String sourceid;
	private String dstid;
	private String mes;
	private String dia;
	private String hora;
	private String tiempoPromedio;
	private String desviacionEstandarTiempo;
	private String tiempoPromedioGeometrico;
	private String desviacionEstandarTiempoGeometrico;


	public ViajeUber(String pSourceid, String pDstid, String pHora, String pTiempoPromedio, String pMes, String pDia, String pDesviacionEstandarTiempo, String pTiempoPromedioGeometrico, String pDesviacionEstandarTiempoGeometrico)
	{
		sourceid = pSourceid;
		dstid = pDstid;
		mes = pMes;
		dia = pDia;
		hora = pHora;
		tiempoPromedio = pTiempoPromedio;
		desviacionEstandarTiempo = pDesviacionEstandarTiempo;
		tiempoPromedioGeometrico = pTiempoPromedioGeometrico;
		desviacionEstandarTiempoGeometrico = pDesviacionEstandarTiempoGeometrico;
	}
	public String darSourceid()
	{
		return sourceid;
	}
	public String darDstid()
	{
		return dstid;
	}
	public String darMes()
	{
		return mes;	
	}
	public String darDia()
	{
		return dia;
	}
	public String darHora()
	{
		return hora;
	}
	public String darTiempoPromedio()
	{
		return tiempoPromedio;
	}
	public String darDesviacionEstandarTiempo()
	{
		return desviacionEstandarTiempo;
	}
	public String darTiempoPromedioGeometrico()
	{
		return tiempoPromedioGeometrico;
	}
	public String darDesviacionEstandarTiempoGeometrico()
	{
		return desviacionEstandarTiempoGeometrico;
	}
}

