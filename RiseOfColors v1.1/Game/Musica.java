import java.applet.AudioClip;

public class Musica {
	boolean play, stop, loop;
	String file;
	AudioClip mySong;
	LoadArquivos carregar;

	public Musica() {
		
		carregar = new LoadArquivos();
		carregar.checkPasta("Musica");
		try {
			mySong = carregar.LoadMusica(0);
			mySong.loop();
		} catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			System.out.println("Por algum motivo a musica parou ");

		}
	}
}
