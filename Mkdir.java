import java.io.*;

public class Mkdir implements Runnable {
  /* Command:
           mkdir name
           Action:
           make a directory in the path of the name.
           Errors:
           The user enters:
           1. dir                 The name is missing.
           2. dir name            But name is already exist.

           When there is an error println a message and return (not exit).
  */

	private String name;
  public Mkdir(String s_name){
    this.name = s_name;
  }

  private void f(String name){
	  
	  if (name.equalsIgnoreCase(""))
		  System.out.println("Directory name not specified");
	  else
	  {
		  File file = new File(name);
		  if(file.exists())
			  System.out.println("Directory already exists.");
		  else
			  file.mkdir();
	  }
  }

@Override
public void run() {
	// TODO Auto-generated method stub
	f(name);
	
}
}