package nus.iss.workshop13.util;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import nus.iss.workshop13.model.Contact;
import static nus.iss.workshop13.util.IOUtil.*;

public class Contacts {
    
    private static final Logger logger = LoggerFactory.getLogger(Contacts.class);

    public void saveContact(Contact contact, ApplicationArguments appArgs) {
        Set<String> optNames = appArgs.getOptionNames();
        String[] optNamesArr = optNames.toArray(new String[optNames.size()]);
        List<String> optVal = appArgs.getOptionValues(optNamesArr[0]);
        if (checkDir(optVal.get(0))) {
            writeDir(optVal.get(0), contact);
        } else {
            logger.warn("Closing application...");
            logger.warn("Please create required data directory when starting the app by passing as arguments");
            System.exit(1);
        }
    }

    public Contact getContactById(String contactId, ApplicationArguments appArgs) {
        Set<String> optNames = appArgs.getOptionNames();
        String[] optNamesArr = optNames.toArray(new String[optNames.size()]);
        List<String> optVal = appArgs.getOptionValues(optNamesArr[0]);
        List<String> contactDetails = readDir(optVal.get(0), contactId);
        Contact getContact = new Contact();
        getContact.setName(contactDetails.get(0));
        getContact.setEmail(contactDetails.get(1));
        getContact.setPhoneNum(contactDetails.get(2));
        return getContact;
    }

}
