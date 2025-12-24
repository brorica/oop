package validator;

import java.util.regex.Pattern;

public class Validator {

    public static String EMAIL_VALIDATE(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
        if (EMAIL_PATTERN.matcher(email).matches()) {
            return email;
        }
        throw new RuntimeException("올바른 이메일 형식이 아닙니다. email = " + email);
    }
}
