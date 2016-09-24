import java.util.ArrayList;
import java.util.List;

/**
 * Created by darcio on 9/10/16.
 */
public class ParseStreamAndStatistics {

    public static void main(String[] args) {


    }

    static String validate(String input) {


        int lines = 0;
        int fields = 0;
        int empties = 0;

        boolean openField = false;
        boolean error = false;
        boolean wroteVal = false;
        boolean escaped = false;

        List<String > fieldNames = new ArrayList<>();


        for (int i = 0; i < input.length(); i++) {

            // if is first line, consider as a field name
            //

            char c = input.charAt(i);

            if (escaped) {
                escaped = false;
                if(c!='n')
                    wroteVal = true;
                else{
                    lines++;
                    wroteVal=false;
                    openField=false;
                }
            } else {


                if (c == '|') {

                    if (openField) {
                        openField = false;

                        if (!wroteVal) {
                            empties++;
                        }

                        wroteVal=false;

                    } else {

                        openField = true;
                    }


                } else if (c == '~') {
                    if (escaped) {
                        wroteVal = true;
                    } else {


                    }


                } else {

                    wroteVal=true;
                }
            }

        }


        String err = "";
        if (error) err = "format_error";

        return "" + lines + ":" + fields + ":" + empties + ":" + err;

    }

}
