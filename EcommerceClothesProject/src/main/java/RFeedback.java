
public class RFeedback {

	protected int id;
	protected String Feedback;

	public RFeedback(int id, String feedback) {
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


	
	public RFeedback(String Feedback) {
		super();
		this.Feedback = Feedback;
	}
	
	
	public String getFeedback() {
		return Feedback;
	}
	
	
	public void setFeedback(String Feedback) {
		this.Feedback = Feedback;
	}
	
	
	
}
