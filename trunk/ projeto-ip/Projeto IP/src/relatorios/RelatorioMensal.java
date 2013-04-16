package relatorios;

import interfaces.Iterator;
import dados.carros.Carro;

public class RelatorioMensal implements java.io.Serializable, Iterator<ObjetoBase>{
	private ObjetoBase[] meses; 
	private int count = 0;
	
	public RelatorioMensal(){
		this.meses = new ObjetoBase[0];
	}
	
	public void inserirDados(ObjetoBase data) {
		ObjetoBase[] auxArray = this.meses;
		this.meses = new ObjetoBase[meses.length +1];
		for (int i = 0; i < auxArray.length; i++) {
			this.meses[i] = auxArray[i];
		}
		this.meses[meses.length - 1] = data;
	}

	public ObjetoBase next() {
		count++;
		return meses[count -1];
	}

	@Override
	public boolean hasNext() {
		if(count < meses.length)
			return true;
		else
			return false;
		
	}

	@Override
	public Iterator iterator() {
		return this;
	}
	
}
