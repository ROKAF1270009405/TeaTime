package com.teatime.dto;

public class CustomerServiceDTO {

	private int qnano;        // Q&A 게시글 번호
	private String id;        // 아이디
	private String title;     // 제목
	private String content;   // 내용
	private String csreply;   // 답변

	public CustomerServiceDTO(int qnano, String id, String title, String content, String csreply) {
		super();
		this.qnano = qnano;
		this.id = id;
		this.title = title;
		this.content = content;
		this.csreply = csreply;
	}

	public CustomerServiceDTO() {

	}

	public int getQnano() {
		return qnano;
	}

	public void setQnano(int qnano) {
		this.qnano = qnano;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCsreply() {
		return csreply;
	}

	public void setCsreply(String csreply) {
		this.csreply = csreply;
	}

} // end customerServiceDTO class
