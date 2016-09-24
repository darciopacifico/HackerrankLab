import java.util.Arrays;
import java.util.List;

/**
 * Created by darcio on 9/10/16.
 */
public class BotStashes {
    public static void main(String[] args) {
        System.out.println(compute("PMLPMMMLPMLPMML"));
        System.out.println(compute("PL"));
        System.out.println(compute("PLPLPLPLPLPLPLPLPLPL"));
        System.out.println(compute("PLPLPLPLPLPLPLPLPLPL"));
    }

    /*
     * Complete the function below.
     */
    static String compute(String instructions) {
        int[] stashes = new int[10];
        // P, L, M

        int fila = 0;
        boolean holdBlock = false;

        for (int i = 0; i < instructions.length(); i++) {

            char inst = instructions.charAt(i);
            if (inst == 'P') {
                holdBlock = true;
                fila = 0;
            } else if (inst == 'L') {
                if (holdBlock) {
                    if (stashes[fila] < 15) {
                        stashes[fila]++;
                        holdBlock = false;
                    }
                }

            } else if (inst == 'M') {
                if (fila < 9) {
                    fila++;
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < stashes.length; i++)
            sb.append(String.format("%X", stashes[i]));

        return sb.toString();


    }

}
