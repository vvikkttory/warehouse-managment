package abschluss1;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

/**
 * Klasse fuer die 8 Regale.
 * Diese Klasse beinhaltet die Konstruktoren und Methoden 
 * für das Einlagern, Auslagern, Speicherung und Einlesen der Waren.
 * Beim Einlagern und Auslagern wird die erforderliche Abzweigungen 
 * durch die Methode public void richtung(int x, int y) gezeigt.
 *
 */

public class LagerDaten 
{
	private Map<Integer,Regal> regalMap = new HashMap<Integer, Regal>();
	private File file = new File ("./src/daten.txt");
	private Regal regal1 = new Regal();
	private Regal regal2 = new Regal();
	private Regal regal3 = new Regal();
	private Regal regal4 = new Regal();
	private Regal regal5 = new Regal();
	private Regal regal6 = new Regal();
	private Regal regal7 = new Regal();
	private Regal regal8 = new Regal();
	private int regalNr,zeilenNr,spaltenNr;
	private Boolean gefunden;
	
	/**
	 * Konstruktor, die 8 leere Regale in Hashmap hinzufuegt.
	 */
	public LagerDaten ()
	{
		regalMap.put(1, regal1);
		regalMap.put(2, regal2);
		regalMap.put(3, regal3);
		regalMap.put(4, regal4);
		regalMap.put(5, regal5);
		regalMap.put(6, regal6);
		regalMap.put(7, regal7);
		regalMap.put(8, regal8);
	}
	
