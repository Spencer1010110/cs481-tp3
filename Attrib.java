import java.io.*;
import java.io.File;

public class Attrib {
  /* Command::
     attrib name       where name must be the name of a file and its path.
     Action:
     Makes the file read only.
     Errors:
     The user enters:
     1. attrib             Does not type the file name.
     2. attrib name        but the file does not exist.
     3. attrib name        but the file is a directory.
     When there is an error println a message and return (not exit).

  */
  public Attrib(String name){
    f(name);
  }

  private void f(String name){
	  
	  if (name.equalsIgnoreCase(""))
		  System.out.println("File name not specified");
	  else
	  {
		  File file = new File(name);
		  if(!file.exists())
			  System.out.println("File does not exist.");
		  else if (file.isDirectory())
			  System.out.println("File specified is a directory.");
		  else
			  file.setReadOnly();
	  }
  }
}
