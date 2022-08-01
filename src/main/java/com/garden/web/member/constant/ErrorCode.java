package com.garden.web.member.constant;

public enum ErrorCode {

  ID_NOT_FOUND("id.not.found"),
  USER_NOT_FOUND("user.not.found"),
  USER_ALREADY_EXISTED("user.already.existed");

  private String msgCode;

  private ErrorCode(String msgCode){this.msgCode = msgCode;}

  public String getCode(){return this.name();}

  public String getMsgCode(){return msgCode;}

  public boolean isEqual(String code){return this.getCode().equals(code);}

  public boolean isEqual(ErrorCode errorCode){return isEqual(errorCode.getCode());}
}
