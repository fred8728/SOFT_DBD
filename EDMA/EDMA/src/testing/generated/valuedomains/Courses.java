package testing.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;
import testing.generated.EDMA;
import testing.generated.valuedomains.Ects;
import testing.generated.valuedomains.Id;
import testing.generated.valuedomains.Name;
import testing.generated.valuedomains.external.EDMA_ExternalConstraints;
import testing.generated.valuedomains.impl.CoursesBuilderImpl;
import testing.generated.valuedomains.impl.CoursesImpl;

/**
 * The representation of a value from the value domain: Courses
 */
public abstract class Courses implements Comparable<Courses>
{
    protected static final IMetaValueDomain edma_domain = EDMA.environment.getValueDomainDefinitions().getValueDomain(5);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Courses from the terminal
     */
    public static Courses fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new CoursesImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Courses from the string representation
     */
    public static Courses fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new CoursesImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Courses read from the stream
     */
    public static Courses fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new CoursesImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Courses read from the stream
     */
    public static Courses fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new CoursesImpl(res);
    }

    /**
     * Starts creation of a new Courses
     * @return  Builder interface to set the id field
     */
    public static CoursesBuilderId create()
    {
        return new CoursesBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field id
     * @return  The value of the field id
     */
    public abstract Id id();

    /**
     * returns the value of the field name
     * @return  The value of the field name
     */
    public abstract Name name();

    /**
     * returns the value of the field ects
     * @return  The value of the field ects
     */
    public abstract Ects ects();


    /**
     * Builder interface for setting the id field of Courses
     */
    public interface CoursesBuilderId
    {

        /**
         * sets the id field.
         * @param id  The value to assign to the id field
         * @return    Builder interface for setting the name field
         */
        public CoursesBuilderName id(Id id);

        /**
         * sets the id field.
         * @param id  The value to assign to the id field
         * @return    Builder interface for setting the name field
         */
        public CoursesBuilderName id(Integer id) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the name field of Courses
     */
    public interface CoursesBuilderName
    {

        /**
         * sets the name field.
         * @param name  The value to assign to the name field
         * @return      Builder interface for setting the ects field
         */
        public CoursesBuilderEcts name(Name name);

        /**
         * sets the name field.
         * @param name  The value to assign to the name field
         * @return      Builder interface for setting the ects field
         */
        public CoursesBuilderEcts name(String name) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the ects field of Courses
     */
    public interface CoursesBuilderEcts
    {

        /**
         * sets the ects field.
         * @param ects  The value to assign to the ects field
         * @return      The created Courses value
         */
        public Courses ects(Ects ects);

        /**
         * sets the ects field.
         * @param ects  The value to assign to the ects field
         * @return      The created Courses value
         */
        public Courses ects(Integer ects) throws InvalidValueException;

    }

}
