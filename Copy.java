import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

public class Copy implements Runnable {
  /* Command::
   copy nameA nameB      where nameA and nameB must be the name of a files and their paths.
   Action:
   Copies file nameA to file nameB.
   Errors:
   The user enters:
   1. copy               Does not type the file names.
   2. copy name          Did not type a second file name.
   3. copy nameA nameB   but the file nameA does not exist.
   4. copy nameA nameB   but the file nameB alreadyexist.
   5. copy nameA nameB   but nameA is a directory.
   6. copy nameA nameB   but the file is a directory.
   When there is an error println a message and return (not exit).
*/

	private String name;
  public Copy(String s_name) {
    this.name = s_name;
  }

  private void f(String name) {
	  
	  String src = "";
	  String dst = "";
	  
	  StringTokenizer tok = new StringTokenizer(name);
	  src = tok.nextElement().toString();
	  
	  if (tok.hasMoreElements())
		  dst = tok.nextElement().toString();
			  
	  if (src.isEmpty() && dst.isEmpty())
		  System.out.println("No file names entered.");
	  else if (src.isEmpty())
		  System.out.println("No second file name entered.");
	  else
	  {
	  
	  File srcFile = new File(src);
	  File dstFile = new File(dst);
	  
	  if (!srcFile.exists())
		  System.out.println("File " + src + " does not exist.");
	  else if (dstFile.exists())
		  System.out.println("File " + dst + " already exists.");
	  else if (srcFile.isDirectory())
		  System.out.println(name + " is a directory, not a file.");
	  
	  else
	  {  
		  InputStream inStream;
		  OutputStream outStream;
		  
		  try 
		  {
			  inStream = new FileInputStream(srcFile);
			  outStream = new FileOutputStream(dstFile);
			
			  byte[] buffer = new byte[1024];
		  
			  int length;
			  while((length = inStream.read(buffer)) > 0)
			  {
				  outStream.write(buffer, 0, length);
			  }
			
			  inStream.close();
			  outStream.close();
		  
		  } catch (IOException e) {
		}
	  }
	}
  }

@Override
public void run() {
	// TODO Auto-generated method stub
	f(name);
	
}
}


