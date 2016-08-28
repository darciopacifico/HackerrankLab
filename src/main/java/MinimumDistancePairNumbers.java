import java.util.*;

public class MinimumDistancePairNumbers {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        final int n = in.nextInt(); // numbers
        final int p = in.nextInt(); // pairs

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Map<Integer,List<IntIndex>> mapIndexes = new HashMap<>();


        for (int i=0; i<n; i++ ){
            Integer number = in.nextInt();
            List<IntIndex> indexes = mapIndexes.get(i);

            if(indexes==null)
                indexes = new ArrayList<>();

            IntIndex ii = new IntIndex(number,i);
            indexes.add(ii);
            mapIndexes.put(number,indexes);
        }

        for (int i=0; i<p; i++){

            Integer p1 = in.nextInt();
            Integer p2 = in.nextInt();

            List<IntIndex> indexesP1 = mapIndexes.get(p1);
            List<IntIndex> indexesP2 = mapIndexes.get(p2);

            if(indexesP1.isEmpty() || indexesP2.isEmpty()){
                System.out.println(-1);
            }else{

                List<IntIndex> allIndexes = new ArrayList<>();

                allIndexes.addAll(indexesP1);
                allIndexes.addAll(indexesP2);

                allIndexes.sort(new Comparator<IntIndex>() {
                    @Override
                    public int compare(IntIndex o1, IntIndex o2) {
                        return o1.index.compareTo(o2.index);
                    }
                });

                Integer minDist = Integer.MAX_VALUE;

                Integer p1Orp2_num = null;
                Integer p1Orp2_index = null;

                for (IntIndex ii: allIndexes){

                    if(p1Orp2_num!=null) {

                        if(!ii.num.equals(p1Orp2_num)){
                            // not the same!! check distance
                            Integer distAtual = Math.abs(ii.index - p1Orp2_index);
                            if(distAtual<minDist){
                                minDist = distAtual;
                            }
                        }
                    }


                    p1Orp2_index = ii.index;
                    p1Orp2_num = ii.num;
                }
                System.out.println(minDist);
            }
        }
    }

    static class IntIndex{
        public Integer num;
        public Integer index;

        public IntIndex(Integer num, Integer index) {
            this.num = num;
            this.index = index;
        }

    }

}