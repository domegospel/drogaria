package br.com.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*===============================================================* 
 * theDome Informática
 * 
 * Projeto Drogaria - Projeto para venda de sistema drogaria
 *===============================================================* 
 * Classe de Criação e Queries em tabela
 * Tabela : Produto 
 * Tecnologia: Java/Hibernate 
 *===============================================================*/

//Notação Hibernate indicando que é uma entidade(tabela)
@Entity
//Nome da tabela fisica
@Table(name = "tbl_produtos")
//Classe de construcao do Produto, indica os campos, chaves e tudo concernente a tabela
public class Produto {
	//Chave Primária, gerada automaticamente, pro_codigo(nome fisico)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_codigo")
	private Long codigo;

	//Campo pro_descricao, Alfanumerico, tamanho 50 e sem nulidade
	@Column(name = "pro_descricao", length = 50, nullable = false)
	private String descricao;

	//Campo pro_preco, Numerico Monetario, tamanho 7,2 e sem nulidade 
	@Column(name = "pro_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	//Campo pro_quantidade, numerico e sem nulidade 
	@Column(name = "pro_quantidade", nullable = false)
	private Integer quantidade;

	//Notacao Hibernate para criar chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_fabricante_fab_codigo", referencedColumnName = "fab_codigo", nullable = false)
    //          |----> nome na tabela filha(tabela Produtos)  |
	//                                                        |----> nome na tabela pai(tabela Fabricantes)       
	//Campo de chave estrangeira aqui é feito como um campo do tipo do objeto Fabricante
	private Fabricante fabricante;

	//Encapsulamento de campos
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}

