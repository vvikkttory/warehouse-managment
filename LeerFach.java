package abschluss1;

import java.io.Serializable;

/**
 * Die Klasse fuer das leere Fach.
 * LeerFach beinhaltet eine ArrayList von LeerWaren.
 */
public class LeerFach extends Fach implements Serializable{
	public LeerFach()
	{
		super();
		for (int i = 0; i<warenInFach.size();i++)
		{
			warenInFach.set(i, new LeerWaren());
		}
	}
}