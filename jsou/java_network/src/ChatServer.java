import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer implements Runnable {
	
	ServerSocket ss;
	Service service;
	ArrayList<Service> list = new ArrayList<>(); // 서비스는 쓰레드를 상속 받고 있음.
	
	public ChatServer() {
		try {
			ss = new ServerSocket(7778); // 클라이언트와 대응하기 위한 소켓을 만드는 것!! 
			System.out.println("채팅 서버 서비스 중.....시작.....!!!!!!");
			
			new Thread(this).start(); // 현재 클래스가 runnable을 가지고 있으므로 행동자를 this하고 시작해줌.
		} catch (Exception e) {
			System.out.println("ChatServer err : " + e);
		}
	}
	
	// Client별 처리용 내부 클래스 ---------------------------
	class Service extends Thread {
		String chat_name;
		BufferedReader in;
		OutputStream out;
		Socket socket;
		
		public Service(Socket socket) { // 들어올 때 마다 서비스 객체를 계속 만들어 주는 것.
			try {
				this.socket = socket;
				in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
				
				out = socket.getOutputStream();
			} catch (Exception e) {
				System.out.println("Service err : " + e);
			}
		}
		
		public void messageAll(String msg) {
			try {
				for (int i = 0; i < list.size() ; i++) {
					Service ser = list.get(i); // ArrayList 컬렉션에 들어가있는 모든 클라이언트에게
					ser.messageSend(msg); // 메세지를 보냄.
				}
			} catch (Exception e) {
				System.out.println("messageAll err : " + e);
			}
		}
		
		public void messageSend(String msg) {
			try {
				out.write((msg + "\n").getBytes("euc-kr")); // 여기서 인코딩하고 메세지를 클라이언트에게 전달
			} catch (Exception e) {
				System.out.println("messageSend err : " + e);
			}
		}
		
		@Override
		public void run() { // 무한루프
			while(true) {
				try {
					String msg = in.readLine();
					if(msg == null || msg.equals("")) continue; // 메세지 값이 없으면 아무 작업을 하지 않음.
					
					// 메세지가 있는 경우 처리
					if(msg.charAt(0) == '/') { // 약속이 있는 메세지 ('/').  
						if(msg.charAt(1) == 'r') { // 대화명 변경
							messageAll("/r" + chat_name + "-" + msg.substring(2)); // 옛이름 - New 이름.
							chat_name = msg.substring(2);
						} else if(msg.charAt(1) == 'q') { // 퇴장
							try {
								messageAll("/q" + chat_name);
								list.remove(this); // 현재 객체 삭제
								in.close();
								out.close();
								socket.close();
							} catch (Exception e) {
								// TODO: handle exception
							} 
							break;
						} else if(msg.charAt(1) == 's') { // 귓속말
							// /s 접속자명 - 메세지
							String name = msg.substring(2, msg.indexOf('-')).trim(); // 하이폰 전까지를 name으로 잡음.
							for(Service ser : list) {
								if(name.equals(ser.chat_name)) { // list 배열에 있는 접속자를 찾아서 귓속말로 보내줌.
									ser.messageSend(chat_name + ">(Secret)" + msg.indexOf
											('-') + 1 ); // 하이폰 이후에 있는 메세지를 출력해줌.
								}
							}
						}
					} else { // 일반 메세지
						messageAll(chat_name + ">" + msg);
					}
				} catch (Exception e) {
					System.out.println("ChatServer run err : " + e);
					break;
				}
			}
		}
	}
		
	@Override
	public void run() { // 무한루프
		while (true) {
			try {
				Socket socket = ss.accept(); // Client connect Wait. 클라이언트가 들어올 때까지 대기.
				service = new Service(socket); // 클라이언트가 들어오면 서비스 객체를 계속 만들어줌. Service 클래스를 계속 실행시켜주는 것.
				service.start();
				service.chat_name = service.in.readLine(); // 클라이언트 이름을 만들어줌.

				service.messageSend("/c" + service.chat_name); // '/c'는 최초접속 : connect
				for (Service ser : list) {
					ser.messageSend("/c" + service.chat_name);
					service.messageSend("/c" + service.chat_name); 
				}
				list.add(service);
			} catch (Exception e) {
				System.out.println("ChatServer run err : " + e);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	
	}

}
