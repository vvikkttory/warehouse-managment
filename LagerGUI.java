package abschluss1;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


/**
 * Diese Klasse beinhaltet graphical user interface.
 * Die GUI hat 4 Panel: operationPanel, regalPanel, inhaltPanel  und wahlPanel.
 * regalPanel beinhaltet acht JButton.
 * inhaltPanel beinhaltet 10x10 JTable.
 * operationPanel beinhaltet vier JTextArea und zwei JButton.
 * wahlPanel beinhaltet zwei JComboBox.
 */
public class LagerGUI extends JFrame{
	private LagerDaten data;
	private JPanel inhaltPanel, regalPanel, operationPanel, wahlPanel;
	private JTable inhaltTable;
	private String [][] inhalt;
	private Integer [] inhaltHeader = {1,2,3,4,5,6,7,8,9,10};
	private DefaultTableModel model;
	private JTextArea namenArea, teilNrArea, serienNrArea, groesseArea, messageArea;
	private JLabel inhaltLabel,messageLabel,serienNrLabel,teilNrLabel,namenLabel,groesseLabel;
	private JButton einlagernButton,auslagernButton, exitButton;
	private JComboBox<String> comboBox, hochWertBox;
	private String wahl,hochWertWahl;
	
	public LagerGUI(LagerDaten d)
	{
		this.data=d;
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1350,530);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocationRelativeTo(null);
		this.setTitle("LagerVerwaltung");
		
		data.lesen();
		
		//RegalPanel ----------------------------------------------
		regalPanel = new JPanel();
		regalPanel.setBounds(0, 0, 470, 240);
		regalPanel.setLayout(null);
		regalPanel.setBackground(Color.DARK_GRAY);
		this.add(regalPanel);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(350, 180, 100, 20);
		regalPanel.add(exitButton);
		exitButton.addActionListener(e->exit());
		
		JButton regal1 = new JButton("Regal: 1");
		regal1.setBounds(30, 140, 200, 20);
		regalPanel.add(regal1);

		JButton regal2 = new JButton("Regal: 2");
		regal2.setBounds(30, 100, 200, 20);
		regalPanel.add(regal2);
		
		JButton regal3 = new JButton("Regal: 3");
		regal3.setBounds(30, 60, 200, 20);
		regalPanel.add(regal3);
		
		JButton regal4 = new JButton("Regal: 4");
		regal4.setBounds(30, 20, 200, 20);
		regalPanel.add(regal4);
		
		JButton regal5 = new JButton("Regal: 5");
		regal5.setBounds(250, 140, 200, 20);
		regalPanel.add(regal5);
		
		JButton regal6 = new JButton("Regal: 6");
		regal6.setBounds(250, 100, 200, 20);
		regalPanel.add(regal6);
		
		JButton regal7 = new JButton("Regal: 7");
		regal7.setBounds(250, 60, 200, 20);
		regalPanel.add(regal7);
		
		JButton regal8 = new JButton("Regal: 8");
		regal8.setBounds(250, 20, 200, 20);
		regalPanel.add(regal8);
		
		JLabel nullPunktLabel = new JLabel("x");
		nullPunktLabel.setBounds(30, 180, 10, 10);
		nullPunktLabel.setForeground(Color.white);
		regalPanel.add(nullPunktLabel);
		
		JLabel startLabel = new JLabel("Startpunkt");
		startLabel.setBounds(10,190, 100,20);
		startLabel.setForeground(Color.WHITE);
		regalPanel.add(startLabel);
		
		
		//Inhalt Panel ---------------------------------------------
		
		inhaltPanel = new JPanel();
		inhaltPanel.setLayout(null);
		inhaltPanel.setBounds(470, 0, 880, 500);
		inhaltPanel.setBackground(Color.lightGray);
		this.add(inhaltPanel);
		
