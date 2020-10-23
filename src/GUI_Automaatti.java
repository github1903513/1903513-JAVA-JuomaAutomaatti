import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell‰‰n t‰‰ll‰ jotta komponentteihin voidaan viitata mist‰ tahansa luokan
	// sis‰lt‰

	JPanel contentPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;
	
	

	/**
	 * Main-metodi, joka k‰ynnist‰‰ sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();
					Sarjallistamista Sarjallistamista = new Sarjallistamista();

					// K‰yttˆliittym‰ saa parametrina olion, jonka tiedot se n‰ytt‰‰
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k‰yttˆliittym‰. Huomaa, ett‰ otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T‰m‰ siksi, ett‰ voidaan n‰ytt‰‰ sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel kahviLabel = new JLabel("Kahvi");
		kahviLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kahviLabel.setBounds(83, 221, 49, 14);
		contentPane.add(kahviLabel);
		
		JLabel teeLabel = new JLabel("Tee");
		teeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		teeLabel.setBounds(83, 425, 49, 14);
		contentPane.add(teeLabel);
		
		JLabel kaakaoLabel = new JLabel("Kaakao");
		kaakaoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kaakaoLabel.setBounds(83, 625, 62, 14);
		contentPane.add(kaakaoLabel);
		
		JLabel kahviLabel_1 = new JLabel("Kahvi:50");
		kahviLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kahviLabel_1.setBounds(224, 152, 139, 14);
		contentPane.add(kahviLabel_1);
		
		JLabel teeLabel_1 = new JLabel("Tee:50");
		teeLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		teeLabel_1.setBounds(224, 351, 120, 14);
		contentPane.add(teeLabel_1);
		
		JLabel kaakaoLabel_1 = new JLabel("Kaakao:50");
		kaakaoLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kaakaoLabel_1.setBounds(224, 530, 104, 14);
		contentPane.add(kaakaoLabel_1);
		
		JButton kahviButton = new JButton("New button");
		kahviButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kahviButton.setIcon(new ImageIcon("C:\\Zhang\\Laurea\\Java\\JuomaAutomaatti\\img\\coffee.jpg"));
		kahviButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
				    {
					 int sumaKahvi = ja.tilaaKahvi();
					 if(sumaKahvi == 0)
						{
							kahviLabel_1.setText("kahvi‰ ei ole en‰‰ j‰ljell‰!");
						}
						else if (sumaKahvi < 20)
						{ 
							kahviLabel_1.setText("Kahvi:"+ sumaKahvi);
							kahviLabel_1.setForeground(Color.RED);
						}
						else
						{
							kahviLabel_1.setText("Kahvi:"+ sumaKahvi);
						}
				    }
				    catch(Exception ex)
				    { 
				    	JOptionPane.showMessageDialog(null, "Please input Celsius and click the convert button!");
				     }
			}
		});
		kahviButton.setBounds(73, 75, 112, 135);
		contentPane.add(kahviButton);
		
		JButton teeButton = new JButton("New button");
		teeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
			    {
				 int sumaTee = ja.tilaaTee();
				 if(sumaTee == 0)
					{
					 teeLabel_1.setText("Teet‰ ei ole en‰‰ j‰ljell‰!");
					}
					else if (sumaTee < 20)
					{ 
						teeLabel_1.setText("Tee:"+ sumaTee);
						teeLabel_1.setForeground(Color.RED);
					}
					else
					{
						teeLabel_1.setText("Tee:"+ sumaTee);
					}
			    }
			    catch(Exception ex)
			    { 
			    	JOptionPane.showMessageDialog(null, "Erro !");
			     }
			}
		});
		teeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		teeButton.setIcon(new ImageIcon("C:\\Zhang\\Laurea\\Java\\JuomaAutomaatti\\img\\tea.jpg"));
		teeButton.setBounds(73, 265, 112, 135);
		contentPane.add(teeButton);
		
		JButton kaakaoButton = new JButton("New button");
		kaakaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
				 int sumaKaakao = ja.tilaaKaakao();
				 if(sumaKaakao == 0)
					{
					 kaakaoLabel_1.setText("Kaakao ei ole en‰‰ j‰ljell‰!");
					}
					else if (sumaKaakao < 20)
					{ 
						kaakaoLabel_1.setText("Kaakao:"+ sumaKaakao);
						kaakaoLabel_1.setForeground(Color.RED);
					}
					else
					{
						kaakaoLabel_1.setText("Kaakao:"+ sumaKaakao);
					}
			    }
			    catch(Exception ex)
			    { 
			    	JOptionPane.showMessageDialog(null, "Erro !");
			     }
			}
		});
		kaakaoButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kaakaoButton.setIcon(new ImageIcon("C:\\Zhang\\Laurea\\Java\\JuomaAutomaatti\\img\\cocoa.jpg"));
		kaakaoButton.setBounds(73, 468, 112, 135);
		contentPane.add(kaakaoButton);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(10, 11, 399, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Yll\u00E4pito");
		menuBar.add(mnNewMenu);
		
		JMenuItem teeYll‰pito = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		teeYll‰pito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
					int uusiTee = Integer.parseInt(uusiArvo);
					if (uusiTee >= 20)
					{
						teeLabel_1.setForeground(Color.black);
						teeLabel_1.setText("Tee:"+ uusiTee);
						ja.setTee(uusiTee);
					}
					else if(uusiTee > 0)
					{
						teeLabel_1.setForeground(Color.RED);
						teeLabel_1.setText("Tee:"+ uusiTee);
						ja.setTee(uusiTee);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid data!");
					}
					

				}
				catch(Exception ex)
			    { 
					ja.setTee(0);
					JOptionPane.showMessageDialog(null, "Please enter a valid data!");
			     }
			}
		});
		mnNewMenu.add(teeYll‰pito);
		
		JMenuItem kahvinYll‰pito = new JMenuItem("Aseta Kahvin m\u00E4\u00E4r\u00E4");
		kahvinYll‰pito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
					int uusiKahvi = Integer.parseInt(uusiArvo);
					if (uusiKahvi >= 20)
					{
						kahviLabel_1.setForeground(Color.black);
						kahviLabel_1.setText("Kahvi:"+ uusiKahvi);
						ja.setKahvi(uusiKahvi);
					}
					else if(uusiKahvi > 0)
					{
						kahviLabel_1.setForeground(Color.RED);
						kahviLabel_1.setText("Kahvi:"+ uusiKahvi);
						ja.setKahvi(uusiKahvi);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid data!");
					}

				}
				catch(Exception ex)
			    { 
					ja.setKahvi(0);
					JOptionPane.showMessageDialog(null, "Please enter a valid data!");
			     }
			}
		});
		mnNewMenu.add(kahvinYll‰pito);
		
		JMenuItem kaakaoYll‰pito = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		kaakaoYll‰pito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
					int uusiKaakao = Integer.parseInt(uusiArvo);
					if (uusiKaakao >= 20)
					{
						kaakaoLabel_1.setForeground(Color.black);
						kaakaoLabel_1.setText("Kaakao:"+ uusiKaakao);
						ja.setKaakao(uusiKaakao);
					}
					else if(uusiKaakao > 0)
					{
						kaakaoLabel_1.setForeground(Color.RED);
						kaakaoLabel_1.setText("Kaakao:"+ uusiKaakao);
						ja.setKaakao(uusiKaakao);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid data!");
					}

				}
				catch(Exception ex)
			    { 
					ja.setKaakao(0);
					JOptionPane.showMessageDialog(null, "Please enter a valid data!");
			     }
			}
		});
		mnNewMenu.add(kaakaoYll‰pito);
		
		JMenuItem tallennaYll‰pito = new JMenuItem("Tallenna automaatin tila");
		tallennaYll‰pito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Sarjallistamista.kirjoitaTiedostoon(ja);
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Save the xml file error!");
				}
			}
		});
		mnNewMenu.add(tallennaYll‰pito);
		
		JMenuItem LataaYll‰pito = new JMenuItem("Lataa automaatti");
		LataaYll‰pito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
				
					kaakaoLabel_1.setText("Kaakao:"+ uusi.getKaakao());
					teeLabel_1.setText("Tee:"+ uusi.getTee());
					kahviLabel_1.setText("Kahvi:"+ uusi.getKahvi());
					
					if(uusi.getKaakao() < 20) kaakaoLabel_1.setForeground(Color.RED); else kaakaoLabel_1.setForeground(Color.black);
					if(uusi.getKahvi() < 20) kahviLabel_1.setForeground(Color.RED);else kahviLabel_1.setForeground(Color.black);
					if(uusi.getTee() < 20) teeLabel_1.setForeground(Color.RED);else teeLabel_1.setForeground(Color.black);
					
					ja.setKaakao(uusi.getKaakao());
					ja.setKahvi(uusi.getKahvi());
					ja.setTee(uusi.getTee());
					
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "load the xml file error!");
				}
				
			}
		});
		mnNewMenu.add(LataaYll‰pito);
		
		JMenuItem LopetaYll‰pito = new JMenuItem("Lopeta");
		LopetaYll‰pito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnNewMenu.add(LopetaYll‰pito);
		
		JMenu mnNewMenu_1 = new JMenu("Ohjelmasta");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem versioTietoja = new JMenuItem("Versiontiedot");
		versioTietoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Versiotiedot ikkuna = new Versiotiedot();
				ikkuna.setVisible(true);
			}
		});
		mnNewMenu_1.add(versioTietoja);
		
		JMenuItem ohjeTietoja = new JMenuItem("Ohje");
		mnNewMenu_1.add(ohjeTietoja);
	}
}
