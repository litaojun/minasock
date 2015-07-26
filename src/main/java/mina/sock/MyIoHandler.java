package mina.sock;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
//import org.codehaus.plexus.logging.Logger;


public class MyIoHandler extends IoHandlerAdapter {  
// 这里我们使用的SLF4J作为日志门面，至于为什么在后面说明。   
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