		inhalt = new String[10][10];
		model = new DefaultTableModel (inhalt, inhaltHeader);
		inhaltTable = new JTable(model);
		inhaltTable.setBounds(40, 40, 800, 400);
		inhaltTable.setRowHeight(40);
		inhaltPanel.add(inhaltTable);
		
		inhaltLabel = new JLabel();
		inhaltLabel.setBounds(350, 10, 200, 20);
		inhaltPanel.add(inhaltLabel);
		
		//Operation Panel -------------------------------------------------------
		operationPanel = new JPanel();
		operationPanel.setLayout(null);
		operationPanel.setBounds(0,280, 470, 250);
		operationPanel.setBackground(Color.cyan.darker().darker().darker());
		this.add(operationPanel);
		
		wahlPanel = new JPanel();
		wahlPanel.setBounds(0,240,470,40);
		wahlPanel.setLayout(null);
		wahlPanel.setBackground(Color.cyan.darker().darker().darker());
		this.add(wahlPanel);
		
		comboBox = new JComboBox<>(new String[]{"Einlagern", "Auslagern"});
		comboBox.addActionListener(e->changeOpPanel());
		comboBox.setBounds(140, 10, 100, 20);
		wahlPanel.add(comboBox);
		
		hochWertBox = new JComboBox<>(new String [] {"Normal", "Hochwertig"});
		hochWertBox.addActionListener(e->changeOpPanelHochWert());
		hochWertBox.setBounds(280,10,100,20);
		wahlPanel.add(hochWertBox);
				
		namenArea = new JTextArea("");
		namenArea.setBounds(110, 10, 300, 20);
		
		namenLabel = new JLabel("Name:");
		namenLabel.setBounds(10, 10, 100, 20);
		namenLabel.setForeground(Color.white);
		
		teilNrArea = new JTextArea("");
		teilNrArea.setBounds(110, 40, 300, 20);
		
		teilNrLabel = new JLabel("TeileNr:");
		teilNrLabel.setBounds(10, 40, 100, 20);
		teilNrLabel.setForeground(Color.white);
		
		serienNrArea = new JTextArea("");
		
		serienNrLabel = new JLabel("SerienNr:");
		serienNrLabel.setForeground(Color.white);
		
		groesseArea = new JTextArea("");
		groesseArea.setBounds(110, 70, 300, 20);
		
		groesseLabel = new JLabel("Groesse:");
		groesseLabel.setBounds(10, 70, 100, 20);
		groesseLabel.setForeground(Color.white);
		
		einlagernButton = new JButton("Einlagern");
		einlagernButton.setBounds(110, 130, 100, 20);
		
		auslagernButton = new JButton("Auslagern");
		auslagernButton.setBounds(230, 130, 100, 20);
		
		messageArea = new JTextArea();
		messageArea.setBounds(110, 160, 300, 20);
		
		messageLabel = new JLabel("Message:");
		messageLabel.setBounds(40, 160, 80, 20);
		messageLabel.setForeground(Color.white);

		// Action listener --------------------------------------------------
		regal1.addActionListener(e-> anzeigen(1));
		regal2.addActionListener(e-> anzeigen(2));
		regal3.addActionListener(e-> anzeigen(3));
		regal4.addActionListener(e-> anzeigen(4));
		regal5.addActionListener(e-> anzeigen(5));
		regal6.addActionListener(e-> anzeigen(6));
		regal7.addActionListener(e-> anzeigen(7));
		regal8.addActionListener(e-> anzeigen(8));
		
