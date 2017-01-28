package br.com.drogaria.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.loader.custom.Return;

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
public class GerarBackUp {

	// Processamento principal para gerar back-up Fabricante
	public void geraBackUpFabricante() {

		DateFormat dataFormata = new SimpleDateFormat("yyyyMMdd-HHmmss");
		Date data = new Date();
		
		// Especificação do caminho
		String caminho = "/home/optimus/Documentos/Programas/ProjetosJava/drogaria/bkup/";

		// Nome do arquivo diario
		String arquivoDiario = "bkp-fabricantes-" + dataFormata.format(data) + ".txt";

		//Nome do arquivo atual
		String arquivoAtual  = "bkp-fabricantes.txt";
		
		//Gera arquivo back-up diario
		if (gerarArquivoFabricante(caminho + arquivoDiario)){
			//Se gravar diario, Gera arquivo back-up diario
			gerarArquivoFabricante(caminho + arquivoAtual);
		} else {
			System.out.println("Fabricante - Arquivos não gerados");
		}
	}
	
	private Boolean gerarArquivoFabricante(String caminho){
		//Tipo de charset
		Charset utf8 = StandardCharsets.UTF_8;
		
		//Retorno do metodo
		Boolean retorno = true;

		//Criar objeto para acesso ao BD
		FabricanteDAO dao = new FabricanteDAO();

		//Criar Lista para receber os fabricantes
		List<Fabricante> fabricantes = dao.listar();

		//Nome do caminho completo Diario
		Path arquivo = Paths.get(caminho);

		//Variavel de gravacao de registro
		String registro = null;

		//Gravação do arquivo diario
		try (BufferedWriter linha = Files.newBufferedWriter(arquivo, utf8)) {
			//Listar fabricante um a um
			for (Fabricante fabricante : fabricantes) {
				//Montar registro para gravação
				registro = fabricante.getCodigo() + ";" + fabricante.getDescricao() + ";" + " \n";
				//Grava registro no arquivo de back-up
				linha.write(registro);
			}
		} catch (IOException e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}
}
