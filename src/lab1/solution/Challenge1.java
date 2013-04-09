package lab1.solution;

import java.util.zip.DataFormatException;
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
public class Challenge1 {

    private static final int LAST_NAME_IDX = 1;
    private static String VALIDATE_MSG = " is not valid - Field cannot contain "
            + "digits or symbols, and cannot be empty or null.  \nPlease enter "
            + "your full name";

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            if (!validateFullName(fullName)) {
                throw new ArrayIndexOutOfBoundsException("Full Name" + VALIDATE_MSG);
            }
            String lastName = app.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        } catch (ArrayIndexOutOfBoundsException oob) {
            JOptionPane.showMessageDialog(null, oob.getMessage());
        }
    }

    public String extractLastName(String fullName) {
        String[] nameParts = fullName.split(" ");
        return nameParts[LAST_NAME_IDX];
    }

    public static boolean validateFullName(String fullName) {
        // validate that fullName is populated with characters
        return fullName.matches("[A-Z] [a-zA-Z]*");
    }
}
