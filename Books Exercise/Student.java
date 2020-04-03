
/**
 * The Student instance can be described, can study, 
 * and you can check whether they have finished studying.
 *
 * @author jc812
 * @version 1.0
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String studentName;
    private Library collegeLibrary;
    private LibraryCard studentCard;
    private TextBook currentTextbook;
    
    /**
     * Constructor for fields of class Student - assigns a suitable library, libraryCard and Name to the Student.
     * 
     * @param name     Name of the Student
     * @param library  Library instance the Student is part of
     * @return Student instance
     */
    public Student(String name, Library library)
    {
        studentName = name;
        collegeLibrary = library;
        studentCard = collegeLibrary.issueCard();
        currentTextbook = null;
    }

    /**
     * Checks whether the Student has finished studying.
     *
     * @return boolean
     */
    public boolean finishedStudies()
    {
        if ((studentCard.expired()) && (currentTextbook == null))
        {
            return true;
        } 
        else {
            return false;
        }
    }
    
    /**
     * The Student studys by getting a Textbook out or reads a chapter or returns a Textbook.
     * 
     * @return void
     */
    public void study()
    {
        if (currentTextbook == null)
        {
            currentTextbook = collegeLibrary.borrowBook(studentCard);
        }
        else if (!(currentTextbook.isFinished()))
        {
            currentTextbook.readNextChapter();
        }
        else {
            currentTextbook.closeBook();
            collegeLibrary.returnBook(currentTextbook);
            currentTextbook = null;
        }    
    }  
    
    /**
     * The Student is described; their name, LibraryCard and Textbook.
     * 
     * @return void
     */
    public void describe()
    {
        System.out.print("Student " + studentName);
        if (currentTextbook == null) 
        { 
            System.out.print(" does not have a book and ");
            studentCard.describe();
        }
        else {
            System.out.print(" does have a book and ");
            studentCard.describe();
            currentTextbook.describe();
            if (currentTextbook.isFinished()){
                System.out.println("The book is finished.");
            } 
            else {
                System.out.println("The student is reading the book.");
            }    
        }
    }    
}
