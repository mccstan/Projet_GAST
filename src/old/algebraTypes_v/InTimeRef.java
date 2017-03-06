package algebraTypes_v;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class InTimeRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "SYSMAN.INTIME";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final InTimeRef _InTimeRefFactory = new InTimeRef();

  public static ORADataFactory getORADataFactory()
  { return _InTimeRefFactory; }
  /* constructor */
  public InTimeRef()
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
    InTimeRef r = new InTimeRef();
    r._ref = (REF) d;
    return r;
  }

  public static InTimeRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (InTimeRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to InTimeRef: "+exn.toString()); }
  }

  public InTime getValue() throws SQLException
  {
     return (InTime) InTime.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(InTime c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
