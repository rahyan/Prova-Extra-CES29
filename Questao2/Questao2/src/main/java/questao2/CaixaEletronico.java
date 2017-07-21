package questao2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaixaEletronico {
	
	//(*)
	//essa classe ira permitir que o caixa armazene os pares de login e senha
	//das contas cadastradas, sem precisar pedir informacao pra classe Conta
	private class conta_cadastrada {
		String login;
		String senha;
		Conta conta;
		
		public conta_cadastrada(String login_, String senha_, Conta c) {
			this.login = login_;
			this.senha = senha_;
			this.conta = c;
		}
	}
	
	private static boolean logado; //esse boolean indica o estado caixa, logado ou deslogado
	private static Conta conta; //aqui sera armazenada a conta que esta sendo utilizada
	private ArrayList<conta_cadastrada> contas = new ArrayList<conta_cadastrada> (); //aqui serao armazenadas as contas que sao criadas
													   //poderia ser implementado com banco de dados,
												       //mas foge do escopo do curso
	
	//Criando instancia do CaixaEletronico
	private static CaixaEletronico caixa = new CaixaEletronico();
	
	//tornando o construtor privado para que a classe nao
	//possa ser instanciada
	private CaixaEletronico(){;}
	
	//funcao que retorna a unica instancia disponivel
	public static CaixaEletronico getInstance(){
		logado = false;
		conta = null;
		return caixa;
	}
	
	public boolean logado() {
		return logado;
	}
	
	public Conta getContaAtual() {
		return conta;
	}
	
	//metodo que decide se senha eh forte
	public boolean senhaValida(String senha) {

		boolean senhaValida;
		
		Pattern peloMenosUmNumero = Pattern.compile(".*[0-9].*");
		Pattern peloMenosUmaLetra = Pattern.compile(".*[a-zA-Z].*");
		Pattern peloMenosUmCaractereEspecial = Pattern.compile(".*[%!$&+,:;=?@#|/*].*");
		Pattern peloMenos8Caracteres = Pattern.compile(".{8,}");
		Matcher m1 = peloMenosUmNumero.matcher(senha);
    	Matcher m2 = peloMenosUmaLetra.matcher(senha);
    	Matcher m3 = peloMenosUmCaractereEspecial.matcher(senha);
    	Matcher m4 = peloMenos8Caracteres.matcher(senha);
    	
    	senhaValida = m1.matches() && m2.matches() && m3.matches() && m4.matches();

    	return senhaValida;
	}
	
	//metodo que verifica se login existe no banco de dados do caixa,
	//ou seja, se ele eh um login valido para ser escolhido
	public boolean procuraConta(String login) {
		
		boolean contaExiste = false;
		for(conta_cadastrada c : contas) {
  		  if(login.equals(c.login)) contaExiste = true;
		}
		return contaExiste;
	}
	
	public boolean criarConta(String login, String senha) {
		
		//se nao esta logado, pode fazer
		if(!logado()) {
	    	//Se o login nao existir na base de dados e a senha for valida, cria a conta
	    	if(!procuraConta(login) && senhaValida(senha)) {;
	    		contas.add(new conta_cadastrada(login, senha, (new Conta(login, senha))));
	    		return true;
	    	}
	    	
	    	else return false;
		}
		
		//se esta logado, deve deslogar antes
		else return false;
	}
	
	public boolean logarConta(String login, String senha) {
		
		boolean logou = false;
		
		//se nao esta logado, pode logar
		if(!logado()) {
			for(conta_cadastrada c : contas) {
		  		  if(login.equals(c.login) && senha.equals(c.senha)) {
		  			  this.conta = c.conta;
		  			  logou = true;
		  			  logado = true;
		  		  }
			}
		}
		
		return logou;
	}
	
	public double saldo() {
		
		//se esta logado, deve retornar o saldo
		if(logado()) {
			return conta.getSaldo();
		}
		
		else return -99999999; //um valor negativo absurdo que o banco nao permitiria alguem estar devendo
	}
	
	public boolean deposito(double valor) {
		
		//se esta logado e valor do deposito eh positivo, deve realizar o deposito
		if(logado() && valor > 0) {
			conta.setSaldo(saldo() + valor);
			return true;
		}
		//se nao esta logado, nao faz nada
		else return false;
	}

	public boolean pagamento(double valor) {
		
		//se esta logadoe e valor do pagamento eh positivo, deve realizar o pagamento
		if(logado() && valor > 0) {
			conta.setSaldo(saldo() - valor); //nao tem problema o saldo ficar negativo
			return true;
		}
		
		//se nao esta logado, nao faz nada
		else return false;
	}
	
	public boolean deslogar() {
	
		//se esta logado, pode deslogar
		if(logado()) {
			this.conta = null;
			logado = false;
			return true;
		}
		
		//se nao esta logado, nao faz nada
		else return false;
	}
}

