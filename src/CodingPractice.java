import java.util.ArrayList;
import java.util.List;

public class CodingPractice {
    public static void main(String[] args) {
        // Fibonacci:
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
        List<Integer> ls = new ArrayList<>();
        int initVal = 1;
     /*   int tillVal = 20;*/
        //while(initVal < tillVal){
        while(true){
            if(initVal == 1 || initVal ==2){
                ls.add(1);
            }
            else
                ls.add(ls.get(initVal-2)+ls.get(initVal-3));

            if(ls.get(initVal-1) > 54)
                break;

            initVal++;
        }
        System.out.println("list:"+ls);

    }
}
