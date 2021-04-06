package testing.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;
import testing.generated.EDMA;
import testing.generated.valuedomains.external.EDMA_ExternalConstraints;
import testing.generated.valuedomains.impl.EctsImpl;

/**
 * The representation of a value from the value domain: Ects
 */
public abstract class Ects implements Comparable<Ects>
{
    protected static final IMetaValueDomain edma_domain = EDMA.environment.getValueDomainDefinitions().getValueDomain(4);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Ects from the terminal
     */
    public static Ects fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new EctsImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Ects from the string representation
     */
    public static Ects fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new EctsImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Ects read from the stream
     */
    public static Ects fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new EctsImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Ects read from the stream
     */
    public static Ects fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new EctsImpl(res);
    }

    /**
     * Call this method to create a new Ects value. 
     * @param value  The value of the Ects to be created.
     * @return       The newly created Ects value
     */
    public static Ects create(Integer value) throws InvalidValueException
    {
        EctsImpl.edma_validate(value);
        return new EctsImpl(EctsImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid Ects
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid Ects
     */
    public static boolean isValidEcts(Integer value)
    {
        try
        {
            EctsImpl.edma_validate(value);
        }
        catch(InvalidValueException e)
        {
            return false;
        }
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Integer value that is stored in this Ects
     * @return  The Integer value stored in this Ects
     */
    public abstract Integer value();
}
