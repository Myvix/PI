import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Colisao {

	protected boolean colidiu = false;

	public Colisao() {

	};

	public boolean ColisaoInimigo(Entidade player, ArrayList<Rectangle2D> objeto) {

		for (int i = 0; i < player.getCorpo().size(); i++) {
			Rectangle2D testecolidiu = player.getCorpo().get(i).getBounds2D();

			for (int j = 0; j < objeto.size(); j++) {
				Rectangle2D a = objeto.get(j);
				Rectangle2D comparar = a.getBounds2D();

				if (testecolidiu.intersects(comparar)) {
					colidiu = true;
					System.out.println("Colidiu");
				} else
					colidiu = false;
			}

		}
		return colidiu;
	}

}
