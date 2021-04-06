package testing.generated.valuedomains.impl;

import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import testing.generated.valuedomains.Courses;
import testing.generated.valuedomains.Ects;
import testing.generated.valuedomains.Id;
import testing.generated.valuedomains.Name;
import testing.generated.valuedomains.external.EDMA_ExternalConstraints;
import testing.generated.valuedomains.impl.EctsImpl;
import testing.generated.valuedomains.impl.IdImpl;
import testing.generated.valuedomains.impl.NameImpl;

/**
 * The implementation of Courses
 */
public class CoursesImpl extends Courses implements IValueInstance
{
    private int edma_hash;
    private Object[] value;



    /**
     * Check if a value is valid
     * @param value  The value to validate
     */
    public static void edma_validate(Object value) throws InvalidValueException
    {
        edma_domain.validate(value, EDMA_ExternalConstraints.instance);
    }

    /**
     * create value without checking
     * @param value  The value to check and create
     * @return       <tt>true</tt> The new created value
     */
    public static Object edma_create(Object value)
    {
        return edma_domain.newValue(value);
    }

    /**
     * Constructor
     * @param o  The Object that represents this struct value
     */
    public CoursesImpl(Object o)
    {
        edma_hash = 0;
        value = (Object[]) o;
    }

    /**
     * Gets the value domain for this value instance
     * @return  The value domain for this value instance
     */
    public IMetaValueDomain edma_getDomain()
    {
        return edma_domain;
    }

    /**
     * Access to the general Object value
     * @return  The value as a general Object
     */
    public Object edma_getValue()
    {
        return value;
    }

    /**
     * Returns <tt>true</tt> if this value equals the given value
     * @param o  Object to test equality with
     * @return   <tt>true</tt> if this value equals the given value
     */
    public boolean equals(Object o)
    {
        if(!(o instanceof IValueInstance)) return false;
        IValueInstance inst = (IValueInstance) o;
        if(5 != inst.edma_getDomain().getIndex()) return false;
        return edma_domain.valueEqual(value, inst.edma_getValue());
    }

    /**
     * Gets the value hash for this value instance
     * @return  The hash for this value instance
     */
    public int hashCode()
    {
        if(edma_hash == 0) edma_hash = edma_domain.valueHashCode(value);
        return edma_hash;
    }

    /**
     * Returns this value instance as a string
     * @return  this value instance as a string
     */
    public String toString()
    {
        return edma_domain.valueToString(value);
    }

    /**
     * Compare this Courses to another Courses
     * @param courses  The Courses to compare with
     * @return         A negative integer, zero, or a positive integer as this
     *                 Courses is less than, equal to, or greater than the
     *                 specified Courses
     */
    public int compareTo(Courses courses)
    {
        return edma_domain.valueCompare(value, ((CoursesImpl) courses).value);
    }

    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public void toStream(DataOutput out) throws IOException
    {
        edma_domain.writeValue(((IValueInstance) this).edma_getValue(), out);
    }

    /**
     * returns the value of the field id
     * @return  The value of the field id
     */
    public Id id()
    {
        return new IdImpl(value[0]);
    }

    /**
     * returns the value of the field name
     * @return  The value of the field name
     */
    public Name name()
    {
        return new NameImpl(value[1]);
    }

    /**
     * returns the value of the field ects
     * @return  The value of the field ects
     */
    public Ects ects()
    {
        return new EctsImpl(value[2]);
    }
}
