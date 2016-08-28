import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by darcio on 8/27/16.
 */
public class SherlockAndValidString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        //int qtdChar = ('z' - 'a')-1;

        Map<Character,Integer> mapChar = new HashMap<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            Integer count = mapChar.get(c);
            if(count==null) count =0;

            mapChar.put(c, ++count);
        }

        Map<Integer,Integer> groupCount = new HashMap<>();

        Collection<Integer> contagens = mapChar.values();

        for(Integer contagem:contagens){
            Integer ocorrencia = groupCount.get(contagem);
            if(ocorrencia==null) ocorrencia = 0;
            groupCount.put(contagem,++ocorrencia);
        }


        Collection<Integer> metaCont = groupCount.values();

        if(metaCont.size()==1){
            System.out.println("YES");
        }else if(metaCont.size()>2){
            System.out.println("NO");
        }else if (metaCont.contains(1)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }

}
