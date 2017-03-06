-- Type MGPoint étendu : ajout de l'offset

/*
ugpoint: record {
        nid: int;
        rid: int;
        side: { up, down, none }  -  {  1, 0, -1 };
        offset: [-inf; +inf] -  (Tajectoire variant entre entre -n et n en cm);
        t1: real;
        t2: real;
        pos1: real;
        pos2: real;
}	
*/

CREATE OR REPLACE TYPE ugpoint AS
object(nid INTEGER,   rid INTEGER,   side INTEGER, offset NUMBER,   t1 NUMBER,   t2 NUMBER,   pos1 NUMBER,   pos2 NUMBER)
/

CREATE OR REPLACE TYPE UGPOINT_V AS VARRAY(10000) OF ugpoint;
/

CREATE OR REPLACE TYPE MGPOINT_V AS
object(units UGPOINT_V);
/





-- Type MPoint : trajectoire 

/*
upoint: record {
        nid: int;
        rid: int;
        side: { up, down, none }  -  {  1, 0, -1 };
        offset: [-inf; +inf] -  (Tajectoire variant entre entre -n et n en cm);
        t1: real;
        t2: real;
        pos1: real;
        pos2: real;
}	
*/

CREATE OR REPLACE TYPE upoint AS
object(point1_x NUMBER, point1_y NUMBER, point2_x NUMBER, point2_y NUMBER, t1 NUMBER,   t2 NUMBER)
/
 
CREATE OR REPLACE TYPE UPOINT_V AS VARRAY(10000) OF ugpoint;
/


CREATE OR REPLACE TYPE MPOINT_V AS
object(units UPOINT_V);
/
