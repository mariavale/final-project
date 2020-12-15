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
 * @author Maria, Justin
 */
public class HtmlValidator {
    Queue<HtmlTag> tags;
    int spaces;
    
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
    
    // call self closing
    
    public void validate(){
        
        Stack<HtmlTag> stack = new Stack<>();
        spaces = 0;
        int tsize = tags.size();
        //String spacing = "";
        for(int i = 0; i < tsize; i++){
            if(tags.peek().isSelfClosing()){
                addSpacing();
                System.out.println(tags.remove());
            } else if(tags.peek().isOpenTag()){
                addSpacing();
                System.out.println(stack.push(tags.remove()));
                spaces++;
            } else if(stack.size() > 0 && tags.peek().matches(stack.peek())){
                stack.pop();
                addSpacing();
                System.out.println(tags.remove());
                spaces--;
            } else {
                System.out.println("Error unexpected: " + tags.remove());
            }
        }
        int size = stack.size();
        for(int i = 0; i < size; i++){
            System.out.println("ERROR Unclosed: " + stack.pop());
        } 
    }
    
    public void addSpacing() {
        for(int i = 0; i < spaces; i++) {
            System.out.print("  ");
        }
    }
}
 