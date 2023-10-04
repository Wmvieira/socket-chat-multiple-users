import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    Socket s;
    Thread t;
    PrintWriter out;
    BufferedReader in;

    public ClientThread(Socket s){
        this.s = s;
    }

    public void setup(){
        try{
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        t = new Thread(this);
        t.start();
    }

    public void sendMsgs(){
        String msg;
        try{
            while((msg = in.readLine()) != null){
                out.println(msg);
                out.flush();    
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        String msg;
        try{
            while((msg = in.readLine()) != null){
                System.out.println(msg);
            }
            System.exit(0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
