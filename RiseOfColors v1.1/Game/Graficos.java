import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Graficos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ArrayList<Image> aux;
	static Personagem player;
	public static LoadArquivos carregar;
	int backgroundIndex;

	public Graficos() {
		
		character();
		backgroundIndex = aux.size();
	}

	public void paint(Graphics g) {
		g.drawImage(aux.get(backgroundIndex), 0, 0, null);
	}

	public static void character() {
		player = new Personagem();
		carregar = new LoadArquivos();
		aux = new ArrayList<Image>();
		try {
			for (int i = 0; i < carregar.checkPasta("Personagem"); i++) {
				aux.add(carregar.ImagemLoad(i));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, TratamentoDeErro.SendError(e));
		}

	}
}