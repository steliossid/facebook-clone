
public class Main {
	
	public static void main(String[] args) {
		
		Database.connect();
		
		User u1 = new User(Database.assignUID(), "Rhett", "rhett@foo.com");
		User u2 = new User(Database.assignUID(), "Jazmin", "jazmin@foo.com");
		User u3 = new User(Database.assignUID(), "Dayle", "dayle@foo.com");
		User u4 = new User(Database.assignUID(), "Tatiana", "tatiana@foo.com");
		User u5 = new User(Database.assignUID(), "Bonnie", "bonnie@foo.com");
		User u6 = new User(Database.assignUID(), "Allan", "allan@foo.com");
		User u7 = new User(Database.assignUID(), "Devin", "devin@foo.com");
		
		Group g1 = new Group(Database.assignUID(), "TechGurus", "A group for tech enthusiasts");
		ClosedGroup g2 = new ClosedGroup(Database.assignUID(), "ExamSolutions", "Solutions to common exam questions");
		
		u1.addFriend(u2);
		u1.addFriend(u3);
		u1.addFriend(u4);
		u1.addFriend(u5);
		u1.addFriend(u6);
		u1.addFriend(u1);
		
		u2.addFriend(u1);
		u2.addFriend(u3);
		u2.addFriend(u4);
		u2.addFriend(u5);
		u2.addFriend(u2);
		
		u6.addFriend(u2);
		u6.addFriend(u1);
		
		u1.mutualFriends(u2);
		u6.mutualFriends(u1);
		
		u1.printFriends();	
		u2.printFriends();
		u6.printFriends();
		
		g1.addToGroup(u1);
		g1.addToGroup(u2);
		g1.addToGroup(u1);
		g1.addToGroup(u5);
		g1.addToGroup(u7);
		
		g2.addToGroup(u1);
		g2.addToGroup(u2);
		g2.addToGroup(u6);
		g2.addToGroup(u6);
		g2.addToGroup(u3);
		g2.addToGroup(u7);
		
		g1.printMembers();
		g2.printMembers();

	}

}
