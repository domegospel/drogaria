package br.com.drogaria.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;


/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe de testes dos metodos e classes de acesso ao BD
 * Tabela : Funcionarios 
 * Tecnologia: Java/JUnit 
 *===============================================================*/

//Classe de Testes do FuncionarioDAO
public class FuncionarioDAOTest {
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
    @Ignore
	//Metodo para salvar o Funcionario no BD
	public void salvar(){
		
		Funcionario f1 = new Funcionario();
		f1.setCpf("222.222.222-22");
		f1.setFuncao("Empresaria");
		f1.setNome("Hellen Freitas");
		f1.setSenha("12345");
		
		Funcionario f2 = new Funcionario();
		f2.setCpf("999.999.999-99");
		f2.setFuncao("Farmaceutico");
		f2.setNome("Romero Ventuta");
		f2.setSenha("12345");

		FuncionarioDAO dao = new FuncionarioDAO();
		
		dao.salvar(f1);
		dao.salvar(f2);
	}
	
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	@Ignore
	//Metodo para listar os Funcionarios do BD
	public void listar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		for(Funcionario funcionario:funcionarios){
			System.out.println(funcionario);
		}
	}
	
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	@Ignore
	//Metodo para selecao por Codido do Funcionario no BD
	public void buscarPorcodigo(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = dao.buscarPorCodigo(10L);
		Funcionario f2 = dao.buscarPorCodigo(9L);

		System.out.println(f1);
		System.out.println(f2);
	}
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	@Ignore
	//Metodo para excluir por Codido do Funcionario no BD
	public void excluir(){
		FuncionarioDAO dao = new FuncionarioDAO();
		
		//Precisamos primeiro buscar o registro no BD para que seja feita a exclusao por inteiro
		Funcionario f1 = dao.buscarPorCodigo(6L);
		
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
	//Metodo para excluir por Codido do Funcionario no BD
	public void excluir2(){
		FuncionarioDAO dao = new FuncionarioDAO();
		
		//Ira excluir a partir de um codigo
		dao.excluir(6L);

	}
	//Notacao JUnit para testar o metodo 
	@Test
	//Notacao JUnit para que este metodo seja ignorado
	//@Ignore
	//Metodo para salvar o Funcionario no BD
	public void editar(){
		
		Funcionario f1 = new Funcionario();
		f1.setCodigo(5L);
		f1.setCpf("264.769.157-62");
		f1.setFuncao("Analista Sênior");
		f1.setNome("Ronaldo Freitas");
		f1.setSenha("54321");
		
		Funcionario f2 = new Funcionario();
		f2.setCodigo(10L);
		f2.setCpf("767.767.767-77");
		f2.setFuncao("Farmaceutica Senior");
		f2.setNome("Carla Lima");
		f2.setSenha("12345");

		FuncionarioDAO dao = new FuncionarioDAO();
		
		dao.editar(f1);
		dao.editar(f2);
	}
}


