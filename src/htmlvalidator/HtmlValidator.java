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
    
    public HtmlValidator() {}
    
    public HtmlValidator(Queue<HtmlTag> ntags) {
        
        if(ntags == null){
            throw new IllegalArgumentException("Queue is null");
        }
        
        int size = ntags.size();
        for(int i = 0; i < size;i++){
            tags.add(ntags.remove());
        }
    }
    
    public void addTag(HtmlTag tag) {
        
        if(tag == null){
            throw new IllegalArgumentException("Tag is null");
        }
        
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
        
        if(element == null){
            throw new IllegalArgumentException("Element is null");
        }
        
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
                HtmlTag tag = tags.remove();
                System.out.println(tag);
                tags.add(tag);
                
            //checks if tag is an open tag
            } else if(tags.peek().isOpenTag()){
                addSpacing();
                
                HtmlTag tag = tags.remove();
                stack.push(tag);
                tags.add(tag);
                System.out.println(tag);
                
                spaces++;
                
            //checking if there is corresponding closing tag with openeing ta
            } else if(stack.size() > 0 && tags.peek().matches(stack.peek())){
                stack.pop();
                spaces--;
                addSpacing();
                HtmlTag tag = tags.remove();
                tags.add(tag);
                System.out.println(tag);
            } else {
                HtmlTag tag = tags.remove();
                tags.add(tag);
                System.out.println("ERROR Unexpected: " + tag);
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
 