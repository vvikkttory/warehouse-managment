package abschluss1;

import java.io.Serializable;

/**
 * Die Klasse fuer die Ware.
 * Diese Klasse beinhaltet Teilennummer, Name, Seriennummer und Groesse.
 * Groesse wird als Volumen einer Ware betrachtet
 *
 */
public abstract class Waren implements Serializable{
	protected String teilennummer;
	protected String name = "";
	protected String seriennummer;
	protected double groesse;
}