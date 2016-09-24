import java.math.BigDecimal;

/**
 * Created by darcio on 9/18/16.
 */
public class FloatLab {
    public static void main(String[] args) {

        {
            System.out.println("small exponent");
            float f = 44.068f;
            double d = 44.068d;
            System.out.println("" + f);
            System.out.println("" + d);
            System.out.println("" + f * f);
            System.out.println("" + d * d);
        }


        {
            System.out.println("large exponent");
            float f = 98541.068f;
            double d = 98541.068d;
            System.out.println("" + f);
            System.out.println("" + d);
            System.out.println("" + f * f);
            System.out.println("" + d * d);

            BigDecimal bd = new BigDecimal(d);
            System.out.println("" + bd.multiply(bd));
        }

    }
}
