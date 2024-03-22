package exercise;

// BEGIN
public class InputTag implements TagInterface{
    private String type;
    private String value;

    public InputTag(String currentType, String currentValue) {
        type = currentType;
        value = currentValue;
    }
    @Override
    public String render() {
        return new StringBuilder()
        .append("<input type=\"")
        .append(type)
        .append("\" value=\"")
        .append(value)
        .append("\">")
        .toString();
    }
}
// END
