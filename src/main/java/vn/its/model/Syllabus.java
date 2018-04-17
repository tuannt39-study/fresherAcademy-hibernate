package vn.its.model;

import javax.persistence.Embeddable;

@Embeddable
public class Syllabus {
	private String content;
	private int duration;

	public Syllabus() {
		super();
	}

	public Syllabus(String content, int duration) {
		super();
		this.content = content;
		this.duration = duration;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return content + " - " + duration;
	}

}
