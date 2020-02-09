
public class BinaryFormatException extends NumberFormatException {
    private String bin;
    
    public BinaryFormatException(String bin){
        super(bin + " is not a binary string");
        this.bin = bin;
    }
    
    public String getBinaryString(){
        return bin;
    }
}
