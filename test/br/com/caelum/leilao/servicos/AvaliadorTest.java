package br.com.caelum.leilao.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servicos.Avaliador;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		// *Cenario: Tres lances em ordem crescente
		Usuario marcelo = new Usuario("marcelo");
		Usuario marcela = new Usuario("marcela");
		Usuario antonio = new Usuario("antônio");

		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(marcelo, 200));
		leilao.propoe(new Lance(marcela, 300));
		leilao.propoe(new Lance(antonio, 1000));

		// *Executa a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		// *Compara a saída com o esperado
		double maiorEsperado = 1000;
		double menorEsperado = 200;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
	}
}
