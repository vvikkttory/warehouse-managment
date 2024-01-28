package abschluss1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Die Klasse fuer das Fach.
 * Die Klasse beinhaltet eine ArrayList, die aus Waren besteht, und eine double freiPlatz, die auf 8 eingestellt ist.
 * 
 */

public class Fach implements Serializable {

	protected ArrayList <Waren> warenInFach = new ArrayList <>();
	private double freiPlatz = 8;
	
	/**
	 * Diese Funktion gibt die Name der Ware an der beliebige Stelle der Liste zuruek.
	 * @param i die Stelle der Waren in der List.
	 * @return String name
	 */
	public String getWarenNameAt(int i)
	{
		return warenInFach.get(i).name;
	}
	
	/**
	 * Diese Funktion erzeugt eine Liste aus die Name der Waren von ArrayList warenInFach, und gibt diese Liste zurueck.
	 * @return String [] name.
	 */
	public String [] getWarenNameList()
	{
		String [] name = new String [warenInFach.size()];
		for (int i = 0; i<warenInFach.size();i++)
		{
			name[i]=warenInFach.get(i).name;
		}
		return name;
	}
	
	/**
	 * Diese Funktion erzeugt eine String n. Sie besteht aus die Name aller Waren in der ArrayList warenInFach, 
	 * und die Namen sind durch das Zeichen " | " geteilt.
	 * @return String n
	 */
	public String printWarenName()
	{
		String n = "";
		for (int i = 0; i<warenInFach.size(); i++)
		{
			n += warenInFach.get(i).name+" | ";
		}
		return n;
	}
	
	/**
	 * Ein Setter fuer die Ware an eine bestimmte Stelle.
	 * @param i ein int Argument fuer die Stelle
	 * @param a ein Waren Argument fuer die Ware, die eingesetzt werden soll.
	 */
	public void setWarenAt(int i, Waren a)
	{
		warenInFach.set(i, a);
	}
	
	/**
	 * Diese Funktion addiert eine Ware in der ArrayListe warenInFach.
	 * @param a ist ein Waren Argument.
	 */
	public void addWaren(Waren a)
	{
		warenInFach.add(a);
		freiPlatz -= a.groesse;
	}
	
	/**
	 * Diese Methode entfernt das Produkt aus der ArrayList warenInFach.
	 * @param a
	 */
	public void removeWaren(Waren a)
	{
		warenInFach.remove(a);
		freiPlatz += a.groesse;
	}
	
	/**
	 * Ein Getter fuer das freiPlatz.
	 * @return
	 */
	public double getfreiPlatz()
	{
		return freiPlatz;
	}
	
}
