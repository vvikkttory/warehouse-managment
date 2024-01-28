package abschluss1;

import java.io.Serializable;

/**
 * Die Klasse fuer eine Ware, die hat bestimmte Name, Teilenummer, Seriennummer und Groesse.
 *
 */

public class KonkreteWaren extends Waren implements Serializable{

	public KonkreteWaren(String n, String t, String s, double g)
	{
		super();
		name = n;
		teilennummer = t;
		seriennummer = s;
		groesse = g;
		
	}
}


