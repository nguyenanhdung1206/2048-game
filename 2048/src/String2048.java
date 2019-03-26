
import static java.lang.Integer.parseInt;


public class String2048 {
    private String value;
    public String2048(String v){
        value=v;
    }

    public String getValue() {
        return value;
    }
    
    @Override
    public String toString(){
        return "  "+value+"  ";
    }
    
    public int toInt(){
        return Integer.parseInt(getValue());
    }
}
