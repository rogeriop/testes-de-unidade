package br.com.caelum.leilao.servicos;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MatematicaMalucaTest {
	
	@Test
	public void validarNumeroMaiorQue30() {
		
		int numeroInformado = 50;

		int resultadoEsperado = 200;
		
		assertEquals(resultadoEsperado, new MatematicaMaluca().contaMaluca(numeroInformado));
	}

	@Test
	public void validarNumeroMaiorQueDez() {
		
		int numeroInformado = 15;
		
		int resultadoEsperado = 45;
		
		assertEquals(resultadoEsperado, new MatematicaMaluca().contaMaluca(numeroInformado));
	}

	@Test
	public void validarNumeroMenorQueDez() {
		
		int numeroInformado = 9;
		
		int resultadoEsperado = 18;
		
		assertEquals(resultadoEsperado, new MatematicaMaluca().contaMaluca(numeroInformado));
	}

	@Test
	public void validarNumeroIgualAZero() {
		
		int numeroInformado = 0;
		
		int resultadoEsperado = 0;
		
		assertEquals(resultadoEsperado, new MatematicaMaluca().contaMaluca(numeroInformado));
	}

	@Test
	public void validarNumeroIgualADez() {
		
		int numeroInformado = 10;
		
		int resultadoEsperado = 20;
		
		assertEquals(resultadoEsperado, new MatematicaMaluca().contaMaluca(numeroInformado));
	}

	@Test
	public void validarNumeroIgualATrinta() {
		
		int numeroInformado = 30;
		
		int resultadoEsperado = 90;
		
		assertEquals(resultadoEsperado, new MatematicaMaluca().contaMaluca(numeroInformado));
	}
}
