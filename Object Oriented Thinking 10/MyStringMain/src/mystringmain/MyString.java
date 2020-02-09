
package mystringmain;

public class MyString {
    private char[] chars;
    private String s;
    
    public MyString(char[] chars){
        this.chars = new char[chars.length];
        for(int i = 0; i < chars.length; i++){
            this.chars[i] = chars[i];
        }     
    }
    
    public char charAt(int index){
        return chars[index];
    }
    
    public int length(){
        return chars.length;
    }
    
    public MyString substring(int begin, int end){
        char[] ch = new char[end - begin];
        for(int i = begin, j = 0; i < end; i++, j++){
            ch[j] = chars[i];
        }
        return new MyString(ch);
    }
    
    public MyString toLowerCase(){
        char[] ch = new char[chars.length];
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= 'A' && chars[i] <= 'Z')
                ch[i] = (char)(chars[i] + 32);
            else
                ch[i] = chars[i];
        }
        return new MyString(ch);
    }
    
    public boolean equals(MyString s){
        if(chars.length != s.length())
            return false;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != s.charAt(i))
                return false;
        }
        return true;
    }
    
    public static MyString valueOf(int i){
        int length = 0;
        int n = i;
        while(n >= 1){
            n /= 10;
            length++;
        }
        char[] ch = new char[length];
        for(int j = 0, k = (int)Math.pow(10, length - 1);
                j < length; j++, k /= 10){
            ch[j] = Character.forDigit((i / k), 10);
            i %= k;
        }
        return new MyString(ch);
    }
    
    public MyString(String s){
        this.s = "";
        for(int i = 0; i < s.length(); i++){
            this.s += s.charAt(i) + "";
        }
    }
    
    public int compare(String s){
        int index = 0;
        if(this.s.length() < s.length())
            index = -1;
        if(s.length() < this.s.length())
            index = 1;
        
        for(int i = 0; i < this.s.length(); i++){
            if(this.s.charAt(i) < s.charAt(i))
                index = -(i + 1);
            if(this.s.charAt(i) > s.charAt(i))
                index = i + 1;
        }
        return index;
    }
    
    public MyString substring(int begin){
        String b = "";
        for(int i = begin, j = 0; i < s.length(); i++, j++){
            b += s.charAt(i) + "";
        }
        return new MyString(b);
    }
    
    public MyString toUpperCase(){
        String n = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                n += String.valueOf((char)(s.charAt(i) - 32));
            else
                n += String.valueOf(s.charAt(i));
        }
        return new MyString(n);
    }
    
    public char[] toChars(){
        char[] ch = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            ch[i] = s.charAt(i);
        }
        return ch;
    }
    
    public static MyString valueOf(boolean b){
        return (b ? new MyString("true") : new MyString("false"));
    }
}
