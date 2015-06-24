import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jogo extends JFrame implements Runnable {

	private static final long serialVersionUID = 98349827539845637L;
	protected static int largura = 300;
	protected static int altura = largura / 16 * 9;// proporção para resolução
	protected static int escala = 3;
	protected static String titulo = "Raise of Color";
	public boolean rodando;
	public boolean pausado = false;
	private int FPS = 30;
	protected Musica bgm;
	public Level mapa;
	public ImagemPanel map = new ImagemPanel();
	Thread game;
	Comandos jogador;
	Personagem usuario;
	public static Estado etapa;

	public static void main(String[] args) {
		// Reference https://www.youtube.com/watch?v=gHh_96Ss1AI
		Jogo init = new Jogo();
		init.Start();

	}

	private synchronized void Start() {
		if (rodando) {
			return;
		}

		rodando = true;
		game = new Thread(this);
		game.start();

	}

	@Override
	public void run() {

		initialize();

		while (rodando) {
			long time = System.currentTimeMillis();
			input();
			Update();
			Render();

			time = (1000 / FPS) - (System.currentTimeMillis() - time);

			if (time > 0) {
				try {
					Thread.sleep(time);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, TratamentoDeErro.SendError(e));
				}
			}
		}

		setVisible(false);
	}

	private void initialize() {

		setMaximumSize(new Dimension(altura * escala, largura * escala));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle(titulo);
		map.setSize(new Dimension(800, 600));
		jogador = new Comandos();
		usuario = new Personagem();
		addKeyListener(map.player.controle);
		add(map);
		bgm = new Musica();

	}

	private void Render() {

		repaint();	
	}

	private void Update() {

	}

	protected void input() {
		map.player.controle.Teclado();
		map.player.Movimento();
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);

	}
}
