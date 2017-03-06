package types_g3;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class UPOINT_G3 implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "SYSMAN.UPOINT_G3";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,2,2,2,2,2 };
  protected static ORADataFactory[] _factory = new ORADataFactory[6];
  protected static final UPOINT_G3 _UPOINT_G3Factory = new UPOINT_G3();

  public static ORADataFactory getORADataFactory()
  { return _UPOINT_G3Factory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[6], _sqlType, _factory); }
  public UPOINT_G3()
  { _init_struct(true); }
  public UPOINT_G3(java.math.BigDecimal point1X, java.math.BigDecimal point1Y, java.math.BigDecimal point2X, java.math.BigDecimal point2Y, java.math.BigDecimal t1, java.math.BigDecimal t2) throws SQLException
  { _init_struct(true);
    setPoint1X(point1X);
    setPoint1Y(point1Y);
    setPoint2X(point2X);
    setPoint2Y(point2Y);
    setT1(t1);
    setT2(t2);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(UPOINT_G3 o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new UPOINT_G3();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public java.math.BigDecimal getPoint1X() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(0); }

  public void setPoint1X(java.math.BigDecimal point1X) throws SQLException
  { _struct.setAttribute(0, point1X); }


  public java.math.BigDecimal getPoint1Y() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(1); }

  public void setPoint1Y(java.math.BigDecimal point1Y) throws SQLException
  { _struct.setAttribute(1, point1Y); }


  public java.math.BigDecimal getPoint2X() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(2); }

  public void setPoint2X(java.math.BigDecimal point2X) throws SQLException
  { _struct.setAttribute(2, point2X); }


  public java.math.BigDecimal getPoint2Y() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(3); }

  public void setPoint2Y(java.math.BigDecimal point2Y) throws SQLException
  { _struct.setAttribute(3, point2Y); }


  public java.math.BigDecimal getT1() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(4); }

  public void setT1(java.math.BigDecimal t1) throws SQLException
  { _struct.setAttribute(4, t1); }


  public java.math.BigDecimal getT2() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(5); }

  public void setT2(java.math.BigDecimal t2) throws SQLException
  { _struct.setAttribute(5, t2); }

}
