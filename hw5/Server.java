import java.net.ServerSocket;
import java.net.Socket;
 
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
 
import java.io.*;
 
public class Server {
 
    public static void main(String... args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
 
        while(true) {
            Socket socket = ss.accept();
            new Thread(new ClientProcessor(socket)).start();
        }
    }
 
}
 
class ClientRegistry {
    public static Map<String,PrintWriter> clients = new HashMap<>();
}
 
class ClientProcessor implements Runnable {
 
    private final Socket socket;
 
    public ClientProcessor(Socket socket) {
        this.socket = socket;
    }
 
    @Override
    public void run() {
        PrintWriter writer = null;
 
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
 
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(is)
            );
 
            writer = new PrintWriter(os, true);
			
			String name = reader.readLine();
 
            ClientRegistry.clients.put(name, writer);
 
            System.out.println(name + " connected");
 
            while(true) {
				String message;
				String to = null;
				String line = reader.readLine();
				if(line.contains(":")){
					String [] arr = line.split(":");
					to = arr[0];
					message = arr[1];
				}else{
					message = line;
				}
                String output = name + ": " + message;
								
				if( to != null && !to.isEmpty() && ClientRegistry.clients.get(to) != writer ){
					ClientRegistry.clients.get(to).println(output);
				}else{
					for(PrintWriter cw : ClientRegistry.clients.values()) {
						if(cw == writer) continue;
						cw.println(output);
					}
				}
            }
        } catch(IOException e) {
            ClientRegistry.clients.remove(writer);
        }
    }
 
}