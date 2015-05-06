package br.com.caelum.leilao.servicos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

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

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveEntenderleilaoComApenasUmLance() {
		Usuario mario = new Usuario("mario");

		Leilao leilao = new Leilao("Peça única");
		leilao.propoe(new Lance(mario, 200));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorEsperado = 200;
		double menorEsperado = 200;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		Usuario marcelo = new Usuario("Marcelo");
		Usuario marcela = new Usuario("Marcela");
		Usuario antonio = new Usuario("Antônio");
		Usuario denize = new Usuario("Denize");
		Usuario joice = new Usuario("Joice");
		Usuario luana = new Usuario("Luana");
		
		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(marcelo, 200));
		leilao.propoe(new Lance(marcela, 450));
		leilao.propoe(new Lance(antonio, 120));
		leilao.propoe(new Lance(denize, 700));
		leilao.propoe(new Lance(marcela, 630));
		leilao.propoe(new Lance(joice, 230));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorEsperado = 700;
		double menorEsperado = 120;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		Usuario joice = new Usuario("Joice");
		Usuario luana = new Usuario("Luana");
		
		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(joice, 400));
		leilao.propoe(new Lance(luana, 300));
		leilao.propoe(new Lance(joice, 200));
		leilao.propoe(new Lance(joice, 100));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400;
		double menorEsperado = 100;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
	
	@Test
	public void deveDevolverTresLancesMaioresRecebendoCincoLances() {
		Usuario joice = new Usuario("Joice");
		Usuario luana = new Usuario("Luana");
		
		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(joice, 400));
		leilao.propoe(new Lance(luana, 200));
		leilao.propoe(new Lance(joice, 300));
		leilao.propoe(new Lance(joice, 100));
		leilao.propoe(new Lance(luana, 150));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		 
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
		
	}

	@Test
	public void deveDevolverDoisLancesMaioresRecebendoDoisLances() {
		Usuario joice = new Usuario("Joice");
		Usuario luana = new Usuario("Luana");
		
		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(joice, 400));
		leilao.propoe(new Lance(luana, 200));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(2, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(200, maiores.get(1).getValor(), 0.00001);
		
	}

	@Test
	public void deveDevolverListaVaziaRecebendoNenhumLance() {
		
		Leilao leilao = new Leilao("Joia rara");
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(0, maiores.size());
		
	}
}
