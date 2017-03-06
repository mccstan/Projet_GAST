public class ProjectFunctions {

    //FUNCTION MaxOffset(mgp MGPoint_V) RETURN NUMBER; 
    public static double MaxOffset (MGPoint_V mgp) {
		if (mgp == null)
			return null;
		UGPoint ugp;
        double maxOffset = 0;
		try {
			for (int i=0; i<mgp.getUnits().length(); i++) {
				ugp = mgp.getUnits().getElement(i);
                if abs_v(ugp.getOffset > maxOffset)
                    maxOffset = ugp.getOffset;
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return maxOffset;
	}
    //Valeur absolue
    public double abs_v(double v){
        if (v < 0 )
            return -v;
        return v;
    }



    // FUNCTION withinDistance(mp1 MPoint_V, mp2 MPoint_V, distance NUMBER) RETURN NUMBER; 
}


/*
Functions : 
    Vitesse Moyenne sur une trajectoire  MGPoint_V
        FUNCTION meanSpeed(mgp MGPoint_V) RETURN NUMBER; 
    Vérifier si une trajectoire(MPoint) passe par un Point : y=mx+p
        FUNCTION isOnTrajectory(mp MPoint_V, point_x NUMBER, point_y NUMBER) RETURN NUMBER; 
*/