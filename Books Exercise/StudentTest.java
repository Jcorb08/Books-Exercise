

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StudentTest.
 *
 * @author  jc812
 * @version 1.0
 */
public class StudentTest
{
    private Library library1;
    private Student student1;

    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        library1 = new Library(5);
        student1 = new Student("Dave", library1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void FinishedStudying()
    {
        assertEquals(false, student1.finishedStudies());
    }

    @Test
    public void Describe()
    {
        student1.describe();
    }

    @Test
    public void Study()
    {
        student1.study();
        student1.describe();
    }
}




