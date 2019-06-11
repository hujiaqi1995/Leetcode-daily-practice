/**
 * Created by jiaqi on 2019/6/11 8:07 PM
 */
public class P29DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if(dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        return dividend / divisor;
    }

}
