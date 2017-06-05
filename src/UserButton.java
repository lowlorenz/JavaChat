import javax.swing.JButton;

public class UserButton extends JButton{

	private static final long serialVersionUID = 1L;
	private int userID;


	public UserButton(String name, int userID){
		super(name);
		this.userID = userID;
	}	
	
	public int getUserID() {
		return userID;
	}
}
