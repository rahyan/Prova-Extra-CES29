import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import questao2.CaixaEletronico;

public class integrationTestingIT {
	
	static CaixaEletronico caixa;
	static String login1, login2, login3, login4, login5,
		   login6, login7, login8, login9, login10,
		   senhaBoa1, senhaBoa2, senhaBoa3, senhaBoa4, senhaBoa5,
		   senhaBoa6, senhaBoa7, senhaBoa8, senhaBoa9, senhaBoa10,
		   senhaRuim1, senhaRuim2, senhaRuim3, senhaRuim4, senhaRuim5,
		   senhaRuim6, senhaRuim7, senhaRuim8, senhaRuim9, senhaRuim10;
	
	@Before
	public void setup(){
		caixa = CaixaEletronico.getInstance();
		
		login1 = "rahyan";
		login2 = "pedro";
		login3 = "roberto";
		login4 = "rayssa";
		login5 = "ernesto";
		login6 = "alan";
		login7 = "gian";
		login8 = "flavia";
		login9 = "amanda";
		login10 = "paulo";
		
		senhaBoa1 = "dokfodkfodfkdofkadofa1@";
		senhaBoa2 = "3#kdaofkdofksdofks";
		senhaBoa3 = "1332436564564r%";
		senhaBoa4 = "%&**#!@rR5";
		senhaBoa5 = "pedro12!";
		senhaBoa6 = "3193djsaidsaj!!";
		senhaBoa7 = "praias2@@";
		senhaBoa8 = "dfofssd8989@#$";
		senhaBoa9 = "8989dhsu!!@@@";
		senhaBoa10 = "!@#$!@r1";
		senhaRuim1 = "1rR@";
		senhaRuim2 = "r";
		senhaRuim3 = "@";
		senhaRuim4 = "1";
		senhaRuim5 = "adkfsdfksdofksdofks";
		senhaRuim6 = "123456789";
		senhaRuim7 = "!@#$!@#$!";
		senhaRuim8 = "rahyan1234";
		senhaRuim9 = "12345@##!##";
		senhaRuim10 = "!@#$!@#123";
	}	
	
	@Test
	public void verificandoSeContasCriadasCorretamentePeloCaixa() {
		assertTrue(caixa.criarConta(login1, senhaBoa1));
		assertTrue(caixa.criarConta(login2, senhaBoa2));
		assertTrue(caixa.criarConta(login3, senhaBoa3));
		assertTrue(caixa.criarConta(login4, senhaBoa4));
		assertTrue(caixa.criarConta(login5, senhaBoa5));
		
		//procurando contas cadastradas
		assertTrue(caixa.procuraConta(login1));
		assertTrue(caixa.procuraConta(login2));
		assertTrue(caixa.procuraConta(login3));
		assertTrue(caixa.procuraConta(login4));
		assertTrue(caixa.procuraConta(login5));
		
		//procurando contas que nao estao cadastradas
		assertFalse(caixa.procuraConta(login6));
		assertFalse(caixa.procuraConta(login7));
		assertFalse(caixa.procuraConta(login8));
		assertFalse(caixa.procuraConta(login9));
		assertFalse(caixa.procuraConta(login10));
	}
	
	
	@Test
	public void verificaLogaCorretmente() {
		//A variavel "caixa" eh global, portanto as modificacoes feitas
		//nela no teste anterior persistem, logo, todas as 10 contas
		//estao cadastradas no sistema
		
		//nao deve ter nenhuma conta logada
		assertFalse(caixa.logado());
		
		//deve funcionar ao logar com login e senha corretas
		assertTrue(caixa.logarConta(login1, senhaBoa1));
		//apos logar, deve estar logado
		assertTrue(caixa.logado());
		//verificando que a conta logada eh a esperada
		assertEquals(login1, caixa.getContaAtual().getLogin());
		//deve deslogar para outra pessoa poder logar
		assertTrue(caixa.deslogar());
		//depois de deslogar, deve estar deslogado
		assertFalse(caixa.logado());
		assertTrue(caixa.logarConta(login2, senhaBoa2));
		assertTrue(caixa.logado());
		assertEquals(login2, caixa.getContaAtual().getLogin());
		assertTrue(caixa.deslogar());
		assertFalse(caixa.logado());
		assertTrue(caixa.logarConta(login3, senhaBoa3));
		assertTrue(caixa.logado());
		assertEquals(login3, caixa.getContaAtual().getLogin());
		assertTrue(caixa.deslogar());
		assertFalse(caixa.logado());
		assertTrue(caixa.logarConta(login4, senhaBoa4));
		assertTrue(caixa.logado());
		assertEquals(login4, caixa.getContaAtual().getLogin());
		assertTrue(caixa.deslogar());
		assertFalse(caixa.logado());
		assertTrue(caixa.logarConta(login5, senhaBoa5));
		assertTrue(caixa.logado());
		assertEquals(login5, caixa.getContaAtual().getLogin());
		assertTrue(caixa.deslogar());
		assertFalse(caixa.logado());
		
		//logins cadastrados e senhas erradas
		assertFalse(caixa.logarConta(login1, senhaBoa5));
		assertFalse(caixa.logarConta(login2, senhaBoa4));
		assertFalse(caixa.logarConta(login3, senhaBoa10));
		assertFalse(caixa.logarConta(login4, senhaRuim2));
		assertFalse(caixa.logarConta(login5, senhaRuim3));
		//apos todas tentativas, continua deslogado
		assertFalse(caixa.logado());
		
		//logins nao cadastrados
		assertFalse(caixa.logarConta(login6, senhaBoa7));
		assertFalse(caixa.logarConta(login7, senhaBoa5));
		assertFalse(caixa.logarConta(login8, senhaRuim2));
		assertFalse(caixa.logarConta(login9, senhaRuim4));
		assertFalse(caixa.logarConta(login10, senhaBoa9));
		//apos todas tentativas, continua deslogado
		assertFalse(caixa.logado());
	}
	
