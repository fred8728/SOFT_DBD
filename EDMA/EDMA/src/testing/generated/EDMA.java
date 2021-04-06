package testing.generated;

import java.util.ArrayList;
import java.util.Collection;
import org.abstractica.edma.metamodel.IMetaEnvironment;
import org.abstractica.edma.metamodel.impl.MetaEnvironment;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder.Field;
import org.abstractica.edma.runtime.implementations.mem.modelstore.speed.newindex.IndexUtil;
import org.abstractica.edma.runtime.intf.IRuntimeFactory;
import org.abstractica.edma.valuedomains.impl.Constraint;

/**
 * 
 */
public class EDMA
{
    public static final IMetaEnvironment environment = generateEnvironment();



    /**
     * generate the environment
     * @return  
     */
    public static IMetaEnvironment generateEnvironment()
    {
        ValueDomainBuilder vdb = new ValueDomainBuilder();
        
        //String value domain: Name
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("Name", null, 1, null, null, edma_constraints, false);
        }
        
        //Integer value domain: Age
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Age", null, 0, 70, edma_constraints, false);
        }
        
        //Struct value domain: Student
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("name", "Name", false));
            fields.add(vdb.newStructField("age", "Age", false));
            vdb.newStructDomain("Student", null, fields, edma_constraints, false);
        }
        
        //Integer value domain: Id
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Id", null, 1, 9999, edma_constraints, false);
        }
        
        //Integer value domain: Ects
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Ects", null, 5, 30, edma_constraints, false);
        }
        
        //Struct value domain: Courses
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("id", "Id", false));
            fields.add(vdb.newStructField("name", "Name", false));
            fields.add(vdb.newStructField("ects", "Ects", false));
            vdb.newStructDomain("Courses", null, fields, edma_constraints, false);
        }
        
        //Boolean value domain: Active
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newBooleanDomain("Active", null, edma_constraints, false);
        }
        MetaEnvironment edma_environment = new MetaEnvironment("EDMA");
        vdb.buildWithEnvironment(edma_environment);
        //Hack to make serializeable work...
        IndexUtil.setValueDomainDefinitions(edma_environment.getValueDomainDefinitions());
        return edma_environment;
    }

    /**
     * Constructor
     * @param factory  The runtime factory
     */
    public EDMA(IRuntimeFactory factory)
    {
        
    }
}
