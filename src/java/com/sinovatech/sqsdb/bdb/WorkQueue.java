package com.sinovatech.sqsdb.bdb;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * 
 * WorkQueue�ӿ�.
 * Copyright(c) 2011 http://www.sinovatech.com/
 * @author wanghailong@sinovatech.com
 * @version 1.0, 2011-3-28
 */
public abstract class WorkQueue<E> {

	public void setup(E value){
		
	}
	public void init() throws ClassNotFoundException{
		
	}
	/**
	 * �ڴ�ӳ���й���ָ��ֵ��ָ������
	 * [����].
	 * <p>
	 * ������
	 *���ڴ�ӳ���й���ָ��ֵ��ָ�����������ӳ����ǰ������һ���ü���ӳ���ϵ�����ֵ���滻��
	 * @param key ָ��ֵ��Ҫ�����ļ���
	 * @param value ָ������Ҫ������ֵ��
	 * @return ��ָ����������ľ�ֵ�������û���κ�ӳ���ϵ���򷵻� null������ null �����ܱ�ʾ�� HashMap ��ǰ�� null ��ָ����������
	 * @author wanghailong@sinovatech.com -- 2011-3-29
	 * @since
	 */
	public abstract Object add(E value);
	/**
	 * �������Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null��
	 * [����].
	 * <p>
	 * ������
	 * �������Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null��
	 * @return 
	 * @author wanghailong@sinovatech.com -- 2011-3-30
	 * @throws Exception 
	 * @since
	 */
	public abstract E poll() throws Exception;
	
	/**
	 * �����ӳ���д��ڸü���ӳ���ϵ������ɾ����
	 * [����].
	 * <p>
	 * ������
	 * �����ӳ���д��ڸü���ӳ���ϵ������ɾ����
	 * @param key ��ӳ���ϵҪ��ӳ�����Ƴ��ļ���
	 * @return ��ָ����������ľ�ֵ�������û���κ�ӳ���ϵ���򷵻� null������ null �����ܱ�ʾ��ӳ����ǰ�� null ��ָ����������
	 * @author wanghailong@sinovatech.com -- 2011-3-29
	 * @since
	 */
	public abstract boolean removeByField(String fieldName, Object key);
	
	/**
	 * �������������ᵽ����ͷ��.
	 * [����].
	 * <p>
	 * ������
	 * ���ֶ�������ָ��ֵ�������ᵽ����ͷ��
	 * @param fieldName
	 * @param key
	 * @return
	 * @throws Exception
	 * @author wanghailong@sinovatech.com -- 2011-4-23
	 * @since
	 */
	public abstract boolean setHeadByField(String fieldName, Object key) throws Exception;
	
	/**
	 * ���ض��г���.
	 * [����].
	 * <p>
	 * ������
	 * ����ָ���ֶεĳ���
	 * @param fieldName
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-23
	 * @since
	 */
	public abstract long getCountByField(String fieldName);
	
	/**
	 * �������ݶ����λ��.����Ϊ����,������ǰ���ƺ��ڶ��е�λ��.
	 * [����].
	 * <p>
	 * ������
	 * ���ֶ�������ָ��ֵ�������ƶ�λ��,��Ҫ�ͻ��˵�KEY��Ψһ��,�ҿ�תΪ��������
	 * @param fieldName
	 * @param key
	 * @param addValue
	 * @return
	 * @throws Exception
	 * @author wanghailong@sinovatech.com -- 2011-4-23
	 * @since
	 */
	public abstract boolean setPositionByField(String fieldName, Object key, long addValue) throws Exception;
	/**
	 * �����ֶζ�Ӧ��ֵ��λ��
	 * [����].
	 * <p>
	 * ������
	 * 
	 * @param fieldName
	 * @param key
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-23
	 * @since
	 */
	public abstract long getPositionByField(String fieldName, Object key);
	/**
	 * ����������һ�����ݶ���
	 * [����].
	 * <p>
	 * ������
	 *
	 * @param fieldName
	 * @param key
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-23
	 * @since
	 */
	public abstract Object getByField(String fieldName, Object key);
	/**
	 * ֹͣ���з���
	 * [����].
	 * <p>
	 * ������
	 * ֹͣ���з���
	 * @author wanghailong@sinovatech.com -- 2011-4-23
	 * @since
	 */
	public abstract void stop();
}
