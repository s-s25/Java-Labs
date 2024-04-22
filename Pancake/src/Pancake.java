// from Aidan

import java.util.Stack;
public class Pancake{
    private Stack<Integer> s1;
    public Pancake(Stack<Integer> s){
        s1=s;
    }
    public void sort(){
        Stack<Integer> s2=new Stack<Integer>();
        Stack<Integer> s3=new Stack<Integer>();
        while(!(s1.isEmpty())){
            if(s2.isEmpty()||s1.peek()>s2.peek()){
                s2.push(s1.pop());
                add(s2,s3);
            }    
            else s3.push(s2.pop());    
        }
        add(s1,s2);
    }
    private void add(Stack<Integer> x,Stack<Integer> y){
        while(!(y.isEmpty())){
            x.push(y.pop());
        }
    }
    public String toString(){
        String output="";
        Stack<Integer> temp=s1;
        while(!(temp.isEmpty())){
            output+=temp.pop()+" ";
        }
        return output;
    }
}