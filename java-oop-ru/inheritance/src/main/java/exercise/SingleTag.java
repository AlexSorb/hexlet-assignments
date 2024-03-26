package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{

    public SingleTag(String name, Map<String, String> attribute) {
        super(name, attribute);
    }

    @Override
    public String toString() {
        var result = new StringBuilder()
                .append("<")
                .append(super.getTagName());
        for (var currentAttribute : super.getAttributes().entrySet()) {
            result.append(" ")
                    .append(currentAttribute.getKey())
                    .append("=\"")
                    .append(currentAttribute.getValue())
                    .append("\"");
        }
        result.append(">");
       return result.toString();
    }
}
// END
