package functions;

import java.sql.SQLException;

import types_g3.MGPOINT_V_G3;
import types_g3.MPOINT_V_G3;
import types_g3.UGPOINT_G3;
import types_g3.UPOINT_G3;

public class ProjectFunctions {

    //FUNCTION MaxOffset(mgp MGPoint_V) RETURN NUMBER; 
    public static double MaxOffset (MGPOINT_V_G3 mgp) {
		if (mgp == null)
			return 0;
			
		UGPOINT_G3 ugp;
        double maxOffset = 0;
		try {
			for (int i=0; i<mgp.getUnits().length(); i++) {
				ugp = mgp.getUnits().getElement(i);
                if (Math.abs(ugp.getOffset().doubleValue()) > maxOffset)
                    maxOffset = ugp.getOffset().doubleValue();
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return maxOffset;
	}


	//fonction isOnTrajectory, détermine si un un point est sur une trajectoire. 
	//FUNCTION isOnTrajectory(mp MPoint_V, point_x NUMBER, point_y NUMBER) RETURN NUMBER;
	public static double isOnTrajectory(MPOINT_V_G3 mp, double point_x, double point_y){
		
		//si la trajectoir est null on retourn 0
		if(mp == null) return 0; 
		UPOINT_G3 ump;
		//
		try{
			//pour chaque unité de trajectoire 
			for(int i=0; i<mp.getUnits().length(); i++){
				
				//recupérer chaque unité de trajectoire
				ump = mp.getUnits().getElement(i);
				
				//ecrire l'équation de la droite y = mX + p
				// m = (Yb - Ya)/(Xb - Xa)
				// p = Ya - mXa
				
				double m = (ump.getPoint2Y().doubleValue() - ump.getPoint1Y().doubleValue()) / (ump.getPoint2X().doubleValue() - ump.getPoint1X().doubleValue());
				double p = ump.getPoint1Y().doubleValue() - m*ump.getPoint1X().doubleValue(); 
				
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
	    public static double meanSpeed(MGPOINT_V_G3 mgp) {
			//if (mgp == null)
			//	return null;
			UGPOINT_G3 ugp;
	        double temps=0;
	        double distance=0;
	        double vitesse = 0;
			try {
				for (int i=0; i<mgp.getUnits().length(); i++) {
					ugp = mgp.getUnits().getElement(i);
	                distance += ugp.getPos2().doubleValue() - ugp.getPos1().doubleValue();
	                temps += ugp.getT2().doubleValue() - ugp.getT1().doubleValue();

				}
	            vitesse = distance/temps ;
			} catch (SQLException e) { e.printStackTrace(); }
			
			return vitesse;
		}
	    
	  
	 // FUNCTION withinDistance(mp1 MPoint_V, mp2 MPoint_V, distance NUMBER) RETURN NUMBER;
	    public static double withinDistance(MPOINT_V_G3 mp1, MPOINT_V_G3 mp2, double distance){
	    	UPOINT_G3 uPointUn;
	    	UPOINT_G3 uPointDeux;
	    	
	    	try {
	    		int min = ( mp1.getUnits().length() < mp2.getUnits().length()) ? mp1.getUnits().length() : mp2.getUnits().length();
				for (int i=0; i<min; i++) {
					uPointUn = mp1.getUnits().getElement(i);
					uPointDeux = mp2.getUnits().getElement(i);
					if(Math.sqrt(Math.pow(uPointDeux.getPoint1X().doubleValue() - uPointUn.getPoint1X().doubleValue(), 2) +  Math.pow(uPointDeux.getPoint1Y().doubleValue() - uPointUn.getPoint1Y().doubleValue(), 2)) - distance>0  ){
						return 0;
					}
				}
			} catch (SQLException e) { e.printStackTrace(); }
	    	
	    	return 1;
	    }
	    
}	