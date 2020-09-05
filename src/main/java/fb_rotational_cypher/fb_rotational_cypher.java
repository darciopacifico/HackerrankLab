package fb_rotational_cypher;

// Add any extra import statements you may need here
//first green at 11:58

class Main {
    // Add any helper functions you may need here

    String rotationalCipher(String input, int rotationFactor) {
            char[] inputArr = input.toCharArray();
            char[] result = new char[input.length()];

            for (int i = 0; i < inputArr.length; i++) {
                char c = inputArr[i];
                if (!Character.isLetterOrDigit(c)) {
                    result[i] = c;
                }   else if (Character.isDigit(c)) {

                    int number = c - '0';
                    int newNumber = (number + rotationFactor) % 10;
                    result[i] = (char) ('0' + newNumber);

                } else if (Character.isUpperCase(c)) {
                    int number = c - 'A';
                    int newNumber = (number + rotationFactor) % 26;
                    result[i] = (char) ('A' + newNumber);


                } else {
                    int number = c - 'a';
                    int newNumber = (number + rotationFactor) % 26;
                    result[i] = (char) ('a' + newNumber);

                }

            }

            return new String(result);
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) '9');

        System.out.println((int) 'a');
        System.out.println((int) 'z');

        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        new Main().run();
    }
}