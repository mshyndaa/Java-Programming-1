import java.util.*;

public class Game {
	
	private String title;
	private String genre;
	private Vector<Rating> ratingList;
	private int price;
	
	Random rand = new Random();

	public Game(String title, String genre) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.genre = genre;
		this.price = rand.nextInt(60)+1;
		this.ratingList = new Vector<Rating>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Vector<Rating> getRatingList() {
		return ratingList;
	}

	public void addRatingList(Rating rating) {
		this.ratingList.add(rating);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
