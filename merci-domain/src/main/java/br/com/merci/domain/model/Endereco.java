package br.com.merci.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "endereco")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String rua;
	private String numero;
	private String cep;
	private String bairro;
	private Long idCidade;
	private Cidade cidade;
	private List<Fornecedor> fornecedores;
	
	public Endereco(){
		//Default constructor
	}
	
	public Endereco(String rua, String numero, String cep, String bairro, Long idCidade) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.idCidade = idCidade;
	}
	
	public Endereco(String rua, String numero, String cep, String bairro, Long idCidade, Cidade cidade) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.idCidade = idCidade;
		this.cidade = cidade;
	}
	
	public Endereco(Long id, String rua, String numero, String cep, String bairro, Long idCidade, Cidade cidade) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.idCidade = idCidade;
		this.cidade = cidade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 255)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(nullable = false, length = 30)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(nullable = false, length = 60)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(nullable = false, length = 60)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(nullable = false, insertable = false, updatable = false)
	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	
	@JsonBackReference
    @JoinColumn(name = "idCidade")
	@ManyToOne(fetch=FetchType.LAZY)
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "endereco", fetch=FetchType.LAZY)
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
