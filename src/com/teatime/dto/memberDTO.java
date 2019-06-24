package com.teatime.dto;

public class memberDTO {

	private String id;          // 아이디
	private String pwd;         // 비밀번호
	private String nickname;    // 별명
	private String mail;        // 이메일
	private int authority;      // 권한

	public memberDTO(String id, String pwd, String nickname, String mail, int authority) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.mail = mail;
		this.authority = authority;
	}

	public memberDTO() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

} // end memberDTO class
