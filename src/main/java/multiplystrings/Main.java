package multiplystrings;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println(new Solution().multiply("123", "456"));
        System.out.println(new Solution().multiply("123", "00000"));
    }

    public static class Solution {
        public String multiply(String num1, String num2) {


            long sum = 0;

            List<String> partes = new LinkedList<>();
            int largestNumber = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                for (int j = num2.length() - 1; j >= 0; j--) {

                    int d1 = num1.charAt(i) - '0';
                    int d2 = num2.charAt(j) - '0';

                    int potenciaI = (num1.length() - i) - 1;
                    int potenciaJ = (num2.length() - j) - 1;

                    int zeros = potenciaI + potenciaJ;

                    String zeroString = getZeros(zeros);

                    String parte = (d1 * d2) + zeroString;

                    largestNumber = Math.max(largestNumber, parte.length());

                    partes.add(parte);
                }
            }

            //largestNumber++;//one aditional for the rest

            final int lz = largestNumber;
            List<String> newPartes = partes.stream()
                    .map(s -> {
                        String n = getZeros(lz) + s;

                        int start = n.length() - lz;
                        return n.substring(start, n.length());
                    }).collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < largestNumber; i++) {

                long sumDig = 0l;
                for (String parte : partes) {

                    int len = parte.length();
                    int dIndex = (len - i) - 1;

                    if (dIndex < 0)
                        continue;

                    sumDig += parte.charAt(dIndex) - '0';

                }

                long dig = sumDig % 10;
                long resto = sumDig / 10;

                sb.append(dig);

                if (resto > 0) {
                    String newPart = resto + getZeros(i + 1);
                    largestNumber = Math.max(largestNumber, newPart.length());
                    partes.add(newPart);
                }

            }

            String s = sb.reverse().toString();
            int nonZero = 0;
            for (; nonZero < s.length(); nonZero++)
                if (s.charAt(nonZero) != '0') break;

            if (nonZero == s.length()) {
                return "0";
            }

            return s.substring(nonZero);


        }

        String getZeros(int zeros) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < zeros; i++) {
                sb.append('0');
            }

            return sb.toString();
        }

    }
}
