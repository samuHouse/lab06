package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> MyList = new ArrayList();

        for (int i = 1000; i < 2000; i++) {
            MyList.add(i);
        }
        
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

         List<Integer> MyLinkedList = new LinkedList(MyList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        Integer tmp = MyList.get(0);
        MyList.set(0, MyList.get(MyList.size()-1));
        MyList.set(MyList.size()-1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for (Integer elem : MyList) {
            System.out.println(elem);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final int ELEMS = 100_000;

         long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            MyList.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + ELEMS
                + " ints in a ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

// fatto per ArrayList * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
        
        time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            MyLinkedList.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + ELEMS
                + " ints in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        final int ELEMS_TO_READ = 1_000;

        time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS_TO_READ; i++) {
            MyList.get(MyList.size()/2);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + ELEMS_TO_READ
                + " ints in a ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        // ora faccio la stessa cosa per la LinkedList...

        time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS_TO_READ; i++) {
            MyLinkedList.get(MyLinkedList.size()/2);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + ELEMS_TO_READ
                + " ints in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<String, Long> WorldPopulation = new HashMap<>(Map.of("Africa", 1_110_635_000L, "Americas", 972_005_000L,
         "Antartica", 0L, "Asia", 4_298_723_000L, "Europe", 742_452_000L, "Oceania", 38_304_000L));

        /*
         * 8) Compute the population of the world
         */

        Long totalPopulation = 0L;
        
        for (Long continent : WorldPopulation.values()) {
            totalPopulation += continent;
        }

        System.out.println("the world population is "+totalPopulation);
    }
}
