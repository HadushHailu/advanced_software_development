package html;

public class Strikethrough extends HtmlTag{
    public Strikethrough(HtmlElement element) {
        super(element);
    }

    @Override
    public String toHtml() {
        return "<s>" + element.toHtml() + "</s>";
    }
}
