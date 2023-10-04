import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {
    Socket s;
    Thread t;
    PrintWriter out;
    BufferedReader in;

    public ServerThread(Socket s){
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

    public void sendMsg(String msg){
        out.println(msg);
        out.flush();
    }

    @Override
    public void run() {
        try{
            String msg = in.readLine();
            String msgPartes[] = msg.split(" ");
            int nEchos = Integer.parseInt(msgPartes[msgPartes.length - 1]);
            for (int i = 0; i < nEchos; i++) {
                sendMsg(msg);
            }
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }   
    }
}
