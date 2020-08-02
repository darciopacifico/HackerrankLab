package evaldiv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        /**
         * equations = [ ["a", "b"], ["b", "c"] ],
         * values = [2.0, 3.0],
         * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
         */

        List<String> eq1 = new ArrayList<>();eq1.add("a");eq1.add("b");
        List<String> eq2 = new ArrayList<>();eq1.add("b");eq1.add("c");

        List<List<String>> equations = new ArrayList<>();
        equations.add(eq1);
        equations.add(eq2);
        double[] values = new double[]{2d, 3d};

        List<String> q1 = new ArrayList<>();eq1.add("a");eq1.add("c");
        List<String> q2 = new ArrayList<>();eq1.add("b");eq1.add("a");
        List<String> q3 = new ArrayList<>();eq1.add("a");eq1.add("e");
        List<String> q4 = new ArrayList<>();eq1.add("a");eq1.add("a");
        List<String> q5 = new ArrayList<>();eq1.add("x");eq1.add("x");
        List<List<String>> queries = new ArrayList<>();
        queries.add(q1);queries.add(q2);queries.add(q3);queries.add(q4);queries.add(q5);

        Arrays.stream(new Solution()
                .calcEquation(equations, values, queries))
                .forEach(System.out::println);
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        return new double[]{};
    }
}
