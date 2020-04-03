
import java.util.ArrayList;
import java.util.Random;
/**
 * Creates a College, where there are Student instances working.
 * Describes the College and runs the College. 
 *
 * @author  jc812
 * @version 1.0
 */
public class College
{
    // instance variables
    private ArrayList<Student> students;
    private Library collegeLibrary;
    private Random randomStudent;

    /**
     * Constructor for fields of class College - new Library, new Set of Students
     * 
     * @param numOfStudents   Number of Students in the College 
     * @param numOfTextbooks  Number of Textbooks in the College
     * @return College instance
     */
    public College(int numOfStudents, int numOfTextbooks)
    {
        collegeLibrary = new Library(numOfTextbooks);
        students = new ArrayList();
        for (int i = 0; i < numOfStudents; i++)
        {
            students.add(new Student("Student" + i, collegeLibrary));
        }    
        randomStudent = new Random();
    }

    /**
     * Describes the College and the number of Students working there.
     *
     * @return void
     */
    public void describe()
    {
        System.out.print("The College currently has ");
        System.out.print(students.size());
        System.out.println(" hard-working students.");
        collegeLibrary.describe();
    }
    
    /**
     * Checks whether a random Student has finished studying and makes the Student leave the College.
     * 
     * @return void
     */
    private void nextStep()
    {
        if (students.isEmpty()) 
        {
            System.out.println("Everything has gone quiet.");
        }    
        else {
            int indexOfStudent = randomStudent.nextInt(students.size());
            if (students.get(indexOfStudent).finishedStudies())
            {
                students.remove(indexOfStudent);
                System.out.print("The Student has graduated and left");
                System.out.println(" the college.");
            }
            else {
                students.get(indexOfStudent).study();
            }
        }
    }
    
    /**
     * Describes the College, and determines if a random student can leave the College, a set number of times.
     * 
     * @param nSteps The number of times to run
     * @return void
     */
    public void runCollege(int nSteps)
    {
        for (int i = 1; i <= nSteps; i++) 
        {
            System.out.println("Step " + i);
            describe();
            nextStep();
        }
    }
    
    /**
     * Starts the program if running Java in standalone.
     * 
     * @param args Inputs Array of numOfStudents, numOfTextbooks, nSteps
     * @return void
     */
    public static void main(String[] args)
    {
        if (args.length == 0) 
        {
            args = new String[3];
            args[0] = "5";
            args[1] = "5";
            args[2] = "100";
        }
        College college = new College(Integer.parseInt(args[0]), 
            Integer.parseInt(args[1]));
        college.runCollege(Integer.parseInt(args[2]));
    }
}
