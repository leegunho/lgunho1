public class ThreaInterrupt implements Runnable{
    static private StringBuffer buf = new StringBuffer();
    static long start  = System.currentTimeMillis();
    static String lastMassage = "";
    
    public void run(){
        long end = System.currentTimeMillis();
        String message = "";
        while ( true ) {
            Thread.yield();
            
            if ( Thread.currentThread().isInterrupted())
                message = "Yielder : interrupted. ";
            
            if ( end - start > 1500){
                message += "Yielder : time over ";
                break;
            }
            else message += "Yielder : keep going!!! ";
            end = System.currentTimeMillis();
            print(message);
            message = "";
        }
        print(" : Yielder ends");
    }
    
    static void print(String msg){
        synchronized (buf) {
            if ( lastMassage.equals(msg)) return;        
            buf.append((System.currentTimeMillis() - start ) + " " + msg + "\n");
            lastMassage = msg;
        }
    }
    public static void main(String[] args) {
        // on the main thread stack
        
        Thread yielder = new Thread(new ThreaInterrupt());
        yielder.start(); // main thread makes yielder thread begin
        try {
            Thread.sleep(500);
            yielder.interrupt();
            print(">>>>>>>>>>>> first interrupt! ");
        } catch (InterruptedException e) {}
        
        try {
            Thread.sleep(1000);
            yielder.interrupt();
            print(">>>>>>>>>>>> second interrupt! ");
        } catch (InterruptedException e) {}
        print("Main Thread ends");
        
        try {    yielder.join(); } catch (InterruptedException e) {}
        
        System.out.println(buf.toString());
    }
}