/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlvalidator;

import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author maria, Justin
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
        for(int i = 0; i < tags.size(); i++) {
            HtmlTag tag = tags.remove();
            if(!element.equals(tag.toString())) {
                tags.add(tag);
            }
        }
    }
    
    
    
    
        /*
    Examine each tag from the queue, and if it is an opening tag 
    that requires a closing tag, push it onto a stack and increase indentation. 
    If it is a closing tag, compare it to the tag on top of the stack. 
    If the two tags match, pop the top tag of the stack and decrease indentation
    If they don't match, it is an error. Any tags remaining on the stack at the end are errors.
    */
    
    public void validate(){
        
        Stack<HtmlTag> stack = new Stack<>();
        
        
        if(tags.peek().isOpenTag()){
            stack.push(tags.remove());
        }else if(tags.peek() == stack.firstElement()){
            stack.pop();
        }else{
            //error 
        }
        
    }
}
