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
  private String message;

  public Response(T data, Integer code) {
    this.data = data;
    this.code = code;
  }

  public Response(T data, Integer code, String message) {
    this.data = data;
    this.code = code;
    this.message = message;
  }

  public T getData() {
    return this.data;
  }

  public Integer getCode() {
    return this.code;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }
  
}
