package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		
		int severPort=8765;
		String clientMsg = "";
		int length=0;
		int v=0,c=0,cs=0;
		
		try {			 
			// Creazione del socket sul server e ascolto sulla porta
			ServerSocket serverSocket = new ServerSocket(severPort);
			System.out.println("Server: in ascolto sulla porta " + severPort);

			// Attesa della connessione con il client
			Socket clientSocket = serverSocket.accept();
			
			// Create input and output streams to read/write data
			DataInputStream inStream = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(clientSocket.getOutputStream());	

			// Scambio di dati tra client e server
			while(!clientMsg.equals("quit")) {
				//riporto a 0 vocali,consonanti e caratteri speciali
				v=0;c=0;cs=0;
				
				//Lettura dato da stream di rete
				clientMsg = inStream.readUTF();
				System.out.println("Server: ricevuto messaggio " + clientMsg );
				
				//controllo lungheza e numero voali
				length=clientMsg.length();
				clientMsg.toLowerCase();
				
				for(int i=0;i<length;i++) {
					if(clientMsg.charAt(i)=='a' || clientMsg.charAt(i)=='e' || clientMsg.charAt(i)=='i' || clientMsg.charAt(i)=='o' || clientMsg.charAt(i)=='u')
						v++;
					else if(clientMsg.charAt(i)>'a' && clientMsg.charAt(i)<='z')
						c++;
					else
						cs++;
				}
				
				/*
				//Invio dati su stream di rete
				outStream.writeUTF("Echo from server : "         + clientMsg + " Lunghezza: " + length + " Vocali: " + v + " Consonanti: " + c + " Caratteri speciali: " + cs);
				outStream.flush();
				System.out.println("Server: invio messaggio "    + clientMsg );
				System.out.println("Echo from server : Lunghezza: " + length + " Vocali: " + v + " Consonanti: " + c + " Caratteri speciali: " + cs);
				*/
				
				//quando vcoali sono metà delle consanti allora esci
				if(v==(c/2)) {
					outStream.writeUTF("Echo from server : " + clientMsg + "\nConnessione interrotta." + " Lunghezza: " + length + " Vocali: " + v + " Consonanti: " + c + " Caratteri speciali: " + cs);
					outStream.flush();
					System.out.println("Echo from server : " + clientMsg + "\nConnessione interrotta." + " Lunghezza: " + length + " Vocali: " + v + " Consonanti: " + c + " Caratteri speciali: " + cs);
					clientMsg="quit";
				}
				else {
					outStream.writeUTF("Echo from server : " + clientMsg + " Lunghezza: " + length + " Vocali: " + v + " Consonanti: " + c + " Caratteri speciali: " + cs);
					outStream.flush();
					System.out.println("Echo from server : " + clientMsg + " Lunghezza: " + length + " Vocali: " + v + " Consonanti: " + c + " Caratteri speciali: " + cs);
				}
			}


			// Close resources
			serverSocket.close();
			clientSocket.close();
			inStream.close();
			outStream.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
