package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import questao3.Matematica;

public class testes {
	
	Matematica m;
	
	@Before
	public void setUp() {
		m = new Matematica();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void quandoParametroForNegativoEsperarExcecao1() {
		m.fibonacci(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void quandoParametroForNegativoEsperarExcecao2() {
		m.fibonacci(-100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void quandoParametroForNegativoEsperarExcecao3() {
		m.fibonacci(-234);
	}
	
	@Test
	public void quandoEntradaForZeroSaidaDeveSerZero() {
		assertEquals(0, m.fibonacci(0));
	}
	
	@Test
	public void quandoEntradaForUmSaidaDeveSerUm() {
		assertEquals(1, m.fibonacci(1));
	}
	
	@Test
	public void quandoEntradasSaoMaioresQueUm() {
		int i;
		
		i = 0;
		assertEquals(m.fibonacci(i+2),m.fibonacci(i+1)+m.fibonacci(i));
		
		i = 8;
		assertEquals(m.fibonacci(i+2),m.fibonacci(i+1)+m.fibonacci(i));
		
		i = 13;
		assertEquals(m.fibonacci(i+2),m.fibonacci(i+1)+m.fibonacci(i));
	}

}
