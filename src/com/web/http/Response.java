package com.web.http;

public class Response {
    private int code;
    private String message;
    
    public Response(int code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * @return the code
   */
  public int getCode() {
    return code;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

}