import java.util.ArrayList;

public class User {
	
	private int id;
	private String name;
	private String email;
	private ArrayList<User> friendsList = new ArrayList<User>();
	
	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		String sql = "INSERT INTO `user`" +
				" VALUES (" + id + ", '" + name + "', '" + email + "')";
		Database.insert(sql);
	}
	
	// Method that checks if two users are friends. 
	// Returns true if they are, false if they are not.
	public boolean isFriend(User aUser) {
		
		boolean flag = false;
		
		if(this.getId() == aUser.getId())
			flag = false;
		
		for(User u: this.friendsList) {
			if(u.getId() == aUser.getId())
				flag = true;
		}
		return flag;
	}
	
	// Method that adds aUser to the user's friend list
	public void addFriend(User aUser) {
		
		if(this.isFriend(aUser)) {
			System.out.println(this.getName() + " and " + aUser.getName() + " are already friends!");
		}	
		else {
			if(aUser.getId() == this.getId()) {
				System.out.println("You can't add yourself to the friend list!");
			}
			else {
				this.friendsList.add(aUser);
				System.out.println(this.getName() + " and " + aUser.getName() + " are now friends!");
			}
		}
	}
	
	// Method that prints mutual friends between two users
	public ArrayList<User> mutualFriends(User aUser) {
		
		System.out.println("\nMutual friends between " + this.getName() + " and "
							+ aUser.getName() + ":");
		ArrayList<User> mutual = new ArrayList<User>();
		
		int k=1;
		for(User i: this.friendsList) {
			for(User j: aUser.friendsList) {
				if(i.getId() == j.getId()) {
					mutual.add(j);
					System.out.println(k + ": " + j.getName());
					k++;
				}
			}
		}
		return mutual;
	}
	
	// Method that prints user's friend list
	public void printFriends() {
		int i=1;
		System.out.println("\nFriends of " + this.getName() + ":");
		for(User u: this.friendsList) {
			System.out.println(i + ": " + u.getName());
			i++;
		}	
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
}
