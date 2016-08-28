import java.util.Scanner;

/**
 *
 * Solution to maximize the cuts in a tree to create a forest of even trees
 *
 * Created by darcio on 8/26/16.
 */
public class MaximizeEvenVerticesForests {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //recursively count the number of child nodes

        int v = sc.nextInt();
        int e = sc.nextInt();

        if(v%2==1){
            //not possible to divide at all
            System.out.println(0);
            return;
        }

        int[] map = new int[v+1];
        int[] count = new int[v+1];

        for (int i = 0; i < e; i++)
            map[sc.nextInt()] = sc.nextInt();

        for (int i = 1; i <= v; i++)
            goUpCounting(i,map,count);

        int accCuts=0;
        for(int i = 1; i <= v; i++){
            if(count[i]==1){

                accCuts = goUpCutting(i,map,count,accCuts);

            }
        }

        System.out.println(accCuts);

    }

    private static int goUpCutting(int i, int[] map, int[] count, int accCuts) {
        int next = map[i];

        if(next==0) return accCuts;

        if(count[i]%2==0 /*&& isEvenUpToTheRoot(map[i],map,count)*/ ){ // OK cut!!

            //cut the relation in the array
            map[i]=0;

            //decrement the count accumulator array
            count[next]=count[next]-count[i];

            accCuts++;
        }

        return goUpCutting(next,map,count,accCuts);
    }

    public static void goUpCounting(int from, int[] arr, int[] arrAcc){
        if(from !=0) {
            arrAcc[from]++;
            goUpCounting(arr[from], arr, arrAcc);
        }
    }



}
