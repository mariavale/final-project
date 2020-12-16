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
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("head", true));
        tags.add(new HtmlTag("title", true));
        tags.add(new HtmlTag("head", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("b", false));
        tags.add(new HtmlTag("i", true));
        tags.add(new HtmlTag("i", false));
        tags.add(new HtmlTag("br"));
        tags.add(new HtmlTag("title", false));
        tags.add(new HtmlTag("head", false));
        tags.add(new HtmlTag("html", false));
        
        HtmlValidator validator = new HtmlValidator(tags);
        System.out.println(validator.getTags());
        validator.validate();
        
        System.out.println("-----------------------");
        System.out.println("Remove 'head'");
        validator.removeAll("head");
        System.out.println(validator.getTags());
        validator.validate();
        
        System.out.println("-----------------------");
        System.out.println("Remove 'br'");
        validator.removeAll("br");
        System.out.println(validator.getTags());
        validator.validate();
        
        System.out.println("-----------------------");
        System.out.println("Remove 'b'");
        validator.removeAll("b");
        System.out.println(validator.getTags());
        validator.validate();
        
        System.out.println("-----------------------");
        System.out.println("Remove 'grg'"); //removes nothing
        validator.removeAll("grg");
        System.out.println(validator.getTags());
        validator.validate();
    }
}