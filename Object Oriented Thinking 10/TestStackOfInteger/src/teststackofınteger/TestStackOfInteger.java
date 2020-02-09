
package teststackofınteger;

public class TestStackOfInteger {

    public static void main(String[] args) {
        StackOfInteger stack = new StackOfInteger();
        
        for(int i = 0; i < 10; i++)
            stack.push(i);
        
        while(!stack.empty())
            System.out.print(stack.pop() + " ");
    }
    
}
