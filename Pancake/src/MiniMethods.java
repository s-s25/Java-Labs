// from Aidan

import java.util.Stack;
public class MiniMethods{
    private int[] items;
    private int sp;
    public MiniMethods(){
        items = new int[1024];
        sp = 0;
    }
    public int peek(){
        if(sp == 0) throw new IllegalArgumentException("NoSuchElementException");
        return items[sp - 1];
    }
    public boolean isEmpty(){
        if(sp==0) return true;
        return false;
    }
    public void push(int x){
        items[sp]=x;
        sp++;
    }
    public int pop(){
        int output=items[sp-1];
        sp--;
        return output;
    }
    public void rearrange(){
        Stack<Integer> pos= new Stack<Integer>();
        Stack<Integer> neg= new Stack<Integer>();
        Stack<Integer> zero= new Stack<Integer>();
        while(!(isEmpty())){
            if(peek()>0)pos.push(pop());
            else if(peek()<0)neg.push(pop());
            else zero.push(pop());
        }
        while(!(neg.isEmpty())) push(neg.pop());
        while(!(zero.isEmpty())) push(zero.pop());
        while(!(pos.isEmpty())) push(pos.pop());
    }
    public String toString(){
        int x=sp;
        String output="";
        while(!(isEmpty())){
            output+=pop()+" ";
        }
        sp=x;
        return output;
    }
}