	/**
	 * Methode fuer das Einlagern der Waren mit Name, Teilnummer, Seriennummer und größe.
	 * @param n ist ein String Argument fuer den Name.
	 * @param t ist ein String Argument fuer die Teilnummer.
	 * @param s ist ein String Argument fuer die Seriennummer.
	 * @param g ist ein double Argument fuer die Groesse.
	 * @return String koordinat, die zeigt, wo die Ware eingelagert wurde.
	 */
	public String einlagern(String n, String t, String s, double g)
	{
		gefunden = false;
	    int r = 1;
	    int i = 0;
	    int j = 0;

	    for (r = 1; r < 9 && !gefunden; r++) 
	    {
	        for (i = 0; i < 10 && !gefunden; i++) 
	        {
	            for (j = 0; j < 10 && !gefunden; j++) 
	            {
	                Fach fach = regalMap.get(r).getFachAt(i, j);
	                if (g <= fach.getfreiPlatz()) 
	                {
	                    fach.addWaren(new KonkreteWaren(n, t, s, g));
	                    gefunden = true;
	                }
	            }
	        }
	    }
	    r--;
		i--;
		j--;
		
		regalNr=r;
		zeilenNr=i;
		spaltenNr=j;
		
		String koordinat="";
		
	    if (gefunden) 
	    {
	    	// x Teil
			int x=0;
			if (regalNr<=4)
			{
				x =2;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			else if (regalNr >4)
			{
				x=24;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			
			// y Teil
			int y=0;
			if(r==1 || r==5)
			{
				y=2;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==2|| r==6)
			{
				y=6;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==3||r==7)
			{
				y=10;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==4||r==8)
			{
				y=14;
				koordinat += " y = "+y+" | ";
			}
			
			// z Teil
			int z = 19-2*i;
			koordinat += " z = "+ z+ "";
			
			richtung(x,y);
			
			return koordinat;
	    } else {
	        return "nicht gefunden";
	    }
	}
	
	/**
 	 * Diese Funktion sucht anhand des Namens nach die normale Ware, und auslagert sie, falls vorhanden.
	 * @param name ist ein String Argument fuer den Name.
	 * @return String koordinat, die zeigt, wo die Ware ausgelagert wurde.
	 */
	public String auslagernNameNormal(String name)
	{
		gefunden = false;
		int r = 1;
		int i = 0;
		int j = 0;
		int k = 0;
		
		for(r=1; r<9 && gefunden==false; r++ )
		{
			for(i=0; i<10 && gefunden==false; i++)
			{
				for (j=0; j<10 && gefunden==false; j++)
				{
					for(k=0; k<regalMap.get(r).getFachAt(i, j).warenInFach.size() && gefunden==false; k++)
					{
						if (name.equals(regalMap.get(r).getFachAt(i, j).warenInFach.get(k).name) && regalMap.get(r).getFachAt(i, j).warenInFach.get(k).seriennummer.isEmpty())
						{
							gefunden = true;
						}
					}
				}
			}
		}
		r--;
		i--;
		j--;
		k--;
		
		regalNr=r;
		zeilenNr=i;
		spaltenNr=j;
		
		String koordinat = "";
		
		if (gefunden == true)
		{
			regalMap.get(r).getFachAt(i, j).removeWaren(regalMap.get(r).getFachAt(i, j).warenInFach.get(k));;
			
			// x Teil
			int x=0;
			if (regalNr<=4)
			{
				x =2;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			else if (regalNr >4)
			{
				x=24;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			
			// y Teil
			int y=0;
			if(r==1 || r==5)
			{
				y=2;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==2|| r==6)
			{
				y=6;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==3||r==7)
			{
				y=10;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==4||r==8)
			{
				y=14;
				koordinat += " y = "+y+" | ";
			}
			
			// z Teil
			int z = 19-2*i;
			koordinat += " z = "+ z+ "";
			
			// Stelle
			koordinat += " Stelle = " +k;
			
			richtung(x,y);
			
			return koordinat;
		}
		else
		{
			return "nicht gefunden";
		}
	}
	
	
	/**
	 * Diese Funktion sucht anhand der Teilnummer nach die normale Ware, und auslagert sie, falls vorhanden.
	 * @param teilnum ist ein String Argument fuer die Teilnummer.
	 * @return String koordinat, die zeigt, wo die Ware ausgelagert wurde.
	 */
	public String auslagernNormal(String teilnum)
	{
		gefunden = false;
		int r = 1;
		int i = 0;
		int j = 0;
		int k = 0;
		
		for(r=1; r<9 && gefunden==false; r++ )
		{
			for(i=0; i<10 && gefunden==false; i++)
			{
				for (j=0; j<10 && gefunden==false; j++)
				{
					for(k=0; k<regalMap.get(r).getFachAt(i, j).warenInFach.size() && gefunden==false; k++)
					{
						if (teilnum.equals(regalMap.get(r).getFachAt(i, j).warenInFach.get(k).teilennummer) && regalMap.get(r).getFachAt(i, j).warenInFach.get(k).seriennummer.isEmpty())
						{
							gefunden = true;
						}
					}
				}
			}
		}
		r--;
		i--;
		j--;
		k--;
		
		regalNr=r;
		zeilenNr=i;
		spaltenNr=j;
		
		String koordinat = "";
		
		if (gefunden == true)
		{
			regalMap.get(r).getFachAt(i, j).removeWaren(regalMap.get(r).getFachAt(i, j).warenInFach.get(k));;
			
			// x Teil
			int x=0;
			if (regalNr<=4)
			{
				x =2;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			else if (regalNr >4)
			{
				x=24;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			
			// y Teil
			int y=0;
			if(r==1 || r==5)
			{
				y=2;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==2|| r==6)
			{
				y=6;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==3||r==7)
			{
				y=10;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==4||r==8)
			{
				y=14;
				koordinat += " y = "+y+" | ";
			}
			
			// z Teil
			int z = 19-2*i;
			koordinat += " z = "+ z+ "";
			
			// Stelle
			koordinat += " Stelle = " +k;
			
			richtung(x,y);
			
			return koordinat;
		}
		else
		{
			return "nicht gefunden";
		}
	}
	
	/**
	 * Diese Funktion sucht anhand der Seriennummer und des Namens nach die hochwertige Ware, und auslagert sie, falls vorhanden.
	 * @param serNum ist ein String Argument fuer die Seriennummer.
	 * @param Name ist ein String Argument fuer die Name.
	 * @return String koordinat, die zeigt, wo die Ware eingelagert wurde.
	 */
	public String auslagernNameHochWert(String serNum, String name)
	{
		gefunden = false;
		int r = 1;
		int i = 0;
		int j = 0;
		int k = 0;
		
		for(r=1; r<9 && gefunden==false; r++ )
		{
			for(i=0; i<10 && gefunden==false; i++)
			{
				for (j=0; j<10 && gefunden==false; j++)
				{
					for(k=0; k<regalMap.get(r).getFachAt(i, j).warenInFach.size() && gefunden==false; k++)
					{
						if (serNum.equals(regalMap.get(r).getFachAt(i, j).warenInFach.get(k).seriennummer) && name.equals(regalMap.get(r).getFachAt(i, j).warenInFach.get(k).name))
						{
							gefunden = true;
						}
					}
				}
			}
		}
		r--;
		i--;
		j--;
		k--;
		
		regalNr=r;
		zeilenNr=i;
		spaltenNr=j;
		
		String koordinat="";
		
		if (gefunden == true)
		{
			regalMap.get(r).getFachAt(i, j).removeWaren(regalMap.get(r).getFachAt(i, j).warenInFach.get(k));
			
			// x Teil
			int x=0;
			if (regalNr<=4)
			{
				x =2;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			else if (regalNr >4)
			{
				x=24;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			
			// y Teil
			int y=0;
			if(r==1 || r==5)
			{
				y=2;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==2|| r==6)
			{
				y=6;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==3||r==7)
			{
				y=10;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==4||r==8)
			{
				y=14;
				koordinat += " y = "+y+" | ";
			}
			
			// z Teil
			int z = 19-2*i;
			koordinat += " z = "+ z+ "";
			
			//Stelle
			koordinat += " Stelle = " +k;
			
			richtung(x,y);
			
			return koordinat;
			
		}
		else
		{
			return "nicht gefunden";
		}
	}
	
	/**
	 * Diese Funktion sucht anhand der Seriennummer und Teilenummer nach die hochwertige Ware, und auslagert sie, falls vorhanden.
	 * @param serNum ist ein String Argument fuer die Seriennummer.
	 * @param teilNum ist eine String Argument fuer die Teilenummer.
	 * @return String koordinat, die zeigt, wo die Ware eingelagert wurde.
	 */
	public String auslagernHochWert(String serNum, String teilNum)
	{
		gefunden = false;
		int r = 1;
		int i = 0;
		int j = 0;
		int k = 0;
		
		for(r=1; r<9 && gefunden==false; r++ )
		{
			for(i=0; i<10 && gefunden==false; i++)
			{
				for (j=0; j<10 && gefunden==false; j++)
				{
					for(k=0; k<regalMap.get(r).getFachAt(i, j).warenInFach.size() && gefunden==false; k++)
					{
						if (serNum.equals(regalMap.get(r).getFachAt(i, j).warenInFach.get(k).seriennummer) && teilNum.equals(regalMap.get(r).getFachAt(i, j).warenInFach.get(k).teilennummer))
						{
							gefunden = true;
						}
					}
				}
			}
		}
		r--;
		i--;
		j--;
		k--;
		
		regalNr=r;
		zeilenNr=i;
		spaltenNr=j;
		
		String koordinat="";
		
		if (gefunden == true)
		{
			regalMap.get(r).getFachAt(i, j).removeWaren(regalMap.get(r).getFachAt(i, j).warenInFach.get(k));
			
			// x Teil
			int x=0;
			if (regalNr<=4)
			{
				x =2;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			else if (regalNr >4)
			{
				x=24;
				x=x+j*2;
				koordinat = " x = "+x+" | ";
			}
			
			// y Teil
			int y=0;
			if(r==1 || r==5)
			{
				y=2;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==2|| r==6)
			{
				y=6;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==3||r==7)
			{
				y=10;
				koordinat += " y = "+y+" | ";
			}
			
			if(r==4||r==8)
			{
				y=14;
				koordinat += " y = "+y+" | ";
			}
			
			// z Teil
			int z = 19-2*i;
			koordinat += " z = "+ z+ "";
			
			//Stelle
			koordinat += " Stelle = " +k;
			
			richtung(x,y);
			
			return koordinat;
			
		}
		else
		{
			return "nicht gefunden";
		}
	}
	
	/**
	 * Getter fuer die Regalnummer.
	 * @return int regalNr.
	 */
	public int getRegalNr()
	{
		return regalNr;
	}
	
	/**
	 * Getter fuer die Zeilennummer.
	 * @return in zeilenNr.
	 */
	public int getZeileNr()
	{
		return zeilenNr;
	}
	
	/**
	 * Getter fuer die Spaltennummer.
	 * @return int spaltenNr.
	 */
	public int getSpaltenNr()
	{
		return spaltenNr;
	}
	
	/**
	 * Getter fuer das Regal.
	 * @param key ist ein int Argument.
	 * @return Ein ganze Regal aus HashMap regalMap.
	 */
	public Regal getRegal(int key)
	{
		return regalMap.get(key);
	}
	
	/**
	 * Methode zur Überprüfung, ob das Produkt gefunden wurde.
	 * @return boolean gefunden.
	 */
	public boolean istGefunden()
	{
		return gefunden;
	}
	
	/**
	 * Diese Funktion druckt die notwendigen Umdrehungen, die der Transportwagen machen soll, in der Konsole aus.
	 * @param x ist ein int Argument fuer die x Koordinat der Position.
	 * @param y ist ein int Argument fuer die y Koordinat der Position.
	 */
	public void richtung(int x, int y)
	{
		if (y==2)
		{
			System.out.println("Unterwegs sind keine Abzweigungen erforderlich");
		}
		
		if (y==6)
		{
			System.out.println("-------------------------------------");
			System.out.println("am Punkt (23,1,0) nach links abbiegen");
			if(x<23)
			{
				System.out.println("am Punkt (23,5,0) nach links abbiegen");
				System.out.println("-------------------------------------");
			}
			else
			{
				System.out.println("am Punkt (23,5,0) nach rechts abbiegen");
				System.out.println("-------------------------------------");
			}
		}
		
		if(y==10)
		{
			System.out.println("-------------------------------------");
			System.out.println("am Punkt (23,1,0) nach links abbiegen");
			if(x<23)
			{
				System.out.println("am Punkt (23,9,0) nach links abbiegen");
				System.out.println("-------------------------------------");
			}
			else
			{
				System.out.println("am Punkt (23,9,0) nach rechts abbiegen");
				System.out.println("-------------------------------------");
			}
		}
		
		if(y==14)
		{
			System.out.println("-------------------------------------");
			System.out.println("am Punkt (23,1,0) nach links abbiegen");
			if(x<23)
			{
				System.out.println("am Punkt (23,13,0) nach links abbiegen");
				System.out.println("-------------------------------------");
			}
			else
			{
				System.out.println("am Punkt (23,13,0) nach rechts abbiegen");
				System.out.println("-------------------------------------");
			}
		}
	}
	
	/**
	 * Diese Funktion speicher alle Daten von Waren in den acht Regalen in .txt Datei.
	 */
	public void speichern() 
	{
		try 
		{
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(regalMap);
			System.out.println("-------------------------------------");
			System.out.println("Gespeichert");
			System.out.println("-------------------------------------");
			oos.close();
			fos.close();
		} 
		catch (IOException e) 
		{
			System.out.println("-------------------------------------");
			System.out.println("Fehler beim Speichern");
			System.out.println("-------------------------------------");
			e.printStackTrace();
		}
		
	}
	
	/**
	 *  Diese Funktion liest alle Daten von Waren in den acht Regalen aus .txt Datei.
	 */
	public void lesen()
	{
		try
		{
			Map<Integer,Regal> read;
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			read = (Map<Integer,Regal>) ois.readObject();
			regalMap = read;
			System.out.println("-------------------------------------");
			System.out.println("Gelesen");
			System.out.println("-------------------------------------");
			fis.close();
			ois.close();
		}
		catch(IOException | ClassNotFoundException e)
		{
			System.out.println("-------------------------------------");
			System.out.println("Fehler beim Lesen");
			System.out.println("-------------------------------------");
			e.printStackTrace();
		}
		
	}
	
	

}
