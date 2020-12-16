/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlvalidator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Maria, Justin
 */
public class HtmlValidator {
    Queue<HtmlTag> tags = new LinkedList<>();
    Queue<HtmlTag> tagsCopy = new LinkedList<>();
    int spaces;
    
    public HtmlValidator() {
    }
    
    public HtmlValidator(Queue<HtmlTag> ntags) {
        int size = ntags.size();
        for(int i = 0; i < size;i++){
            tags.add(ntags.remove());
        }
    }
    
    public void addTag(HtmlTag tag) {
        tags.add(tag);
    }
    
    public Queue<HtmlTag> getTags() {
        return tags;
    }
    
    /*
    * @Param string element 
    * removes all tags that are equal to element
    */
    public void removeAll(String element) {
        int size = tags.size();
        for(int i = 0; i < size; i++) {
            HtmlTag tag = tags.remove();
            if(!tag.toString().contains(element)) {
                tags.add(tag);
            }
        }
    }
    
    
    

    
    
    /*
    * Validate method
    * Validates html code, prints out code with any errors detected
    */
    public void validate(){
        
        Stack<HtmlTag> stack = new Stack<>();
        
        spaces = 0;
        int tsize = tags.size();
        
        for(int i = 0; i < tsize; i++){
            
            //checks if tag is self closing
            if(tags.peek().isSelfClosing()){
                addSpacing();
                System.out.println(tags.add(tags.remove()));
                
            //checks if tag is an open tag
            } else if(tags.peek().isOpenTag()){
                addSpacing();
                HtmlTag tag = tags.remove();
                System.out.println(stack.push(tag));
                tags.add(tag);
                
                spaces++;
                
            //checking if there is corresponding closing tag with openeing ta
            } else if(stack.size() > 0 && tags.peek().matches(stack.peek())){
                stack.pop();
                spaces--;
                addSpacing();
                System.out.println(tags.add(tags.remove()));
            } else {
                System.out.println("ERROR Unexpected: " + tags.add(tags.remove()));
            }
        }

        //printing out all other errors not shown during runtime of validating
        int size = stack.size();
        for(int i = 0; i < size; i++){
            System.out.println("ERROR Unclosed: " + stack.pop());
            spaces--;
        } 
    }
    
    /*
    * Method for visual spacing when printing out html code
    */
    public void addSpacing() {
        for(int i = 0; i < spaces; i++) {
            System.out.print("  ");
        }
    }
}
 