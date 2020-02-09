
package testexceptionjava;

public class TestExceptionJava {

    public static void main(String[] args) {
        try{
            System.out.println(sum(new int[]{1, 2, 3, 4, 5}));
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("\n" + ex.getMessage());
            System.out.println("\n" + ex.toString());
            
            System.out.println("\nTrace info obtained from getStackTrace");
            StackTraceElement[] traceElements = ex.getStackTrace();
            for(int i = 0; i < traceElements.length; i++){
                System.out.print("method " + traceElements[i].getMethodName());
                System.out.print("(" + traceElements[i].getClassName() + ")");
                System.out.println(traceElements[i].getLineNumber());
            }
        }
        
        ////////////////
        System.out.println();
        try{
            CircleWithException c1 = new CircleWithException(5);
            CircleWithException c2 = new CircleWithException(-5);
            CircleWithException c3 = new CircleWithException(0);
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex);
        }
        System.out.println("Number of objects created: " + 
                CircleWithException.getNumberOfObjects());
        
        //////////
        System.out.println();
        try{
            method();
            System.out.println("after the method call");
        }        
        catch(RuntimeException ex){
            System.out.println("runtime in main");
        }
        catch(Exception ex){
            System.out.println("exception in main");
        }
        finally{
            //final statements  // executed under all circumstances...
        }
        
        
    }
    
    static void method() throws Exception{
        try{
            String s = "abc";
            System.out.println(s.charAt(3));
        }        
        catch(RuntimeException ex){
            System.out.println("runtime in method");
        }
        catch(Exception ex){
            System.out.println("exception in method");
        }
    }
    
    private static int sum(int[] list){
        int result = 0;
        for(int i = 0; i <= list.length; i++)
            result += list[i];
        return result;
    }
}
