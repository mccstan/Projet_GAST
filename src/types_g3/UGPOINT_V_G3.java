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

public class UGPOINT_V_G3 implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "SYSMAN.UGPOINT_V_G3";
  public static final int _SQL_TYPECODE = OracleTypes.ARRAY;

  MutableArray _array;

private static final UGPOINT_V_G3 _UGPOINT_V_G3Factory = new UGPOINT_V_G3();

  public static ORADataFactory getORADataFactory()
  { return _UGPOINT_V_G3Factory; }
  /* constructors */
  public UGPOINT_V_G3()
  {
    this((UGPOINT_G3[])null);
  }

  public UGPOINT_V_G3(UGPOINT_G3[] a)
  {
    _array = new MutableArray(2002, a, UGPOINT_G3.getORADataFactory());
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
    UGPOINT_V_G3 a = new UGPOINT_V_G3();
    a._array = new MutableArray(2002, (ARRAY) d, UGPOINT_G3.getORADataFactory());
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
  public UGPOINT_G3[] getArray() throws SQLException
  {
    return (UGPOINT_G3[]) _array.getObjectArray(
      new UGPOINT_G3[_array.length()]);
  }

  public UGPOINT_G3[] getArray(long index, int count) throws SQLException
  {
    return (UGPOINT_G3[]) _array.getObjectArray(index,
      new UGPOINT_G3[_array.sliceLength(index, count)]);
  }

  public void setArray(UGPOINT_G3[] a) throws SQLException
  {
    _array.setObjectArray(a);
  }

  public void setArray(UGPOINT_G3[] a, long index) throws SQLException
  {
    _array.setObjectArray(a, index);
  }

  public UGPOINT_G3 getElement(long index) throws SQLException
  {
    return (UGPOINT_G3) _array.getObjectElement(index);
  }

  public void setElement(UGPOINT_G3 a, long index) throws SQLException
  {
    _array.setObjectElement(a, index);
  }

}
