import java.text.NumberFormat;

/**
 * Created by wangkp on 2017/12/25.
 */
public class TestNumber {

    public static void main(String[] args){
        test1();
    }

    private static void test1(){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(4);
        numberFormat.setMinimumFractionDigits(2);
        String a = numberFormat.format(3.1415926);
        String b = numberFormat.format(2);
        System.out.println(a + "," + b);
    }

}
