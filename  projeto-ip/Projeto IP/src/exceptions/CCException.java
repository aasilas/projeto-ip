package exceptions;

public class CCException extends Exception {

	public CCException(){
		super("Há um item cadastrado com o mesmo cpf .");
	}
}
