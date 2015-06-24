import java.awt.Insets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Level extends JPanel {

	private static final long serialVersionUID = 2L;

	ArrayList<JPanel> camadas;
	JPanel aux;
	public LoadArquivos pegar;
	BufferedImage Imagem;
	Insets local;

	public JPanel GetLevelAtual() {

		return drawGamePanel();

	}

	public JPanel drawGamePanel() {
		pegar = new LoadArquivos();
		JPanel gamePanel = new JPanel();

		return gamePanel;
	}


}
