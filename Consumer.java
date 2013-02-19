import java.util.*;

public class Consumer extends Thread {
  public static BoundedBuffer buffer = new BoundedBuffer();

  public static void main(String[] args){
    Thread t = new Consumer();
    t.start();
  }

  public void run() {
    Date message;

    while (true) {
      BoundedBuffer.napping();

      // consume an item from the buffer
      System.out.println("Consumer wants to consume.");

      message = (Date)buffer.remove();
    }
  }
  //private  BoundedBuffer buffer;
}
