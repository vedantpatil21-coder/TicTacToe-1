package Thread;

public class Main {
    public static void main(String[] args){
        Helloprint helloprint = new Helloprint();
        Thread thread1 = new Thread(helloprint);
        thread1.start();
        Thread thread2 = new Thread();
        thread2.start();

    }
}
