import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;


public class Messenger extends JFrame{

	private static final long serialVersionUID = 1L;

	JPanel jplContacts;
	JPanel jplFavorites;
	JPanel jplNonFavorites;
	JPanel jplText;
	
	ArrayList<UserButton> lblFavorites;
	ArrayList<UserButton> lblNonFavorites;
	
	String userName;
	
	public Messenger(){
		super("Messenger");
		
		userName = "All";		
	
		//------------------------- erstellen der favorite Label
		lblFavorites = new ArrayList<UserButton>();
		for(int i=0;i<10;i++){
			lblFavorites.add(new UserButton("favorite " + i,i));			
		}		
		
		//------------------------- erstellen der nonFavorite Label
		lblNonFavorites = new ArrayList<UserButton>();
		for(int i=0;i<100;i++){
			lblNonFavorites.add(new UserButton("nonFavorite " + i,i+10));			
		}	
		
		//------------------------- draw Contacts
		drawContacts();
		
		//------------------------- adding favorite pane to contact pane
		jplContacts.add(jplFavorites);
		
		//------------------------- adding a seperator to contact pane
		jplContacts.add(new JSeparator(JSeparator.HORIZONTAL));
		
		//------------------------- adding nonFavorite pane to contact pane
		jplContacts.add(jplNonFavorites);
		
		

		jplText = new JPanel();
		jplText.add( new JLabel( new ImageIcon("/home/lowlorenz/Bilder/myOwnPics/DSC01611.JPG") ) );
		
		
		this.setVisible(true);
		this.setLayout( new BorderLayout() );
		this.add(jplContacts, BorderLayout.LINE_START);
		this.add(jplText, BorderLayout.CENTER);
		
		this.pack();
		
	}
	
	public void drawContacts(){
		//------------------------- erstellen des Contact Panes
		jplContacts = new JPanel();	
		jplContacts.setLayout( new BoxLayout(jplContacts, BoxLayout.Y_AXIS));	
		
		//------------------------- erstellen des favorite Panes
		jplFavorites = new JPanel();
		jplFavorites.setLayout(new BoxLayout(jplFavorites, BoxLayout.Y_AXIS));
	

		//------------------------- adding favorite label to favorite pane
		lblFavorites.forEach(
				e -> {
					JPanel jpl = new JPanel();
					JButton jbt = new JButton("-");
					
					jbt.addActionListener(
							event -> dropFavorite(e.getUserID())
							);		
					
					jpl.setLayout( new BoxLayout(jpl, BoxLayout.X_AXIS));
					jpl.add(e);
					jpl.add(jbt);
					
					jplFavorites.add(jpl);
					jplFavorites.add(Box.createRigidArea(new Dimension(e.getWidth(),5)));
				}
			);
		
		
		//------------------------- erstellen des nonFavorite Panes
		jplNonFavorites = new JPanel();
		jplNonFavorites.setLayout(new BoxLayout(jplNonFavorites, BoxLayout.Y_AXIS));

		//------------------------- adding nonFavorite label to nonFavorite pane
		lblNonFavorites.forEach(
				e -> {					
					JPanel jpl = new JPanel();
					JButton jbt = new JButton("+");
					
					jbt.addActionListener(
							event -> addFavorite(e.getUserID())
							);					
					
					jpl.setLayout( new BoxLayout(jpl, BoxLayout.X_AXIS));
					jpl.add(e);
					jpl.add(jbt);
					
					jplNonFavorites.add(jpl);
					jplNonFavorites.add(Box.createRigidArea(new Dimension(e.getWidth(),5)));
				}
			);
	}
	
	private void addFavorite(int id){
		System.out.println("add - " + id);
	}
	
	private void dropFavorite(int id){
		System.out.println("drop - " + id);
	}
	
	public static void main(String[] args){
		new Messenger();
	}
	
}
