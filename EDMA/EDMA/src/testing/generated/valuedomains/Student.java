package testing.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;
import testing.generated.EDMA;
import testing.generated.valuedomains.Age;
import testing.generated.valuedomains.Name;
import testing.generated.valuedomains.external.EDMA_ExternalConstraints;
import testing.generated.valuedomains.impl.StudentBuilderImpl;
import testing.generated.valuedomains.impl.StudentImpl;

/**
 * The representation of a value from the value domain: Student
 */
public abstract class Student implements Comparable<Student>
{
    protected static final IMetaValueDomain edma_domain = EDMA.environment.getValueDomainDefinitions().getValueDomain(2);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Student from the terminal
     */
    public static Student fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new StudentImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Student from the string representation
     */
    public static Student fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new StudentImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Student read from the stream
     */
    public static Student fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new StudentImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Student read from the stream
     */
    public static Student fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new StudentImpl(res);
    }

    /**
     * Starts creation of a new Student
     * @return  Builder interface to set the name field
     */
    public static StudentBuilderName create()
    {
        return new StudentBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field name
     * @return  The value of the field name
     */
    public abstract Name name();

    /**
     * returns the value of the field age
     * @return  The value of the field age
     */
    public abstract Age age();


    /**
     * Builder interface for setting the name field of Student
     */
    public interface StudentBuilderName
    {

        /**
         * sets the name field.
         * @param name  The value to assign to the name field
         * @return      Builder interface for setting the age field
         */
        public StudentBuilderAge name(Name name);

        /**
         * sets the name field.
         * @param name  The value to assign to the name field
         * @return      Builder interface for setting the age field
         */
        public StudentBuilderAge name(String name) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the age field of Student
     */
    public interface StudentBuilderAge
    {

        /**
         * sets the age field.
         * @param age  The value to assign to the age field
         * @return     The created Student value
         */
        public Student age(Age age);

        /**
         * sets the age field.
         * @param age  The value to assign to the age field
         * @return     The created Student value
         */
        public Student age(Integer age) throws InvalidValueException;

    }

}
