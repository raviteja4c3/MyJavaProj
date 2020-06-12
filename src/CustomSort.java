import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSort{

    public static void main(String[] args) {

        List<Student> ls1 = new ArrayList<>();
        ls1.add(new Student(10, "Ravi", 26));
        ls1.add(new Student(12, "Kuamr", 26));
        ls1.add(new Student(11, "Teja", 27));
        List<Student> ls2 = new ArrayList<>(ls1);

        // way1: Sorting using comparator with lamda feature of functional interface.
        System.out.println("Org List:"+ls1);
        Collections.sort(ls1, ((o1, o2)->o1.getEmpId() > o2.getEmpId()?1:-1));
        System.out.println("Comparator sort(lamda):"+ls1);

        //way2: Sorting using Comparator with Innerclass implementation of comparator.
        Comparator<Student> com2 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getEmpId() > o2.getEmpId() && o1.getAge() > o2.getAge())
                    return 1;
                return -1;
            }
        };
        System.out.println("Sort before comparator: list:"+ls2);
        Collections.sort(ls2, com2);
        System.out.println("After Sort on both Id: list:"+ls2);



        // Way3: Sorting using Comparable
        Comparable<Student> comp = new Comparable<Student>() {
            @Override
            public int compareTo(Student o) {
                if(o.getEmpId() > o.getEmpId() && o.getAge() > o.getAge())
                    return 1;
                return -1;
            }
        };
        System.out.println("sort before comparable:"+ls1);
        Collections.sort(ls1);
        System.out.println("comparable sort:"+ls1);


// End result would be same on both the cases.
// Even though you use Comparable, it won't stop you to use comparator.

        // Sorting using Lamda expression of Comparator functional interface.

     // Way1: Create a separate class which implements comparator and override the compare method in it.
     // Pass that class obj to Collections,sort(list, obj).
     // Way2: Write inner class implementation, instead creating a seperate class and

     //

    }
}
class test5 extends Thread{

}
