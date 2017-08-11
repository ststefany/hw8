package helpers;

public enum SpecialCharacters {
    LINE_SEPARATOR(System.getProperty("line.separator")),
    SPACE(" "),
    DOUBLE_SPACE("  ");

    private String value;

    public String getValue() {
        return value;
    }

    SpecialCharacters(String value) {

        this.value = value;
    }

}
