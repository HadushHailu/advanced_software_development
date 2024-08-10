package html;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Application {
	public static void main(String[] args) throws Exception {
		String inputText = "Hello, World!";

		HtmlElement plainText = new Text(inputText);
		HtmlElement boldText = new Bold(plainText);
		HtmlElement italicText = new Italic(plainText);
		HtmlElement underlineText = new Underline(plainText);
		HtmlElement strikethroughText = new Strikethrough(plainText);

		System.out.println("Plain Text: " + plainText.toHtml());
		System.out.println("Bold: " + boldText.toHtml());
		System.out.println("Italic: " + italicText.toHtml());
		System.out.println("Underline: " + underlineText.toHtml());
		System.out.println("Strikethrough: " + strikethroughText.toHtml());

		HtmlElement boldStrikethroughText = new Strikethrough(new Bold(plainText));
		HtmlElement allFormatsText = new Strikethrough(new Underline(new Italic(new Bold(plainText))));

		System.out.println("Bold + Strikethrough: " + boldStrikethroughText.toHtml());
		System.out.println("Bold + Italic + Underline + Strikethrough: " + allFormatsText.toHtml());
	}
}


