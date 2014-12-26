package com.shicaigj.ops.model;

import java.io.Serializable;

/**
 * 
 * @author mengqizhou
 *
 */
public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String username;
  private String nickname;


  public User(String username, String nickname) {
    this.username = username;
    this.nickname = nickname;
  }


  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public String getNickname() {
    return nickname;
  }


  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


}
