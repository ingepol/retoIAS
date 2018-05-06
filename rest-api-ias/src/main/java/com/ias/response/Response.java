package com.ias.response;

/**
 * Clase generica para manejar una respuesta estandar en todas las peticiones Rest
 * 
 * @author Paul Arenas
 *
 */
public class Response<T> {
	private T data;
	private Integer code;

	public Response(T data, Integer code) {
		this.data = data;
		this.code = code;
	}

	public T getData() {
		return this.data;
	}
	
	public Integer getCode() {
		return this.code;
	}
}