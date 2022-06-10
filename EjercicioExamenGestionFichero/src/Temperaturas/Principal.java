package Temperaturas;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException{
	try {
		FileReader lectura = new FileReader("./temperaturas.txt"); 
		Scanner entrada = new Scanner(lectura);
		
		//variables
		String lugar;
		double valor;
		String medida;
		double total=0;
		//contador de medidas
		int cont=0;
		
		//array que guarda las temperaturas
		ArrayList <Temperatura> listaTemperaturas = new ArrayList<Temperatura>();
		
		//Bucle para guardar todos los datos como objetos de tipo temperatura
		while(entrada.hasNext()==true) {
			//tomo los tres valores
			lugar=entrada.next();
			valor=entrada.nextDouble();
			medida=entrada.next();
			//los añado en el array de temperaturas
			listaTemperaturas.add(new Temperatura(lugar,valor,medida));
			//para contar cada temperatura añadida
			cont++;
		}
		
		//ahora necesito recorrer el array de temperaturas y tratar todas las temperaturas por igual
		for (int i=0;i<listaTemperaturas.size()-1;i++) {
			if(listaTemperaturas.get(i).getMedida().equalsIgnoreCase("C")) {
				total=total+listaTemperaturas.get(i).getValor();
			} else {
				double faToCel = listaTemperaturas.get(i).getValor();
				faToCel=(faToCel-32)/1.80;
				total=total+faToCel;
			}
		}
		
		System.out.println("Ha habido un total de "+cont+" temperaturas medidas");
		
		System.out.println("La media de temperaturas medidas es de "+total/cont+ " grados Celsius");
		
		System.out.println("Las medidas recogidas son las siguientes:");
		//Lo recorro inverso a como esta introducido en el fichero(Los ultimos los muestro primero)
		for(int i=listaTemperaturas.size()-1;i>=0;i--) {
			System.out.println("La temperatura captada en "+listaTemperaturas.get(i).getLugar()+" ha sido de "+listaTemperaturas.get(i).getValor()+" "+listaTemperaturas.get(i).getMedida());
		}
		entrada.close();
	} catch (FileNotFoundException e) {
		System.out.println("No encuentro el archivo");
	}
	
	}

}
