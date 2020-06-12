public class MultiThread {

    public static void main(String[] args) throws InterruptedException {
        test1 obj1 = new test1();
        obj1.start();
        Thread.sleep(1000);
        test1 obj2 = new test1();
        Thread.sleep(1000);
        obj2.start();
        // In this case, A separate object is used by each thread. So needs more memory
        // job and runner are tightly coupled

        test2 obj = new test2();
        Thread th1 = new Thread(obj);
        Thread th2 = new Thread(obj);
        th1.start();
        Thread.sleep(1000);
        th2.start();
        // In this case, the object is shared by multiple threads. So needs less memory.
        // job and runner are loosly coupled.
    }

}

class test1 extends Thread{
    int counter = 10;
    @Override
    public void run() {
        counter++;
        System.out.println("Extend Thread counter:"+counter);
        super.run();
    }
}

class test2 implements Runnable{
    int counter = 10;
    @Override
    public void run() {
        counter++;
        System.out.println("Implements Runnable Counter:"+counter);
    }
}
