package principal;

public class Util {
	public static boolean cpfValido(String cpfNumber){
		char[] cpf = String.valueOf(cpfNumber).toCharArray();
		if (cpf.length == 11) {
			int dgt1 = 0, dgt2 = 0;
			for (int i = 0, j = 11; i < (cpf.length - 2); i++, j--) {
				dgt1 += getIntOfChar(cpf[i]) * (j - 1);
				dgt2 += getIntOfChar(cpf[i]) * (j);
			}

			dgt1 = (dgt1 % 11 >= 2 ? 11 - (dgt1 % 11) : 0);
			dgt2 = (dgt2 + dgt1 * 2);
			dgt2 = (dgt2 % 11 >= 2 ? 11 - (dgt2 % 11) : 0);

			if (dgt1 == getIntOfChar(cpf[cpf.length - 2])
					&& dgt2 == getIntOfChar(cpf[cpf.length - 1])) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
private static int getIntOfChar(char value) {
	return Character.getNumericValue(value);
}

}
