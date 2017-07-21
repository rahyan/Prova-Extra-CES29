package questao3;

public class Matematica { 
	public int fibonacci(int numero) {  
		if (numero >= 0) {  
			if (numero == 0) return 0;  
			if (numero == 1) return 1;  
				return fibonacci(numero-1) + fibonacci(numero-2);  
		}   
		throw new IllegalArgumentException();  
	}
}
