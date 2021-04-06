package testing.generated.valuedomains.impl;

import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import testing.generated.valuedomains.Courses;
import testing.generated.valuedomains.Courses.CoursesBuilderEcts;
import testing.generated.valuedomains.Courses.CoursesBuilderId;
import testing.generated.valuedomains.Courses.CoursesBuilderName;
import testing.generated.valuedomains.Ects;
import testing.generated.valuedomains.Id;
import testing.generated.valuedomains.Name;
import testing.generated.valuedomains.impl.EctsImpl;
import testing.generated.valuedomains.impl.IdImpl;
import testing.generated.valuedomains.impl.NameImpl;

/**
 * 
 */
public class CoursesBuilderImpl implements CoursesBuilderEcts, CoursesBuilderId, CoursesBuilderName
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public CoursesBuilderImpl()
    {
        edma_value = new Object[3];
    }

    /**
     * sets the id field.
     * @param id  The value to assign to the id field
     * @return    Builder interface for setting the name field
     */
    public CoursesBuilderName id(Id id)
    {
        if(id == null) throw new NullPointerException("The field id in the Courses ValueDomain may not be null");
        edma_value[0] = ((IValueInstance) id).edma_getValue();
        return this;
    }

    /**
     * sets the id field.
     * @param id  The value to assign to the id field
     * @return    Builder interface for setting the name field
     */
    public CoursesBuilderName id(Integer id) throws InvalidValueException
    {
        if(id != null) IdImpl.edma_validate(id);
        if(id == null) throw new NullPointerException("The field id in the Courses ValueDomain may not be null");
        edma_value[0] = IdImpl.edma_create(id);
        return this;
    }

    /**
     * sets the name field.
     * @param name  The value to assign to the name field
     * @return      Builder interface for setting the ects field
     */
    public CoursesBuilderEcts name(Name name)
    {
        if(name == null) throw new NullPointerException("The field name in the Courses ValueDomain may not be null");
        edma_value[1] = ((IValueInstance) name).edma_getValue();
        return this;
    }

    /**
     * sets the name field.
     * @param name  The value to assign to the name field
     * @return      Builder interface for setting the ects field
     */
    public CoursesBuilderEcts name(String name) throws InvalidValueException
    {
        if(name != null) NameImpl.edma_validate(name);
        if(name == null) throw new NullPointerException("The field name in the Courses ValueDomain may not be null");
        edma_value[1] = NameImpl.edma_create(name);
        return this;
    }

    /**
     * sets the ects field.
     * @param ects  The value to assign to the ects field
     * @return      The created Courses value
     */
    public Courses ects(Ects ects)
    {
        if(ects == null) throw new NullPointerException("The field ects in the Courses ValueDomain may not be null");
        edma_value[2] = ((IValueInstance) ects).edma_getValue();
        return new CoursesImpl(CoursesImpl.edma_create(edma_value));
    }

    /**
     * sets the ects field.
     * @param ects  The value to assign to the ects field
     * @return      The created Courses value
     */
    public Courses ects(Integer ects) throws InvalidValueException
    {
        if(ects != null) EctsImpl.edma_validate(ects);
        if(ects == null) throw new NullPointerException("The field ects in the Courses ValueDomain may not be null");
        edma_value[2] = EctsImpl.edma_create(ects);
        return new CoursesImpl(CoursesImpl.edma_create(edma_value));
    }
}
