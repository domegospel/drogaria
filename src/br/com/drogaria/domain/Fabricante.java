package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe de Criação e Queries em tabela
 * Tabela : Fabricantes 
 * Tecnologia: Java/Hibernate 
 *===============================================================*/

//Notação Hibernate indicando que é uma entidade(tabela)
@Entity
//Nome da tabela que será criada no BD
@Table(name = "tbl_fabricantes")
//Queries feitas usando hibernate
@NamedQueries({ 
	//Query para listar fabricantes
	@NamedQuery(name  = "Fabricante.listar", 
                query = "Select fabricante From Fabricante fabricante"),
	//Query para selecionar fabricante por codigo
	@NamedQuery(name  = "Fabricante.buscarPorCodigo",
	            query = "Select fabricante From Fabricante fabricante "
	            		+ " Where fabricante.codigo = :codigo")
    })
//Classe de construcao do Fabricante, indica os campos, chaves e tudo concernente a tabela
public class Fabricante {
	//Id indica que é a Primary Key
	@Id
	//Será gerada automaticamente pelo BD
	@GeneratedValue(strategy = GenerationType.AUTO)
	//Nome fisico do campo
	@Column(name = "fab_codigo")
	//Nome do campo na classe e para o projeto
	private Long codigo;

	//Nome fisico do campo , tamanho e nulidade
	@Column(name = "fab_descricao", length = 50, nullable = false)
	private String descricao;
	
	//Encapsulamento dos campos
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	//Notacao e metodo usado para impressao, quando chamar o objeto inteiro ao inves de 
	//suas partes 
	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}
