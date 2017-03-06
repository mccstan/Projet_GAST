CREATE OR REPLACE PACKAGE mos_g3 AS

-- HEADERS
    FUNCTION withinDistance(mp1 MPoint_V_G3, mp2 MPoint_V_G3, distance NUMBER) RETURN NUMBER;
    FUNCTION meanSpeed(mgp MGPoint_V_G3) RETURN NUMBER;
    FUNCTION isOnTrajectory(mp MPoint_V_G3, point_x NUMBER, point_y NUMBER) RETURN NUMBER;
    FUNCTION MaxOffset(mgp MGPoint_V) RETURN NUMBER; 

END mos_g3;
/

CREATE OR REPLACE PACKAGE BODY mos_g3 AS

    FUNCTION withinDistance(mp1 MPoint_V_G3, mp2 MPoint_V_G3, distance NUMBER) RETURN NUMBER AS
    LANGUAGE java name 'functionsProjectFunctions.withinDistance(types_g3.MPOINT_V_G3, types_g3.MPOINT_V_G3, java.lang.double) return double';

    FUNCTION meanSpeed(mgp MGPoint_V_G3) RETURN NUMBER AS
    LANGUAGE java name 'functionsProjectFunctions.meanSpeed(types_g3.MGPOINT_V_G3) return java.lang.double';

    FUNCTION isOnTrajectory(mp MPoint_V_G3, point_x NUMBER, point_y NUMBER) RETURN NUMBER AS
    LANGUAGE java name 'functionsProjectFunctions.isOnTrajectory(types_g3.MGPOINT_V_G3, java.lang.double, java.lang.double) return java.lang.double';

    FUNCTION MaxOffset(mgp MGPoint_V) RETURN NUMBER AS
    LANGUAGE java name 'functionsProjectFunctions.MaxOffset(types_g3.MGPOINT_V_G3) return java.lang.double';

END mos_g3;
/