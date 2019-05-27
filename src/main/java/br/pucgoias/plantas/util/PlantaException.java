package br.pucgoias.plantas.util;

/**
 * Classe que encapsula as excecoes da aplicacao Plantas
 * @author Adriano Mendonca
 *
 */
public class PlantaException extends Exception {
	
	private static final long serialVersionUID = 1189188521388183949L;
	private Exception ex;
	private String msg;

	public PlantaException(Exception e){
		ex = e;
		msg = e.getMessage();
	}

	public PlantaException(Exception e, String mensagem){
		e.printStackTrace();
		ex = e;
		msg = mensagem;
	}

	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}
	
}
