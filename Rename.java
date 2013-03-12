import java.io.*;
import java.util.StringTokenizer;

public class Rename implements Runnable {
  /* Command:
             rename nameA nameB
             Action:
             Renames the file nameA to the file nameB.
             Use your classes Copy and Delete for this.
             Errors:
             The user enters:
             1. rename              The names nameA and nameB are missing.
             When there is an error println a message and return (not exit).
    */


	private String name;
  public Rename(String s_name) {
    this.name = s_name;
  }

  private void f(String name) {
	 
	  new Copy(name);
	  

	  StringTokenizer tok = new StringTokenizer(name);
	  String src = "";
	  src = tok.nextElement().toString();
	  new Delete(src);
	  
	  
  }

@Override
public void run() {
	// TODO Auto-generated method stub
	f(name);
}
}
