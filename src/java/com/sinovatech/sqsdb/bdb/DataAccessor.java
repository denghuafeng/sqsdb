package com.sinovatech.sqsdb.bdb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sleepycat.persist.EntityIndex;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.SecondaryKey;

/**
 * BDB���ݿ���ʶ���.
 * <p>
 * BDB���ݿ���ʶ���,������������.
 * </p>
 * Copyright(c) 2011 http://www.sinovatech.com/
 * @author wanghailong@sinovatech.com
 * @version 1.0, 2011-3-29
 */
public class DataAccessor {
	private static final Log log = LogFactory.getLog(DataAccessor.class);
    PrimaryIndex pi = null;
    String primaryKey = null;
    Map<String,EntityIndex> indexs = new ConcurrentHashMap();

    /**
     * 
     * ʼ����BDB���ݿ���ʶ���.
     * <p>
     * ����:
     * ʼ����BDB���ݿ���ʶ��������.
     * @param store
     * @param obj
     */
    public DataAccessor(EntityStore store,Object obj) {

        // Primary key for QueueData classes
//    	pi = store.getPrimaryIndex(
//    			String.class, Object.class);
//    	si = store.getSecondaryIndex(pi, String.class, "");
    	Class classes = obj.getClass();

		Field[] fields = classes.getDeclaredFields();
		Annotation annotation = null;
		for (Field field : fields) {// ��װ��������
			field.setAccessible(true);
			if (field.isAnnotationPresent(PrimaryKey.class)) {
				annotation = field.getAnnotation(PrimaryKey.class);
				primaryKey = field.getName();
				pi = store.getPrimaryIndex(field.getType(), classes);
				indexs.put(field.getName(), pi);
			} else if (field.isAnnotationPresent(SecondaryKey.class)) {
				annotation = field.getAnnotation(SecondaryKey.class);
				SecondaryIndex si = store.getSecondaryIndex(pi,
						field.getType(), field.getName());
				indexs.put(field.getName(), si);
			}

		}
    	
    	
    }
}
