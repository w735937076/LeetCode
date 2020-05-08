package Question29;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = -2;
        System.out.println(divide(dividend,divisor));
    }

    public static int divide(int dividend, int divisor) {
        //除数不能为0
        if(divisor == 0){
            throw new ArithmeticException();
        }


        if(dividend == Integer.MIN_VALUE && divisor == -1){
            //判断溢出
            return Integer.MAX_VALUE;
        }

        //判断结果是正还是负
        boolean flag = (dividend ^ divisor) >= 0;

        long tempDividend = Math.abs((long)dividend);
        long tempDivisor =  Math.abs((long)divisor);

        int result = 0;
        //注意：2 << 0 == 2
        int index = -1;
        while(Math.abs((long)divisor) <= tempDividend){
            if(tempDivisor <= tempDividend){
                tempDividend -= tempDivisor;
                tempDivisor += tempDivisor;
                result += (index == -1 ? 1 : 2 << index);
                index ++;
            }else{
                tempDivisor = Math.abs((long)divisor);
                index = -1;
            }
        }

        return flag ? result : -result;
    }
}
