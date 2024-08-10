package html;

public class Italic extends HtmlTag{
    public Italic(HtmlElement element) {
        super(element);
    }

    @Override
    public String toHtml() {
        return "<i>" + element.toHtml() + "</i>";
    }
}
