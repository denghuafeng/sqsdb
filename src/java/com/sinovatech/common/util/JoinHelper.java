/**
 * 
 */
package com.sinovatech.common.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ArrayUtils;

/**
 * <ul>
 * <li> <b>Ŀ��:</b> <br />
 * <p>
 * ������ϲ��ַ�����ͨ�ù�����
 * </p>
 * </li>
 * <li><b>���õĲ�������</b></li>
 * <li><b>���в��ԣ�</b></li>
 * <li> <b>�޸���ʷ��</b><br />
 * <p>
 * ����:Dec 18, 2007 1:53:44 PM<br />
 * ����:liulibin@sinovatech.com
 * </p>
 * </li>
 * <li><b>��֪���⣺</b></li>
 * </ul>
 */

public class JoinHelper
{
	private JoinHelper()
	{

	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ϲ�һ������Ϊ�ָ����ָ���ַ��� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param s
	 * @param separator
	 * @return
	 */
	public static String join(String[] s, String separator)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; i++)
		{
			sb.append(s[i] + separator);
		}
		String s2 = sb.toString();
		return sb.toString().substring(0, s2.length() - separator.length());
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ϲ�һ�����������ĳ������Ϊ�ָ����ָ���ַ��� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param s
	 * @param separator
	 * @return
	 */
	public static String join(Object[] s, String separator, String filed)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; i++)
		{
			try
			{
				sb.append(BeanUtils.getProperty(s[i], filed) + separator);
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			} catch (InvocationTargetException e)
			{
				e.printStackTrace();
			} catch (NoSuchMethodException e)
			{
				e.printStackTrace();
			}
		}
		String s2 = sb.toString();
		return sb.toString().substring(0, s2.length() - separator.length());
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ϲ�һ����������Ϊ�ָ����ָ���ַ��� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param s
	 * @param separator
	 * @return
	 */
	public static String join(Collection co, String separator)
	{
		if(co.size()==0)
			return "";
		StringBuffer sb = new StringBuffer();
		Iterator it = co.iterator();
		while (it.hasNext())
		{
			sb.append(it.next().toString() + separator);
		}

		String s2 = sb.toString();
		return sb.toString().substring(0, s2.length()- separator.length());
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ϲ�һ������������ĳ������Ϊ�ָ����ָ���ַ��� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param s
	 * @param separator
	 * @return
	 */
	public static String join(Collection co, String separator, String filed)
	{
		if(co.size()==0)
			return "";
		StringBuffer sb = new StringBuffer();
		Iterator it = co.iterator();
		while (it.hasNext())
		{
			try
			{
				sb.append(BeanUtils.getProperty(it.next(), filed) + separator);
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			} catch (InvocationTargetException e)
			{
				e.printStackTrace();
			} catch (NoSuchMethodException e)
			{
				e.printStackTrace();
			}
		}

		String s2 = sb.toString();
		return sb.toString().substring(0, s2.length() - separator.length());
	}
}
