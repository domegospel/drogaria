
package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.HibernateUtil;

/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe de Acesso ao Banco de Dados
 * Tabela : Funcionarios 
 * Tecnologia: Java/Hibernate 
 *===============================================================*/
public class FuncionarioDAO {

	/*-----------------------------------------------* 
	 * Metodo Salvar Funcionario
	 *-----------------------------------------------*/
	public void salvar(Funcionario funcionario) {
		
		// Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		// Criar transacao, garantir exito da gravacao do registro
		Transaction transacao = null;
		
		//Tentando gravar o registro na BD
		try {
			//iniciar a transacao abrindo a sessao
			transacao = sessao.beginTransaction();
			//gravando os dados do Funcionario na tabela
			sessao.save(funcionario);
			//confirmar a gravacao
			transacao.commit();
		//em caso de erro - RuntimeException para nao deixar o processo parar	
		} catch(RuntimeException ex) {
			// Se transacao foi aberta e o erro aconteceu no momento da gravacao
			if (transacao != null) {
				//desfazer qualquer alteracao na tabela
				transacao.rollback(); 
				}
			//propagar o erro
			throw ex;
		//De qualquer forma, com erro ou no sucesso da transacao	
		} finally {
			//fechar a sessao
			sessao.close();
		}
	}
	
	/*-----------------------------------------------* 
	 * Metodo Listar Funcionario
	 *-----------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Funcionario> listar(){
		//Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		//Criar variavel com a lista de funcionarios encontrados
		List<Funcionario> funcionarios = null; 

		try {
			//consultar funcionario e colocar na lista funcionarios
			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionarios = consulta.list();
			
		} catch (RuntimeException ex) {
			//propagar o erro
			throw ex;
		} finally {
			sessao.close();
		}

		//retornar os funcionarios encontrados
		return funcionarios;
	}
	
	/*-----------------------------------------------* 
	 * Metodo Buscar por codigo Funcionario
	 *-----------------------------------------------*/
	public Funcionario buscarPorCodigo(Long cod){
		//Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		//Criar variavel com a lista de funcionarios encontrados
		Funcionario funcionario = null; 

		try {
			//consultar funcionario por codigo
			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", cod) ;
			
			//guardar a pesquisa em funcionario
			funcionario = (Funcionario) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			//propagar o erro
			throw ex;
		} finally {
			sessao.close();
		}

		//retornar o funcionario encontrado
		return funcionario;
	}

	/*-----------------------------------------------* 
	 * Metodo Excluir Funcionario
	 *-----------------------------------------------*/
	public void excluir(Funcionario funcionario) {
		
		// Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		// Criar transacao, garantir exito da gravacao do registro
		Transaction transacao = null;
		
		//Tentando gravar o registro na BD
		try {
			//iniciar a transacao abrindo a sessao
			transacao = sessao.beginTransaction();
			//deletar os dados do funcionario na tabela
			sessao.delete(funcionario);
			//confirmar a gravacao
			transacao.commit();
		//em caso de erro - RuntimeException para nao deixar o processo parar	
		} catch(RuntimeException ex) {
			// Se transacao foi aberta e o erro aconteceu no momento da gravacao
			if (transacao != null) {
				//desfazer qualquer alteracao na tabela
				transacao.rollback(); 
				}
			//propagar o erro
			throw ex;
		//De qualquer forma, com erro ou no sucesso da transacao	
		} finally {
			//fechar a sessao
			sessao.close();
		}
	}

	/*-----------------------------------------------* 
	 * Metodo Excluir Funcionario com código
	 *-----------------------------------------------*/
	public void excluir(Long codigo) {
		
		// Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		// Criar transacao, garantir exito da gravacao do registro
		Transaction transacao = null;
		
		//Tentando gravar o registro na BD
		try {
			//iniciar a transacao abrindo a sessao
			transacao = sessao.beginTransaction();
			
			//Buscar o registro a partir do codigo 
			FuncionarioDAO dao = new FuncionarioDAO();
			Funcionario f1 = dao.buscarPorCodigo(codigo);
			
			if (f1 != null) {
		       //deletar os dados do funcionario na tabela a partir do registro encontrado
			   sessao.delete(f1);
			   //confirmar a gravacao
			   transacao.commit();
			}
		//em caso de erro - RuntimeException para nao deixar o processo parar	
		} catch(RuntimeException ex) {
			// Se transacao foi aberta e o erro aconteceu no momento da gravacao
			if (transacao != null) {
				//desfazer qualquer alteracao na tabela
				transacao.rollback(); 
				}
			//propagar o erro
			throw ex;
		//De qualquer forma, com erro ou no sucesso da transacao	
		} finally {
			//fechar a sessao
			sessao.close();
		}
	}
	
	/*-----------------------------------------------* 
	 * Metodo Editar Funcionario com código
	 *-----------------------------------------------*/
	public void editar(Funcionario funcionario) {
		
		// Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		// Criar transacao, garantir exito da gravacao do registro
		Transaction transacao = null;
		
		//Tentando gravar o registro na BD
		try {
			//iniciar a transacao abrindo a sessao
			transacao = sessao.beginTransaction();
			
			//Buscar o registro a partir do codigo 
			FuncionarioDAO dao = new FuncionarioDAO();
			Funcionario f1 = dao.buscarPorCodigo(funcionario.getCodigo());

			//aqui nao houve necessidade, mas lembrar que se nao forem alterados todos 
            //os campos, devemos passar os campos encontrados na busca(f1) e que nao 
            //sofreram alteracao para o objeto(funcionario) que sera atualizado na tabela
			
			if (f1 != null) {
			   //deletar os dados do funcionario na tabela a partir do registro encontrado
			   sessao.update(funcionario);
			   //confirmar a gravacao
			   transacao.commit();
			}
		//em caso de erro - RuntimeException para nao deixar o processo parar	
		} catch(RuntimeException ex) {
			// Se transacao foi aberta e o erro aconteceu no momento da gravacao
			if (transacao != null) {
				//desfazer qualquer alteracao na tabela
				transacao.rollback(); 
				}
			//propagar o erro
			throw ex;
		//De qualquer forma, com erro ou no sucesso da transacao	
		} finally {
			//fechar a sessao
			sessao.close();
		}
	}
	
}
