package mina.sock.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MyClient {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 IoConnector connector=new NioSocketConnector();  
		 connector.setConnectTimeoutMillis(30);  
		 connector.getFilterChain().addLast("codec",  
		 new ProtocolCodecFilter(  
		 new TextLineCodecFactory(  
		 Charset.forName("UTF-8"),  
		 LineDelimiter.WINDOWS.getValue(),  
		 LineDelimiter.WINDOWS.getValue()  
		 )  
		 )  
		 );
		 connector.setHandler(new ClientHandler("你好！/r/n 大家好！"));  
		 connector.connect(new InetSocketAddress("localhost", 9123));   
		 //connector.
		
	}

}
