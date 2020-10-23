import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Versiotiedot extends JFrame{
	public Versiotiedot() {
		setTitle("Juoma-automaatti GUI v.1.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 284, 170);
		JLabel lblNewLabel = new JLabel("     JUOMA-AUTOMAATTI V.1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	
}
