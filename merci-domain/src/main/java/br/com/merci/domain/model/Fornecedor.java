package br.com.merci.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "fornecedor")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Documento documento;
	private Long idEndereco;
	private Endereco endereco;
	private List<Contato> contatos;

	public Fornecedor() {
		// Default constructor
	}

	public Fornecedor(String nome, Documento documento, Endereco endereco, List<Contato> contatos) {
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
		this.contatos = contatos;
	}
	
	public Fornecedor(Long id, String nome, Documento documento, Endereco endereco, List<Contato> contatos) {
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
		this.contatos = contatos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 60)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(nullable = false, insertable = false, updatable = false)
	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	@JsonBackReference
    @JoinColumn(name = "idEndereco")
	@ManyToOne(fetch=FetchType.LAZY)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDocumento", nullable = false)
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "fornecedor_contato", joinColumns = {
			@JoinColumn(name = "idFornecedor", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "idContato", referencedColumnName = "id") })
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}