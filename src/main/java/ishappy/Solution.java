package ishappy;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(123));
        System.out.println(new Solution().isHappy(19));
    }

    public boolean isHappy(int n) {
        int t = n;
        int h = n;

        do {
            if (t == 1) return true;
            h = sumSqrdDigits(sumSqrdDigits(h));
            t = sumSqrdDigits(t);
        } while (t != h);

        return t == 1;
    }

    private int sumSqrdDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int dig = n % 10;
            sum += dig * dig;
            n = n / 10;
        }
        return sum;
    }
}
