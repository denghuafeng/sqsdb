/**
 * 
 */
package com.sinovatech.common.util;

/**
 * <ul>
 * <li> <b>Ŀ��:</b> <br />
 * <p>
 * �ڵ���±�дʵ��
 * </p>
 * </li>
 * <li><b>���õĲ�������</b></li>
 * <li><b>���в��ԣ�</b></li>
 * <li> <b>�޸���ʷ��</b><br />
 * <p>
 * ����: Feb 19, 2008 3:11:23 PM<br />
 * ����:liulibin@sinovatech.com
 * </p>
 * </li>
 * <li><b>��֪���⣺</b></li>
 * </ul>
 */
public interface ITreeNodeMake
{
	/**
	 * <p>
	 * <ul>
	 * <li>�������ڵ��JS����</li>
	 * </ul>
	 * </p>
	 * 
	 * @param o
	 *            �ڵ����
	 * @param hasChilds 
	 * 			�Ƿ������ӽڵ�
	 * @return
	 */
	public String makeNode(Object o, boolean hasChilds);
}
