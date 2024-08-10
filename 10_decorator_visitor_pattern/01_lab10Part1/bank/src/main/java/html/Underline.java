package html;

public class Underline extends HtmlTag{
    public Underline(HtmlElement element) {
        super(element);
    }

    @Override
    public String toHtml() {
        return "<u>" + element.toHtml() + "</u>";
    }
}
