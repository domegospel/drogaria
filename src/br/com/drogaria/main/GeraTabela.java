package br.com.drogaria.main;

import br.com.drogaria.util.HibernateUtil;

/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe de Criação das Tabelas com base no hibernate.cfg.xml e 
 * na classe HibernateUtil
 * Tecnologia: Java/Hibernate 
 *===============================================================*/

//Classe para gerar tabelas no BD
public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}