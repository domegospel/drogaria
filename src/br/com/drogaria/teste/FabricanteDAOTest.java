package br.com.drogaria.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;


/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe de testes dos metodos e classes de acesso ao BD
 * Tabela : Fabricantes 
 * Tecnologia: Java/JUnit 
 *===============================================================*/

//Classe de Testes do FabricanteDAO
public class FabricanteDAOTest {
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	@Ignore
	//Metodo para salvar o Fabricante no BD
	public void salvar(){
		
		Fabricante f1 = new Fabricante();
		f1.setDescricao("Kimbal LABs");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("Palmer Lab");

		FabricanteDAO dao = new FabricanteDAO();
		
		dao.salvar(f1);
		dao.salvar(f2);
	}
	
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	@Ignore
	//Metodo para listar os Fabricantes do BD
	public void listar(){
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		
		for(Fabricante fabricante:fabricantes){
			System.out.println(fabricante);
		}
	}
	
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	@Ignore
	//Metodo para selecao por Codido do Fabricante no BD
	public void buscarPorcodigo(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(3L);
		Fabricante f2 = dao.buscarPorCodigo(9L);

		System.out.println(f1);
		System.out.println(f2);
	}
}
