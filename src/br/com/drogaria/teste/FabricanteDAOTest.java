package br.com.drogaria.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.main.GerarBackUp;
import br.com.drogaria.main.LerBackUp;


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
		f1.setDescricao("ACME Corp.");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("Lightman Corp");

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
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	  @Ignore
	//Metodo para excluir por Codido do Fabricante no BD
	public void excluir(){
		FabricanteDAO dao = new FabricanteDAO();
		
		//Precisamos primeiro buscar o registro no BD para que seja feita a exclusao por inteiro
		Fabricante f1 = dao.buscarPorCodigo(4L);
		
		//Se encontrar o registro entao exclua
		if (f1 != null){
		//Para depois exclui-lo no tabela
		dao.excluir(f1);
		}

	}
	
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	@Ignore
	//Metodo para salvar o Fabricante no BD
	public void editar(){
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(9L);
		f1.setDescricao("Gandalf Round");
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(10L);
		f2.setDescricao("Moria Inc");

		FabricanteDAO dao = new FabricanteDAO();
		
		dao.editar(f1);
		dao.editar(f2);
	}
	
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	//@Ignore
	//Metodo gerar back-up de Fabricantes
	public void gerarbkp(){
	
		GerarBackUp gerar = new GerarBackUp();
		LerBackUp   ler   = new LerBackUp();
		
		gerar.geraBackUpFabricante();
		ler.lerBackUpFabricante();
		
	}
}


