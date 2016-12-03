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
@Table(name = "cidade")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Long idEstado;
	private Estado estado;
	private List<Endereco> enderecos;

	public Cidade(){
		//Default constructor
	}
	
	public Cidade(String nome, Long idEstado) {
		this.nome = nome;
		this.idEstado = idEstado;
	}
	
	public Cidade(String nome, Long idEstado, Estado estado) {
		this.nome = nome;
		this.idEstado = idEstado;
		this.estado = estado;
	}
	
	public Cidade(Long id, String nome, Long idEstado, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.idEstado = idEstado;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, unique = true, length = 255)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, insertable = false, updatable = false)
	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	
	@JsonBackReference
    @JoinColumn(name = "idEstado")
	@ManyToOne(fetch=FetchType.LAZY)
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "cidade", fetch=FetchType.LAZY)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
