/**
 * 
 */
package com.sinovatech.common.util;

import java.util.Random;

/**
 * <ul>
 * <li> <b>Ŀ��:</b> <br />
 * <p>
 * �����������
 * </p>
 * </li>
 * <li><b>���õĲ�������</b></li>
 * <li><b>���в��ԣ�</b></li>
 * <li> <b>�޸���ʷ��</b><br />
 * <p>
 * ����:Dec 11, 2007 4:15:42 PM<br />
 * ����:liulibin@sinovatech.com
 * </p>
 * </li>
 * <li><b>��֪���⣺</b></li>
 * </ul>
 */

public class RandomUtil
{
	private RandomUtil()
	{

	}

	/**
	 * �õ�width���ȵ����������ɵ��ַ���
	 * 
	 * @param width
	 * @return
	 */
	public static String getRand(int width)
	{
		Random random = new Random();
		String strRand = "";
		for (int i = 0; i < width; i++)
		{
			String rand = String.valueOf(random.nextInt(10));
			strRand += rand;
		}
		return strRand;
	}

}
