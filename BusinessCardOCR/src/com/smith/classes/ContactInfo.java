package com.smith.classes;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

/**
 * Responsible for getting/setting names,phone numbers,email addresses
 *
 * @author       David Smith
 * @version      1.0
 */
public class ContactInfo implements com.smith.interfaces.ContactInfo {

    private String name;
    private String phoneNumber;
    private String emailAddress;

    public ContactInfo() {
        this.name = null;
        this.phoneNumber = null;
        this.emailAddress = null;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Checks if a line of the business card is a name , phone number or email address.
     * @param input
     * @throws FileNotFoundException
     */
    public void validate(String input) throws FileNotFoundException {

        //Set the name if it exists in the names database
        if (NameDatabase.NAME_DATABASE.contains(input.split(" ")[0])) {
            setName(input);
        }

        //Set the phone number if the line matches the pattern
        if(Pattern.compile("^(#)?(Phone Number:)?(Telephone:)?(Phone:)?(Tel:)?([+]1\\s?)?(1\\s?)?((\\([0-9]{3}\\))|[0-9]{3})[\\s\\-]?[\0-9]{3}[\\s\\-]?[0-9]{4}$").matcher(input.replaceAll("\\s+","")).matches()) {
            setPhoneNumber(input.replaceAll("[a-zA-Z:#]", "")); //Remove any prefix from the business card line (Phone:, Tel:, etc.)
        }

        //Set the email address if the line matches the pattern
        if(Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$").matcher(input.replaceAll("\\s+","")).matches()) {
            setEmailAddress(input);
        }
    }

    /** Formats the ContactInfo
     * @return String
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\nPhone: " + getPhoneNumber() + "\nEmail: " + getEmailAddress();
    }
}
