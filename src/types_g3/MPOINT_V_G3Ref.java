package types_g3;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class MPOINT_V_G3Ref implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "SYSMAN.MPOINT_V_G3";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final MPOINT_V_G3Ref _MPOINT_V_G3RefFactory = new MPOINT_V_G3Ref();

  public static ORADataFactory getORADataFactory()
  { return _MPOINT_V_G3RefFactory; }
  /* constructor */
  public MPOINT_V_G3Ref()
  {
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _ref;
  }

  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    MPOINT_V_G3Ref r = new MPOINT_V_G3Ref();
    r._ref = (REF) d;
    return r;
  }

  public static MPOINT_V_G3Ref cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (MPOINT_V_G3Ref) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to MPOINT_V_G3Ref: "+exn.toString()); }
  }

  public MPOINT_V_G3 getValue() throws SQLException
  {
     return (MPOINT_V_G3) MPOINT_V_G3.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(MPOINT_V_G3 c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
