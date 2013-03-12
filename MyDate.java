import java.util.*;
import java.text.*;

import java.util.Date;

public class MyDate implements Runnable{
  /* Command:
           date
           Action:
           the current date is displayed.
  */

  public MyDate(){
    //empty
  }

  private void f(){
	  
	  DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy");
	  Date date = new Date();
	  System.out.println(dateFormat.format(date));
  }

@Override
public void run() {
	// TODO Auto-generated method stub
	f();
}
}
