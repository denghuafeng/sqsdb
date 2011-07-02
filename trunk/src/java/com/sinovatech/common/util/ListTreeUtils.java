/**
 * 
 */
package com.sinovatech.common.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * <ul>
 * <li> <b>Ŀ��:</b> <br />
 * <p>
 * �����򹤾�:Ҫ������б�Ľڵ�Ϊ���ڵ㣬���ӽڵ������ϵΪͨ��parentid���й���
 * </p>
 * </li>
 * <li><b>���õĲ�������</b></li>
 * <li><b>���в��ԣ�</b></li>
 * <li> <b>�޸���ʷ��</b><br />
 * <p>
 * ����: Feb 19, 2008 1:37:50 PM<br />
 * ����:liulibin@sinovatech.com
 * </p>
 * </li>
 * <li><b>��֪���⣺</b></li>
 * </ul>
 */
public class ListTreeUtils
{
	/**
	 * <p>
	 * <ul>
	 * <li>���򷽷�</li>
	 * </ul>
	 * </p>
	 * 
	 * @param list
	 *            ��Ҫ������б�
	 * @param idName
	 *            �������
	 * @param parentIdName��
	 *            ���ڵ�ı��
	 * @param rootIdValue
	 *            ���ڵ�ֵ
	 * @return
	 */
	public static List sort(List list, String idName, String parentIdName,
			Object rootIdValue)
	{
		List re = new ArrayList();

		List childs = filterListWithPropertiesValue(list, parentIdName,
				rootIdValue);
		if (childs.size() > 0)
		{
			re.addAll(childs);
			Iterator it = childs.iterator();
			while (it.hasNext())
			{
				Object o = it.next();
				Object root = getBeanProperty(o, idName);
				re.addAll(sort(list, idName, parentIdName, root));
			}
		}
		return re;
	}

	/**
	 * <p>
	 * <ul>
	 * <li>����������ʾJS����</li>
	 * </ul>
	 * </p>
	 * 
	 * @param list
	 * @param idName
	 * @param parentIdName
	 * @param rootIdValue
	 * @param nodeMake
	 * @return
	 */
	public static String make(List list, String idName, String parentIdName,
			Object rootIdValue, ITreeNodeMake nodeMake)
	{
		List childs = filterListWithPropertiesValue(list, parentIdName,
				rootIdValue);
		if (childs.size() > 0)
		{
			StringBuffer re = new StringBuffer();

			Iterator it = childs.iterator();
			while (it.hasNext())
			{
				Object o = it.next();
				// ����JS���벢��ӵ������б�
				Object root = getBeanProperty(o, idName);
				String str = make(list, idName, parentIdName, root, nodeMake);

				// ��ӱ��ڵ�
				re.append(nodeMake.makeNode(o, str != null));

				if (str != null)
					re.append(str);
			}

			return re.toString();
		} else
		{
			return null;
		}
	}

	/**
	 * <p>
	 * <ul>
	 * <li>���б��������ʽ����</li>
	 * </ul>
	 * </p>
	 * 
	 * @param list
	 * @param idName
	 * @param parentIdName
	 * @param rootIdValue
	 * @param nodeMake
	 * @return
	 */
	public static String make2(List list, String idName, String parentIdName,
			Object rootIdValue, ITreeNodeMake nodeMake)
	{
		List childs = filterListWithPropertiesValue(list, parentIdName,
				rootIdValue);
		if (childs.size() > 0)
		{
			StringBuffer re = new StringBuffer();

			Iterator it = childs.iterator();
			while (it.hasNext())
			{
				Object o = it.next();
				// ����JS���벢��ӵ������б�
				Object root = getBeanProperty(o, idName);
				String str = make(list, idName, parentIdName, root, nodeMake);

				// ��ӱ��ڵ�
				re.append(nodeMake.makeNode(o, str != null));

				if (str != null)
					re.append(str);
			}

			return re.toString();
		} else
		{
			return null;
		}
	}

	/**
	 * <p>
	 * <ul>
	 * <li>�����б�</li>
	 * </ul>
	 * </p>
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static List filterListWithPropertiesValue(List list,
			String propertyName, Object value)
	{
		List re = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext())
		{
			Object o = it.next();
			Object v = getBeanProperty(o, propertyName);
			if ((value == null && v == null)
					|| (value != null && value.equals(v)))
			{
				re.add(o);
				it.remove();
			}
		}
		return re;
	}

	/**
	 * <p>
	 * <ul>
	 * <li>��ȡbean������ </li>
	 * </ul>
	 * </p>
	 * 
	 * @param propertyName
	 * @param o
	 * @return
	 */
	public static Object getBeanProperty(Object o, String propertyName)
	{
		try
		{
			return PropertyUtils.getProperty(o, propertyName);
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

		return null;
	}
}
