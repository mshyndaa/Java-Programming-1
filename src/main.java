import java.util.*;


public class main {
	
	Scanner in = new Scanner(System.in);
	int menu = 0;
	String title;
	String genre;
	String review;
	int star = 0;
	Vector<Game> gameList = new Vector<Game>();

	public main() {
		// TODO Auto-generated constructor stub
		
		do {
			System.out.println("AD Game Stop");
			System.out.println("============");
			System.out.println("\n1. Add Game");
			System.out.println("2. View Game List");
			System.out.println("3. Add Review");
			System.out.println("4. Remove Game");
			System.out.println("5. Exit");
			System.out.print(">> ");
			
			try {
				menu = in.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
			in.nextLine();
			
			if(menu == 1) {
				add();
			} else if (menu == 2) {
				view();
			} else if (menu == 3) {
				addReview();
			} else if (menu == 4) {
				remove();
			}
			
		} while(menu != 5);
	}
	
	public void add() {
		System.out.println("AD Game Stop");
		System.out.println("============");
		
		
		do {
			System.out.print("\nInput game title [3..25 characters]: ");
			try {
				title = in.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} while (title.length() < 3 || title.length() > 25);
		
		
		do {
			System.out.print("\nInput game genre [3..20 characters]: ");
			try {
				genre = in.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} while (genre.length() < 3 || genre.length() > 20);
		
		Game game = new Game(title, genre);
		gameList.add(game);
		
		System.out.println("Game successfully added!");
		System.out.print("Press enter to continue...");
		in.nextLine();
		
	}
	
	public void view() {
		System.out.println("List of games:");
		System.out.println("==============\n");
		if(gameList.size() == 0) {
			System.out.println("No game available.");
		} else {
			printGameList();
			
			int id = 0;
			do {
				System.out.print("Choose game No, to view reviews ['0' to return]: ");
				
				try {
					id = in.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				in.nextLine();
				
				if(id > 0 && id <= gameList.size()) {
					id-=1;
					if (gameList.get(id).getRatingList().size() == 0) {
						System.out.println("No review for '"+gameList.get(id).getTitle()+"'");
					} else {
						System.out.println("List Reviews:");
						System.out.println("=============");
						for (int i = 0; i < gameList.get(id).getRatingList().size(); i++) {
							System.out.println((i+1)+". " + gameList.get(id).getRatingList().get(i).getReview());
							System.out.println("Rating: " + gameList.get(id).getRatingList().get(i).getStar());
							System.out.println();
						}
						
						System.out.print("Press enter to go back...");
						in.nextLine();
						
					}
					id+=1;
				}
				
				
			} while (id != 0);
			
			
		}
		
		System.out.print("Press enter to continue...");
		in.nextLine();
	}
	
	public void printGameList() {
		System.out.println("+====+==========================+===============+=======+");
		System.out.println("| No | Game Title\t\t| Genre\t\t| Price |");
		System.out.println("+====+==========================+===============+=======+");
		
		for (int i = 0; i < gameList.size(); i++) {
			System.out.println("| " +(i+1)+ "  | " +gameList.get(i).getTitle()+ "\t\t\t| " +gameList.get(i).getGenre()+"\t\t| "+gameList.get(i).getPrice()+"\t|");
		}
		
		System.out.println("+====+==========================+===============+=======+");
	}
	
	public void addReview() {
		
		if(gameList.size() == 0) {
			System.out.println("No game available.");
		} else {
			System.out.println("List of games:");
			System.out.println("==============\n");
			printGameList();
			System.out.println();
			
			int id = 0;
			do {
				
				System.out.print("Choose game No. to add review ['0' to cancel]: ");
				
				try {
					id = in.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				in.nextLine();
				
				if(id > 0 && id <= gameList.size()) {
					id-=1;
					
					do {
						System.out.print("Input review: ");
						review = "";
						try {
							review = in.nextLine();
						} catch (Exception e) {
							// TODO: handle exception
						}
					} while (review.length() < 1);
					
					do {
						System.out.print("Set your rating [1-5] stars: ");
						star = 0;
						try {
							star = in.nextInt();
						} catch (Exception e) {
							// TODO: handle exception
						}
						in.nextLine();
					} while (star < 1 || star > 5);
					
					Rating rating = new Rating(review, star);
					
					gameList.get(id).addRatingList(rating);
					System.out.println("Review successfully added!");
					break;
				}
				
			} while (id != 0);
		}
		
		System.out.print("Press enter to continue...");
		in.nextLine();
	}
	
	public void remove() {
		System.out.println("Remove Game");
		System.out.println("===========");
		if(gameList.size() == 0) {
			System.out.println("No game available.");
		} else {
			System.out.println("\nList of games:");
			System.out.println("===============");
			printGameList();
			System.out.println();
			
			int id = 0;
			do {
				System.out.print("Choose game No. to be removed ['0' to cancel]: ");
				
				try {
					id = in.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				in.nextLine();
				
				if(id > 0 && id <= gameList.size()) {
					gameList.remove(id-1);
					System.out.println("Game successfully removed!!");
					break;
				}
			
			} while (id != 0);
			
		}
		
		System.out.println("Press enter to continue...");
		in.nextLine();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
