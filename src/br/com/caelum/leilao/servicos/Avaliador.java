package br.com.caelum.leilao.servicos;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double media = 0;
	public void avalia(Leilao leilao) {
		double total = 0;
		for (Lance lance: leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)  maiorDeTodos = lance.getValor();
			if (lance.getValor() < menorDeTodos ) menorDeTodos = lance.getValor();
			total += lance.getValor();
		}
		media = total / leilao.getLances().size();  
	}
	
	public double getMaiorLance() {
		return this.maiorDeTodos;
	}
	public double getMenorLance() {
		return this.menorDeTodos;
	}
	
	public double getMediaLance() {
		return media;
	}
}
