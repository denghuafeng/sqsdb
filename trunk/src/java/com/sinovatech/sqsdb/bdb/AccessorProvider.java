package com.sinovatech.sqsdb.bdb;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinovatech.sqsdb.common.ObjectFactory;
import com.sinovatech.sqsdb.common.PropUtil;

/**
 * 
 * AccessorProvider�����: ���з����ṩ��.
 * <p>
 * ���з����ṩ��.
 * </p>
 * Copyright(c) 2011 http://www.sinovatech.com/
 * @author wanghailong@sinovatech.com
 * @version 1.0, 2011-3-28
 */
public class AccessorProvider {
	private static final Log log = LogFactory.getLog(AccessorProvider.class);
	
	private static Map maps = new HashMap();
	
	private static String QUEUE_CLASS = PropUtil.getString("sqsconfig", "queue.class");
	
	/**
	 * ���ݶ������ֻ�ȡ���ж���,������в����ڸ��ݿɱ�������д�������.
	 * <p>
	 * ������
	 * ���ڻ�ȡ���ж���,�ڶ����ṩ����֮���Զ����л���
	 * @param name ������
	 * @param obj �������ݶ���
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-23
	 * @throws ClassNotFoundException 
	 * @since
	 */
	public static WorkQueue getQueue(String name, Object...obj) throws ClassNotFoundException{
		WorkQueue sqs = null;
		if(name==null){
			sqs = (WorkQueue)ObjectFactory.getInstance((QUEUE_CLASS));
		}else{
			if(maps.get(name)==null){
				synchronized(maps){
					if(maps.get(name)==null){
						if(obj.length>0){
							sqs = (WorkQueue)ObjectFactory.getInstance((QUEUE_CLASS),name);
							sqs.setup(obj[0]);
							maps.put(name, sqs);
						}else{
							sqs = (WorkQueue)ObjectFactory.getInstance((QUEUE_CLASS),name);
							sqs.init();
							maps.put(name, sqs);
						}
					}else{
						sqs = (WorkQueue)maps.get(name);
					}
				}
			}else{
				sqs = (WorkQueue)maps.get(name);
			}
		}
		
		return sqs;
		
	}
}
