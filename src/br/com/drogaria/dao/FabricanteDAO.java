
package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe de Acesso ao Banco de Dados
 * Tabela : Fabricantes 
 * Tecnologia: Java/Hibernate 
 *===============================================================*/
public class FabricanteDAO {

	/*-----------------------------------------------* 
	 * Metodo Salvar Fabricante
	 *-----------------------------------------------*/
	public void salvar(Fabricante fabricante) {
		
		// Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		// Criar transacao, garantir exito da gravacao do registro
		Transaction transacao = null;
		
		//Tentando gravar o registro na BD
		try {
			//iniciar a transacao abrindo a sessao
			transacao = sessao.beginTransaction();
			//gravando os dados do fabricante na tabela
			sessao.save(fabricante);
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
	 * Metodo Listar Fabricante
	 *-----------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Fabricante> listar(){
		//Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		//Criar variavel com a lista de fabricantes encontrados
		List<Fabricante> fabricantes = null; 

		try {
			//consultar fabricante e colocar na lista fabricantes
			Query consulta = sessao.getNamedQuery("Fabricante.listar");
			fabricantes = consulta.list();
			
		} catch (RuntimeException ex) {
			//propagar o erro
			throw ex;
		} finally {
			sessao.close();
		}

		//retornar os fabricantes encontrados
		return fabricantes;
	}
	
	/*-----------------------------------------------* 
	 * Metodo Buscar por codigo Fabricante
	 *-----------------------------------------------*/
	public Fabricante buscarPorCodigo(Long cod){
		//Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		//Criar variavel com a lista de fabricantes encontrados
		Fabricante fabricante = null; 

		try {
			//consultar fabricante por codigo
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");
			consulta.setLong("codigo", cod) ;
			
			//guardar a pesquisa em fabricante
			fabricante = (Fabricante) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			//propagar o erro
			throw ex;
		} finally {
			sessao.close();
		}

		//retornar o fabricante encontrado
		return fabricante;
	}

	/*-----------------------------------------------* 
	 * Metodo Excluir Fabricante
	 *-----------------------------------------------*/
	public void excluir(Fabricante fabricante) {
		
		// Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		// Criar transacao, garantir exito da gravacao do registro
		Transaction transacao = null;
		
		//Tentando gravar o registro na BD
		try {
			//iniciar a transacao abrindo a sessao
			transacao = sessao.beginTransaction();
			//deletar os dados do fabricante na tabela
			sessao.delete(fabricante);
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
	 * Metodo Excluir Fabricante com código
	 * Nao vamos usar aqui mas vou manter para efeito didatico
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
			FabricanteDAO dao = new FabricanteDAO();
			Fabricante f1 = dao.buscarPorCodigo(codigo);
			
			if (f1 != null) {
		       //deletar os dados do fabricante na tabela a partir do registro encontrado
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
	 * Metodo Editar Fabricante com código
	 *-----------------------------------------------*/
	public void editar(Fabricante fabricante) {
		
		// Abrir sessao utilizando o Hibernate(classe HibernateUtil)
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		// Criar transacao, garantir exito da gravacao do registro
		Transaction transacao = null;
		
		//Tentando gravar o registro na BD
		try {
			//iniciar a transacao abrindo a sessao
			transacao = sessao.beginTransaction();
			
			//Buscar o registro a partir do codigo 
			FabricanteDAO dao = new FabricanteDAO();
			Fabricante f1 = dao.buscarPorCodigo(fabricante.getCodigo());

			//aqui nao houve necessidade, mas lembrar que se nao forem alterados todos 
            //os campos, devemos passar os campos encontrados na busca(f1) e que nao 
            //sofreram alteracao para o objeto(fabricante) que sera atualizado na tabela
			
			if (f1 != null) {
			   //deletar os dados do fabricante na tabela a partir do registro encontrado
			   sessao.update(fabricante);
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
