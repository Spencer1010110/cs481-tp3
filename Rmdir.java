import java.io.*;

public class Rmdir {
  /* Command:
               rmdir name
               Action:
               Removes the directory name.
               Errors:
               The user enters:
               1. rmdir              The name is missing.
               2. rmdir name         But the name does not exist.
               3. rmdir name         But name is not a directory.
               4. rmdir name         But the directory name is not empty.
               When there is an error println a message and return (not exit).
  */


  public Rmdir(String name){
    f(name);
  }

  private void f(String name){
	  
	  if (name.equalsIgnoreCase(""))
		  System.out.println("Directory name not specified");
	  else
	  {
		  File dir = new File(name);
		  if(!dir.exists())
			  System.out.println("Directory does not exist.");
		  else if(dir.isFile())
			  System.out.println(name + " is a file, not a directory.");
		  //else if dir isn't empty...
		  else
			  dir.delete();
	  }
	  
  }
}
