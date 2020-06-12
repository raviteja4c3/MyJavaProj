public class StringExplore {
    public static void main(String[] args) {
        String s1 = "ABC"; // stores to string pool.
        String s2 = "ABC"; // points to existing data slot in string pool
        String s3 = new String("ABC"); // creates obj in heap mem and points to it. And as the value already present in string pool, it ignores adding to pool.
        String s4 = new String("DEF"); // creates obj in heap mem and points to it, also creates in string pool.
        String s5 = new String("DEF"); // creates obj in heap mem and points to it, And as the value already present in string pool, it ignores adding to pool.

        System.out.println(s1==s2); // true
        System.out.println(s2==s3); //false
        System.out.println(s3==s4); //false
        System.out.println(s4==s5); //false

        System.out.println(s1.equals(s2)); //true
        System.out.println(s2.equals(s3)); //true
        System.out.println(s3.equals(s4)); //false
        System.out.println(s4.equals(s5)); //true

        s5 = "lmn";
        System.out.println("s5: "+s5); // lmn [object created earlier for s5 will be deleted by GC]

    }
}
