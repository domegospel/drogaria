package br.com.drogaria.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
//Nome fisico da tabela no BD
@Table(name = "tbl_vendas")

//Classe de construcao do Venda, indica os campos, chaves e tudo concernente a tabela
public class Venda {
	//Campo chave estrangeira, gerado automaticamente pelo BD
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ven_codigo")
	private Long codigo;

	//Campo ven_horario, tipo timestamp e sem nulidade 
	@Column(name = "ven_horario",  nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date horario;
	
	//Campo ven_valor_total,Numerico Monetario, tamanho 7,2 e sem nulidade 
	@Column(name = "ven_valor_total", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor;
	
	//Notacao Hibernate para criar chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	// |--> Tabela Filha (muitos) para tabela Pai (um)
	@JoinColumn(name = "tbl_funcionarios_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
    //          |----> nome na tabela filha(tabela Vendas)    |
	//                                                        |----> nome na tabela pai(tabela Funcionarios)       
	//Campo de chave estrangeira aqui é feito como um campo do tipo do objeto Funcionario
	private Funcionario funcionario;

	//Encapsulamento de campos
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
