package com.sddevops.selenium_EcommerceClothesProject;

import java.util.Comparator;
import java.util.Objects;

public class Feedback {
	
	protected int id;
	protected String Feedback;

	public Feedback(int id, String feedback) {
		super();
		this.id = id; 
		this.Feedback = feedback;
	}
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getFeedback() {
		return Feedback;
	}
	
	
	public void setFeedback(String Feedback) {
		this.Feedback = Feedback;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, Feedback);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Feedback))
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(Feedback, other.Feedback) && Objects.equals(id, other.id);
				
	}

	
}