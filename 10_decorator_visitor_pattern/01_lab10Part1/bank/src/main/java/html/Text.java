package html;

public class Text implements HtmlElement{
    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String toHtml() {
        return text;
    }
}
