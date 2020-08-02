package insertdeletegetrandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    java.util.Random rand = new java.util.Random();
    Map<Integer, Integer> indexByVal = new HashMap<>(2000*2000);
    List<Integer> vals = new ArrayList<>();

    public static void main(String[] args) {
        //["RandomizedSet","remove"   ,"remove"   ,"insert"   ,"getRandom"    ,"remove"   ,"insert"]
        //[[]             ,[0]        ,[0]        ,[0]        ,[]             ,[0]        ,[0]]
        //[null           ,false      ,false      ,true       ,0              ,true       ,true]

        RandomizedSet obj = new RandomizedSet();

        System.out.println(obj.insert(0) + " must be true");
        System.out.println(obj.remove(0) + " must be true");
        System.out.println(obj.insert(-1) + " must be true");
        System.out.println(obj.remove(0) + " must be false");

        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());


    }

    public RandomizedSet() {

    }

    public boolean insert(int vl) {

        if (!this.indexByVal.containsKey(vl)) {
            this.vals.add(vl);
            int valIndex = this.vals.size() - 1;
            indexByVal.put(vl, valIndex);
            return true;
        }

        return false;
    }

    public boolean remove(int vl) {

        if (this.indexByVal.isEmpty() || !this.indexByVal.containsKey(vl))
            return false;

        int indexOfVal = this.indexByVal.get(vl);

        int lastIndex = this.vals.size() - 1;

        if (indexOfVal == lastIndex) {
            this.vals.remove(indexOfVal);
            this.indexByVal.remove(vl);
            return true;
        }

        int lastVale = this.vals.remove(lastIndex);

        this.indexByVal.remove(vl);
        this.vals.set(indexOfVal, lastVale);
        this.indexByVal.put(lastVale, indexOfVal);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }

}
