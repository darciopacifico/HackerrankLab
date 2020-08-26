package twoplustwo;

import java.lang.reflect.Field;

public class Solution {
    public static void main(String[] args) throws Exception {
        abracadabra();
        System.out.printf("%d", 2 + 2);
    }

    private static void abracadabra() throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] intArray = (Integer[]) c.get(cache);
        intArray[132] = 5;
    }
}
