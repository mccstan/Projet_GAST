package algebraTypes_v;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.jpub.runtime.MutableArray;

public class Intervals_V implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "SYSMAN.INTERVALS_V";
  public static final int _SQL_TYPECODE = OracleTypes.ARRAY;

  MutableArray _array;

private static final Intervals_V _Intervals_VFactory = new Intervals_V();

  public static ORADataFactory getORADataFactory()
  { return _Intervals_VFactory; }
  /* constructors */
  public Intervals_V()
  {
    this((Interval_V[])null);
  }

  public Intervals_V(Interval_V[] a)
  {
    _array = new MutableArray(2002, a, Interval_V.getORADataFactory());
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
    Intervals_V a = new Intervals_V();
    a._array = new MutableArray(2002, (ARRAY) d, Interval_V.getORADataFactory());
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
  public Interval_V[] getArray() throws SQLException
  {
    return (Interval_V[]) _array.getObjectArray(
      new Interval_V[_array.length()]);
  }

  public Interval_V[] getArray(long index, int count) throws SQLException
  {
    return (Interval_V[]) _array.getObjectArray(index,
      new Interval_V[_array.sliceLength(index, count)]);
  }

  public void setArray(Interval_V[] a) throws SQLException
  {
    _array.setObjectArray(a);
  }

  public void setArray(Interval_V[] a, long index) throws SQLException
  {
    _array.setObjectArray(a, index);
  }

  public Interval_V getElement(long index) throws SQLException
  {
    return (Interval_V) _array.getObjectElement(index);
  }

  public void setElement(Interval_V a, long index) throws SQLException
  {
    _array.setObjectElement(a, index);
  }

}
