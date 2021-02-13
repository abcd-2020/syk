package board;

import java.sql.Date;

public class Board {
	private int board_id;//sequence
	private String writer;
	private String w_date;
	private String title;
	private String content;

	
	public Board() {
		
	}
	
	

	public Board(int board_id, String writer, String w_date, String title, String content) {
		super();
		this.board_id = board_id;
		this.writer = writer;
		this.w_date = w_date;
		this.title = title;
		this.content = content;
	}



	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getw_date() {
		return w_date;
	}

	public void setw_date(String w_date) {
		this.w_date = w_date;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	

	@Override
	public String toString() {
		return "Board [board_id=" + board_id + ", writer=" + writer + ", w_date=" + w_date + ", title=" + title
				+ ", content=" + content + "]";
	}



	@Override
	public boolean equals(Object arg0) {
		
		if(arg0 != null && arg0 instanceof Board) {
			if(((Board)arg0).getBoard_id()==board_id) {
				return true;
			}
		}
		
		return false;
	}

}
