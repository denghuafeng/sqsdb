package com.sinovatech.sqsdb.socket;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;




public abstract class Server {
	
	static Logger logger = Logger.getLogger(Server.class.getName());
	private int port = 4091;
	private IoHandler ioHandler = null;
	private String ip = null;
	/**
	 * ������
	 */
	private IoAcceptor acceptor = null;
    private String charset="UTF-8";
//    private IoAcceptorConfig ioAcceptorConfig;
	
	/**
     * ���췽��
     */
    public Server(String ioHandlerName)
    {
        this.setParam(HandlerFactory.getIoHandler(ioHandlerName));
      
    }
    
    /**
     * ���췽��������port��ioHandler(io������)
     */
    public Server(IoHandler ioHandler) {
		this.setParam(ioHandler);
				
    }

	/**
	 * ������������
	 * @param ip
	 * @param port
	 * @param ioHandler io������
	 */
	public void setParam(IoHandler ioHandler) {
//        this.port = port;
        this.ioHandler = ioHandler;
//        ByteBuffer.setUseDirectBuffers(false);
//        ByteBuffer.setAllocator(new SimpleByteBufferAllocator());
	}

	public void start() throws IOException {
//		acceptor.setHandler(ioHandler);
		if(ip==null)
			acceptor.bind(new InetSocketAddress(port));
		else
			acceptor.bind(new InetSocketAddress(ip,port));
	}
	
	/**
	 * �رռ���
	 * @throws Exception
	 */	
	public void shutdown() {
//		if(ip==null)
//			acceptor.unbind(new InetSocketAddress(port));
//		else
//			acceptor.unbind(new InetSocketAddress(ip,port));
		acceptor.dispose();
	}	
	
	
	/**
	 * ��ȡ��ǰSocket��Textģʽ�µ��ַ���
	 * @return
	 */	
	public String getCharset() {
		return charset;
	}

	/**
	 * ���õ�ǰSocket��Textģʽ�µ��ַ���
	 * @return
	 */		
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * ����ioFilter����
	 * @return
	 */		
	public void addLast(String name, IoFilter ioFilter) {
		acceptor.getFilterChain().addLast( name, ioFilter );
	}
	/**
	 * ����ioFilter����
	 * @return
	 */		
	public void addFirst(String name, IoFilter ioFilter) {
		acceptor.getFilterChain().addFirst( name, ioFilter );
	}
	
	public void addLogLast(){
		this.addLast("logging", new LoggingFilter());
	}
	

	public IoAcceptor getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(IoAcceptor acceptor) {
		this.acceptor = acceptor;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public IoHandler getIoHandler() {
		return ioHandler;
	}

	public void setIoHandler(IoHandler ioHandler) {
		this.ioHandler = ioHandler;
		acceptor.setHandler(ioHandler);
	}

//	public IoAcceptorConfig getIoAcceptorConfig() {
//		return ioAcceptorConfig;
//	}
//
//	public void setIoAcceptorConfig(IoAcceptorConfig socketAcceptorConfig) {
//		this.ioAcceptorConfig = socketAcceptorConfig;
//	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
