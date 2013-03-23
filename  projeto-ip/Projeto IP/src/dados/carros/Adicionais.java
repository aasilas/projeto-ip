package dados.carros;


public class Adicionais {

	private boolean ar;
	private boolean gps;
	private boolean travasEletricas;
	private boolean som;
	private boolean freioABS;
	private boolean airbag;
	private boolean dirHidraulica;
	
	public Adicionais(boolean ar, boolean gps, boolean travas, boolean som, boolean freios, boolean airbag, boolean dirHidraulica){
		this.ar = ar;
		this.gps = gps;
		this.travasEletricas = travas;
		this.som = som;
		this.freioABS = freios;
		this.airbag = airbag;
		this.dirHidraulica = dirHidraulica;
	}

	public boolean isAr() {
		return ar;
	}

	public void setAr(boolean ar) {
		this.ar = ar;
	}

	public boolean isGps() {
		return gps;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}

	public boolean isTravasEletricas() {
		return travasEletricas;
	}

	public void setTravasEletricas(boolean travasEletricas) {
		this.travasEletricas = travasEletricas;
	}

	public boolean isSom() {
		return som;
	}

	public void setSom(boolean som) {
		this.som = som;
	}

	public boolean isFreioABS() {
		return freioABS;
	}

	public void setFreioABS(boolean freioABS) {
		this.freioABS = freioABS;
	}

	public boolean isAirbag() {
		return airbag;
	}

	public void setAirbag(boolean airbag) {
		this.airbag = airbag;
	}

	public boolean isDirHidraulica() {
		return dirHidraulica;
	}

	public void setDirHidraulica(boolean dirHidraulica) {
		this.dirHidraulica = dirHidraulica;
	}
	
	
}
