package abschluss1;

import java.io.Serializable;


/**
 * Die Klasse für das Regal.+
 * Die Klasse beinhaltet die Konstruktor und 10x10 2 Dimensionale Array von Fach.
 *
 */
public class Regal implements Serializable{
	private Fach [][] regalInhalt = new Fach [10][10];
	
	/**
	 * Konstruktor setzt alle Faeche auf LeerFach.
	 */
	public Regal()
	{
		for(int i = 0; i<10;i++)
		{
			for (int j=0; j<10;j++)
			{
				regalInhalt[i][j] = new LeerFach();
			}
		}
	}
	
	/**
	 * Getter fuer das Fach.
	 */
	public Fach getFachAt(int i, int j)
	{
		return regalInhalt[i][j];
	}
}