    package loggerratelimiter;

    import java.util.HashMap;
    import java.util.Map;

    public class Logger {
        private final Map<String, Integer> lastOccurrenceByMessage = new HashMap<>();

        private final static int MESSAGE_COOL_DOWN_PERIOD = 10;

        public static void main(String[] args) {
            Logger logger = new Logger();

            System.out.println(logger.shouldPrintMessage(1, "foo") + " = true"); //returns true;
            System.out.println(logger.shouldPrintMessage(2, "bar") + " = true"); //returns true;
            System.out.println(logger.shouldPrintMessage(3, "foo") + " = false"); //returns false;
            System.out.println(logger.shouldPrintMessage(8, "bar") + " = false"); //returns false;
            System.out.println(logger.shouldPrintMessage(10, "foo") + " = false"); //returns false;
            System.out.println(logger.shouldPrintMessage(11, "foo") + " = true"); //returns true;
        }

        /**
         * Initialize your data structure here.
         */
        public Logger() {
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer lastOccurrence = this.lastOccurrenceByMessage.get(message);

            if (lastOccurrence == null || (timestamp - lastOccurrence) >= MESSAGE_COOL_DOWN_PERIOD) {
                this.lastOccurrenceByMessage.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
