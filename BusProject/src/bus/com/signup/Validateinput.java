/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.com.signup;

/**
 *
 * @author roshan
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validateinput {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN
            = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    public Validateinput() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }
    //    String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    public boolean validate(final String password) {

        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
