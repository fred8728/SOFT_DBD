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
import testing.generated.valuedomains.impl.ActiveImpl;

/**
 * The representation of a value from the value domain: Active
 */
public abstract class Active implements Comparable<Active>
{
    protected static final IMetaValueDomain edma_domain = EDMA.environment.getValueDomainDefinitions().getValueDomain(6);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Active from the terminal
     */
    public static Active fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new ActiveImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Active from the string representation
     */
    public static Active fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new ActiveImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Active read from the stream
     */
    public static Active fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new ActiveImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Active read from the stream
     */
    public static Active fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new ActiveImpl(res);
    }

    /**
     * Call this method to create a new Active value. 
     * @param value  The value of the Active to be created.
     * @return       The newly created Active value
     */
    public static Active create(Boolean value)
    {
        return new ActiveImpl(ActiveImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Boolean is a valid Active
     * @param value  The Boolean value to be tested
     * @return       true if the provided Boolean is a valid Active
     */
    public static boolean isValidActive(Boolean value)
    {
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Boolean value that is stored in this Active
     * @return  The Boolean value stored in this Active
     */
    public abstract Boolean value();
}
