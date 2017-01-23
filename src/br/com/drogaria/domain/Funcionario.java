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
 * Tabela : Funcionario 
 * Tecnologia: Java/Hibernate 
 *===============================================================*/

//Notação Hibernate indicando que é uma entidade(tabela)
@Entity
//Nome da tabela que será criada no BD
@Table(name = "tbl_funcionarios")
//Queries feitas usando hibernate
@NamedQueries({ 
	//Query para listar funcionarios
	@NamedQuery(name  = "Funcionario.listar", 
              query = "Select funcionario From Funcionario funcionario"),
	//Query para selecionar fabricante por codigo
	@NamedQuery(name  = "Funcionario.buscarPorCodigo",
	            query = "Select funcionario From Funcionario funcionario "
	            		+ " Where funcionario.codigo = :codigo")
  })
//Classe de construcao do Funcionario, indica os campos, chaves e tudo concernente a tabela
public class Funcionario {
	//Este campo sera chave, gerado automaticamente pelo BD e seu nome fisico é fun_codigo
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fun_codigo")
	//nome do campo na classe e para o projeto 
	private Long codigo;

	//campo fun_nome(nome fisico), alfanumerico , tamanho de 50 e sem nulidade
	@Column(name = "fun_nome", length = 50, nullable = false)
	private String nome;
	
	//campo fun_nome(nome fisico), alfanumerico, tamanho de 14 e sem nulidade e conteudo unico
	@Column(name = "fun_cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	//campo fun_senha(nome fisico), alfanumerico, tamanho de 32 e sem nulidade
	@Column(name = "fun_senha", length = 32, nullable = false)
	private String senha;

	//campo fun_funcao(nome fisico), alfanumerico, tamanho de 50 e sem nulidade
	@Column(name = "fun_funcao", length = 50, nullable = false)
	private String funcao;

	//Encapsulamento dos campos 
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", funcao="
				+ funcao + "]";
	}
	
}