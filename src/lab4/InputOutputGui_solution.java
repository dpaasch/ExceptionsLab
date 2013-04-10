package lab4;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui_solution {

    private NameService_solution nameService;

    public InputOutputGui_solution() {
        nameService = new NameService_solution();
    }

    public void startConversation() throws ArrayIndexOutOfBoundsException {
        int oobCount = 0;
        int count = 1;
        try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            String lastName = nameService.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        } catch (ArrayIndexOutOfBoundsException oob) {
            JOptionPane.showMessageDialog(null, oob.getMessage());
            oobCount++;
        } finally {
            JOptionPane.showMessageDialog(null, "Method - startConversation"
                    + " was run " + count++ + " times, with " + oobCount + " "
                    + new ArrayIndexOutOfBoundsException());
        }
    }
}