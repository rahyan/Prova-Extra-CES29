package questao2;

public class Conta {
	private String login;
	private String senha;
	private double saldo;

	public Conta (String login, String senha) {
		this.login = login;
		this.senha = senha;
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;
	}
	
	public String getLogin() {
		return this.login;
	}

	
	//Considerei um absurdo existir esse metodo heheheh, minha solucao foi criar
	//uma sublclasse no caixa eletronico para auxiliar (ver (*) na classe CaixaEletronico)
	/*
	public String getSenha() {
		return this.senha;
	} */
}