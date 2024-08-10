package html;

public class Bold extends HtmlTag{
    public Bold(HtmlElement element) {
        super(element);
    }

    @Override
    public String toHtml() {
        return "<b>" + element.toHtml() + "</b>";
    }
}
