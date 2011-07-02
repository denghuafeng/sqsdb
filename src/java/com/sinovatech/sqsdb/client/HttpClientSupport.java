package com.sinovatech.sqsdb.client;




import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.session.IoSession;

import com.sinovatech.sqsdb.common.PropUtil;
import com.sinovatech.sqsdb.server.codec.HttpResponseMessage;
import com.sinovatech.sqsdb.server.codec.Message;

/**
 * HTTP�ͻ���
 * Copyright(c) 2011 http://www.sinovatech.com/
 * @author wanghailong@sinovatech.com
 * @version 1.0, 2011-4-25
 */
public class HttpClientSupport {
	private static final Log log = LogFactory.getLog(HttpClientSupport.class);
	private static final MinaSessionManager minaSessionManager = new MinaSessionManager();
	private Equalizer equalizer = null;
	
	private static final String[] defalutSocketAddress = PropUtil.getString("minasocket", "client.server.ips").split(";");
    private static final int timeOut = PropUtil.getInt("minasocket", "client.Timeout");
    
    public HttpClientSupport() {
		
	}
    
    public HttpClientSupport(Equalizer equalizer) {
		this.equalizer = equalizer;
	}

    /**
     * �����ӳػ�ȡָ��IP������
     * <p>
     * ������
     *
     * @param socketAddress
     * @return
     * @throws Exception
     * @author wanghailong@sinovatech.com -- 2011-4-25
     * @since
     */
    public IoSession getIoSession(String socketAddress) throws Exception {
    	IoSession ioSession = minaSessionManager.getMinaSession(socketAddress);
    	return ioSession;
    }
    
    /**
     * 
     * ������Ϣ
     * <p>
     * ������Ϣ,������waitResponse����,�Ƿ�ȴ����ص���Ϣ
     *
     * @param msg 
     * @param waitResponse
     * @param code
     * @param socketAddress
     * @return
     * @throws Exception
     * @author wanghailong@sinovatech.com -- 2011-5-27
     * @since
     */
    public HttpResponseMessage sendMessage(Object msg, boolean waitResponse,Integer code, String... socketAddress) throws Exception{
    	IoSession ioSession = null;
    	HttpResponseMessage response = null;
    	if(code==null){
    		
    		if(socketAddress.length==0){
        		socketAddress = defalutSocketAddress;
        		ioSession = minaSessionManager.getMinaSession(socketAddress[0]);
        	}else{
        		ioSession = minaSessionManager.getMinaSession(socketAddress[0]);
        	}
    		
    	}else{
    		if(socketAddress.length==0){
        		socketAddress = defalutSocketAddress;
        		ioSession = (IoSession)equalizer.getMinaSession(minaSessionManager,code,socketAddress);
        	}else{
        		ioSession = (IoSession)equalizer.getMinaSession(minaSessionManager,code,socketAddress);
        	}
    	}
    	
    	ioSession.write(msg);
    	
    	if(waitResponse){
	    	ReadFuture readFuture = ioSession.read();
	    	if(readFuture.await(timeOut, TimeUnit.SECONDS)){
	    		response = (HttpResponseMessage)readFuture.getMessage();
	    	}
    	}
    	
    	return response;
    }
    
    /**
     * ����codeֵ���ⷽʽ,�����ӳػ�ȡ����
     * <p>
     * ������
     *
     * @param code
     * @param socketAddress
     * @return
     * @throws Exception
     * @author wanghailong@sinovatech.com -- 2011-4-25
     * @since
     */
    public IoSession getIoSession(int code, String... socketAddress) throws Exception {
    	IoSession ioSession = null;
    	if(socketAddress.length==0){
    		socketAddress = defalutSocketAddress;
    		ioSession = (IoSession)equalizer.getMinaSession(minaSessionManager,code,socketAddress);
    	}else{
    		ioSession = (IoSession)equalizer.getMinaSession(minaSessionManager,code,socketAddress);
    	}
    	return ioSession;
    }
    
    /**
     * �黹���ӵ����ӳ�
     * <p>
     * ������
     *
     * @param socketAddress
     * @param ioSession
     * @throws Exception
     * @author wanghailong@sinovatech.com -- 2011-4-25
     * @since
     */
    public void returnIoSession(String socketAddress, IoSession ioSession) throws Exception{
    	if (null == ioSession) {
			return;
		}
    	minaSessionManager.returnMinaSession(socketAddress, ioSession);
    }



	public Equalizer getEqualizer() {
		return equalizer;
	}

	public void setEqualizer(Equalizer equalizer) {
		this.equalizer = equalizer;
	}
	
}
