import enums.CustomerGrade;

import static validator.Validator.EMAIL_VALIDATE;

public class Customer {

    private final int id;
    private final String name;
    private String email;
    private CustomerGrade customerGrade;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = validateName(name);
        this.email = EMAIL_VALIDATE(email);
        this.customerGrade = CustomerGrade.BRONZE;
    }

    public String validateName(String name) {
        if (name.length() > 20) {
            throw new RuntimeException("이름은 1 ~ 20글자 입니다.");
        }
        return name;
    }

    public void setEmail(String email) {
        this.email = EMAIL_VALIDATE(email);
    }

    public void setCustomerGrade(CustomerGrade customerGrade) {
        this.customerGrade = customerGrade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public CustomerGrade getCustomerGrade() {
        return customerGrade;
    }
}
