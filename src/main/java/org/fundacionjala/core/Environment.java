package org.fundacionjala.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * Class for set the environment of the project.
 */
public class Environment {

    private String user;
    private String pass;
    private static final String USER_KEY = "user";
    private static final String PASS_KEY = "pass";
    private static final String CONF_FILE = "environment.json";

    /**
     * Method for read the JSON file.
     *
     * @param numUser integer for select the user.
     */
    public void readJSONUser(int numUser) {
        JSONParser parser = new JSONParser();
        try (InputStream inputStream = new FileInputStream(CONF_FILE)) {
            Reader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            user = (String) jsonObject.get(USER_KEY.concat(String.valueOf(numUser)));
            pass = (String) jsonObject.get(PASS_KEY.concat(String.valueOf(numUser)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter of the user name.
     *
     * @return the String of user.
     */
    public String getUser() {
        return user;
    }

    /**
     * Getter of the password.
     *
     * @return the String of the password.
     */
    public String getPass() {
        return pass;
    }
}
