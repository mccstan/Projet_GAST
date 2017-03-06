package types_g3;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.jpub.runtime.MutableArray;

public class UPOINT_V_G3 implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "SYSMAN.UPOINT_V_G3";
  public static final int _SQL_TYPECODE = OracleTypes.ARRAY;

  MutableArray _array;

private static final UPOINT_V_G3 _UPOINT_V_G3Factory = new UPOINT_V_G3();

  public static ORADataFactory getORADataFactory()
  { return _UPOINT_V_G3Factory; }
  /* constructors */
  public UPOINT_V_G3()
  {
    this((UPOINT_G3[])null);
  }

  public UPOINT_V_G3(UPOINT_G3[] a)
  {
    _array = new MutableArray(2002, a, UPOINT_G3.getORADataFactory());
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _array.toDatum(c, _SQL_NAME);
  }

  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    UPOINT_V_G3 a = new UPOINT_V_G3();
    a._array = new MutableArray(2002, (ARRAY) d, UPOINT_G3.getORADataFactory());
    return a;
  }

  public int length() throws SQLException
  {
    return _array.length();
  }

  public int getBaseType() throws SQLException
  {
    return _array.getBaseType();
  }

  public String getBaseTypeName() throws SQLException
  {
    return _array.getBaseTypeName();
  }

  public ArrayDescriptor getDescriptor() throws SQLException
  {
    return _array.getDescriptor();
  }

  /* array accessor methods */
  public UPOINT_G3[] getArray() throws SQLException
  {
    return (UPOINT_G3[]) _array.getObjectArray(
      new UPOINT_G3[_array.length()]);
  }

  public UPOINT_G3[] getArray(long index, int count) throws SQLException
  {
    return (UPOINT_G3[]) _array.getObjectArray(index,
      new UPOINT_G3[_array.sliceLength(index, count)]);
  }

  public void setArray(UPOINT_G3[] a) throws SQLException
  {
    _array.setObjectArray(a);
  }

  public void setArray(UPOINT_G3[] a, long index) throws SQLException
  {
    _array.setObjectArray(a, index);
  }

  public UPOINT_G3 getElement(long index) throws SQLException
  {
    return (UPOINT_G3) _array.getObjectElement(index);
  }

  public void setElement(UPOINT_G3 a, long index) throws SQLException
  {
    _array.setObjectElement(a, index);
  }

}
