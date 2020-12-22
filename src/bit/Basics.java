package bit;

/**
 * 位运算的基本操作
 * & 运算(AND)，保留左右两个数的相同部分
 * ^ 运算(XOR)，保留左右两个数不同的部分（不同的把有效数字 1 保留）
 * ~ 运算(NOT)，
 * | 运算(OR),
 * >> 有符号右移，相当于除以 2
 * >>> 无符号右移
 * << 左移
 *
 * @Author lx
 * @Date 2020/12/9 14:15
 * @Version 1.0
 */
public class Basics {

    /**
     * 数字的二进制表示中，1 的个数
     *
     * @param n
     * @return
     */
    public static int numberOfBinary1(int n) {
        /**
         * 数字中 1 的个数
         * 一个数- 1，相当于把这个数最后一位 1 变成 0，这一位后边全变成 1
         * a & a - 1 (减法优先 & 运算)就相当于把最后边那个 1 给去掉了
         * 如果把所有的 1 都去掉，那么就变成 0 了
         */
        int m = 0;
        while (n != 0) {
            n &= n - 1;
            ++m;
        }
        return m;
    }

    /**
     * 数字的二进制表示中某一位是否是 1
     *
     * @param n
     */
    public static boolean split2group(int n) {
        /**
         * [1] 负数在计算机中的二进制长啥样
         * m 的原码（我们理解的机器应该存储负数的样子）
         * 10000000 00000000 00000000 00001101
         * 每一个数值为取反 m 的反码
         * 11111111 11111111 11111111 11110010
         * 反码 +1 m 的补码（实际机器存储负数的样子）
         * 11111111 11111111 11111111 11110011
         * [2] 通过一个数和它的相反数做 与运算，得到的是这个数最后一位 1 为 1 其他位均为 0 的数字
         * 也就是 0001 0010 & 1110 1110 = 0000 0010
         * [3] 一个数中只有一位为 1，那么这个数与其他数字 & 操作是否为零，可以判断其他数字这一位是否为 1
         */
        int m = (int) (Math.random() * 100);
        int mLastBit1 = m & -m;
        if ((n & mLastBit1) == 0) {
            return false;
        } else {
            return true;
        }
    }
}