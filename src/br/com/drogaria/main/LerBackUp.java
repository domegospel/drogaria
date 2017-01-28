package br.com.drogaria.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe para Gerar Back-Up das tabelas
 * Tabela : Fabricantes / 
 * Tecnologia: Java 
 *===============================================================*/

//Classe Usada Para Gerar Back-Up
public class LerBackUp {

	// Especificação do caminho
	private final String caminho = "/home/optimus/Documentos/Programas/ProjetosJava/drogaria/bkup/";
	
	// Processamento principal para gerar back-up Fabricante
	public void lerBackUpFabricante() {

		//Nome do arquivo atual
		String nomeArquivo  = "bkp-fabricantes.txt";

		//Tipo de charset
		Charset utf8 = StandardCharsets.UTF_8;
		
		//Retorno do metodo
		Boolean retorno = true;

		//Criar objeto para acesso ao BD
		FabricanteDAO dao = new FabricanteDAO();

		//Criar Lista para receber os fabricantes
		List<Fabricante> fabricantes = dao.listar();

		//Variavel de leitura de registro
		String linha = null;

		//Nome do caminho completo Diario
		Path arquivo = Paths.get(caminho + nomeArquivo);

		//Gravação do arquivo diario
		try (BufferedReader leitor = Files.newBufferedReader(arquivo, utf8)) {
			//Listar fabricante um a um
			System.out.println("Arquivo de Back-Up Fabricantes");
			System.out.println("==============================");
			while ((linha = leitor.readLine()) != null){
				System.out.println(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
			retorno = false;
		}
	}
}
