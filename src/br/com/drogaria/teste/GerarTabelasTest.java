package br.com.drogaria.teste;

import org.junit.Test;

import br.com.drogaria.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Test
	public void Gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
	
}
