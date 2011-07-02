package com.sinovatech.sqsdb.socket;

import java.io.Serializable;
import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.LoggingFilter;


public abstract class Client {

	static Logger logger = Logger.getLogger(Client.class.getName());

	private String ip = "127.0.0.1";
	private int port = 80;
    private IoHandler ioHandler = null;
    private ConnectFuture connectFuture;
    private String charset="UTF-8";
    private IoConnector connector;
//    private IoServiceConfig ioServiceConfig;

	/**
     * ���췽��
     */
    public Client(String ip, int port,String ioHandlerName)
    {
        this.setParam(ip, port, HandlerFactory.getIoHandler(ioHandlerName));
    }
    /**
     * �޲ι��췽��.
     * <p>
     * ����:
     *
     */
    public Client(){
    	
    }
    
    /**
     * ���췽��������ip, port��ioHandler(io������)
     */
    public Client(String ip, int port,IoHandler ioHandler) {
		this.setParam(ip, port, ioHandler);
    }

	/**
	 * ������������
	 * @param ip
	 * @param port
	 * @param ioHandler io������
	 */
	public void setParam(String ip, int port,IoHandler ioHandler) {
        this.ip = ip;
        this.port = port;
        this.ioHandler = ioHandler;
//        ByteBuffer.setUseDirectBuffers(false);
//        ByteBuffer.setAllocator(new SimpleByteBufferAllocator());
	}
	
	/**
	 * ����ָ����ip��port, ��ָ��IO������
	 * @param ip
	 * @param port
	 * @param ioHandler
	 */	
	public IoSession connect(){
		connectFuture = connector.connect(new InetSocketAddress(ip,port));
		connectFuture.awaitUninterruptibly();
		return connectFuture.getSession();
	}
	

	
	/**
	 * д����
	 * @param data
	 * @throws Exception
	 */
	public void write(Object data) throws Exception{
		WriteFuture future = connectFuture.getSession().write(data);
//		future.awaitUninterruptibly();
	}
	
	/**
	 * д����
	 * @param data
	 * @throws Exception
	 */
	public void write(byte[] data) throws Exception{
		WriteFuture future = connectFuture.getSession().write(data);
//		future.awaitUninterruptibly();
	}
	
	/**
	 * д����
	 * @param data
	 * @throws Exception
	 */
	public void write(String data) throws Exception{
		WriteFuture future = connectFuture.getSession().write(data);
//		future.awaitUninterruptibly();
	}
	
	/**
	 * д����
	 * @param data
	 * @throws Exception
	 */
//	public void write(Serializable data) throws Exception{
//		WriteFuture future = connectFuture.getSession().write(data);
//		future.join();
//		future.addListener(IoFutureListener.CLOSE);//����������Ƿ�����Ϻ�ر����ӣ����˾��Ƕ����ӣ���Ȼ�ǳ�����
//	}
	
	/** 
	 * �ر�session
	 */
	public void close() throws Exception{
		if ( connectFuture.isConnected() ) {
			connectFuture.getSession().close(true);
		}				
	}
	
	
	/**
	 * ����ioFilter����
	 * @return
	 */		
	public void addLast(String name, IoFilter ioFilter) {
		connector.getFilterChain().addLast( name, ioFilter );
	}
	/**
	 * ����ioFilter����
	 * @return
	 */		
	public void addFirst(String name, IoFilter ioFilter) {
		connector.getFilterChain().addFirst( name, ioFilter );
	}
	
	public void addLogLast(){
		this.addLast("logging", new LoggingFilter());
	}

	/**
	 * ��ȡ�˿�ֵ
	 * @return
	 */
	public int getPort() {
		return port;
	}

	/**
	 * ���ö˿�
	 * @param port
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * ��ȡIP��ַ
	 * @return
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ����IP��ַ
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * ��ȡ��ǰSocket��IOHandler
	 * @return
	 */
	public IoHandler getIoHandler() {
		return ioHandler;
	}

	/**
	 * ���õ�ǰSocket��IOHandler
	 * @return
	 */
	public void setIoHandler(IoHandler ioHandler) {
		this.ioHandler = ioHandler;
		connector.setHandler(ioHandler);
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
	 * ��ȡ��ǰ����
	 * @return
	 */
	public IoConnector getConnector() {
		return connector;
	}

	/**
	 * ��������
	 * @param connector
	 */
	public void setConnector(IoConnector connector) {
//		connector.setHandler(ioHandler);
		this.connector = connector;
	}

	/**
	 * ��ȡ��ǰConnectFuture
	 * @return
	 */
	public ConnectFuture getConnectFuture() {
		return connectFuture;
	}

	/**
	 * ��ȡ��ǰConnectFuture
	 * @return
	 */
	public void setConnectFuture(ConnectFuture cf) {
		this.connectFuture = cf;
	}

	/**
	 * @return the ioServiceConfig
	 */
//	public IoServiceConfig getIoServiceConfig() {
//		return ioServiceConfig;
//	}

	/**
	 * @param ioServiceConfig the ioServiceConfig to set
	 */
//	public void setIoServiceConfig(IoServiceConfig ioServiceConfig) {
//		this.ioServiceConfig = ioServiceConfig;
//	}
	
	
}
