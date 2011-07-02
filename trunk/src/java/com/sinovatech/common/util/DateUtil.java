package com.sinovatech.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <ul>
 * <li> <b>Ŀ��:</b> <br />
 * <p>
 * ���ڲ�����
 * </p>
 * </li>
 * <li><b>���õĲ�������</b></li>
 * <li><b>���в��ԣ�ȫ����̬����������ʵ������ֱ�ӵ��ü���</b></li>
 * <li> <b>�޸���ʷ��</b><br />
 * <p>
 * ����:Nov 13, 2007 6:03:21 PM<br />
 * ����:liulibin@sinovatech.com
 * </p>
 * </li>
 * <li><b>��֪���⣺</b></li>
 * </ul>
 */
public class DateUtil
{
	private DateUtil()
	{
		
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ���ȡ����ȵĵ�һ��</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param format
	 * @return
	 */
	public static Date getFirstDayOfYear(String format)
	{
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_YEAR, 1);
		return ca.getTime();
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ���ȡһ������һ����</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param format
	 * @return
	 */
	public static Date getLastMonth(String format)
	{
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, 1);
		ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) - 1);
		return ca.getTime();
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ���ȡ��������һ��</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param format
	 * @return
	 */
	public static Date getLastDayOfYear()
	{
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MONTH, Calendar.DECEMBER);
		ca.set(Calendar.DAY_OF_MONTH, 30);
		return ca.getTime();
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�Comments</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param i
	 * @return
	 */
	public static Date subDays(Date source, int i)
	{

		return new Date(source.getTime() - 86400000 * i);
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�����iСʱ</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ�
	 * </li>
	 * </ul>
	 * </p>
	 * 
	 * @param source
	 * @param i
	 * @return
	 */
	public static Date subHours(Date source, int i)
	{
		return new Date(source.getTime() - 3600000 * i);
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ����ӷ���</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ�
	 * </li>
	 * </ul>
	 * </p>
	 * 
	 * @param source
	 * @param i
	 * @return
	 */
	public static Date subMinius(Date source, int i)
	{
		return new Date(source.getTime() - 60000 * i);
	}


	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�Ϊʱ������I��</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param source
	 * @param i
	 * @return
	 */
	public static Date subSeconds(Date source, int i)
	{
		return new Date(source.getTime() - 1000 * i);
	}
	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�Comments</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param i
	 * @return
	 */
	public static Date addDays(Date source, int i)
	{

		return new Date(source.getTime() + 86400000 * i);
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�����iСʱ</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ�
	 * </li>
	 * </ul>
	 * </p>
	 * 
	 * @param source
	 * @param i
	 * @return
	 */
	public static Date addHours(Date source, int i)
	{
		return new Date(source.getTime() + 3600000 * i);
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ����ӷ���</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ�
	 * </li>
	 * </ul>
	 * </p>
	 * 
	 * @param source
	 * @param i
	 * @return
	 */
	public static Date addMinius(Date source, int i)
	{
		return new Date(source.getTime() + 60000 * i);
	}


	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�Ϊʱ������I��</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param source
	 * @param i
	 * @return
	 */
	public static Date addSeconds(Date source, int i)
	{
		return new Date(source.getTime() + 1000 * i);
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�Comments</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Date d = new Date();
		System.out.println(DateUtil.format(d, DateUtil.yyyyMMddHHmmssSpt));
		System.out.println(DateUtil.format(DateUtil.addSeconds(d, 1),
				DateUtil.yyyyMMddHHmmssSpt));
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�����ָ����ʽ�ĵ�ǰ���ڸ�ʽ���ַ���</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param formart
	 * @return
	 */
	public static String format(String format)
	{
		return new SimpleDateFormat(format).format(Calendar.getInstance()
				.getTime());
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ�����ָ����ʽ�ĵ�ǰ���ڸ�ʽ���ַ���</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param formart
	 * @return
	 */
	public static String format(Date date, String format)
	{
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ���ʽ���ַ���Ϊ����</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parse(String date, String format)
	{
		try
		{
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static String yyyyMMddHHmm = "yyyyMMddHHmm";
	public static String yyyyMMdd = "yyyyMMdd";
	public static String yyyyMM = "yyyyMM";
	public static String HHmmss = "HHmmss";
	public static String HHmm = "HHmm";

	public static String yyyyMMddHHmmssSpt = "yyyy-MM-dd HH:mm:ss";
	public static String yyyyMMddHHmmSpt = "yyyy-MM-dd HH:mm";
	public static String yyyyMMddSpt = "yyyy-MM-dd";
	public static String yyyyMMSpt = "yyyy-MM";
	public static String HHmmssSpt = "HH:mm:ss";
	public static String HHmmSpt = "HH:mm";
}
