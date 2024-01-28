package abschluss1;

/**
 *Diese Klasse enthaelt die main().
 */
public class Lager {
	
	private LagerGUI view;
	private LagerDaten data;
	
	public Lager()
	{
		data = new LagerDaten();
		view = new LagerGUI(data);
	}
	
	public static void main(String [] args)
	{
		Lager app = new Lager();
		app.view.setVisible(true);
		app.view.anzeigen(1);
	}

}