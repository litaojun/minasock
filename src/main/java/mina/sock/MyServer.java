package mina.sock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Map.Entry;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MyServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 IoAcceptor acceptor=new NioSocketAcceptor();  
		 acceptor.getSessionConfig().setReadBufferSize(2048);  
		 acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);  
		 acceptor.setHandler(new MyIoHandler());  
		 acceptor.getFilterChain().addLast("codec",  
		    new ProtocolCodecFilter(  
		    new TextLineCodecFactory(  
		    Charset.forName("UTF-8"),  
		    LineDelimiter.WINDOWS.getValue(),  
		    LineDelimiter.WINDOWS.getValue()  
		    )  
		    )  
		    );  
		 acceptor.bind(new InetSocketAddress(9123));   
		 for(Entry<Long, IoSession> x : acceptor.getManagedSessions().entrySet())
		 {
			//((MyIoHandler)x.getValue().getService()).
			x.getValue().write("xxxxxxxxx");
		 }
		 
		
		 }

}
