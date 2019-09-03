package mundo;

import java.util.Scanner;

import consola.InteraccionConsola;

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
				System.out.println("--------------------------------------- \n Adi�s \n ---------------------------------------"); 
				lector.close();
				finalizado = true;
				break;	


			}
		}
	}
}
