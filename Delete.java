import java.io.*;

public class Delete implements Runnable {
  /* Command::
     delete name           where name must be the name of a file and its paths.
     Action:
     deletes name
     Errors:
     The user enters:
     1. delete                The user did not type the file name.
     2. delete name           The file name does not exist in the path.
     3. delete name          But the file name does is a directory.
     When there is an error println a message and return (not exit).
*/
	private String name;
  public Delete(String s_name){
    this.name = s_name;
  }

  private void f(String name){
	  
	  if (name.equalsIgnoreCase(""))
		  System.out.println("File Name not Specified");
	  else
	  {
		  File file = new File(name);
		  if(!file.exists())
			  System.out.println("File does not exist.");
		  	else if (file.isDirectory())
			  System.out.println("File specified is a directory.");
			else
				file.delete();
	  }
	  
  }

@Override
public void run() {
	// TODO Auto-generated method stub
	f(name);
}
}
