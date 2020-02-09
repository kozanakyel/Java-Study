
package mystringmain;

public class MyStringMain {

    public static void main(String[] args) {
        /// 10.26 CALCULATOR
        String a = args[0].replaceAll(" ", "");
        a = a.replaceAll("[+]", "#+#");
        a = a.replaceAll("[-]", "#-#");
        a = a.replaceAll("[*]", "#*#");
        a = a.replaceAll("[/]", "#/#");
        args = a.split("#");
        
        if(args.length != 3){
            System.out.println("Usage: java Calculator opearnd1 "
                    + "operand operand2");
            System.exit(0);
        }
        
        int result = 0;
        switch (args[1].charAt(0)) {
            case '+' : result = Integer.parseInt(args[0]) +
                  Integer.parseInt(args[2]);
                      break;
            case '-' : result = Integer.parseInt(args[0]) -
                  Integer.parseInt(args[2]);
                      break;
            case '*' : result = Integer.parseInt(args[0]) *
                  Integer.parseInt(args[2]);
                      break;
            case '/' : result = Integer.parseInt(args[0]) /
                  Integer.parseInt(args[2]);
                      break;
        }

        // Display result
        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                + " = " + result);


        ////////////////
        System.out.println(MyString.valueOf(25));
        MyString.valueOf(10);
        
        MyString str = new MyString(new char[]{'T', 'e', 's', 't'});
        MyString value = str.valueOf(145);
        for (int i = 0; i < value.length(); i++) {
            System.out.print(value.charAt(i));		
        }
        System.out.println();
        
        print(MyString.valueOf(true));
    }  
    
    public static void print(MyString str) {
	print(str.toChars());
    }

	/** Display an array of characters */
    public static void print(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
        }
        System.out.println();
    }
}
