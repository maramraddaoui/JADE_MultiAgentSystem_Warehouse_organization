import java.util.ArrayList;
import java.sql.Struct;
import java.util.*;  
public class Astar {
	public ArrayList<Objets> listDeveloppe = new ArrayList<Objets>();  
	public ArrayList<Noeud> listPrioritaire = new ArrayList<Noeud>();
	public ArrayList<Noeud> listPere = new ArrayList<Noeud>();
	public ArrayList<Objets> listChemin = new ArrayList<Objets>();
	public int c;
	Noeud noeud;
	
	public Astar() {
		
		
	}
	public ArrayList<Objets> CheminAstar(Objets posI, Objets posF, Objets [][]magasin) {
		Objets posII=posI;
		int p=0;
		//System.out.println(posII.nL+","+posII.nC);
		//listDeveloppe.add(posI);
		while(posII!=posF) {
		listDeveloppe.add(posII);
		//System.out.println(posII.nL+","+posII.nC);
		if((posII.nL)+1<=7) {
			//System.out.println("nL+1");
			//System.out.println(posII.nL+1+","+posII.nC);
			if(magasin[(posII.nL)+1][posII.nC].type=="vide") {
				//System.out.println(notDev(magasin[(posII.nL)+1][posII.nC]));
				//System.out.println(posII.nL+","+posII.nC);
				if((notDev(magasin[(posII.nL)+1][posII.nC])==true)&&(notExist(magasin[(posII.nL)+1][posII.nC]))) {
					
					c=calculerCout(posI, posF, magasin[(posII.nL)+1][posII.nC]);
					//System.out.println("noeud:"+posII.nL+","+posII.nC);
					//System.out.println("cout:"+c);
					noeud= new Noeud(c,magasin[(posII.nL)+1][posII.nC],magasin[(posII.nL)][posII.nC]);
				    int k=0;
				    if((listPrioritaire.isEmpty()==false)&&(k<listPrioritaire.size())) {
				    while((listPrioritaire.get(k).c < noeud.c)) {
				    	k++;
				    	if(k>=listPrioritaire.size()) {
				    		break;
				    	}
				    }
				    }
                    if(k>=listPrioritaire.size()) {
				    	
				    	listPrioritaire.add(noeud);
				    }else {
				    listPrioritaire.add(k,noeud);
				    }
				    listPere.add(p,noeud);
				    p++;
				    
				
			}
		}
	}
		//System.out.println("N=");
		//System.out.println(posII.nL-1);
		if((posII.nL)-1>=0) {
			//System.out.println("nL-1");
			//System.out.println(posII.nL+","+posII.nC);
			if(magasin[(posII.nL)-1][posII.nC].type=="vide"){
				//System.out.println("vide");
				if((notDev(magasin[(posII.nL)-1][posII.nC])==true)&&(notExist(magasin[(posII.nL)-1][posII.nC]))) {
					//System.out.println("NE");
					c=calculerCout(posI, posF, magasin[(posII.nL)-1][posII.nC]);
					//System.out.println("noeud:"+posII.nL+","+posII.nC);
					//System.out.println("cout:"+c);
					noeud= new Noeud(c,magasin[(posII.nL)-1][posII.nC],magasin[(posII.nL)][posII.nC]);
				    int k=0;
				    if((listPrioritaire.isEmpty()==false)&&(k<listPrioritaire.size())) {
				    //System.out.println("notempty");
				    while((listPrioritaire.get(k).c < noeud.c)) {
				    	k++;
				    	//System.out.println(k);
				    	if(k>=listPrioritaire.size()) {
				    		break;
				    	}
				    }
				    }
                    if(k>=listPrioritaire.size()) {
				    	
				    	listPrioritaire.add(noeud);
				    }else {
				    listPrioritaire.add(k,noeud);
				    }
				    //System.out.println(noeud.fils.nL+","+noeud.fils.nC);
				    //System.out.println("lP="+listPrioritaire.size());
				    listPere.add(p,noeud);
				    p++;
				    
				
			}
		}
	}
		if(posII.nC-1>=0) {
			//System.out.println("nC-1="+posII.nC);
			//System.out.println(posII.nL+","+posII.nC);
			if(magasin[(posII.nL)][posII.nC-1].type=="vide") {
				if((notDev(magasin[(posII.nL)][posII.nC-1])==true)&&(notExist(magasin[(posII.nL)][posII.nC-1]))) {
					c=calculerCout(posI, posF, magasin[(posII.nL)][posII.nC-1]);
					//System.out.println("noeud:"+posII.nL+","+posII.nC);
					//System.out.println("cout:"+c);
					noeud= new Noeud(c,magasin[(posII.nL)][posII.nC-1],magasin[(posII.nL)][posII.nC]);
				    int k=0;
				    if((listPrioritaire.isEmpty()==false)&&(k<listPrioritaire.size())) {
				    	while((listPrioritaire.get(k).c < noeud.c)) {
				    	k++;
				    	if(k>=listPrioritaire.size()) {
				    		break;
				    	}
				        }
				    }
                    if(k>=listPrioritaire.size()) {
				    	
				    	listPrioritaire.add(noeud);
				    }else {
				    listPrioritaire.add(k,noeud);
				    }
				    
				    listPere.add(p,noeud);
				    p++;
				    
				
			}
		}
	}
		if(posII.nC+1<=5) {
			//System.out.println("nC+1");
			if(magasin[(posII.nL)][posII.nC+1].type=="vide") {
				if((notDev(magasin[(posII.nL)][posII.nC+1])==true)&&(notExist(magasin[(posII.nL)][posII.nC+1]))) {
					c=calculerCout(posI, posF, magasin[(posII.nL)][posII.nC+1]);
					//System.out.println("noeud:"+posII.nL+","+posII.nC);
					//System.out.println("cout:"+c);
					noeud= new Noeud(c,magasin[(posII.nL)][posII.nC+1],magasin[(posII.nL)][posII.nC]);
				    int k=0;
				    if((listPrioritaire.isEmpty()==false)&&(k<listPrioritaire.size())) {
				    //System.out.println("non");
				    //System.out.println(listPrioritaire.get(k).c);
				    //System.out.println(listPrioritaire.get(k).c <= noeud.c);
				    while((listPrioritaire.get(k).c <= noeud.c)) {
				    	k++;
				    	//System.out.println("k="+k);
				    	//System.out.println(listPrioritaire.size());
				    	if(k>=listPrioritaire.size()) {
				    		break;
				    	}
				    }
				    }
				    //System.out.println("k="+k);
				    if(k>=listPrioritaire.size()) {
				    	
				    	listPrioritaire.add(noeud);
				    }else {
				    listPrioritaire.add(k,noeud);
				    }
				    //System.out.println("lP="+listPrioritaire.size());
				    //System.out.println(listPrioritaire.get(0).fils.nL+","+listPrioritaire.get(0).fils.nC);
				    //System.out.println(listPrioritaire.get(1).fils.nL+","+listPrioritaire.get(1).fils.nC);
				    listPere.add(p,noeud);
				    p++;
				    
				
			}
		}
	}
		posII=listPrioritaire.get(0).fils;
		//System.out.println(posF.nL+","+posF.nC);
		//System.out.println(posII.nL+","+posII.nC);
		for (int i=0; i<listPrioritaire.size(); i++) {
		//System.out.println("noeud="+listPrioritaire.get(i).fils.nL+","+listPrioritaire.get(i).fils.nC);	
		//System.out.println("c="+listPrioritaire.get(i).c);
		}
		listPrioritaire.remove(0);
		//System.out.println(listPrioritaire.size());
		
		//System.out.println("lD="+listDeveloppe.size());
		//System.out.println(posII==posF);
		
		}
		for(int k=0; k<listPere.size()-1;k++) {
			if(listPere.get(k).fils==posII) {
				//System.out.println("c="+listPere.get(k).c);
			}}
		for(int k=0; k<listPere.size();k++) {
			//System.out.println("fils:"+listPere.get(k).fils.nL+","+listPere.get(k).fils.nC);
			//System.out.println("pere:"+listPere.get(k).pere.nL+","+listPere.get(k).pere.nC);
		}
		
		//System.out.println("size="+listPere.size());
		while(posII!=posI) {
			//System.out.println("che:"+posII.nL+","+posII.nC);
			listChemin.add(posII);
			for(int k=0; k<listPere.size();k++) {
				//System.out.println(k);
				if(listPere.get(k).fils==posII) {
					//System.out.println(k);
					posII=listPere.get(k).pere;
				}
			}
		}
		listChemin.add(posII);
		return listChemin;
		
	
		
	}
	public boolean notDev(Objets m) {
		for ( int k=0; k< listDeveloppe.size(); k++ ){
			//System.out.println("dd"+listDeveloppe.get(k).nL+","+listDeveloppe.get(k).nC);
            if (listDeveloppe.get(k)==m) {
                return false;
                
            }
            
        }
		return true;
		
		
	}
	public boolean notExist(Objets m) {
		for ( int k=0; k< listPrioritaire.size(); k++ ){
			//System.out.println("dd"+listPrioritaire.get(k).fils.nL+","+listPrioritaire.get(k).fils.nC);
            if (listPrioritaire.get(k).fils==m) {
                return false;
                
            }
            
        }
		return true;
	}
	public int calculerCout(Objets posI, Objets posF,Objets m) {
		int g;
		int h;
		//g=(m.nC+m.nL)-(posI.nC+posI.nL);
		//h=(posF.nC+posF.nL)-(m.nC+m.nL);
		g=((m.nC-posI.nC)*(m.nC-posI.nC))+((m.nL-posI.nL)*(m.nL-posI.nL));
		h=((posF.nC-m.nC)*(posF.nC-m.nC))+((posF.nL-m.nL)*(posF.nL-m.nL));
		return g+h;
	}
}
