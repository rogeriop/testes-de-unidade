package br.com.caelum.leilao.servicos;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTest {

	@Test
	public void seEliminaCaracterInvalido() {
		boolean ehValido = new Palindromo().ehPalindromo("Socorram-me subi no onibus em Marrocos");
		
		Assert.assertTrue(ehValido);
	}
	@Test
	public void seEPalindromo() {
		boolean ehValido = new Palindromo().ehPalindromo("Anotaram a data da maratona");
		Assert.assertTrue(ehValido);
		
	}
	@Test
	public void seNaoEPalindromo() {
		boolean ehValido = new Palindromo().ehPalindromo("É preciso amar as pessoas");
		Assert.assertFalse(ehValido);
		
	}
	
}
