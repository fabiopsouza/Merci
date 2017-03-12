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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contatos == null) ? 0 : contatos.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (contatos == null) {
			if (other.contatos != null)
				return false;
		} else if (!contatos.equals(other.contatos))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", documento=" + documento + ", idEndereco=" + idEndereco
				+ ", endereco=" + endereco + ", contatos=" + contatos + "]";
	}

}