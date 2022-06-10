package Temperaturas;

public class Temperatura {
	
	private String lugar;
	private double valor;
	private String medida;
	
	public Temperatura(String lugar, double valor, String medida){
		this.lugar=lugar;
		this.valor=valor;
		this.medida=medida;
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getMedida() {
		return medida;
	}
	
	
}
