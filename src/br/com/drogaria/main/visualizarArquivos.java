package br.com.drogaria.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class visualizarArquivos {

	private String diretorio = "/home/optimus/Documentos/Programas/ProjetosJava/drogaria/bkup/";

	public visualizarArquivos() throws IOException {

		File file = new File(diretorio);
		File afile[] = file.listFiles();
		int i = 0;
	
		Arrays.sort(afile);
	
		for (int j = afile.length; i < j; i++) {
			File arquivos = afile[i];
			System.out.println(arquivos.getName());
		}
	}

	public static void main(String[] args) {
		try {
			visualizarArquivos v = new visualizarArquivos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}