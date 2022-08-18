package prac02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {

		Socket socket = null;
		Scanner sc = null;
		BufferedWriter out = null;
		
		try {
			
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9090));
			
			Client client = new Client(socket);
			client.start();
			
			sc = new Scanner(System.in);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
			while (true) {
				
				String message = sc.nextLine();
				out.write(message + "\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if( out != null) {
					out.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
