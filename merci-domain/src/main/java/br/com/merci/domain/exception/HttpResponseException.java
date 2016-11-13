package br.com.merci.domain.exception;

public class HttpResponseException extends Exception {

	private static final long serialVersionUID = 1L;

	private String error;
	private String detail;
	private String field;
	private Integer code;

	public HttpResponseException(String error) {
		this.error = error;
	}
	
	public HttpResponseException(String error, String detail) {
		this.error = error;
		this.detail = detail;
	}
	
	public HttpResponseException(String error, Integer code) {
		this.error = error;
		this.code = code;
	}
	
	public HttpResponseException(String error, String detail, String field) {
		this.error = error;
		this.detail = detail;
		this.field = field;
	}
	
	public HttpResponseException(String error, String detail, String field, Integer code) {
		this.error = error;
		this.detail = detail;
		this.field = field;
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
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
		HttpResponseException other = (HttpResponseException) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HttpResponseException [error=" + error + ", detail=" + detail + ", field=" + field + ", code=" + code
				+ "]";
	}

}
