package mina.sock.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;


public class ClientHandler extends IoHandlerAdapter {  
//private final static Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);  
private final String values;  
public ClientHandler(String values) {  
this.values = values;  
}  
@Override  
public void sessionOpened(IoSession session) {  
session.write(values);  
}  

@Override 
public void sessionCreated(IoSession session)
{
	System.out.println("clent open ..");
}
@Override 
public void messageSent(IoSession session, Object message)
{
	session.write(message.toString());
}
@Override  
public void messageReceived(IoSession session, Object message)  
throws Exception {  
String str = message.toString();  
//log.info("The message received is [" + str + "]");  
System.out.println("str=" + str);
}  
}  

