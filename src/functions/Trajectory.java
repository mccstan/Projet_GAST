package functions;

public class Trajectory {

    //fonction isOnTrajectory, détermine si un un point est sur une trajectoire. 
	
    public static double isOnTrajectory(mp Mpoint_V, point_x double, point_y double ){
    
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
    	
    		print("L'erreur est : "+e.getMessage()); 
    		
    	}
    	
    	//si nous arrivons ici, c'est que le point n'est pas sur la droite 
    	return 0;
    }
}
