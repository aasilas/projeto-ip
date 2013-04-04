package exceptions;

public class CCException extends Exception {

	public CCException(){
		super("Há um cliente cadastrado com o mesmo cpf.");
	}
}
