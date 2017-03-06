package types_g3;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class UGPOINT_G3Ref implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "SYSMAN.UGPOINT_G3";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final UGPOINT_G3Ref _UGPOINT_G3RefFactory = new UGPOINT_G3Ref();

  public static ORADataFactory getORADataFactory()
  { return _UGPOINT_G3RefFactory; }
  /* constructor */
  public UGPOINT_G3Ref()
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
    UGPOINT_G3Ref r = new UGPOINT_G3Ref();
    r._ref = (REF) d;
    return r;
  }

  public static UGPOINT_G3Ref cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (UGPOINT_G3Ref) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to UGPOINT_G3Ref: "+exn.toString()); }
  }

  public UGPOINT_G3 getValue() throws SQLException
  {
     return (UGPOINT_G3) UGPOINT_G3.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(UGPOINT_G3 c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
