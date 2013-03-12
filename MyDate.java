import java.util.*;
import java.text.*;

import java.util.Date;

public class MyDate{
  /* Command:
           date
           Action:
           the current date is displayed.
  */

  public MyDate(){
    f();
  }

  private void f(){
	  
	  DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy");
	  Date date = new Date();
	  System.out.println(dateFormat.format(date));
  }
}
