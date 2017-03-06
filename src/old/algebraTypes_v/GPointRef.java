package algebraTypes_v;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class GPointRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "SYSMAN.GPOINT";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final GPointRef _GPointRefFactory = new GPointRef();

  public static ORADataFactory getORADataFactory()
  { return _GPointRefFactory; }
  /* constructor */
  public GPointRef()
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
    GPointRef r = new GPointRef();
    r._ref = (REF) d;
    return r;
  }

  public static GPointRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (GPointRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to GPointRef: "+exn.toString()); }
  }

  public GPoint getValue() throws SQLException
  {
     return (GPoint) GPoint.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(GPoint c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