		//Transportsystem in GUI---------------------------------------------
		auslagernButton.addActionListener(e->auslagern());
		einlagernButton.addActionListener(e->einlagern());
		changeOpPanel();
	}

	/**
	 * Diese Funktion nimmt die Werte aus teilNrArea, namenArea, und serienNrArea, falls notig ist. 
	 * Danach lagert diese Ware aus.
	 */
	public void auslagern()
	{
		String t;
		t = teilNrArea.getText();
		
		if(hochWertWahl.equals("Hochwertig"))
		{
			if(t.isEmpty())
			{
				String s;
				String n;
				s = serienNrArea.getText();
				n = namenArea.getText();
				if(n.isEmpty())
				{
					messageArea.setText("Geben Sie bitte die Name ein.");
				}
				else if (s.isEmpty())
				{
					messageArea.setText("Geben Sie bitte die Seriennummer ein");
				}
				else
				{
					messageArea.setText(data.auslagernNameHochWert(s,n));
					if(data.istGefunden())
					{
						anzeigen(data.getRegalNr());
					}
				}
				
			}
			else if(!t.isEmpty())
			{
				String s;
				s = serienNrArea.getText();
				if(s.isEmpty())
				{
					messageArea.setText("Geben Sie bitte die Seriennummer ein.");
				}
				else
				{
					messageArea.setText(data.auslagernHochWert(s,t));
					if(data.istGefunden())
					{
						anzeigen(data.getRegalNr());
					}
				}
			}
		}
		else if (hochWertWahl.equals("Normal"))
		{
			if(t.isEmpty())
			{
				String n = namenArea.getText();
				if(n.isEmpty())
				{
					messageArea.setText("Geben Sie bitte die Name oder Teilenummer ein.");
				}
				else
				{
					messageArea.setText(data.auslagernNameNormal(n));
					if(data.istGefunden())
					{
						anzeigen(data.getRegalNr());
					}
				}
				
			}
			else if(!t.isEmpty())
			{
				messageArea.setText(data.auslagernNormal(t));
				if(data.istGefunden())
				{
					anzeigen(data.getRegalNr());
				}
			}
			
		}
		
	}
	
	/**
	 * Diese Funktion nimmt die Werte aus teilNrArea, namenArea, groesseArea und serienNrArea, 
	 * dann lagert diese Ware ein.
	 */
	public void einlagern()
	{
		double g;
		String n,t,s;
		
		n=namenArea.getText();
		t=teilNrArea.getText();
		
		
		if(n.isEmpty())
		{
			messageArea.setText("Geben Sie bitte die Name ein.");
		}
		else
		{
			if(groesseArea.getText().isEmpty())
			{
				messageArea.setText("Geben Sie bitte die gultige Groesse ein.");
			}
			else
			{
				g=Double. parseDouble(groesseArea.getText());
				if(g<0 || g>8)
				{
					messageArea.setText("Geben Sie bitte die gultige Groesse ein.");
				}
				else
				{
					if(hochWertWahl.equals("Hochwertig") && t.isEmpty())
					{
						s=serienNrArea.getText();
						if(s.isEmpty())
						{
							messageArea.setText("Geben Sie bitte die Seriennummer ein.");
						}
						else
						{
							t = generierenRandomTeilNr();
							teilNrArea.setText(t);
							messageArea.setText(data.einlagern(n, t, s, g));
						}
						
					}
					else if(hochWertWahl.equals("Hochwertig") && !t.isEmpty())
					{
						s=serienNrArea.getText();
						if(s.isEmpty())
						{
							messageArea.setText("Geben Sie bitte die Seriennummer ein.");
						}
						else
						{
							messageArea.setText(data.einlagern(n, t, s, g));
						}
						
					}
					else if(hochWertWahl.equals("Normal") && !t.isEmpty())
					{
						s="";
						messageArea.setText(data.einlagern(n, t, s, g));
					}
					else if(hochWertWahl.equals("Normal") && t.isEmpty())
					{
						s="";
						t = generierenRandomTeilNr();
						teilNrArea.setText(t);
						messageArea.setText(data.einlagern(n, t, s, g));
					}
					
					if(data.istGefunden())
					{
						anzeigen(data.getRegalNr());
					}
				}
				
			}
			
		}
		
		
		
	}
	
	/**
	 * Diese Funktion nimmt int key, und zeigt die zugehörige Inhalt des Regals.
	 * @param key
	 */
	public void anzeigen(int key)
	{
		neuTable();
		inhaltLabel.setText("Das Inhalt des Regal "+key);
		for(int i = 0; i<10;i++)
		{
			for(int j = 0; j<10; j++)
			{
					inhaltTable.setValueAt(data.getRegal(key).getFachAt(i, j).printWarenName(),i,j);
			}
		}
		
	}
	
	/**
	 * Diese Funktion löscht den Inhalt von jtable.
	 */
	public void neuTable()
	{
		for(int i = 0; i<10;i++)
		{
			for(int j = 0; j<10; j++)
			{
				inhaltTable.setValueAt("", i, j);
			}
		}
	}
	
	/**
	 * Diese Funktion ändert den OperationPanel, wenn die Ware normal ist.
	 */
	public void changeOpPanel ()
	{
		wahl = (String) comboBox.getSelectedItem();
		operationPanel.removeAll();
		if (wahl.equals("Einlagern"))
		{
			operationPanel.add(einlagernButton);
			operationPanel.add(groesseArea);
			operationPanel.add(groesseLabel);
			operationPanel.add(namenArea);
			operationPanel.add(namenLabel);
			operationPanel.add(teilNrArea);
			operationPanel.add(teilNrLabel);
			operationPanel.add(messageArea);
			operationPanel.add(messageLabel);
		}
		else if(wahl.equals("Auslagern"))
		{
			operationPanel.add(auslagernButton);
			operationPanel.add(namenArea);
			operationPanel.add(namenLabel);
			operationPanel.add(teilNrArea);
			operationPanel.add(teilNrLabel);
			operationPanel.add(messageArea);
			operationPanel.add(messageLabel);
		}
		operationPanel.revalidate();
		operationPanel.repaint();
		changeOpPanelHochWert();
	}
	
	/**
	 * Diese Funktion ändert den OperationPanel, wenn die Ware hochwertig ist.
	 */
	public void changeOpPanelHochWert()
	{
		hochWertWahl = (String) hochWertBox.getSelectedItem();
		operationPanel.remove(serienNrArea);
		operationPanel.remove(serienNrLabel);
		
		if(hochWertWahl.equals("Hochwertig")&& wahl.equals("Auslagern"))
		{
			serienNrArea.setBounds(110, 70, 300, 20);
			serienNrLabel.setBounds(10, 70, 300, 20);
			operationPanel.add(serienNrArea);
			operationPanel.add(serienNrLabel);
		}
		else if (hochWertWahl.equals("Hochwertig")&& wahl.equals("Einlagern"))
		{
			serienNrArea.setBounds(110, 100, 300, 20);
			serienNrLabel.setBounds(10, 100, 300, 20);
			operationPanel.add(serienNrArea);
			operationPanel.add(serienNrLabel);
		}
		operationPanel.revalidate();
		operationPanel.repaint();
	}
	
	/**
	 * Speichert die alle Daten und schließt das Programm.
	 */
	public void exit()
	{
		data.speichern();
		System.exit(0);
	}
	
	//----------------Automatische Erzeugung der Teilnummern-----------------
	
	/**
	 * Diese Funktion erzeugt zufaellige Teilenummer und speichert sie in einem Set. 
	 * Wenn die neu generierte Teilenummer nicht mit allen Elementen der Menge übereinstimmt, wird sie zurückgegeben.
	 * @return String teilnummer.
	 */
	private String generierenRandomTeilNr() 
	{
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Set<String> usedTeilnummern = new HashSet<>();
	    String teilnummer;

	    do {
	        StringBuilder teilnummerBuilder = new StringBuilder();
	        for (int i = 0; i < 6; i++) {
	            int index = (int) (Math.random() * characters.length());
	            char randomChar = characters.charAt(index);
	            teilnummerBuilder.append(randomChar);
	        }
	        teilnummer = teilnummerBuilder.toString();
	    } while (!usedTeilnummern.add(teilnummer));

	    return teilnummer;
	}

	
}
