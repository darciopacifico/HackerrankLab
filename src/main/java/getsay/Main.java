package getsay;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));

        long now = System.nanoTime();
        for (int i = 70; i <= 10; i++) {
            System.out.println(i + ", " + new Solution().countAndSay(i).length());
        }
        System.out.println("chain total ns " + (System.nanoTime() - now));

        now = System.nanoTime();
        for (int i = 70; i <= 10; i++) {
            System.out.println(i + ", " + new ArraySolution().countAndSay(i).length());
        }
        System.out.println("array total ns " + (System.nanoTime() - now));
    }

    public static class Solution {

        public String countAndSay(int n) {
            StringBuilder sb = new StringBuilder();
            SayListener listener = new SayResultRegister(sb);

            for (int i = 1; i < n; i++) {
                SayListener newSayListener = new SayListener(listener);
                listener = newSayListener;
            }

            listener.acceptDigit(1);
            listener.flush();

            return sb.toString();
        }


        public static class SayListener {
            final SayListener child;

            public SayListener(SayListener child) {
                this.child = child;
            }

            Integer lastDig;
            int lastDigCount;

            public void acceptDigit(int digit) {
                if (lastDig != null && lastDig == digit) {
                    lastDigCount++;
                } else {
                    if (lastDig != null) {
                        child.acceptDigit(lastDigCount);
                        child.acceptDigit(lastDig);
                    }
                    lastDig = digit;
                    lastDigCount = 1;
                }
            }


            public void flush() {
                child.acceptDigit(lastDigCount);
                child.acceptDigit(lastDig);
                child.flush();
            }

        }

        public static class SayResultRegister extends SayListener {
            final StringBuilder sb;

            public SayResultRegister(StringBuilder sb) {
                super(null);
                this.sb = sb;
            }

            public void acceptDigit(int digit) {
                sb.append((char) ('0' + digit));
            }

            @Override
            public void flush() {

            }
        }

        public static class SayResultArrRegister extends SayListener {
            final List<Character> sb;

            public SayResultArrRegister(List<Character> sb) {
                super(null);
                this.sb = sb;
            }

            public void acceptDigit(int digit) {
                sb.add((char) ('0' + digit));
            }

            @Override
            public void flush() {

            }
        }
    }


    public static class ArraySolution {
        private static final double AVG_GROWTH_RATE = 1.36;
        private static final double AMORTIZED_GROWTH_RATE = 2.5;
        private static final int MINIMAL_INITIAL_SIZE = 100;

        public String countAndSay(int n) {

            char[] number = new char[MINIMAL_INITIAL_SIZE];
            char[] numberSayResult = new char[MINIMAL_INITIAL_SIZE];

            numberSayResult[0] = '1';
            number[0] = '1';
            int lastCharIndex = 1;

            for (int i = 1; i < n; i++) {
                lastCharIndex = getSay(number, lastCharIndex, numberSayResult);

                int newEstimateSize = Math.max(100, (int) (lastCharIndex * AVG_GROWTH_RATE));

                if (number.length <= newEstimateSize) {
                    //Increase array size with an amortized growth rate
                    number = numberSayResult;
                    numberSayResult = new char[(int) (number.length * AMORTIZED_GROWTH_RATE)];
                } else {
                    //Reuse the same pair of arrays.
                    char[] temp = number;
                    number = numberSayResult;
                    numberSayResult = temp;
                }
            }

            return new String(number, 0, lastCharIndex).trim();
        }


        private int getSay(char[] number, int numberSize, char[] sayResult) {

            char lastDig = number[0];
            int lastDigCount = 1;

            int sayResultSize = 0;
            for (int i = 1; i < numberSize; i++) {
                char digit = number[i];

                if (lastDig == digit) {
                    lastDigCount++;
                } else {

                    sayResult[sayResultSize++] = ((char) ('0' + lastDigCount));
                    sayResult[sayResultSize++] = lastDig;
                    lastDig = digit;
                    lastDigCount = 1;
                }
            }

            sayResult[sayResultSize++] = ((char) ('0' + lastDigCount));
            sayResult[sayResultSize++] = lastDig;

            return sayResultSize;
        }

    }
}
