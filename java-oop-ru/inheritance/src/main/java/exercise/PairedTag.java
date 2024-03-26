package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    private List<Tag> children;
    private String body;
    public PairedTag(String name, Map<String, String> attributes,String tagBody, List<Tag> children) {
        super(name, attributes);
        this.children = children;
        body = tagBody;
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
        result.append(">")
                .append(body);
        children.forEach(x -> result.append(x.toString()));
        result.append("</")
                .append(super.getTagName())
                .append(">");
        return result.toString();
    }
}
// END
