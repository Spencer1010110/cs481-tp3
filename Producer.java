import java.util.*;

public class Producer extends Thread {

  public Producer() {
    buffer = Consumer.buffer;
  }

  public static void main(String[] args){
    Thread t = new Producer();
    t.start();
  }


  public void run() {
    Date message;

    while (true) {
      BoundedBuffer.napping();

      // produce an item & enter it into the buffer
      message = new Date();
      System.out.println("Producer produced " + message);

      buffer.enter(message);
    }
  }

  private  BoundedBuffer buffer;
}
