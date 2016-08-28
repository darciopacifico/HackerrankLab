import java.util.*;

public class StrongestPadlock {
    private static final String MESSAGE_NOT_ENOUGH_PADLOCKS = "Not enough padlocks with keys";

    static class Padlock {
        final private int id;
        final private int strength;

        public Padlock(int id, int strength) {
            this.id = id;
            this.strength = strength;
        }
    }

    static class Key {
        final private int id;

        public Key(int id) {
            this.id = id;
        }
    }

    private static List<Padlock> strongestPadlocks(final int n, final List<Padlock> padlocks, final List<Key> keys) {
               return null; /* Enter your code here. */
    }

    private static int loadPadlocksAndKeys(final Scanner  in, final List<Padlock> padlocks, final List<Key> keys) {
        final int p = in.nextInt();
        final int k = in.nextInt();
        final int n = in.nextInt();

        // load padlocks
        for(int i = 0; i < p; i++) {
            int padlockId = in.nextInt();
            int padlockStrength = in.nextInt();
            Padlock padlock = new Padlock(padlockId, padlockStrength);
            padlocks.add(padlock);
        }

        // load keys
        for(int i = 0; i < k; i++) {
            int keyId = in.nextInt();
            Key key = new Key(keyId);
            keys.add(key);
        }

        return n;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        final List<Padlock> padlocks = new ArrayList<Padlock>();
        final List<Key> keys = new ArrayList<Key>();

        final int n = loadPadlocksAndKeys(in, padlocks, keys);

        final List<Padlock> strongestPadlocks = strongestPadlocks(n, padlocks, keys);

        System.out.println(MESSAGE_NOT_ENOUGH_PADLOCKS);
    }
}