import java.io.*;

public class Dir implements Runnable {
  /* Command::
       dir name           where name must be null or the name of a directory and its paths.
       Action:
       List the file and directory names in this directory.
       Note that if the user enters "dir" it is OK and it means the current
       directory. In this case as you know a period (e,g .) means the current
       directory
       Errors:
       The user enters:
       1. dir name             The directory name does not exist.
       2. dir name             But the name does is not a directory name.
       When there is an error println a message and return (not exit).
  */

	private String name;
  public Dir(String s_name){
    this.name = s_name;
  }

	  private void f(String name){
		  File dir;
		  File[] dirList;

		  if (name.equalsIgnoreCase("") || name.equalsIgnoreCase("."))
			  {
			  	dir = new File(".");
			  	String s_dir = dir.getAbsolutePath();
				dir = new File(s_dir);
			  }
		  else 
			  dir = new File(name);

		  if (!dir.exists())
			  System.out.println("Directory does not exist.");
		  else if (!dir.isDirectory() && dir.isFile())
			  System.out.println(name + " is a file, not a directory");
		  else{
	                  dirList = dir.listFiles(); // Doesn't actually list files? Does now :-)
	                  	for(File path : dirList){ //Fixed to list files
				System.out.println(path);
	           }
		  }
	 }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		f(name);
		
	}
}
