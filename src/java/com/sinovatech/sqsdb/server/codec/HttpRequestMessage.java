package com.sinovatech.sqsdb.server.codec;


public class HttpRequestMessage extends HttpMessage{
	
	public static final String HTTP_METHOD_GET = "GET";
	
	public static final String HTTP_METHOD_POST = "POST";
	
	private String NAME = "name=";
	private String CLASS = "&class=";
	private String ELEMENT = "&";
    
	private String requestMethod = HTTP_METHOD_GET;
	
	private String path = null;
	
	private String params = null;
	
	public HttpRequestMessage(){
	}
	
	/**
	 * 
	 * ʵ����һ���������
	 * <p>
	 * ����:
	 *
	 * @param path URL·��.��/poll
	 * @param params URL����.��name=name&test=test
	 * @param method ����POST����GET��ʽ
	 */
	public HttpRequestMessage(String path, String params, String method) {
		requestMethod = method;
		this.path = path;
		this.params = params;
    }
	
	/**
	 * 
	 * ʵ����һ���������
	 * <p>
	 * ����:
	 *
	 * @param path URL·��.��/poll
	 * @param params URL����.��name=name&test=test
	 */
	public HttpRequestMessage(String path, String params) {
		this.path = path;
		this.params = params;
    }
	
	/**
	 * 
	 * ʵ����һ���������
	 * <p>
	 * ����:
	 *
	 * @param path URL·��.��/poll
	 * @param queueName ��������.
	 * @param classes ���б����Class,�������Ĭ�ϵ�Class,��ΪNULL
	 * @param dataParam URL����.��test=test
	 * @param method  ����POST����GET��ʽ
	 */
	public HttpRequestMessage(String path,String queueName,Class classes,String dataParam, String method){
		requestMethod = method;
		this.path = path;
		StringBuffer sb = new StringBuffer();
		if(queueName != null){
			sb.append(NAME);
			sb.append(queueName);
		}
		if(classes != null){
			sb.append(CLASS);
			sb.append(classes.getName());
		}
		if(dataParam != null){
			sb.append(ELEMENT);
			sb.append(dataParam);
		}
		this.params = sb.toString();
	}
	
	/**
	 * 
	 * ʵ����һ���������.
	 * <p>
	 * ����:
	 *
	 * @param path URL·��.��/poll
	 * @param queueName ��������.
	 * @param classes ���б����Class,�������Ĭ�ϵ�Class,��ΪNULL
	 * @param dataParam URL����.��test=test
	 */
	public HttpRequestMessage(String path,String queueName,Class classes,String dataParam){
		this.path = path;
		StringBuffer sb = new StringBuffer();
		if(queueName != null){
			sb.append(NAME);
			sb.append(queueName);
		}
		if(classes != null){
			sb.append(CLASS);
			sb.append(classes.getName());
		}
		if(dataParam != null){
			sb.append(ELEMENT);
			sb.append(dataParam);
		}
		this.params = sb.toString();
	}
	
	/**
	 * ����HTTP���õķ�ʽ
	 * <p>
	 * ������
	 *
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-28
	 * @since
	 */
	public String getRequestMethod() {
		return requestMethod;
	}

	/**
	 * ����HTTP���õķ�ʽ
	 * <p>
	 * ������
	 *
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-28
	 * @since
	 */
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	/**
	 * ����URL·��
	 * <p>
	 * ������
	 *
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-28
	 * @since
	 */
	public String getPath() {
		return path;
	}

	/**
	 * ����URL·��
	 * <p>
	 * ������
	 *
	 * @param path
	 * @author wanghailong@sinovatech.com -- 2011-4-28
	 * @since
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getContext() {
        return path == null ? null : path.substring(1);
    }
	
	/**
	 * ����URL����
	 * <p>
	 * ������
	 *
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-28
	 * @since
	 */
	public String getParams() {
		return params;
	}
	
	/**
	 * ����URL����.
	 * <p>
	 * ������
	 *
	 * @param params
	 * @author wanghailong@sinovatech.com -- 2011-4-28
	 * @since
	 */
	public void setParams(String params) {
		this.params = params;
	}
	
	

}
