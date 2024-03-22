package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private TagInterface inputTag;

    public LabelTag(String tag, TagInterface inputTag) {
        this.tag = tag;
        this.inputTag = inputTag;
    }

    @Override
    public String render() {
        return new StringBuilder()
                .append("<label>")
                .append(tag)
                .append(inputTag.render())
                .append("</label>")
                .toString();

    }
}
// END
