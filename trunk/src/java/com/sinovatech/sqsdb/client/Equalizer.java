package com.sinovatech.sqsdb.client;

/**
 * ������Խӿ�.
 * <p>
 * ������Խӿ�.
 * </p>
 * Copyright(c) 2011 http://www.sinovatech.com/
 * @author wanghailong@sinovatech.com
 * @version 1.0, 2011-4-25
 */
public interface Equalizer {
	/**
	 * ��������Ի�ȡʵ��.
	 * <p>
	 * ������
	 *
	 * @param manager
	 * @param code
	 * @param socketAddress
	 * @return
	 * @author wanghailong@sinovatech.com -- 2011-4-25
	 * @since
	 */
	Object getMinaSession(MinaSessionManager manager, int code, String... socketAddress);
}
