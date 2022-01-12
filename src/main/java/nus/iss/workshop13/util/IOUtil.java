package nus.iss.workshop13.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import nus.iss.workshop13.model.Contact;

public class IOUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(IOUtil.class);
    private static String userDir = System.getProperty("user.dir"); 

    public static boolean checkDir(String dir) {
        Path path = Paths.get(userDir, dir);
        return Files.exists(path);
    }

    public static void createDir(String dir) {
        Path path = Paths.get(userDir, dir);
        try {
            Files.createDirectories(path);
        } catch (IOException ioe) {
            logger.error("Error creating directory!", ioe);
        }
    }

    public static void writeDir(String dir, Contact contact) {
        String id = contact.getId();
        Path path = Paths.get(userDir, dir, "/", id);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"));
            writer.write(contact.getName() + "\n");
            writer.write(contact.getEmail() + "\n");
            writer.write(contact.getPhoneNum() + "\n");
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            logger.error(ioe.getMessage());
        }
    }

    public static List<String> readDir(String dir, String contactId) {
        Path path = Paths.get(userDir, dir, "/", contactId);
        try {
            List<String> contactDetails = Files.readAllLines(path, Charset.forName("UTF-8"));
            return contactDetails;
        } catch (IOException ioe) {
            logger.error(ioe.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found", ioe);
        }
    }

}
