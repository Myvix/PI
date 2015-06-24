import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Personagem extends Entidade {
	protected Comandos controle;
	private ArrayList<Image> hp;
	public ArrayList<Rectangle2D> mundo;

	public int speed = 2;

	public Personagem() {
		carregar = new LoadArquivos();
		posicao = new Point();
		posicao.x = 344;
		posicao.y = 266;
		setLife(0);
		controle = new Comandos();
		CriarCorpo();
		setHp(new ArrayList<Image>());
		mundo = new ArrayList<Rectangle2D>();
		CriarHP();
		CriarMundo();

	}

	private void CriarMundo() {

		mundo.add(new Rectangle2D.Float(170, 89, 0, 89));
		mundo.add(new Rectangle2D.Float(168, 0, 168, 277));
		mundo.add(new Rectangle2D.Float(600, 458, 458, 0));
		mundo.add(new Rectangle2D.Float(164, 163, 163, 0));

	}

	private void CriarHP() {
		for (int i = 0; i < carregar.checkPasta("Hp"); i++) {
			getHp().add(carregar.ImagemLoad(i));
		}

	}

	public Image HpAtual() {
		if (getHp().isEmpty())
			CriarHP();

		return getHp().get(getLife());

	}

	public String MenuControl() {
		String escolha = "New";

		if (controle.cima)
			if (escolha != "New") {
				escolha = "New";
				return escolha;

			}
		if (controle.baixo)
			if (escolha != "Quit") {
				escolha = "Quit";

			}
		if (controle.aceitar) {
			if (escolha == "New")
				return escolha = "Fase";
			if (escolha.equals("Quit"))
				return escolha = "Sair";
		}

		return escolha;
	}

	@SuppressWarnings("unused")
	public Image Movimento() {
		int lastposicaoY = 11, posicaoInicial = 9;
		Image aux = anim.get(11);

		if (controle.baixo) {
			posicao.y += speed;
			if (lastposicaoY != posicao.y)
				posicaoInicial++;

			if (posicaoInicial <= 11)
				aux = anim.get(posicaoInicial);

			else
				posicaoInicial = 6;
		}

		if (controle.esquerda) {
			posicao.x -= 2;
			for (int i = 6; i < 8; i++) {
				return aux = anim.get(i);
			}
		}
		if (controle.direita) {
			posicao.x += 2;
			for (int i = 3; i < 5; i++) {
				return aux = anim.get(i);

			}
		}
		if (controle.cima) {
			posicao.y -= 2;
			for (int i = 0; i < 2; i++)
				return aux = anim.get(i);

		}
		return aux;
	}

	public ArrayList<Image> getHp() {
		return hp;
	}

	public void setHp(ArrayList<Image> hp) {
		this.hp = hp;
	}
}
