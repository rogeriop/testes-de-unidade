package br.com.caelum.leilao.servicos;

import org.junit.Test;

import br.com.caelum.leilao.servicos.AnoBissexto;
import static org.junit.Assert.*;
public class AnoBissextoTest {

	@Test
	public void deveSerBissextoAnoMultiploDe400() {
		assertEquals(true, new AnoBissexto().ehBissexto(1600));
	}
	
	@Test
	public void deveSerBissextoAnoMultiploDe4SeNaoForDe100() {
		assertEquals(true, new AnoBissexto().ehBissexto(2016));
	}
	
	@Test
	public void naoDeveSerBissextoAnoMultiploDe100SeNaoForDe400() {
		assertEquals(false, new AnoBissexto().ehBissexto(1900));
	}
}
