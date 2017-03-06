package functions;

import java.sql.SQLException;

public class ProjectFunctions {

    //FUNCTION MaxOffset(mgp MGPoint_V) RETURN NUMBER; 
    public static double MaxOffset (MGPoint_V mgp) {
		/*if (mgp == null)
			return null;
			*/
		UGPoint ugp;
        double maxOffset = 0;
		try {
			for (int i=0; i<mgp.getUnits().length(); i++) {
				ugp = mgp.getUnits().getElement(i);
                if (Math.abs(ugp.getOffset) > maxOffset)
                    maxOffset = ugp.getOffset;
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return maxOffset;
	}


	//fonction isOnTrajectory, détermine si un un point est sur une trajectoire. 
	//FUNCTION isOnTrajectory(mp MPoint_V, point_x NUMBER, point_y NUMBER) RETURN NUMBER;
	public static double isOnTrajectory(Mpoint_V mp, double point_x, double point_y){
	
		//si la trajectoir est null on retourn 0
		if(mp == null) return 0; 
		
		//
		try{
			//pour chaque unité de trajectoire 
			for(int i=0; mp.getUnits().length(); i++){
				
				//recupérer chaque unité de trajectoire
				umg = mp.getUnits().getElement(i);
				
				//ecrire l'équation de la droite y = mX + p
				// m = (Yb - Ya)/(Xb - Xa)
				// p = Ya - mXa
				
				int m = (umg.getPoint2_y - umg.getPoint1_y) / (umg.getPoint2_x - umg.getPoint1_x);
				int p = umg.getPoint1_y - m*umg.getPoint1_x; 
				
				//Verifier si le point donné verifie est sur la doite 
				//si OUI retourner immédiatement 1
				
				if((point_x*m + p) == point_y ) return 1; 
		
			}
			
		
		}catch(Exception e){
		
			System.out.println("L'erreur est : "+e.getMessage()); 
			
		}
		
		//si nous arrivons ici, c'est que le point n'est pas sur la droite 
		return 0;
	}
	
	    
	//FUNCTION meanSpeed(mgp MGPoint_V) RETURN NUMBER; 
	    public static double meanSpeed(MGPoint_V mgp) {
			//if (mgp == null)
			//	return null;
			UGPoint ugp;
	        double temps=0;
	        double distance=0;
	        double vitesse = 0;
			try {
				for (int i=0; i<mgp.getUnits().length(); i++) {
					ugp = mgp.getUnits().getElement(i);
	                distance += ugp.getPos2() - ugp.getPos1();
	                temps += ugp.getT2() - ugp.getT1();

				}
	            vitesse = distance/temps ;
			} catch (SQLException e) { e.printStackTrace(); }
			
			return vitesse;
		}
	    
	  
	 // FUNCTION withinDistance(mp1 MPoint_V, mp2 MPoint_V, distance NUMBER) RETURN NUMBER;
	    public static double withinDistance(MPoint_V mp1, MPoint_V mp2, double distance){
	    	UPoint uPointUn;
	    	UPoint uPointDeux;
	    	int min = minus(mp1.getUnits().lenth(),mp2.getUnits().length());
	    	try {
				for (int i=0; i<min; i++) {
					uPointUn = mp1.getUnits().getElement(i);
					uPointDeux = mp2.getUnits().getElement(i);
					if(Math.sqrt(Math.pow(uPointDeux.getPoint1_x()-uPointUn.getPoint1_x()) +  Math.pow(uPointDeux.getPoint1_y()-uPointUn.getPoint1_y())) - distance>0  ){
						return 0;
					}
				}
			} catch (SQLException e) { e.printStackTrace(); }
	    	
	    	return 1;
	    }
	    public int minus(int a, int b){
	    	if(a<b){
	    		return a;
	    	}
	    	else{
	    		return b;
	    	}
	    }
	    
	
}	