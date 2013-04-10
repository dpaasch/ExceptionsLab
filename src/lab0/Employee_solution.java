package lab0;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;

/**
 * In this challenge you need to address the probability that at some point the
 * arguments to method parameters may not be valid. <p> For example, String
 * arguments may be null or empty; other objects may be null; or primitive
 * numbers may be out of acceptable range. <p> You need to validate ALL method
 * parameters to make sure any and all arguments are valid. The only exception
 * is when any argument is acceptable based on requirements. Fix the code below
 * using if logic to validate method arguments and throw
 * IllegalArgumentException or a custom exception if the validation fails.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class Employee_solution {

    public static final int MAX_VACATION_DAYS = 28;
    public static final int MIN_VACATION_DAYS = 0;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;
    private String VAC_MSG = "# Vaction Days is not valid - Days must be "
            + "between 0 - 28";
    private String HIRE_MSG = "Hire date is not valid - Please enter in the "
            + "following format mm/dd/yyyy";
    private String SSN_MSG = "SSN is not valid - Please enter in the following "
            + "format 123-45-6789";    
    private String MSG = " is not valid - Field cannot be empty, null, or "
            + "contain digits";

    public Employee_solution() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee_solution(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }

    public int getDaysVacation() {
        return daysVacation;
    }

    public void setDaysVacation(int daysVacation) {
        try {
            if (daysVacation < MIN_VACATION_DAYS || daysVacation > MAX_VACATION_DAYS) {
                throw new IllegalArgumentException(VAC_MSG);
            }
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        } finally {
            this.daysVacation = daysVacation;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        try {
            if (!validateFirstName(firstName)) {
                throw new DataFormatException("First Name" + MSG);
            } 
        } catch (DataFormatException dfe) {
            System.err.println(dfe.getMessage());
        } finally {
            this.firstName = firstName;
        }
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        try {
            if (validateHireDate(hireDate) == false) {
                throw new ParseException(HIRE_MSG, 2);
            }
        } catch (ParseException pe) {
            System.err.println(pe.getMessage());
        } finally {
            this.hireDate = hireDate;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        try {
            if (!validateLastName(lastName)) {
                throw new DataFormatException("Last Name" + MSG);
            } 
        } catch (DataFormatException dfe) {
            System.err.println(dfe.getMessage());
        } finally {
            if (validateLastName(lastName)) {
                this.lastName = lastName;
            }
        }
    }

    public final String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        try {
            if (validateSsn(ssn) == false) {
                throw new NumberFormatException(SSN_MSG);
            }
        } catch (NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        } finally {
            if (validateSsn(ssn) == true) {
                this.ssn = ssn;
            }
        }
    }

    public static boolean validateFirstName(String firstName) {
        // validate that firstName is populated with characters
        return firstName.matches("[A-Z] [a-zA-Z]*");
    }

    public static boolean validateLastName(String lastName) {
        // validate that lastName is populated with characters
        return lastName.matches("[A-Z] [a-zA-Z]*");
    }

    public static boolean validateHireDate(Date hireDate) throws ParseException {
        boolean status = true;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        date = df.parse("07/15/2010");
        if (hireDate.compareTo(date) <= 0) {
            status = false;
        }
        return status;
    }

    public static boolean validateSsn(String ssn) {
        boolean status = true;
        if (ssn.length() != 11) {
            status = false;
        } else if (Character.isDigit(ssn.charAt(0))
                && (Character.isDigit(ssn.charAt(1))
                && (Character.isDigit(ssn.charAt(2))
                && (ssn.charAt(3) == '-')
                && (Character.isDigit(ssn.charAt(4))
                && (Character.isDigit(ssn.charAt(5))
                && (ssn.charAt(6) == '-')
                && (Character.isDigit(ssn.charAt(7))
                && (Character.isDigit(ssn.charAt(8))
                && (Character.isDigit(ssn.charAt(9))
                && (Character.isDigit(ssn.charAt(10))))))))))) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public static void main(String[] args) {
        Employee_solution e = new Employee_solution();
        Date d = new Date(0);
        e.setDaysVacation(30);
        e.setFirstName(" ");
        e.setHireDate(d);
        e.setLastName("");
        e.setSsn("12345679000");
    }
}
