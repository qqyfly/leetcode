public class Utils {

    /**
     * 返回最大公约数
     * @param a
     * @param b
     * @return 最大公约数
     */
    public int gcd(int a,int b){
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 返回最小公倍数
     * @param a
     * @param b
     * @return 最小公倍数
     */
    public int lcm(int a,int b){
        return (a * b) / gcd(a,b);
    }

}
