package mundo;

public class ViajeUber 
{

	private String sourceid;
	private String dstid;
	private String hora;
	private String tiempoPromedio;


	public ViajeUber(String pSourceid, String pDstid, String pHora, String pTiempoPromedio)
	{
		sourceid = pSourceid;
		dstid = pDstid;
		hora = pHora;
		tiempoPromedio = pTiempoPromedio;
	}
	public String darSourceid()
	{
		return sourceid;
	}
	public String darDstid()
	{
		return dstid;
	}
	public String darHora()
	{
		return hora;
	}
	public String darTiempoPromedio()
	{
		return tiempoPromedio;
	}
}

