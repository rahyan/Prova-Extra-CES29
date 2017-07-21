package questao2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVReader {

    /*
     * OBSERVAÇÃO:
     * Para resolver essa questão, irei assumir que cada linha do documento possui informação
     * de um e apenas um User (que aparentemente eh o que o codigo assume a princípio)
     */
	
	
	//Metodo que ira sanitizar a entrada, para prevenir
	//code injections mal intencionados
	public static boolean ehFileNameLimpo(String fileName) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
		Matcher matcher = pattern.matcher(fileName);
		
		return !matcher.find();
	}
	
	//Metodo que usa tecnicas reflection para mudar o tamanho
	//de uma array em tempo de execucao
	public static Object changeArraySize(Object obj, int len) {
		Class<?> arr = obj.getClass().getComponentType();
		Object newArray = Array.newInstance(arr, len);
 
		//do array copy
		int co = Array.getLength(obj);
		System.arraycopy(obj, 0, newArray, 0, co);
		return newArray;
	}
	
	public static void main(String[] args) throws Exception {
		
		//Declaracoes locais da main
        String csvFile = "/Users/mkyong/csv/users.csv";
        String line = "";
        String cvsSplitBy = ",";
                     
	    if(ehFileNameLimpo(csvFile)) {    	        
	    	
	    	User[] users = new User[10];
	    	
	    	//os trys foram seperados para poder declarar o FileReader
	    	//e posteriormente fecha-lo
	    	try(FileReader fr = new FileReader(csvFile)) {
		    	try (BufferedReader br = new BufferedReader(fr)) {
		            
		        	for (int i = 0; (line = br.readLine()) != null; i++) {
		                
		        		//se o contador chegou no tamanho da array, aloca mais 10 espaços		        
		        	    if(users.length == i) changeArraySize(users, users.length + 10);
		        		
		        		// use comma as separator
		                String[] usersLine = line.split(cvsSplitBy);
		                User user = new User((usersLine[0]), usersLine[1], usersLine[2], 
		                		usersLine[3], usersLine[4]);
		                users[i]=user;
		                
		                
		            }
		        	
		        	//Depois de usar os readers, devemos fechar
			    	br.close(); fr.close();
		
		    	} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}
	    	
	    } else throw new Exception("Nome de arquivo de entrada inseguro!");
    }
}

