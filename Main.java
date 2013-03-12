import java.io.*;
import java.util.StringTokenizer;
/*
  As we are going through the semester I will add more names to Token.java.
  The errors that I mentioned in any class are the ones that I could think of
  while I was writing the class. There may be more erros that I could not think
  of. Please inform me if there are more errors so that I inform other students.
*/
class Main {
    public static void main(String[] args) {
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
              new Thread(new Attrib(s)).start();
              break;
            case Token.COPY:
            	 new Thread(new Copy(s)).start();
              break;
            case Token.DATE:
            	 new Thread(new MyDate()).start();
              break;
            case Token.DELETE:
            	 new Thread(new Delete(s)).start();
              break;
            case Token.DIR:
            	 new Thread(new Dir(s)).start();
              break;
            case Token.EDIT:
            	 new Thread(new Notepad()).start();
              break;
            case Token.EXEC:
            	 new Thread(new Execute(s)).start();
              break;
            case Token.EXIT:
              System.exit(1);
            case Token.MKDIR:
            	 new Thread(new Mkdir(s)).start();
              break;
            case Token.RENAME:
            	 new Thread(new Rename(s)).start();
              break;
            case Token.RMDIR:
            	 new Thread(new Rmdir(s)).start();
              break;
            case Token.TIME:
            	 new Thread(new MyTime()).start();
              break;
            default:
              System.out.println("Wrong command.");
          }
        }
      }
    }
}

