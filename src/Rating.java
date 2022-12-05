
public class Rating {
	private String review;
	private int star;
	
	public Rating(String review, int star) {
		this.review = review;
		this.star = star;
	}
	
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	
}
