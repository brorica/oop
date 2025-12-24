package enums;

public enum CustomerGrade {
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold"),
    Platinum("Platinum")
    ;

    private final String label;

    CustomerGrade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
