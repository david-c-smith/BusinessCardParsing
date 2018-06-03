package com.smith.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class responsible for getting/setting names,phone numbers,email addresses
 *
 * @author       David Smith
 * @version      1.0
 */
public class BusinessCardParser implements com.smith.interfaces.BusinessCardParser {

    public BusinessCardParser(String document) throws FileNotFoundException {
        System.out.println(getContactInfo(document));
    }

    /**
     * Parses the business card external for name,phone,email
     * @param document
     * @throws FileNotFoundException
     */
    public ContactInfo getContactInfo(String document) {
        ContactInfo contactInfo = new ContactInfo();

        try {
            File f = new File(document);

            if(f.exists()) {
                Scanner sc = new Scanner(f);

                List<String> businessCardList = new ArrayList<>();

                while (sc.hasNextLine()) {
                    String businessCardLine = sc.nextLine();
                    businessCardList.add(businessCardLine);
                }

                //Iterate through every line of the business card; setting the name,phone,email
                for (String line : businessCardList) {
                    contactInfo.validate(line);
                }
            }
            else {
                System.err.println("File does not exist.");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contactInfo;
    }
}
