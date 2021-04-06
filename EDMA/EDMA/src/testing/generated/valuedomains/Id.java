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
import testing.generated.valuedomains.impl.IdImpl;

/**
 * The representation of a value from the value domain: Id
 */
public abstract class Id implements Comparable<Id>
{
    protected static final IMetaValueDomain edma_domain = EDMA.environment.getValueDomainDefinitions().getValueDomain(3);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Id from the terminal
     */
    public static Id fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new IdImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Id from the string representation
     */
    public static Id fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new IdImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Id read from the stream
     */
    public static Id fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new IdImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Id read from the stream
     */
    public static Id fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new IdImpl(res);
    }

    /**
     * Call this method to create a new Id value. 
     * @param value  The value of the Id to be created.
     * @return       The newly created Id value
     */
    public static Id create(Integer value) throws InvalidValueException
    {
        IdImpl.edma_validate(value);
        return new IdImpl(IdImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid Id
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid Id
     */
    public static boolean isValidId(Integer value)
    {
        try
        {
            IdImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this Id
     * @return  The Integer value stored in this Id
     */
    public abstract Integer value();
}
