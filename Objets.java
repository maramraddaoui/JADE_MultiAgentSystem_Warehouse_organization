import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;


public class Objets {

	
	public String type;
	JButton btn;
	float Capacite;
	float c;
	ArrayList<Produits> produits = new ArrayList<Produits>();
    String E;
    int nL;
    int nC;
    
	public Objets( int i,int j,String t, float C) {
		nL=i;
		nC=j;
		E="nonExplorée";
		type=t;
		//c=C;
		Capacite=C;
		btn = new JButton("");
		
		btn.setPreferredSize(new Dimension(5, 5));
		btn.setBackground(new Color(255, 255, 204));
		//btn.setBackground(Color.orange);
		
	}

}
