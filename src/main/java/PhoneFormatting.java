import java.util.ArrayList;
import java.util.List;

public class PhoneFormatting {


    public static void main(String[] args) {

        System.out.println(new PhoneFormatting().solution("00-44  48 5555 8361").equals("004-448-555-583-61"));
        System.out.println(new PhoneFormatting().solution("00-44  48 5555 83613").equals("004-448-555-583-613"));
        System.out.println(new PhoneFormatting().solution("00-44  48 5555 836145").equals("004-448-555-583-61-45"));

        System.out.println(new PhoneFormatting().solution("00-44  48 5555 8361"));
        System.out.println(new PhoneFormatting().solution("00-44  48 5555 83613"));
        System.out.println(new PhoneFormatting().solution("00-44  48 5555 836145"));

        //004-448-555-583-61
        //004-448-555-583-61
    }


    public String solution(String S) {

        String cs = cleanString(S);

        if (cs.length() > 3 ){

            Integer lastPartSize = cs.length() % 3;
            List<String> strParts = new ArrayList<>();

            StringBuffer part = new StringBuffer();
            for (int i=0; i<cs.length(); i++){
                part.append(cs.charAt(i));
                if(part.length()==3){
                    strParts.add(part.toString());
                    part = new StringBuffer();
                }
            }
            if(part.length()>0){
                strParts.add(part.toString());
            }


            if(lastPartSize==1){ //
                String penultimo = strParts.get(strParts.size()-2);
                String ultimo = strParts.get(strParts.size()-1);

                char c = penultimo.charAt(penultimo.length()-1);

                ultimo = c+ultimo;
                penultimo = penultimo.substring(0,2);

                strParts.set(strParts.size()-2, penultimo);
                strParts.set(strParts.size()-1, ultimo);
            }

            StringBuffer mkString = new StringBuffer();

            String sep="";
            for(String xxx: strParts){
                mkString.append(sep+xxx);
                sep = "-";
            }

            cs = mkString.toString();

        }


        return cs;
    }



    private String cleanString(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
                sb.append(ch);
        }
        return sb.toString();
    }

}