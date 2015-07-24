package br.com.caelum.leilao.servicos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario marcelo;
	private Usuario marcela;
	private Usuario antonio;
	private Usuario denize;
	private Usuario joice;
	private Usuario luana;
	private Usuario mario;
/*
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}	
	
*/	
	
	
	@Before
	public void setUp() {
		this.leiloeiro = new Avaliador();
		
		this.marcelo = new Usuario("Marcelo");
		this.marcela = new Usuario("Marcela");
		this.antonio = new Usuario("Antônio");
		this.denize = new Usuario("Denize");
		this.joice = new Usuario("Joice");
		this.luana = new Usuario("Luana");
		this.mario = new Usuario("Mario");
	}


	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenumLanceDado() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo").constroi();
		
		leiloeiro.avalia(leilao);
	}
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		// *Cenario: Tres lances em ordem crescente
		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(marcelo, 200));
		leilao.propoe(new Lance(marcela, 300));
		leilao.propoe(new Lance(antonio, 1000));

		// *Executa a ação
		leiloeiro.avalia(leilao);

		// *Compara a saída com o esperado
/*
		double maiorEsperado = 1000;
		double menorEsperado = 200;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
*/
		assertThat(leiloeiro.getMaiorLance(), equalTo(1000.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(200.0));
	}

	@Test
	public void deveEntenderleilaoComApenasUmLance() {

		Leilao leilao = new Leilao("Peça única");
		leilao.propoe(new Lance(mario, 200));

		leiloeiro.avalia(leilao);

		double maiorEsperado = 200;
		double menorEsperado = 200;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		
		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(marcelo, 200));
		leilao.propoe(new Lance(marcela, 450));
		leilao.propoe(new Lance(antonio, 120));
		leilao.propoe(new Lance(denize, 700));
		leilao.propoe(new Lance(marcela, 630));
		leilao.propoe(new Lance(joice, 230));
		
		leiloeiro.avalia(leilao);

		double maiorEsperado = 700;
		double menorEsperado = 120;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		
		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(joice, 400));
		leilao.propoe(new Lance(luana, 300));
		leilao.propoe(new Lance(joice, 200));
		leilao.propoe(new Lance(luana, 100));
		
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400;
		double menorEsperado = 100;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
	
	@Test
	public void deveDevolverTresLancesMaioresRecebendoCincoLances() {

		Leilao leilao = new CriadorDeLeilao().para("Joia rara")
				.lance(joice, 400)
				.lance(luana, 200)
				.lance(joice, 300)
				.lance(luana, 100)
				.lance(joice, 150)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		 
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
		
	}

	@Test
	public void deveDevolverDoisLancesMaioresRecebendoDoisLances() {
		
		Leilao leilao = new Leilao("Joia rara");
		leilao.propoe(new Lance(joice, 400));
		leilao.propoe(new Lance(luana, 200));
		
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(2, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(200, maiores.get(1).getValor(), 0.00001);
		
	}

	
}
