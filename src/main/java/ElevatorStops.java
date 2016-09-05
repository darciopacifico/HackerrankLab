import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by darcio on 9/3/16.
 */
public class ElevatorStops {

    public static void main(String[] args) {

        System.out.println(new ElevatorStops().solution(
                new int[]{60, 80, 40},
                new int[]{2, 3, 5},
                5,
                2,
                200
        ));

        System.out.println(new ElevatorStops().solution(
                new int[]{40, 40, 100,80,20},
                new int[]{3, 3, 2,2,3},
                3, //m
                5, // x
                200 // y
        ));

    }

    public int solution(int[] weights, int[] floors, int qttFloors, int maxPersons, int maxWeight) {
        int stops = 0;

        int travelWeight = 0;
        int travelPeople = 0;

        Set<Integer> travelDests = new HashSet<>();
        List<Set<Integer>> travels = new ArrayList<>();

        travels.add(travelDests);

        for (int i = 0; i < weights.length; i++) {
            if(travelPeople+1 >maxPersons || travelWeight + weights[i]>maxWeight){
                travelPeople=1;
                travelWeight=weights[i];

                travelDests = new HashSet<>();
                travels.add(travelDests);

            }else{
                travelPeople++;
                travelWeight = travelWeight +weights[i];
            }

            travelDests.add(floors[i]);
        }

        for (Set<Integer> dests:travels)
            stops = stops + dests.size()+1;

        return stops;
    }

}
