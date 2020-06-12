import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Hello {
    public static void main(String[] args) throws IOException, SQLException, FileNotFoundException {
        System.out.println("Hello World!!");

        int  i1 = 123;
        double d1  =123.999;
        float f1 = 123.01f;
        long l1 = 123;

        Integer I11 = Integer.valueOf(i1);
        System.out.println("I11:"+I11);
        Double D11 = Double.valueOf(f1);
        System.out.println("D11:"+D11);
        int i4 = D11.intValue();
        System.out.println("i4:"+i4);

        // Any premetive data type to wrapper data type using    [WrapperType= WrapperType.valueOf(premVal)]
        // Any wrapper data type to premitive using [PremType = WrapperVal.premValue()]

        // When data types are same, then you can directly use AutoBoxing and Unboxing features of Java. No need to do typecasting.
        i4 = I11; //Here Wrapper to premitive [Unboxing] java takes cares of writing like wrapperVal.premValue()
        System.out.println("Unboxing:"+i4);

        D11 = d1; //premitive to wrapper [Autoboxing] java takes cares of writing like WrapperType.valueOf(premVal)
        System.out.println("Autoboxing:"+D11);


        ArrayList al = new ArrayList();
        al.add("Ravi");al.add(123);al.add("Teja");
        System.out.println("al:"+al); // List is allowing to add any data type val, as we didn't used diamond opr.


        HashSet<String>  hs = new HashSet<>();
        LinkedHashSet<String>  lhs = new LinkedHashSet<>();
        TreeSet<String> ts = new TreeSet<>();
        NavigableSet<String> ns = new TreeSet<>();
        hs.add("a"); hs.add("b"); hs.add("d"); hs.add("c");
        lhs.add("a"); lhs.add("b"); lhs.add("d"); lhs.add("c");
        ts.add("a"); ts.add("b"); ts.add("d"); ts.add("c");
        ns.add("a"); ns.add("b"); ns.add("d"); ns.add("c");
        //hs.add("Apple"); hs.add("Banana"); hs.add("Alda"); hs.add("Bolero");
        List<String> lsss = new ArrayList<>(lhs);
        Collections.sort(lsss); //sorting a LinkedHashSet using Collections.sort by converting into list.
        System.out.println("lsss:"+lsss);

        TreeSet<String> ts2 = new TreeSet<>(lhs); // Sorting a LinkedHashSet by using TreeSet.
        System.out.println("ts2:"+ts2);

        System.out.println("hs:"+hs);
        System.out.println("lhs:"+lhs);
        System.out.println("ts:"+ts);
        System.out.println("ns:"+ns);
        ns= ts.descendingSet();

        System.out.println("ns:"+ns);

        HashMap<Integer, String> hm  = new HashMap<>();
        LinkedHashMap<Integer, String> lhm  = new LinkedHashMap<>();
        ConcurrentMap<Integer, String> chm = new ConcurrentHashMap<>();
        /* When you need concurrency (multiple threads try to access same obj at a time) and without the cost
        of synchronization (lock on whole object) then you should use ConcurrentMap. Here read opr is allowed
        with out lock and write/edit operations are allowed with a lock.
         */
        /* When you want to keep lock on whole map/set/list object then use Collections.synchronized */
        Map<Integer, String> shm = Collections.synchronizedMap(new HashMap<>());
        Map<Integer, String> slhm = Collections.synchronizedMap(new LinkedHashMap<>());
        Set<String> shs = Collections.synchronizedSet(new HashSet<>());
        Set<String> slhs = Collections.synchronizedSet(new LinkedHashSet<>());
        List<String> sal = Collections.synchronizedList(new ArrayList<>());
        List<String> sll = Collections.synchronizedList(new LinkedList<>());

        Map<Integer, String> shm2 = Collections.synchronizedMap(hm);


        hm.put(1, "Ravi"); hm.put(4, "Teja"); hm.put(2, "Sandeep"); hm.put(3, "Kumar");
        lhm.put(1, "Ravi"); lhm.put(4, "Teja"); lhm.put(2, "Sandeep"); lhm.put(3, "Kumar");
        chm.put(1, "Ravi"); chm.put(4, "Teja"); chm.put(2, "Sandeep"); chm.put(3, "Kumar");
        shm.put(1, "Ravi"); shm.put(4, "Teja"); shm.put(2, "Sandeep"); shm.put(3, "Kumar");



        /*for(int i=0; i<hm.size();i++){
            if(hm.get(i).equals("Teja")){
                hm.put(i, "Teja2");
            }
        }*/
       /* for(int i=0; i<shm2.size();i++){
            if(shm2.get(i).equals("Teja")){
                shm2.put(i, "Teja2");
            }
        }*/

       /* for (Map.Entry<Integer, String> em : hm.entrySet()){
                em.getKey(); em.getValue();
                if(em.getValue().equals("Teja")){
                    em.setValue("Teja2");
                }
        }

        for (Map.Entry<Integer, String> em : shm.entrySet()){
            em.getKey(); em.getValue();
            if(em.getValue().equals("Teja")){
                em.setValue("Teja2");
            }
        }*/

        System.out.println("hm:"+hm);
        System.out.println("lhm:"+lhm);
        System.out.println("chm:"+chm);
        System.out.println("shm:"+shm);

        String a ="apple";
        String b = new String("abc");
        b = "def";
        System.out.println("b:"+b);

        /* // The below gives null pointer exception
        String s = new String((String) null);
        System.out.println("s:"+s);
*/



        FileInputStream fis = null;
        fis = new FileInputStream("B:/myfile.txt");
        int k;
        while(( k = fis.read() ) != -1)
        {
            System.out.print((char)k);
        }
        fis.close();
    }
}