	@Test
	public void tentandoCriarContasComSenhasNaoPermitidas() {
		//verificando que esta deslogado
		assertFalse(caixa.logado());
		
		//tentando criar contas com senhas fracas, nao deve funcionar
		assertFalse(caixa.criarConta(login1, senhaRuim1));
		assertFalse(caixa.criarConta(login2, senhaRuim2));
		assertFalse(caixa.criarConta(login3, senhaRuim3));
		assertFalse(caixa.criarConta(login4, senhaRuim4));
		assertFalse(caixa.criarConta(login5, senhaRuim5));
		assertFalse(caixa.criarConta(login6, senhaRuim6));
		assertFalse(caixa.criarConta(login7, senhaRuim7));
		assertFalse(caixa.criarConta(login8, senhaRuim8));
		assertFalse(caixa.criarConta(login9, senhaRuim9));
		assertFalse(caixa.criarConta(login10, senhaRuim10));
	}
	
	@Test
	public void verificandoServicosFuncionamCorretamente() {
		assertTrue(caixa.logarConta(login1, senhaBoa1));
		assertTrue(caixa.logado());
		
		//saldo inicial deve ser zero
		assertEquals(0, caixa.saldo(), 0);
		//deposito positivo deve ser aceito
		assertTrue(caixa.deposito(100));
		//saldo atual deve estar atualizado
		assertEquals(100, caixa.saldo(), 0);
		//deposito negativo nao deve ser aceito
		assertFalse(caixa.deposito(-100));
		//saldo atual deve permanecer o mesmo
		assertEquals(100, caixa.saldo(), 0);
		//pagamento positivo deve ser aceito
		assertTrue(caixa.pagamento(23.7));
		//saldo atual deve estar atualizado
		assertEquals(76.3, caixa.saldo(), 0);
		//pagamento negativo nao deve ser aceito
		assertFalse(caixa.pagamento(-500));
		//saldo atual deve permanecer o mesmo
		assertEquals(76.3, caixa.saldo(), 0);
		
		assertTrue(caixa.deslogar());
		
		assertTrue(caixa.logarConta(login2, senhaBoa2));
		assertTrue(caixa.logado());
		
		//saldo inicial deve ser zero
		assertEquals(0, caixa.saldo(), 0);
		//deposito positivo deve ser aceito
		assertTrue(caixa.deposito(45.6));
		//saldo atual deve estar atualizado
		assertEquals(45.6, caixa.saldo(), 0);
		//deposito negativo nao deve ser aceito
		assertFalse(caixa.deposito(-100));
		//saldo atual deve permanecer o mesmo
		assertEquals(45.6, caixa.saldo(), 0);
		//pagamento positivo deve ser aceito
		assertTrue(caixa.pagamento(5.6));
		//saldo atual deve estar atualizado
		assertEquals(40, caixa.saldo(), 0);
		//pagamento negativo nao deve ser aceito
		assertFalse(caixa.pagamento(-500));
		//saldo atual deve permanecer o mesmo
		assertEquals(40, caixa.saldo(), 0);
	}
}
