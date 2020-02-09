
package stringclassandbuilder;

public class StringClassAndBuilder {

    public static void main(String[] args) {
        String newString = new String("Welcome to java");
        String message = "Welcome to java";
        char[] charArray = {'g', 'o', 'o', 'd'};
        message = new String(charArray);
        
        // s = java ifadesi unreference konumda fakat depolama alanında mevcut
        String s = "Java";
        s = "HTML";
        System.out.println(s);
        
        //interned object and immutable
        String s1 = "Welcome to Java";
        String s2 = s1;
        String s3 = new String("Welcome to Java");
        String s4 = "Welcome to Java";
        System.out.println("s1 == s2 is " + (s1 == s2)); //is false diff objects
        System.out.println("s1 == s3 is " + (s1 == s3)); //is true same interned
        System.out.println(s1.equals(s3)); //compare to including of object
        System.out.println("Welcome to Java".replace("Java", "HTML"));
        System.out.println(s1.replace('o', 'T'));
        System.out.println(s1.replaceFirst("o", "T"));        
        
        //Replace and splitting and matches //regular expression
        "Welcome".replace('e', 'A');
        "Welcome".replaceFirst("e", "AB");
        "Welcome".replaceAll("e", "bada");
        "Welcome".replace('e', 'A');
                
        String[] tokens = "java#HTML#Perl".split("#");
        for(int i = 0; i < tokens.length; i++)
            System.out.print(tokens[i] + " ");
        //regular expression
        "java".matches("java");  //matches powerful method
        "java".equals("java");
        
        "java is fun".matches("java.*");
        boolean a = "java is cool".matches("java.*");
        System.out.println("\n" + a);
        
        //investigate this problem
        boolean matchDigit = "440-02-4534".matches("\\d{3}-\\d{2}-\\d{4}");
        System.out.println(matchDigit);
        
        String NNN = "a+b$#c".replaceAll("[$+#]", "NNN");
        System.out.println(NNN);
        String[] token = "Java,C?C#,C++".split("[.,:;?]");
        for(int i = 0; i < token.length; i++)
            System.out.println(token[i]);
        
        //String and Array
        char[] chars = "Java".toCharArray();
        
        char[] dst = {'j', 'a', 'v', 'a', '1', '3', '0', '1'};
        "CS3720".getChars(2, 6, dst, 4);
        for(int i = 0; i < dst.length; i++)
            System.out.print(dst[i]);
        
        String str = new String(new char[]{'J', 'a', 'v', 'a'});
        String str1 = String.valueOf(new char[]{'J', 'a', 'v', 'a'});
        String str2 = String.valueOf(23.5);
        boolean g = true;
        String str3 = String.valueOf(g);
        System.out.println("\n" + str3.length());
        
        //formmatting string
        String formatting = String.format("%7.2f%6d%-4s", 45.574, 14, "AB");
        //String.format(format, item1, item2, ....);
        //System.out.printf(format, item1, item2, ....);
        //System.out.print(String.format(format, item1, item2, ....)
        System.out.println(formatting);
        
        String[] splitArray = "Welcome to Java and HTML".split(" ");
        String s11 = splitArray[0];
        String s22 = splitArray[1];
        
        System.out.println("A,B;C".replaceAll("[,;]", "#"));
        
        //StringBuilderBuffer class is not immutable
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Welcome");
        stringBuilder.append(' ');
        stringBuilder.append("to");
        stringBuilder.append(' ');
        stringBuilder.append("Java");
        
        //stringBuilder.insert(11, "HTML and ");
        System.out.println(stringBuilder);
        
        stringBuilder.delete(8, 11);
        stringBuilder.deleteCharAt(8);
        stringBuilder.replace(11, 15, "HTML");
        stringBuilder.setCharAt(0, 'w');
        
        stringBuilder.capacity();
        stringBuilder.trimToSize(); // capacity i azaltıyor....
        stringBuilder.append("bakhele");
        System.out.println(stringBuilder.capacity());
        stringBuilder.trimToSize();  //important builder capacity operation
        System.out.println(stringBuilder.capacity());
        stringBuilder.reverse(); //terse cevir....
        System.out.println(stringBuilder);
        
        String k = "Java";
        k = k + "bala";
        System.out.println(k);
        StringBuilder builder = new StringBuilder(k);
        change(k, builder);  
        System.out.println(k);
        System.out.println(builder);
    }
    
    public static void change(String s, StringBuilder builder){
        s = s + " and HTML";
        builder.append(" and HTML");
    }
    
}
