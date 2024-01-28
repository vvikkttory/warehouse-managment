package abschluss1;

import java.io.Serializable;

/**
 * Die Klasse fuer eine leere Ware. Die keine Name, Teilennummer, Seriennummer und groesse hat.
 *
 */

public class LeerWaren extends Waren implements Serializable{
	public LeerWaren()
	{
		this.name="";
	}
}
