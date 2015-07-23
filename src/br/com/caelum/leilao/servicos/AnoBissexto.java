package br.com.caelum.leilao.servicos;

public class AnoBissexto {
	public Boolean ehBissexto(int ano) {
		
		if (ano % 400 == 0) return true;
		if (ano % 100 == 0) return false;
		if (ano % 4 == 0) return true;
		
		return false;
	}
}
