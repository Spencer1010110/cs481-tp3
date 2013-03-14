import java.io.*;
import java.util.StringTokenizer;
/*
  As we are going through the semester I will add more names to Token.java.
  The errors that I mentioned in any class are the ones that I could think of
  while I was writing the class. There may be more erros that I could not think
  of. Please inform me if there are more errors so that I inform other students.
*/
class Main {
	
	static Thread t_thread;
	
    public static void main(String[] args) throws InterruptedException {
      while(true){
        System.out.print("PROMPT\\>");
        String command = "";
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
          command = stdin.readLine();
        }
        catch (Exception e) {
          System.out.println(e);
          return;
        }
        StringTokenizer tok = new StringTokenizer(command);
        if (tok.hasMoreTokens()) {
          Token token = new Token(tok.nextToken());
          String s = "";
          while (tok.hasMoreTokens())
            s = s + " " + tok.nextToken();
          if (!s.equals(""))
            s = s.substring(1);
          switch (token.kind) {
            case Token.ATTRIB:
            	t_thread = new Thread(new Attrib(s));
              break;
            case Token.COPY:
            	t_thread = new Thread(new Copy(s));
              break;
            case Token.DATE:
            	t_thread = new Thread(new MyDate());
              break;
            case Token.DELETE:
            	t_thread = new Thread(new Delete(s));
              break;
            case Token.DIR:
            	t_thread = new Thread(new Dir(s));
              break;
            case Token.EDIT:
            	t_thread = new Thread(new Notepad());
              break;
            case Token.EXEC:
            	t_thread = new Thread(new Execute(s));
              break;
            case Token.EXIT:
              System.exit(1);
            case Token.MKDIR:
            	t_thread = new Thread(new Mkdir(s));
              break;
            case Token.RENAME:
            	t_thread = new Thread(new Rename(s));
              break;
            case Token.RMDIR:
            	t_thread = new Thread(new Rmdir(s));
              break;
            case Token.TIME:
            	t_thread = new Thread(new MyTime());
              break;
            default:
              System.out.println("Wrong command.");
          }
        }
        
    	t_thread.start();
    	t_thread.join();
    	
    	
    	t_thread = new Thread(new Execute("Producer.class"));
    	t_thread.start();
    	t_thread.run();
    	
    	t_thread = new Thread(new Execute("Consumer.class"));
    	t_thread.start();
    	t_thread.run();
      }
    }
}

