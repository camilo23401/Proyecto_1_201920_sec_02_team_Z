package mundo;

public class ViajeUber 
{

	private int sourceid;
	private int dstid;
	private short mes;
	private short dia;
	private short hora;
	private double tiempoPromedio;
	private double desviacionEstandarTiempo;
	private double tiempoPromedioGeometrico;
	private double desviacionEstandarTiempoGeometrico;


	public ViajeUber(int pSourceid, int pDstid, short pHora, double pTiempoPromedio, short pMes, short pDia, double pDesviacionEstandarTiempo, double pTiempoPromedioGeometrico, double pDesviacionEstandarTiempoGeometrico)
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
	public int darSourceid()
	{
		return sourceid;
	}
	public int darDstid()
	{
		return dstid;
	}
	public short darMes()
	{
		return mes;	
	}
	public short darDia()
	{
		return dia;
	}
	public short darHora()
	{
		return hora;
	}
	public double darTiempoPromedio()
	{
		return tiempoPromedio;
	}
	public double darDesviacionEstandarTiempo()
	{
		return desviacionEstandarTiempo;
	}
	public double darTiempoPromedioGeometrico()
	{
		return tiempoPromedioGeometrico;
	}
	public double darDesviacionEstandarTiempoGeometrico()
	{
		return desviacionEstandarTiempoGeometrico;
	}
}

