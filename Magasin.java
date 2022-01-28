import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import FirstAgent.DailyBehaviour;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Magasin extends JFrame {

	JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
    int i;
    int j;
    Objets[][] magasin;
    private JLabel infoProduit;
    private JLabel idProduit;
    private JLabel nbProduit;
    private JLabel poidsProduit;
    private JLabel choixCapacite;
    JTextField capacite;
    JTextField id;
    JTextField nb;
    JTextField poids;
    JButton ajoutProduit;
    JButton envoyer;
    JButton enregistrer;
    FirstAgent robot;
    Produits pr;
    ArrayList<Produits> produits = new ArrayList<Produits>();
    static Magasin frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 
						frame = new Magasin(8,6);
						frame.setVisible(true);
					
					
					//Runtime rt= Runtime.instance();
					Runtime rt= Runtime.instance();
					Profile pro=new ProfileImpl();
					pro.setParameter(Profile.MAIN_HOST, "localhost");
					pro.setParameter(Profile.GUI, "true");
					ContainerController cc = rt.createMainContainer(pro);
					AgentController ac1,ac2,ac3;
					try {
					   ac1=cc.createNewAgent("Agent1", "FirstAgent", new Object[]{frame,7,1} );
                       ac2=cc.createNewAgent("Agent2", "FirstAgent", new Object[]{frame,7,2} );
					   ac3=cc.createNewAgent("Agent3", "SecondAgent",new Object[]{frame} );
					   ac3.start();
					   ac1.start();
					   ac2.start();
					}catch(StaleProxyException e) {
						e.printStackTrace();
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Magasin(int n, int m) {
		i=n;
		j=m;
		magasin= new Objets[n][m];
		
		for(int p=0; p<i; p++) {
			for(int k=0; k<j; k++ ) {
				magasin[p][k]=new Objets(p,k,"vide",0);
				
			}
			
		}
		
		
		for(int p=0; p<i; p++) {
			for(int k=0; k<j; k++ ) {
				if(magasin[p][k].type=="Armoire") 
				{
					magasin[p][k].btn.addMouseListener(new MouseAdapter() {
						@Override
					
					    public void mouseClicked(MouseEvent e) {
							JOptionPane.showMessageDialog(contentPane, "Cette armoire contient les produits suivants et de capacité");
						}
						
				});;
				
				}}}
		
	   
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel1 =new JPanel();
		panel2 =new JPanel();
		panel2.setLayout(null);
		infoProduit =new JLabel("Information sur le Produit");
		infoProduit.setForeground(Color.blue);
		infoProduit.setBounds(60,100,200,25);
		idProduit =new JLabel("L'id du Produit");
		idProduit.setBounds(5,150,170,25);
		poidsProduit =new JLabel("Le poids du produit");
		poidsProduit.setBounds(5,180,170,25);
		choixCapacite =new JLabel("Choisir une capacité");
		choixCapacite.setBounds(5,20,190,25);
		nbProduit =new JLabel("Nombre de boites de ce produit");
		nbProduit.setBounds(5,210,190,25);
		ajoutProduit=new JButton("Ajouter ce produit");
		ajoutProduit.setBounds(5,250,150,25);
		envoyer=new JButton("Envoyer");
		envoyer.setBounds(160,250,90,25);
		enregistrer=new JButton("enregistrer");
		enregistrer.setBounds(80,60,100,25);
		
		id=new JTextField();
		id.setBounds(190,150,50,25);
		nb=new JTextField();
		nb.setBounds(190,210,50,25);
		poids=new JTextField();
		poids.setBounds(190,180,50,25);
	    capacite=new JTextField();
		capacite.setBounds(190,20,50,25);
		
		panel2.add(infoProduit);
		panel2.add(idProduit);
		panel2.add(nbProduit);
		panel2.add(poidsProduit);
		panel2.add(id);
		panel2.add(nb);
		panel2.add(poids);
		panel2.add(ajoutProduit);
		panel2.add(envoyer);
		panel2.add(choixCapacite);
		panel2.add(capacite);
		panel2.add(enregistrer);
		//panel1.setLayout(null);
		panel1.setLayout(new GridLayout(8, 6));
		
		this.EtatInitial();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.add(panel2);
		contentPane.add(panel1);
		setContentPane(contentPane);
		//String s="";
		int ll=0;
		for( ll=0; ll<i; ll++) {
		
			for(int k=0; k<j; k++ ) {
				Objets mm=magasin[ll][k];
				if(mm.type=="Armoire") 
				{
					mm.btn.addMouseListener(new MouseAdapter() {
						@Override
					
					    public void mouseClicked(MouseEvent e) {
							
							//Objets ma= magasin[l][k];
							String s="";
							//int j=l;
							if((mm.produits.isEmpty()==false)) {
							for(int i=0;i<mm.produits.size();i++) {
							  s=s+" id produit: "+mm.produits.get(i).id+" Poids produit: "+mm.produits.get(i).Poids+" ";	
							}
							System.out.println("s="+s);
							JOptionPane.showMessageDialog(contentPane,"Cette armoire contient les produits suivants: "+s + " et de capacité "+mm.Capacite);
						    
						    }
							
							if((mm.produits.isEmpty())) {
								JOptionPane.showMessageDialog(contentPane,"Cette armoire est vide et sa capacité est "+mm.Capacite);
							
							}
							
						
					
				}});;
				}}}
		ajoutProduit.addMouseListener(new MouseAdapter() {
			@Override
		
		    public void mouseClicked(MouseEvent e) {
				if(Float.parseFloat(poids.getText())<=Float.parseFloat(capacite.getText())) {
				pr=new Produits(id.getText(),Float.parseFloat(poids.getText()),Integer.parseInt(nb.getText()));
				JOptionPane.showMessageDialog(contentPane, "Produit ajouté");
				for(int i=0; i<Integer.parseInt(nb.getText());i++) {
					produits.add(pr);
				}
				
				System.out.println(produits.size());
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Vérifier le poids du produit");
				}
			}
			
		
	});;
	enregistrer.addMouseListener(new MouseAdapter() {
		@Override
	
	    public void mouseClicked(MouseEvent e) {
			int ll;
			for( ll=0; ll<i; ll++) {
				
				for(int k=0; k<j; k++ ) {
					Objets mm=magasin[ll][k];
					if(mm.type=="Armoire") 
					{
						magasin[ll][k].Capacite=Float.parseFloat(capacite.getText());
					}
			
			//JOptionPane.showMessageDialog(contentPane, "Capacite armoire enregistré");
    	
		}}}
	
});;
	
	}
	public void EtatInitial() {
		//robot=new FirstAgent();
		
		for(int k=0; k< j ; k++) {
			magasin[0][k]=new Objets(0,k,"Armoire",0);
			magasin[0][k].btn.setBackground(new Color(255, 153, 0));
			
			
		}
		for(int k=2; k<6; k++ ) {
			magasin[k][0]=new Objets(k,0,"Armoire",0);
			magasin[k][0].btn.setBackground(new Color(255, 153, 0));
			
		}
		for(int k=2; k<6; k++ ) {
			magasin[k][2]=new Objets(k,2,"Armoire",0);
			magasin[k][2].btn.setBackground(new Color(255, 153, 0));
			
		}
		for(int k=2; k<6; k++ ) {
			magasin[k][4]=new Objets(k,4,"Armoire",0);
			magasin[k][4].btn.setBackground(new Color(255, 153, 0));
			
		}
		
		for(int p=0; p<i; p++) {
			for(int k=0; k<j; k++ ) {
				
				panel1.add(magasin[p][k].btn);
			}
		}
		
	
			/*enregistrer.addActionListener(new ActionListener() {
		    	
				public void actionPerformed(ActionEvent e) {
					int ll;
					for( ll=0; ll<i; ll++) {
						
						for(int k=0; k<j; k++ ) {
							Objets mm=magasin[ll][k];
							if(mm.type=="Armoire") 
							{
								magasin[ll][k].Capacite=Float.parseFloat(capacite.getText());
							}
					
					JOptionPane.showMessageDialog(contentPane, "Capacite armoire enregistré");
		    	
				}}
			}});*/
			
		
	}

}
