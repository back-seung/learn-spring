package validate;import dto.RegisterRequest;import org.springframework.validation.Errors;import org.springframework.validation.ValidationUtils;import org.springframework.validation.Validator;import java.util.regex.Matcher;import java.util.regex.Pattern;public class RegisterRequestValidator implements Validator {    private static final String emailRegExp = """                ^[_A-Za-z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$            """;    private Pattern pattern;    public RegisterRequestValidator() {        pattern = Pattern.compile(emailRegExp);    }    @Override    public boolean supports(Class<?> clazz) {        return RegisterRequestValidator.class.isAssignableFrom(clazz);    }    @Override    public void validate(Object target, Errors errors) {        RegisterRequest request = (RegisterRequest) target;        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {            errors.rejectValue("email", "required");        } else {            Matcher matcher = pattern.matcher(request.getEmail());            if (!matcher.matches()) {                errors.rejectValue("email", "bad");            }        }        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");        ValidationUtils.rejectIfEmpty(errors, "password", "required");        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");        if (!request.getPassword().isEmpty()) {            if (!request.isPasswordEqualToConfirmPassword()) {                errors.rejectValue("confirmPassword", "nomatch");            }        }    }}