package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using Java
 * Exception handling techniques. <p> Your challenge is to consider all the
 * possible things that can go wrong with this program and use exception
 * handling where appropriate to prevent the program from crashing. In addition
 * you must display a friendly error message in a JOptionPane and ask the user
 * to try again.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class Challenge1_solution {

    private static final int LAST_NAME_IDX = 1;
    private static String VALIDATE_MSG = " is not valid - Field cannot contain "
            + "digits or symbols, and cannot be empty or null.  \nPlease enter "
            + "your full name";

    public static void main(String[] args) {
        Challenge1_solution app = new Challenge1_solution();
        try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            String lastName = app.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        } catch (ArrayIndexOutOfBoundsException oob) {
            JOptionPane.showMessageDialog(null, oob.getMessage());
        }
    }

    public String extractLastName(String fullName) throws ArrayIndexOutOfBoundsException {
        // validate the full name entered and throw the Array exception
        if (!validateFullName(fullName)) {
            throw new ArrayIndexOutOfBoundsException("Full Name" + VALIDATE_MSG);
        }
        String[] nameParts = fullName.split(" ");
        return nameParts[LAST_NAME_IDX];
    }

    public static boolean validateFullName(String fullName) {
        // validate that fullName is populated with characters
        return fullName.matches("[A-Z] [a-zA-Z]*");
    }
}
