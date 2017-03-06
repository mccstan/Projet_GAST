public class ProjectFunctions {

    //FUNCTION meanSpeed(mgp MGPoint_V) RETURN NUMBER; 
    public static double meanSpeed(MGPoint_V mgp) {
		if (mgp == null)
			return null;
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
}