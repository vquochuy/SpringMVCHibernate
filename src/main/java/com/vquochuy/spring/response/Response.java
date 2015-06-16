package com.vquochuy.spring.response;

import org.springframework.http.HttpStatus;

public class Response extends BaseResponse {

	Object response;

	public Response() {
		super();
	}

	public Response(HttpStatus statusCode, int status, String message,
			Object response) {

		super(statusCode, status, message);
		this.response = response;
		if (response == null) {
			super.setType("None");
		} else {
			super.setType(response.getClass().getSimpleName());
		}
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((response == null) ? 0 : response.hashCode());
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
		Response other = (Response) obj;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Response [response=" + response + "]";
	}

}

