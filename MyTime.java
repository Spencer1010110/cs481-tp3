import java.util.*;
import java.text.*;

import java.util.Date;
/* Command:
           time
           Action:
           the current time is displayed.
  */

public class MyTime implements Runnable{
  public MyTime(){
    f();
  }

  private void f(){
	  
	  DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a z");
	  Date date = new Date();
	  System.out.println(dateFormat.format(date));
	  
  }

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}
