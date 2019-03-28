import java.util.Iterator;

public class ClosedGroup extends Group{
	
	public ClosedGroup(int id, String name, String description) {
		super(id, name, description);
		Database.insertGroup(id, name, description);
	}
	
	// Method that overrides addToGroup. Only mutual friends can be members of closed groups
	// The first member can join a closed group without the mutual friends restriction
	public void addToGroup(User aUser) {
		
		if(this.isMember(aUser)) {
			System.out.println(aUser.getName() + " is already enrolled to "
								+ this.getName() + " closed group");
		}
		else {
			if(this.membersList.size()==0) {
				this.membersList.add(aUser);
				System.out.println(aUser.getName() + " is the first one to enroll to "
									+ this.getName() + " closed group");
			}
			else {
				for(Iterator<User> it = membersList.iterator(); it.hasNext();) {
					User u = it.next();
					if(u.isFriend(aUser)) {
						this.membersList.add(aUser);
						System.out.println(aUser.getName() + " is successfully enrolled to "
											+ this.getName() + " closed group");
					}
				}
			}
		}
	}
}
