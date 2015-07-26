package mina.sock;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
//import org.codehaus.plexus.logging.Logger;


public class MyIoHandler extends IoHandlerAdapter {  
// ��������ʹ�õ�SLF4J��Ϊ��־���棬����Ϊʲô�ں���˵����   
//private final static Logger log = LoggerFactory.getLogger(MyIoHandler.class);  
@Override  
public void messageReceived(IoSession session, Object message)  
throws Exception {  
String str = message.toString();  
//log.info("The message received is [" + str + "]");  
System.out.println("str=" + str);
if (str.endsWith("quit")) {  
session.close(true);  
return;  
}  
}  
@Override 
public void sessionCreated(IoSession session)
{
	System.out.println("server open ..");
}

@Override 
public void messageSent(IoSession session, Object message)
{
	session.write(message.toString());
}
}  

