package montecarlo;

import com.sun.corba.se.spi.monitoring.StatisticsAccumulator;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Stream.generate;

public class Solution {

    static Random random = new Random();

    public static void main(String[] args) {

        Map<Integer, Integer> randomDistributionPerPartition =
                randomDistributionPerPartition(100, 14);

        randomDistributionPerPartition.forEach((k, v) -> System.out.println("Partition " + k + " has " + v + " values"));

        StatisticsAccumulator statisticsAccumulator = new StatisticsAccumulator("rows");

        randomDistributionPerPartition
                .values()
                .forEach(statisticsAccumulator::sample);

        System.out.println(statisticsAccumulator.getValue());
    }

    private static Map<Integer, Integer> randomDistributionPerPartition(int partitions, int rows) {
        final int[] i = {0};
        Stream<Integer> infiniteSequentialStream = generate(() -> i[0]++);
        Stream<Integer> infiniteRandomStream = generate(() -> random.nextInt(partitions));

        //Just to make sure we will have the partition present in lower quantity samples
        Map<Integer, Integer> zeroCountPerPartition = infiniteSequentialStream
                .limit(partitions)
                .collect(Collectors.toMap((k) -> k, (k) -> 0));

        //random samples per pertition
        Map<Integer, Integer> countByPartitionRandom = infiniteRandomStream
                .limit(rows)
                .collect(groupingBy((partitionId) -> partitionId))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, (entry) -> entry.getValue().size()));

        //overlap the zero count
        zeroCountPerPartition.putAll(countByPartitionRandom);
        return zeroCountPerPartition;
    }

}
