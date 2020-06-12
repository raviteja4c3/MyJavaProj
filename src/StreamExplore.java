import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExplore {
    public static void main(String[] args) throws IOException {
        // Intermediate operations - we can further use other methods and return type is stream.
        // Terminal operations - we can not use any other methods after these are used.
        //    return type cold be a collection(list/set)/ a value(boolean, long, optional, array).

        // Filter, Map (Intermediate oprsn), mapToInt, mapToLong, mapToDouble
        List<Integer> ls1 = Arrays.asList(11,16,87,45,29,73);
        System.out.println("ls1"+ls1);
        ls1= ls1.stream().filter(i-> i>15).map(i-> i+1).collect(Collectors.toList());
        System.out.println("filter, map - ls1"+ls1);
        List<String> lsStr = Arrays.asList("Ravi", "Teja", "Kumar", "Hitesh");
        lsStr.stream().mapToInt(String::length).forEach(i -> System.out.print(i)); // (or) mapToInt(s -> s.length());
        //map, mapToInt, mapToLong, mapToDouble: return types: Stream, IntStream, LongStream, DoubleStream, StringStream
        //lsStr.stream().flatMap();
        System.out.println("=========================");

        // Method 1 - using Java Streams
        List<String>countriesList = Arrays.asList("USA", "INDIA", "UK", "Australia", "Russia", "USA");
        countriesList = countriesList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("sorted countries list1:"+countriesList.toString());

        // Method 2 - using Java Collection
        Collections.sort(countriesList);
        System.out.println("sorted countries list2:"+countriesList);

        //Method3 - using comparator interface
       /* Collections.sort(countriesList, new Comparator<String>() {
            @Override
            public int compare(List<String> countriesList, String<String> countriesList) {
                return 0;
            }
        });*/
        System.out.println("sorted countries list2:"+countriesList);






        List<Integer> ls2 = Arrays.asList(11,16,87,87, 45,29,73);
        System.out.println("ls2"+ls2);
        ls2= ls2.stream().filter(i-> i>15).map(i-> i).sorted().distinct().collect(Collectors.toList());
        System.out.println("Sorted and distinct List ls2:"+ls2);
        System.out.println("=========================");

        // limit (returns first n numbers), skip (skips first n numbers and returns remaining) (Intermediate oprsn)
        List<Integer> lst3 = Arrays.asList(11,16,87,87, 45,29,73);
        System.out.println("lst3"+lst3);
        lst3= lst3.stream().filter(i-> i>15).map(i-> i).limit(5).collect(Collectors.toList());
        System.out.println("Limit List lst3:"+lst3);
        lst3= lst3.stream().filter(i-> i>15).map(i-> i).skip(2).collect(Collectors.toList());
        System.out.println("Skip List lst3:"+lst3);
        System.out.println("=========================");

        //Match (allMatch , anyMatch, noneMatch) [Terminal operations]
        List<Integer> ls3 = Arrays.asList(11,16,87,45,29,73);
        System.out.println("ls3"+ls3);
        Boolean b1 = ls3.stream().filter(i-> i>15).map(i-> i).sorted().allMatch(i -> i==16);
        System.out.println("All match - boolean b1:"+b1);
        Boolean b2 = ls3.stream().filter(i-> i>15).map(i-> i).sorted().anyMatch(i -> i==16);
        System.out.println("Any match - boolean b2:"+b2);
        Boolean b3 = ls3.stream().filter(i-> i>15).map(i-> i).sorted().noneMatch(i -> i==18);
        System.out.println("none match - boolean b3:"+b3);
        System.out.println("=========================");

        // Count, min, max, findFirst, findAny [Terminal operations]
        // for [min, max, findFirst, findAny: you can store to optional<T> or if you use 'orElse' next to these
        // functions then, you can store it to Integer/other type.
        List<Integer> ls4 = Arrays.asList(11,16,87,45,29,73);
        System.out.println("ls4"+ls4);
        long i = ls4.stream().count();
        System.out.println("Count of ls4- long:"+i);
        // min(Integer::compare) or Comparator.naturalOrder()
        Optional<Integer> j = ls4.stream().min(Integer::compare);
        Integer ll = ls4.stream().min(Integer::compare).orElse(1);
        //  Optional<Integer> l = ls4.stream().min(Comparator.naturalOrder());
        System.out.println("min of ls4- optional:"+j);
        Optional<Integer> k = ls4.stream().max(Integer::compare);
        //Optional<Integer> m = ls4.stream().min(Comparator.reverseOrder());
        System.out.println("max of ls4- optional:"+k);
        //Optional<Integer> l = ls4.stream().min(Integer::compareTo(ls3));
        ls4 = ls4.stream().filter(o-> o>10).parallel().map(p -> p*p).collect(Collectors.toList());
        System.out.println("Paralally multiplying of ls4- optional:"+ls4);
        Integer[] inAr = ls4.stream().filter(o-> o>10).map(p -> p).toArray(Integer[]::new);
        List<String> ls5 = Arrays.asList();
        //Integer firstVal = ls5.stream().filter(o-> o>10).findFirst().orElse(100);
        String firstVal12 = ls5.stream().findFirst().orElse("Stream is empty");
        System.out.println("firstVal:"+firstVal12);
        Optional<String> op = ls5.stream().findFirst();
        String val= op.isPresent() ? op.get() : "Stream is empty";
        System.out.println("first val:"+val); // returns first value from stream
        String anyVal = ls5.stream().findAny().orElse("NoVal");
        System.out.println("anyVal:"+anyVal); // returns any value from stream


        System.out.println("=========================");
        System.out.println("Stream to Integer Array -inAr:"+Arrays.toString(inAr));
        Stream st = Stream.of(1, 2, 3); // Stream<Integer> st1 = Stream.of(1, 2, 3);
        st.forEach(b-> System.out.print(" b:"+b)); // short hand lamda: st.forEach(System.out::print);
        //once the stream is used, next time when you try to access it'll give 'Illegal state exception'.
        //peek: If you use this, it'll load the stream to another stream, so that even if you print, still you can use main stream.
        //Create a stream: Stream.of(1, 2, 3); Stream.of("Ravi","Teja", "Kumar");
        //Stream to List: .Collect(Collectors.toList());
        //Stream to Set: .Collect(Collectors.toSet());
        //Stream to Array: .toArray(Integer[]::new);

///min , max for strings using
        System.out.println("=========================");
        System.out.println("Sum of Int steam with range 1 to 10: "+IntStream.range(1, 10).sum());
        Stream.of("Ravi","Teja","Kumar").sorted().forEach(System.out::println); //foreach
        Stream.of("Ravi","Teja","Kumar").sorted().findFirst().ifPresent(System.out::println); //findFirst
        String[] strAr = {"Bahu","Bali","Eeshwar"};
        Arrays.stream(strAr).filter(x -> x.startsWith("B")).findFirst().ifPresent(System.out::println); // startsWith
        Arrays.stream(new int[] {2, 4, 6, 8}).map(x -> x*x).average().ifPresent(System.out::println); // average
        Arrays.stream(new String[] {"Bahu","bali","Ballaldev"}).map(s -> s.toLowerCase()).filter(s-> s.startsWith("b")).forEach(System.out::println); //toLowercase, startsWith, foreach
        Stream<String> s = Files.lines(Paths.get("SampleFile.txt")); // FIle read lines to a Stream
        //s.forEach(System.out::println);
        s.filter(ii -> ii.length() > 10).map(jj -> jj).forEach(System.out::println); // length()

    }

    // After Intermediate operations to print, use .foreach(sout) function.
    // After terminal operations to print use .ifPresent(sout) function.

    // Memory Management:
    // stack memory stores its local primitive variables (with values. e.g: int i=10) and references to objects which are in heap in 'Last in First out' manner.
    // primitive local variables are stored in Stack memory.
    // once the method is executed, its stack memory will be cleared.
    // primitive global/class variables are stored in heap memory.
    // static variables will be stored in heap.
    // wrapper class variables will be stored in heap.
    // If stack full it gives StackOverFlowError. If Heap is full it gives OutOfMemoryError.
    // When ever a method is getting executed it creates a slot for it in stack memory and after method execution is done, it clears that data slot.





    public String handleNull(){

        return "No value";
    }
}