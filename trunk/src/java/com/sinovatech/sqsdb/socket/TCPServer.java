package com.sinovatech.sqsdb.socket;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.sinovatech.sqsdb.common.PropUtil;


public class TCPServer extends Server {
	
	/**
	 * TCP����˶���
	 * @param ioHandler ����Handler,ʵ����IoHandler
	 */
    public TCPServer(IoHandler ioHandler) {
    	super(ioHandler);
		this.setPort(PropUtil.getInt("minasocket","server.prot"));
    	
		if(PropUtil.getString("minasocket","server.ip")!=null && !"".equals(PropUtil.getString("minasocket","server.ip")))
    		this.setIp(PropUtil.getString("minasocket","server.ip"));

		NioSocketAcceptor acceptor = null;
    	if(PropUtil.getString("minasocket","socket.ThreadSize")!=null && !"".equals(PropUtil.getString("minasocket","socket.ThreadSize"))){//�̳߳���������
    		int threadSize = Integer.parseInt(PropUtil.getString("minasocket","socket.ThreadSize"));
    		acceptor = new NioSocketAcceptor(threadSize); 
    	}else{
    		acceptor = new NioSocketAcceptor(); 
    	}
    	
    	if(PropUtil.getString("minasocket","socket.Backlog")!=null && !"".equals(PropUtil.getString("minasocket","socket.Backlog")))
    		acceptor.setBacklog(PropUtil.getInt("minasocket","socket.Backlog"));//���÷������������е����ֵ
    	
    	this.setAcceptor(acceptor);
    	this.setIoHandler(ioHandler);
    	SocketSessionConfig config = acceptor.getSessionConfig();
    	
    	//���������ʵ��,������ʹ��
    	if(PropUtil.getString("minasocket","socket.KeepAlive")!=null && !"".equals(PropUtil.getString("minasocket","socket.KeepAlive")))
    		config.setKeepAlive(PropUtil.getBoolean("minasocket","socket.KeepAlive"));
    	
    	config.setReuseAddress(true);////��������һ�����Ӵ��ڳ�ʱ״̬ʱ���׽���
 
    	if(PropUtil.getString("minasocket","socket.SendBufferSize")!=null && !"".equals(PropUtil.getString("minasocket","socket.SendBufferSize")))
    		config.setSendBufferSize(PropUtil.getInt("minasocket","socket.SendBufferSize"));//�������뻺�����Ĵ�С
    	
    	if(PropUtil.getString("minasocket","socket.ReceiveBufferSize")!=null && !"".equals(PropUtil.getString("minasocket","socket.ReceiveBufferSize")))
    		config.setReceiveBufferSize(PropUtil.getInt("minasocket","socket.ReceiveBufferSize"));//��������������Ĵ�С
    	
    	config.setIdleTime(IdleStatus.BOTH_IDLE, PropUtil.getInt("minasocket","socket.maxIdleTime")*2);
    	config.setTcpNoDelay(true);//�Ƿ�ʹ��Nagle�㷨,���涨TCP��һ��ʱ��ֻ�ܷ���һ�����ݱ�����ÿ��IP���ݱ��õ��϶�Ӧ���ʱ�򣬲��ܷ����µĶ����а������ݵ����ݱ��������������ݱ�ͷ����Ϣ���ĵĴ��������������в�̫��Ҫ�Ĵ���--�����ӳ١���Ϊ���ݱ��Ŷ��ˣ����ǲ����������͵�
//    	config.setSoLinger(3);//TCP�׽������ӱ��رյ�ʱ��,Linger�����ӣ��׽���ѡ�����δ���͵����ݿ��ܷ��͵�ʱ���ܺ�
//    	config.setOobInline(true);//�Ƿ�֧�ַ���һ���ֽڵ�TCP��������
    	   	
    	
    	
    	
	}
    

}
