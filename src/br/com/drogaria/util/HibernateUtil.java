package br.com.drogaria.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe do Hibernate para preparar a conexao com o BD
 * Tecnologia: Java/Hibernate 
 *===============================================================*/

//Classe de Testes do FabricanteDAO
public class HibernateUtil {

	//Variavel de sessionFactory para tratar a conexao com BD
    private static final SessionFactory sessionFactory = buildSessionFactory();

    //Construindo a conexao com o BD
    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration configuration = new Configuration();
        	configuration.configure();
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        			.applySettings(configuration.getProperties()).build();
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
        	
        	return sessionFactory;
        }
        catch (Throwable ex) {
            // Mensagem de erro na criação da sessionFactory
            System.err.println("Falha ao tentar criar SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Metodo para gerar a Conexao com o BD
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}