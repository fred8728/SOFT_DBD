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
import testing.generated.valuedomains.impl.AgeImpl;

/**
 * The representation of a value from the value domain: Age
 */
public abstract class Age implements Comparable<Age>
{
    protected static final IMetaValueDomain edma_domain = EDMA.environment.getValueDomainDefinitions().getValueDomain(1);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Age from the terminal
     */
    public static Age fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new AgeImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Age from the string representation
     */
    public static Age fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new AgeImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Age read from the stream
     */
    public static Age fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new AgeImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Age read from the stream
     */
    public static Age fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new AgeImpl(res);
    }

    /**
     * Call this method to create a new Age value. 
     * @param value  The value of the Age to be created.
     * @return       The newly created Age value
     */
    public static Age create(Integer value) throws InvalidValueException
    {
        AgeImpl.edma_validate(value);
        return new AgeImpl(AgeImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid Age
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid Age
     */
    public static boolean isValidAge(Integer value)
    {
        try
        {
            AgeImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this Age
     * @return  The Integer value stored in this Age
     */
    public abstract Integer value();
}
