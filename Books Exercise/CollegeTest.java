

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CollegeTest.
 *
 * @author  jc812
 * @version 1.0
 */
public class CollegeTest
{
    private College college1;

    /**
     * Default constructor for test class CollegeTest
     */
    public CollegeTest()
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
        college1 = new College(2, 2);
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
    public void describe()
    {
        college1.describe();
        college1.runCollege(5);
        college1.describe();
    }

    @Test
    public void runCollege()
    {
        college1.runCollege(100);
        college1.describe();
    }
}


