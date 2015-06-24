import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ImagemPanel extends JPanel {
	private static final long serialVersionUID = -533152572560022519L;
	private Image fundo;
	private Image person;
	protected LoadArquivos carregar;
	public Personagem player;
	protected ArrayList<Image> opcoes;
	protected String situacao = "Menu";
	protected Colisao fisica;

	public ImagemPanel() {

		player = new Personagem();
		carregar = new LoadArquivos();
		opcoes = new ArrayList<Image>();

		if (situacao == "Menu") {

			for (int i = 0; i < carregar.checkPasta(situacao); i++) {
				opcoes.add(carregar.ImagemLoad(i));
			}
			fundo = opcoes.get(0);

		}
		if (situacao == "Fase") {
			carregar.checkPasta("Mapa");
			System.out.println(carregar.listaDeArquivos);
			fundo = carregar.ImagemLoad(0);
			player.CriarCorpo();
			fisica = new Colisao();
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillRect(0, 0, getWidth(), getHeight());
		if (situacao == "Menu") {
			g.drawImage(fundo, 0, 0, null);
			switch (player.MenuControl()) {
			case "New":
				g.drawImage(opcoes.get(2), 250, 290, null);
				g.drawImage(opcoes.get(3), 250, 350, null);
				break;

			case "Quit":
				g.drawImage(opcoes.get(1), 250, 290, null);
				g.drawImage(opcoes.get(4), 250, 350, null);
				break;

			case "Fase":
				situacao = "Fase";
				fundo = Selecionarfase();
				break;

			case "Sair":
				System.exit(0);
				break;

			default:
				break;
			}

		}
		if (situacao == "Fase") {

			g.drawImage(fundo, 0, 0, null);

			g.drawImage(player.Movimento(), player.posicao.x, player.posicao.y,
					null);

			for (int i = 0; i < player.getHp().size(); i++)
				g.drawImage(player.HpAtual(), 0, 0, this);
		}
		g.dispose();
		//fisica.ColisaoInimigo(player, player.mundo);
	}

	public Image Selecionarfase() {
		carregar.checkPasta("Mapa");
		fundo = carregar.ImagemLoad(0);
		return fundo;
	}

	public Image getPerson() {
		return person;
	}

	public void setPerson(Image person) {
		this.person = person;
	}
}