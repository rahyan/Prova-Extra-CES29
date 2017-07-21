import static org.junit.Assert.*;

import org.junit.Test;

import questao2.CaixaEletronico;
import questao2.Conta;

public class unitTest {

	@Test
	public void apenasUmaInstanciaDeCaixaEletronico() {
		
		CaixaEletronico atm1 = CaixaEletronico.getInstance();
		CaixaEletronico atm2 = CaixaEletronico.getInstance();
		CaixaEletronico atm3 = CaixaEletronico.getInstance();
		CaixaEletronico atm4 = CaixaEletronico.getInstance();
		
		assertEquals(atm1, atm2);
		assertEquals(atm1, atm3);
		assertEquals(atm1, atm4);
		assertEquals(atm2, atm3);
		assertEquals(atm2, atm4);
		assertEquals(atm3, atm4);
	}

	@Test
	public void aoIniciarCaixaDeveEstarDeslogado() {
		
		CaixaEletronico atm = CaixaEletronico.getInstance();
		
		assertEquals(false, atm.logado());
	}
	
	@Test
	public void seEstaLogadoCaixaNaoDeveRealizarServicos() {
		CaixaEletronico atm = CaixaEletronico.getInstance();
		
		//apenas verificando que esta de fato deslogado
		assertEquals(false, atm.logado());
		
		
		//servicos nao disponiveis quando esta deslogado
		assertEquals(-99999999, atm.saldo(), 0); //-99999999 eh o valor que indica que o servico nao foi concluido
		assertEquals(false, atm.deposito(150));
		assertEquals(false, atm.pagamento(87.30));
		
		//nao deve deslogar se ja esta deslogado
		assertEquals(false, atm.deslogar());
	}
	
	@Test
	public void verificandoContaCriadaCorretamente() {
		Conta c1 = new Conta("rahyan", "1234"); //a forca da senha nao importa aqui, quem verifica isso eh o caixa
		Conta c2 = new Conta("pedro", "pedro");
		Conta c3 = new Conta("roberto", "1234@java");
		
		assertEquals("rahyan", c1.getLogin());
		assertEquals("pedro", c2.getLogin());
		assertEquals("roberto", c3.getLogin());
	}
	
	@Test
	public void saldoAtualizadoCorretamente() {
		Conta c1 = new Conta("rahyan", "1234");
		Conta c2 = new Conta("pedro", "pedro");
		Conta c3 = new Conta("roberto", "1234@java");
		
		assertEquals(0, c1.getSaldo(), 0);
		assertEquals(0, c2.getSaldo(), 0);
		assertEquals(0, c3.getSaldo(), 0);
		
		c1.setSaldo(100);
		c2.setSaldo(-100);
		c3.setSaldo(23.45);
		
		assertEquals(100, c1.getSaldo(), 0);
		assertEquals(-100, c2.getSaldo(), 0);
		assertEquals(23.45, c3.getSaldo(), 0);
	}
	
	@Test
	public void verificandoSeAnalisaCorretamenteSenhasValidas() {
		String senhaBoa1 = "dokfodkfodfkdofkadofa1@";
		String senhaBoa2 = "3#kdaofkdofksdofks";
		String senhaBoa3 = "1332436564564r%";
		String senhaBoa4 = "%&**#!@rR5";
		String senhaBoa5 = "pedro12!";
		String senhaBoa6 = "3193djsaidsaj!!";
		String senhaBoa7 = "praias2@@";
		String senhaBoa8 = "dfofssd8989@#$";
		String senhaBoa9 = "8989dhsu!!@@@";
		String senhaBoa10 = "!@#$!@r1";
		String senhaRuim1 = "1rR@";
		String senhaRuim2 = "r";
		String senhaRuim3 = "@";
		String senhaRuim4 = "1";
		String senhaRuim5 = "adkfsdfksdofksdofks";
		String senhaRuim6 = "123456789";
		String senhaRuim7 = "!@#$!@#$!";
		String senhaRuim8 = "rahyan1234";
		String senhaRuim9 = "12345@##!##";
		String senhaRuim10 = "!@#$!@#123";
		
		CaixaEletronico atm = CaixaEletronico.getInstance();
		
		assertEquals(true, atm.senhaValida(senhaBoa1));
		assertEquals(true, atm.senhaValida(senhaBoa2));
		assertEquals(true, atm.senhaValida(senhaBoa3));
		assertEquals(true, atm.senhaValida(senhaBoa4));
		assertEquals(true, atm.senhaValida(senhaBoa5));
		assertEquals(true, atm.senhaValida(senhaBoa6));
		assertEquals(true, atm.senhaValida(senhaBoa7));
		assertEquals(true, atm.senhaValida(senhaBoa8));
		assertEquals(true, atm.senhaValida(senhaBoa9));
		assertEquals(true, atm.senhaValida(senhaBoa1));
		assertEquals(false, atm.senhaValida(senhaRuim1));
		assertEquals(false, atm.senhaValida(senhaRuim2));
		assertEquals(false, atm.senhaValida(senhaRuim3));
		assertEquals(false, atm.senhaValida(senhaRuim4));
		assertEquals(false, atm.senhaValida(senhaRuim5));
		assertEquals(false, atm.senhaValida(senhaRuim6));
		assertEquals(false, atm.senhaValida(senhaRuim7));
		assertEquals(false, atm.senhaValida(senhaRuim8));
		assertEquals(false, atm.senhaValida(senhaRuim9));
		assertEquals(false, atm.senhaValida(senhaRuim10));
	}
}