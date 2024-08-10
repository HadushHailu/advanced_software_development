package html;

public abstract class HtmlTag implements HtmlElement{
    protected HtmlElement element;

    public HtmlTag(HtmlElement element) {
        this.element = element;
    }
}
