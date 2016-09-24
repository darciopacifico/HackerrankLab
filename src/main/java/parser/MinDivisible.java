package parser;

/**
 * Created by darcio on 9/8/16.
 */
public class MinDivisible {

    public static void main(String[] args) {


        int n = 40;
        int c = 1;

        Boolean found = false;

        while(!found){
            c++;

            found=true;

            for (int i=1; i<=n; i++){

                if(c%i!=0){
                    found=false;
                    break;
                }

            }

        }




        System.out.println(c);
    }
}
