package koboldblogweb.koboldblogweb.viewmodel.response;

import org.springframework.http.HttpStatus;

public class CommonResponse<T> {
	private HttpStatus status;
	private String message;
	private T data;

	public CommonResponse(HttpStatus status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public CommonResponse(HttpStatus status, T data) {
		this(status,"",data);
	}



	public static <T> CommonResponse<?> ok(T t) {
		return new CommonResponse<>(HttpStatus.OK, "", t);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
