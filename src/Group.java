import java.util.concurrent.CopyOnWriteArrayList;

public class Group {
	
	protected String id;
	protected String name;
	protected String description;
	protected CopyOnWriteArrayList<User> membersList = new CopyOnWriteArrayList<User>();
	
	public Group(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		String sql = "INSERT INTO `group`" +
				" VALUES ('" + id + "', '" + name + "', '" + description + "')";
		Database.ExecuteSQL(sql);
	}
	
	// Method that checks if user is enrolled in a group. 
	// Returns true if he is, false if he is not.
	public boolean isMember(User aUser) {

		boolean flag = false;

		for(User u: this.membersList) {
			if(u.getId().equals(aUser.getId()))
				flag = true;
		}
		return flag;
	}
	
	// Method that adds aUser to the group
	public void addToGroup(User aUser) {
		
		if(!isMember(aUser)) {
			this.membersList.add(aUser);
			String sql = "INSERT INTO `members`" +
					" VALUES ('" + Database.assignUID() + "', '" + aUser.getId() + "', '"
					+ this.id + "')";
			Database.ExecuteSQL(sql);
			System.out.println(aUser.getName() + " is successfully enrolled to "
								+ this.getName() + "group");
		}
		else {
			System.out.println(aUser.getName() + " is already enrolled to "
								+ this.getName() + "group");
		}
	}
	
	// Method that prints all enrolled group members
	public void printMembers() {
		int i=1;
		System.out.println("\nMembers of " + this.getName() + " group:");
		for(User u: this.membersList) {
			System.out.println(i + ": " + u.getName());
			i++;
		}
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
