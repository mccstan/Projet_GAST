CREATE OR REPLACE PACKAGE mos_g3 AS

-- HEADERS
    FUNCTION withinDistance(mp1 MPoint_V_G3, mp2 MPoint_V_G3, distance NUMBER) RETURN NUMBER;
    FUNCTION meanSpeed(mgp MGPoint_V_G3) RETURN NUMBER;
    FUNCTION isOnTrajectory(MPoint_V_G3 mp, point_x NUMBER, point_y NUMBER) RETURN NUMBER;
    FUNCTION MaxOffset(mgp MGPoint_V) RETURN NUMBER; 

END mos_g3;
/

CREATE OR REPLACE PACKAGE BODY mos_g3 AS

    FUNCTION withinDistance(mp1 MPoint_V_G3, mp2 MPoint_V_G3, distance NUMBER) RETURN NUMBER AS
    LANGUAGE java name 'functionsProjectFunctions.withinDistance(MPOINT_V_G3 mp1, MPOINT_V_G3 mp2, double distance) return double';

    FUNCTION meanSpeed(mgp MGPoint_V_G3) RETURN NUMBER AS
    LANGUAGE java name 'functionsProjectFunctions.meanSpeed(MGPOINT_V_G3 mgp) return double';

    FUNCTION isOnTrajectory(MPoint_V_G3 mp, point_x NUMBER, point_y NUMBER) RETURN NUMBER
    LANGUAGE java name 'functionsProjectFunctions.meanSpeed(MGPOINT_V_G3 mgp) return double';

    FUNCTION MaxOffset(mgp MGPoint_V) RETURN NUMBER AS
    LANGUAGE java name 'functionsProjectFunctions.MaxOffset(MGPOINT_V_G3 mgp) return double';

END mos_g3;
/