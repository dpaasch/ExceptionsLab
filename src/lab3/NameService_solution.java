package lab3;

/**
 * This class provides various services relating to name manipulation. No output
 * should be performed here.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService_solution {

    private static String VALIDATE_MSG = " is not valid - Field cannot contain "
            + "digits or symbols, and cannot be empty or null.  \nPlease enter "
            + "your full name";
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;

    /**
     * Finds and returns the last name from within a full name. Caution: No
     * validation is performed.
     *
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) throws InvalidNameException {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length < 2) {
            throw new InvalidNameException();
        }
        // validate the full name entered and throw the Array exception
        if (!validateFullName(fullName)) {
            throw new ArrayIndexOutOfBoundsException("Full Name" + VALIDATE_MSG);
        }
        return nameParts[LAST_NAME_IDX];
    }

    /**
     * Finds and returns the first name from within a full name. Caution: No
     * validation is performed.
     *
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) throws InvalidNameException {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length < 2) {
            throw new InvalidNameException();
        }
        // validate the full name entered and throw the Array exception
        if (!validateFullName(fullName)) {
            throw new ArrayIndexOutOfBoundsException("Full Name" + VALIDATE_MSG);
        }
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     *
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        return name.length();
    }

    public static boolean validateFullName(String fullName) {
        // validate that fullName is populated with characters
        return fullName.matches("[A-Z] [a-zA-Z]*");
    }
}
