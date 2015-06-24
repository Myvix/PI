import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

public class TratamentoDeErro {
	protected static String mensagem;

	
	
	public static String SendError(Exception e) {
		mensagem = "Erro Desconhecido";

		Logger rows = Logger.getLogger(e.getLocalizedMessage());
		if (e instanceof NullPointerException) {
			mensagem = "Falha ao inicar objeto! Por Favor Contate o suporte.";
		}
		if (e instanceof IOException) {
			mensagem = "Path do arquivo incorreto! Por Favor Contate o suporte.";
		}

		if (e instanceof InterruptedException) {
			mensagem = "Falha de Execução da aplicação! Por Favor Contate o suporte.";
		}
		if (e instanceof MalformedURLException) {
			mensagem = "Não foi possivel carregar a musica! Por Favor Contate o suporte.";
		}
		rows.log(null, "Incidencia!", e);

		if (e instanceof ArrayIndexOutOfBoundsException) {
			mensagem = "Arquivo Corrompido ou inexistente! Por Favor Contate o suporte.";
		}
		if (e instanceof FileNotFoundException) {
			mensagem = "Arquivo Corrompido ou inexistente! Por Favor Contate o suporte.";
		}

		rows.log(null, "Incidencia!", e);

		return mensagem;
	}

}
