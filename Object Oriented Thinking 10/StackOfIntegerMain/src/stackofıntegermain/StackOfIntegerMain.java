
package stackofıntegermain;

public class StackOfIntegerMain {

    public static void main(String[] args) {
        StackOfInteger stack = new StackOfInteger();
        
        for(int i = 2; i < 120; i++){
            if(isPrime(i))
                stack.push(i);
        }
        
        System.out.println("\n all the primenumber less than 120 ");
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
    
    public static boolean isPrime(int n){
        for(int d = 2; d <= n / 2; d++){
            if(n % d == 0)
                return false;
        }
        return true;
    }
}
