
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


//import FirstAgent.MyBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SecondAgent extends Agent 

     { 
	Object[] args;
	Magasin m;
	int posL;
	int posC;
	ImageIcon robot;
	float capacite;
	//Objets[][] args;
        protected void setup() 
        { 
             args = getArguments();
             m=(Magasin)args[0];
             addBehaviour( new DailyBehaviour() );
            
        }
        class DailyBehaviour extends SimpleBehaviour{
    		
    		
    		public void action() 
    	 	{
    			
    			m.envoyer.addActionListener(new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
    					JOptionPane.showMessageDialog(m.contentPane, "Produit envoyé");
    					poserProduits();
    		            
    		            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
    		            msg.setContent( "Demande envoyé" );
    		            msg.addReceiver( new AID( "Agent1" , AID.ISLOCALNAME) );
    		            msg.addReceiver( new AID( "Agent2" , AID.ISLOCALNAME) ); 
    		            send(msg);
    		           System.out.println("demande envoyé");
    		           
    				}
    			});
    	 	}
    		
    		public  boolean done() {  return true;  }
    		public void poserProduits() {
    			ImageIcon robotF =new ImageIcon(this.getClass().getResource("/robotFR.png"));
				ImageIcon carton =new ImageIcon(this.getClass().getResource("/boites.png"));
				
	            
	            m.magasin[7][1].btn.setIcon(robotF);
	            try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
	            
	            m.magasin[7][0].btn.setIcon(carton);
	            m.magasin[7][1].btn.setIcon(null);
	            try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    	}
       
    			
        
     
}