package zigzagconcat;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            System.out.println(
            new Solution().getNextRow(4)

            );
        }

        String res = new Solution().convert("PAYPALISHIRING", 4);
        System.out.println(res);
    }

    public static class Solution {
        int rowId = 0;
        boolean sum = true;

        public String convert(String s, int numRows) {

            StringBuilder[] sbRows = new StringBuilder[numRows];

            for (int i = 0; i < sbRows.length; i++) {
                sbRows[i] = new StringBuilder();
            }

            for (int i = 0; i < s.length(); i++) {
                int x = getNextRow(numRows);
                sbRows[x].append(s.charAt(i));
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sbRows.length; i++) {
                sb.append(sbRows[i]);
            }

            return sb.toString();
        }

        public int getNextRow(int numRows) {
            if (numRows == 1) return 0;

            int res = rowId;

            if (sum) {
                if ((rowId + 1) == numRows) {
                    sum = false;
                    rowId--;
                } else {
                    rowId++;
                }
            } else {
                if (rowId == 0) {
                    sum = true;
                    rowId++;
                } else {
                    rowId--;
                }
            }

            return res;
        }

    }
}
