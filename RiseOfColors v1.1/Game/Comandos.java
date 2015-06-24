import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Comandos implements KeyListener {
	private boolean[] botao = new boolean[256];
	public boolean cima, baixo, esquerda, direita, aceitar, voltar, atacar,
			defender;

	public void Teclado() {
		cima = botao[KeyEvent.VK_UP] || botao[KeyEvent.VK_W];
		baixo = botao[KeyEvent.VK_DOWN] || botao[KeyEvent.VK_S];
		esquerda = botao[KeyEvent.VK_LEFT] || botao[KeyEvent.VK_A];
		direita = botao[KeyEvent.VK_RIGHT] || botao[KeyEvent.VK_D];
		aceitar = botao[KeyEvent.VK_ENTER] || botao[KeyEvent.VK_U];
		voltar = botao[KeyEvent.VK_BACK_SPACE] || botao[KeyEvent.VK_I];
		atacar = botao[KeyEvent.VK_Z] || botao[KeyEvent.VK_J];
		defender = botao[KeyEvent.VK_X] || botao[KeyEvent.VK_K];
	}

	public void Teclado(KeyEvent e) {

		cima = botao[KeyEvent.VK_UP] || botao[KeyEvent.VK_W];
		baixo = botao[KeyEvent.VK_DOWN] || botao[KeyEvent.VK_S];
		esquerda = botao[KeyEvent.VK_LEFT] || botao[KeyEvent.VK_A];
		direita = botao[KeyEvent.VK_RIGHT] || botao[KeyEvent.VK_D];
		aceitar = botao[KeyEvent.VK_ENTER] || botao[KeyEvent.VK_U];
		voltar = botao[KeyEvent.VK_BACK_SPACE] || botao[KeyEvent.VK_I];
		atacar = botao[KeyEvent.VK_Z] || botao[KeyEvent.VK_J];
		defender = botao[KeyEvent.VK_X] || botao[KeyEvent.VK_K];

	}

	public void JoyStick() {

	}

	public void keyPressed(KeyEvent e) {
		botao[e.getKeyCode()] = true;

	}

	public void keyReleased(KeyEvent e) {
		botao[e.getKeyCode()] = false;

	}

	public void keyTyped(KeyEvent e) {

	}

}
