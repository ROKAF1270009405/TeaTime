package com.teatime.cs.model;

public class CustomerServiceDTO {

	private int qnano;        // Q&A 게시글 번호.
	private String id;        // 아이디
	private String title;     // 제목
	private String content;   // 내용
	private String hp;			//연락처
	private String regidate;	//글 등록일
	
	private String reply;			//답변
	private String replyregidate;	//답변 등록일
	private int state;			//답변 유무
	
	public CustomerServiceDTO() {}
	public CustomerServiceDTO(int qnano, String id, String title, String content, String hp) {
		this.qnano = qnano;
		this.id = id;
		this.title = title;
		this.content = content;
		this.hp = hp;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyregidate() {
		return replyregidate;
	}
	public void setReplyregidate(String replyregidate) {
		this.replyregidate = replyregidate;
	}
	
	

} // end customerServiceDTO class
