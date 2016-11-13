package br.com.merci.domain.http;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean isSuccess;
	public Object data;
	public String error;
	public String errorDetail;
	public String field;
	public Integer code;

	public HttpResponse() {
		// Default constructor
	}

	public HttpResponse(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public HttpResponse(Object data) {
		this.isSuccess = true;
		this.data = data;
	}

	public HttpResponse(String error) {
		this.isSuccess = false;
		this.error = error;
	}
	
	public HttpResponse(String error, String errorDetail) {
		this.isSuccess = false;
		this.error = error;
		this.errorDetail = errorDetail;
	}

	public HttpResponse(boolean isSuccess, Object data, String error, Integer code) {
		this.isSuccess = isSuccess;
		this.data = data;
		this.error = error;
		this.code = code;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
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
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result + ((errorDetail == null) ? 0 : errorDetail.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + (isSuccess ? 1231 : 1237);
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
		HttpResponse other = (HttpResponse) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		if (errorDetail == null) {
			if (other.errorDetail != null)
				return false;
		} else if (!errorDetail.equals(other.errorDetail))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (isSuccess != other.isSuccess)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HttpResponse [isSuccess=" + isSuccess + ", data=" + data + ", error=" + error + ", errorDetail="
				+ errorDetail + ", field=" + field + ", code=" + code + "]";
	}

}
