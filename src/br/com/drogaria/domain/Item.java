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
 * Tabela : Item 
 * Tecnologia: Java/Hibernate 
 *===============================================================*/

//Notação Hibernate indicando que é uma entidade(tabela)
@Entity
//Nome da tabela que será criada no BD
@Table(name = "tbl_itens")
//Classe de construcao do Item, indica os campos, chaves e tudo concernente a tabela
public class Item {
	//Campo ite_codigo(nome fisico), chave primaria, gerado automaticamente pelo BD
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ite_codigo")
	private Long codigo;

	//Campo ite_quantidade, tamanho 5, sem nulidade, inteiro 
	@Column(name = "ite_quantidade", length =5, nullable = false)
	private Integer quantidade;
	
	//Campo ite_valor_parcial, tamanho, Numérico Monetário, tamanho 7,2 , sem nulidade
	@Column(name = "ite_valor_parcial", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor;

	//Notacao Hibernate para gerar chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	// |--> Tabela Filha (muitos) para tabela Pai (um)
	@JoinColumn(name = "tbl_produtos_pro_codigo", referencedColumnName = "pro_codigo", nullable = false)
    //          |----> nome na tabela filha(tabela Vendas)    |
	//                                                        |----> nome na tabela pai(tabela Funcionarios)
	//Campo de chave estrangeira aqui é feito como um campo do tipo do objeto Produto
	private Produto produto;

	//Notacao Hibernate para gerar chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	// |--> Tabela Filha (muitos) para tabela Pai (um)
	@JoinColumn(name = "tbl_vendas_ven_codigo", referencedColumnName = "ven_codigo", nullable = false)
    //          |----> nome na tabela filha(tabela Vendas)    |
	//                                                        |----> nome na tabela pai(tabela Funcionarios)       
	//Campo de chave estrangeira aqui é feito como um campo do tipo do objeto Venda
	private Venda venda;

	//Encapsulamento dos campos 
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}