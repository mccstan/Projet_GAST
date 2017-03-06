package types_g3;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class MGPOINT_V_G3 implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "SYSMAN.MGPOINT_V_G3";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[1];
  static
  {
    _factory[0] = UGPOINT_V_G3.getORADataFactory();
  }
  protected static final MGPOINT_V_G3 _MGPOINT_V_G3Factory = new MGPOINT_V_G3();

  public static ORADataFactory getORADataFactory()
  { return _MGPOINT_V_G3Factory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[1], _sqlType, _factory); }
  public MGPOINT_V_G3()
  { _init_struct(true); }
  public MGPOINT_V_G3(UGPOINT_V_G3 units) throws SQLException
  { _init_struct(true);
    setUnits(units);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(MGPOINT_V_G3 o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new MGPOINT_V_G3();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public UGPOINT_V_G3 getUnits() throws SQLException
  { return (UGPOINT_V_G3) _struct.getAttribute(0); }

  public void setUnits(UGPOINT_V_G3 units) throws SQLException
  { _struct.setAttribute(0, units); }

}
