package exceptions;

public class FCException extends Exception{
	
	public FCException(){
		super("Há um funcionário cadasatrado com o mesmo cpf.");
	}
}
