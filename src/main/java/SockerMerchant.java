import java.io.IOException;

public class SockerMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        boolean[] sockType = new boolean[100];

        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (sockType[i])
                pairs++;

            sockType[i] = !sockType[i];
        }


        return pairs;

    }

    public static void main(String[] args) throws IOException {

        System.out.println(sockMerchant(10, new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3}));


    }
}
