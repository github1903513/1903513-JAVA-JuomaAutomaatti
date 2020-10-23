import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Sarjallistamista {

	// Otetaan vastaan juoma-automaatti-olio ja kirjoitetaan se XML-muotoisena
	// tiedostoon
	public static void kirjoitaTiedostoon(JuomaAutomaatti ja) throws IOException {

		// XML:n kirjoittamista varten
		
		try
		{
		FileOutputStream tiedosto = new FileOutputStream("Automaatti.xml");
		XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(tiedosto));
		
		JuomaAutomaatti p = new JuomaAutomaatti();

		p.setKahvi(ja.getKahvi());
		p.setTee(ja.getTee());
		p.setKaakao(ja.getKaakao());
		
		// Kirjoitetaan olio XML-muotoiseen tiedostoon
		enc.writeObject(p);

		// Lopputoimet tiedostoille
		enc.close();
		tiedosto.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		//throw new IOException("file handle error");
	}

	public static JuomaAutomaatti lueTiedostosta() throws FileNotFoundException {

		XMLDecoder dec = null;
		
		FileInputStream tiedosto = new FileInputStream("Automaatti.xml");
		dec = new XMLDecoder(new BufferedInputStream(tiedosto));
		JuomaAutomaatti luettu = (JuomaAutomaatti) dec.readObject();

		// Lopputoimet
		dec.close();
		
		// Palautetaan tiedostosta luettu automaatti
		return luettu;
		
	}

}