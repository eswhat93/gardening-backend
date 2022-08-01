package com.garden.common.util;

public class StringCheck {

  public StringCheck(){

  }

  public Boolean isEmpty(String item){
    if(item != null && item != "" && !item.trim().isEmpty()){
      return true;
    }
    return false;
  }
}
