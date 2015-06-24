import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadArquivos {

	protected BufferedImage carregarImagem;
	protected final String path = "D:/WorkSpace/RiseOfColors v1.1/Data/";
	protected String local;
	private int qntArquivos;
	protected File[] listaDeArquivos;
	protected File pasta;
	protected AudioClip musica;
	protected String texto;
	ArrayList<Integer> colisoes = new ArrayList<Integer>();

	public ArrayList<Integer> LoadTxt(int quantidade) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(listaDeArquivos[quantidade]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int tall = 0;
		while (scanner.hasNextInt()) {
			tall = scanner.nextInt();
			colisoes.add(tall);
			System.out.println(tall);

		}

		scanner.close();
		return colisoes;
	}

	public LoadArquivos() {
		carregarImagem = null;
		local = null;
		qntArquivos = 0;
		listaDeArquivos = null;
		pasta = null;
	}

	public AudioClip LoadMusica(int quantidade) {
		try {
			musica = Applet.newAudioClip(new URL("file:"
					+ listaDeArquivos[quantidade]));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, TratamentoDeErro.SendError(e));
		}
		return musica;
	}

	public BufferedImage ImagemLoad(int quantidade) {

		try {
			carregarImagem = ImageIO.read(listaDeArquivos[quantidade]);
			// System.out.println(local + listaDeArquivos);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, TratamentoDeErro.SendError(e));
			// System.out.println(local +
			// listaDeArquivos[quantidade].getPath());
		}

		return carregarImagem;
	}

	public int checkPasta(String tipo) {
		String local = null;
		if (pasta != null) {
			pasta = null;
		}
		if (listaDeArquivos != null) {
			listaDeArquivos = null;
		}
		switch (tipo) {
		case "Personagem":
			local = "Imagem/Personagens/";
			break;
		case "Mapa":
			local = "Imagem/Mapa/";
			break;
		case "Musica":
			local = "Audio/";
			break;
		case "txt":
			local = "Texto/";
			break;
		case "Hp":
			local = "Imagem/Interface/sp/";
			break;
		case "Menu":
			local = "Imagem/Interface/Menu/";
			break;
		default:
			if (tipo.equals(null))
				local = "";
			else
				local = tipo + "/";
			break;
		}
		pasta = new File(path + local);
		listaDeArquivos = pasta.listFiles();
		try {
			qntArquivos = listaDeArquivos.length;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, TratamentoDeErro.SendError(e));
		}
		// System.out.println(local + qntArquivos);
		return qntArquivos;
	}
}
