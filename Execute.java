import java.io.*;
import java.util.StringTokenizer;
import java.lang.reflect.*;

public class Execute implements Runnable {
  /* Command::
         exec name word1 word2, ....   where name must the name of a java class and its paths
                                       and wordis are the arguments.
         Action:
         Executes the "main" of the name.class. Therefore this file must be the main file.
         Errors:
         The user enters:
         1. exec                 The class name is missing.
         2. exec name            But name.class does not exist.
         3. There are exceptions that you need to find them.
         When there is an error println a message and return (not exit).
    */

	private String name;
  public Execute(String s_name){
    this.name = s_name;
  }

  private void f(String name) throws InstantiationException, IllegalAccessException{
	 
	  if (name.equalsIgnoreCase(""))
		  System.out.println("Class name not specified");
	  else
	  {
		  File file = new File(name);
		  if(!file.exists())
			  System.out.println("Class does not exist.");

			else
			{
			Class execClass = name.getClass();
			execClass.newInstance();
			execClass.main();
				
			}
		  
	  }
   }

@Override
public void run() {
	// TODO Auto-generated method stub
	try {
		f(name);
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
}
