package Thread;

public class Helloprint implements Runnable {
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("Hello, world!");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Thread interrupted");

            }
        }

    }

}
