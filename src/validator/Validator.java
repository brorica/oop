package validator;

import java.util.regex.Pattern;

public class Validator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static String EMAIL_VALIDATE(String email) {
        if (email == null || email.isBlank()) {
            throw new RuntimeException("email 값은 필수입니다.");
        }
        if (EMAIL_PATTERN.matcher(email).matches()) {
            return email;
        }
        throw new RuntimeException("올바른 이메일 형식이 아닙니다. email = " + email);
    }
}
