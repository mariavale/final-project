package htmlvalidator;

/**
 * This testing program stub creates a queue of HTML tags
 * in a valid sequence. You may use this as a starting point 
 * for testing your removeAll method.
 * 
 * @author Helene Martin
 * @version Downloaded 9/23/16
 */

import java.util.*;

public class HtmlValidatorTest {
    public static void main(String[] args) {
        // <b>Hi</b><br/>
        Queue<HtmlTag> tags = new LinkedList<HtmlTag>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("head", true));
        tags.add(new HtmlTag("title", true));
        tags.add(new HtmlTag("head", true));
        tags.add(new HtmlTag("b", true));      // <b>
        tags.add(new HtmlTag("b", false));     // </b>
        tags.add(new HtmlTag("br"));           // <br/>
        tags.add(new HtmlTag("title", false));
        tags.add(new HtmlTag("head", false));
        tags.add(new HtmlTag("html", false));
        
        System.out.println(tags);

        HtmlValidator validator = new HtmlValidator(tags);
        
        validator.removeAll("<head>");
        System.out.println(tags);
    }
}