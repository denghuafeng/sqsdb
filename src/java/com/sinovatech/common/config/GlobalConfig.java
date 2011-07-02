package com.sinovatech.common.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <ul>
 * <li> <b>Ŀ��:</b> <br />
 * <p>
 * ϵͳ������Ϣ�洢�ļ�
 * </p>
 * </li>
 * <li><b>���õĲ�������</b></li>
 * <li><b>���в��ԣ�</b></li>
 * <li> <b>�޸���ʷ��</b><br />
 * <p>
 * ����:Nov 1, 2007 3:23:15 PM<br />
 * ����:liulibin@sinovatech.com
 * </p>
 * </li>
 * <li><b>��֪���⣺</b></li>
 * </ul>
 */
public class GlobalConfig
{
	private static Log log = LogFactory.getLog(GlobalConfig.class);

	public final static String SYSTEM_PROPERTIES = "/system.properties";

	// �ļ��洢·��,����ַ�Ӧ�����ļ��ָ�����
	private static String propertiesStorePath;
	// ��������б�
	private static Map propertieMap = new HashMap();
	// ��������ļ�
	private static Map propertieFileMap = new HashMap();

	static
	{
		Properties properties = init(SYSTEM_PROPERTIES);
		Iterator it = properties.keySet().iterator();
		propertiesStorePath = properties.getProperty("path");

		while (it.hasNext())
		{
			String name = (String) it.next();
			String file = properties.getProperty(name);

			file = file.trim();

			propertieFileMap.put(name, file);
			Properties p = init("/" + file);
			propertieMap.put(name, p);
		}
	}

	private static Properties init(String propertyFile)
	{
		Properties p = new Properties();
		try
		{
			log.info("Start Loading property file \t" + propertyFile);
			p.load(GlobalConfig.class.getResourceAsStream(propertyFile));
			log.info("Load property file success!\t" + propertyFile);
		} catch (Exception e)
		{
			e.printStackTrace();
			log.error("Could not load property file." + propertyFile, e);
		}

		return p;
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ���ȡ����</li>
	 * <li>���õ�ǰ������:</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param cls
	 *            �����ļ���𣬼�system.properties�����õ��ļ�key����
	 * @param name
	 *            ��������
	 * @return
	 */
	public static String getProperty(String cls, String name)
	{
		Properties p = (Properties) propertieMap.get(cls);
		if (p != null)
		{
			return p.getProperty(name);
		} else
		{
			return null;
		}
	}

	public static boolean getBooleanProperty(String cls, String name)
	{
		String p = getProperty(cls, name);
		return "true".equals(p);
	}

	public static Integer getIntegerProperty(String cls, String name)
	{
		String p = getProperty(cls, name);
		if (p == null)
		{
			return null;
		}
		return Integer.valueOf(p);
	}

	public static Long getLongProperty(String cls, String name)
	{
		String p = getProperty(cls, name);
		if (p == null)
		{
			return null;
		}
		return Long.valueOf(p);
	}

	public static Double getDoubleProperty(String cls, String name)
	{
		String p = getProperty(cls, name);
		if (p == null)
		{
			return null;
		}
		return Double.valueOf(p);
	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ��������������ļ�</li>
	 * <li>���õ�ǰ������:�������ļ���������path����</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 */
	public static void store()
	{

	}

	/**
	 * <p>
	 * <b>ҵ��������</b>
	 * <ul>
	 * <li>�ɼ���ԭ����Ҫ������Ӧ�õ���</li>
	 * <li>Ŀ�ģ����浥�������ļ�</li>
	 * <li>���õ�ǰ������:�����ļ�������������ѡ��</li>
	 * <li>����������</li>
	 * <li>���⴦���� </li>
	 * <li>��֪���⣺</li>
	 * <li>���õ����ӣ� </li>
	 * </ul>
	 * </p>
	 * 
	 * @param cls
	 */
	public static void store(String cls)
	{
		Properties p = (Properties) propertieMap.get(cls);
		FileOutputStream fi;
		try
		{
			fi = new FileOutputStream(new File((String) propertieFileMap
					.get(cls)));
			p.store(fi, "Modified time: " + Calendar.getInstance().getTime());
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
