/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlvalidator;

import java.util.Queue;

/**
 *
 * @author maria
 */
public class HtmlValidator {
    Queue<HtmlTag> tags;
    
    public HtmlValidator() {
    }
    
    public HtmlValidator(Queue<HtmlTag> tags) {
        this.tags = tags;
    }
    
    public void addTag(HtmlTag tag) {
        tags.add(tag);
    }
    
    public Queue<HtmlTag> getTags() {
        return tags;
    }
    
    public void removeAll(String element) {
        
    }
    
    public boolean validate() {
        boolean valid = true;
        
        return valid;
    }
}
