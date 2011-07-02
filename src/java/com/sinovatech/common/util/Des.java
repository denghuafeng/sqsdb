package com.sinovatech.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <ul>
 * <li> <b>Ŀ��:</b> <br />
 * <p>
 * ��������DES�����㷨
 * </p>
 * </li>
 * <li><b>���õĲ�������</b></li>
 * <li><b>���в��ԣ�</b></li>
 * <li> <b>�޸���ʷ��</b><br />
 * <p>
 * ����: Jan 30, 2008 2:16:55 PM<br />
 * ����:liulibin@sinovatech.com
 * </p>
 * </li>
 * <li><b>��֪���⣺</b></li>
 * </ul>
 */
public class Des
{

	public static final String DES = "DES";

	// 3λ
	public static final String DESede = "DESede";

	// 2��
	public static final String Blowfish = "Blowfish";

	public static void main(String[] args)
	{
		String key = "123456781234567812345678123456781234567812345678";

		
		
		String str = "5GLdlihlArMbnfDo4IaAkPjdmBQWKo/yOx7oqw+B5aFE2QhE3H/UWUjUp2FYyCTsmEedSNTamCZaipC99tzrRiLEDNzbGPM2GXbDtiexSvQQ9UC0uWPF4ukkRAKgw9PKKOfTH0tKGmGI2UR5u3Vfnm1Q0xy3hjDZmh2IteN7Onf4Otz3e85Nag1gvUynKh4IoZv5pQkUIKXkL057VboazXmdR/R7i2RF1grOCYCxfdcEWvm6bD9WJGEfHrw9EZFbT7Kt+Y2d0DUsnF0ac39ndemvOJZDcxkq";
		try
		{
			str = new URLDecoder().decode(str,"utf-8");
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String c = Des
//				.encrytWithBase64(
//						Des.DESede,
//						str, key);
//		System.out.println("...." + c);
		System.out.println(Des.deEncrytWithBase64(Des.DESede, str, key));
	}

	/**
	 * <p>
	 * <ul>
	 * <li>����</li>
	 * </ul>
	 * </p>
	 * 
	 * @param Algorithm
	 *            �㷨
	 * @param myinfo
	 *            �����ܵ��ַ���
	 * @param key
	 *            1��Des.DES��Կ������16λ���ȵ��ַ�������16���Ʊ�������Ϊ8λ<br />
	 *            2��Des.Blowfish��Կ������32λ���ȵ��ַ�������16���Ʊ�������Ϊ16λ<br />
	 *            3��Des.DESede��Կ������48λ���ȵ��ַ�������16���Ʊ�������Ϊ32λ<br />
	 * 
	 * @return
	 */
	public static String encrytWithBase64(String Algorithm, String myinfo,
			String key)
	{
		byte[] keybyte = HexString2Bytes(key);

		byte[] str = Des.encryt(Algorithm, myinfo, keybyte);

		return new BASE64Encoder().encode(str);
	}

	/**
	 * <p>
	 * <ul>
	 * <li>����</li>
	 * </ul>
	 * </p>
	 * 
	 * @param Algorithm
	 *            �㷨
	 * @param myinfo
	 *            �����ܵ�����
	 * @param key
	 *            1��Des.DES��Կ������16λ���ȵ��ַ�������16���Ʊ�������Ϊ8λ<br />
	 *            2��Des.Blowfish��Կ������32λ���ȵ��ַ�������16���Ʊ�������Ϊ16λ<br />
	 *            3��Des.DESede��Կ������48λ���ȵ��ַ�������16���Ʊ�������Ϊ32λ<br />
	 * @return
	 */
	public static String deEncrytWithBase64(String Algorithm, String myinfo,
			String key)
	{
		byte[] keybyte = HexString2Bytes(key);
		byte[] info = null;
		try
		{
			info = new BASE64Decoder().decodeBuffer(myinfo);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		String str = deEncryt(Algorithm, info, keybyte);
		return str;
	}

	/**
	 * <p>
	 * <ul>
	 * <li>����</li>
	 * </ul>
	 * </p>
	 * 
	 * @param Algorithm
	 *            �㷨
	 * @param myinfo
	 *            �����ܵ��ַ���
	 * @param key
	 *            1��Des.DES��Կ������16λ���ȵ��ַ�������16���Ʊ�������Ϊ8λ<br />
	 *            2��Des.Blowfish��Կ������32λ���ȵ��ַ�������16���Ʊ�������Ϊ16λ<br />
	 *            3��Des.DESede��Կ������48λ���ȵ��ַ�������16���Ʊ�������Ϊ32λ<br />
	 * @return
	 */
	public static byte[] encryt(String Algorithm, String myinfo, String key)
	{
		byte[] keybyte = HexString2Bytes(key);

		byte[] str = Des.encryt(Algorithm, myinfo, keybyte);

		return str;
	}

	/**
	 * <p>
	 * <ul>
	 * <li>����</li>
	 * </ul>
	 * </p>
	 * 
	 * @param Algorithm
	 *            �㷨
	 * @param myinfo
	 *            �����ܵ�����
	 * @param key
	 *            1��Des.DES��Կ������16λ���ȵ��ַ�������16���Ʊ�������Ϊ8λ<br />
	 *            2��Des.Blowfish��Կ������32λ���ȵ��ַ�������16���Ʊ�������Ϊ16λ<br />
	 *            3��Des.DESede��Կ������48λ���ȵ��ַ�������16���Ʊ�������Ϊ32λ<br />
	 * @return
	 */
	public static String deEncryt(String Algorithm, byte[] myinfo, String key)
	{
		byte[] keybyte = HexString2Bytes(key);

		String str = deEncryt(Algorithm, myinfo, keybyte);
		return str;
	}

	/*
	 * ���� Algorithm ���� �����㷨,���� DES,DESede,Blowfish myinfo Ҫ���ܵ���Ϣ
	 */
	private static byte[] encryt(String Algorithm, String myinfo, byte[] keybyte)
	{

		byte[] cipherByte = null;
		try
		{
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

			// ����

			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			cipherByte = c1.doFinal(myinfo.getBytes());

		} catch (java.security.NoSuchAlgorithmException e1)
		{
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2)
		{
			e2.printStackTrace();
		} catch (java.lang.Exception e3)
		{
			e3.printStackTrace();
		}
		return cipherByte;

	}

	/*
	 * ���� Algorithm ���� �����㷨,���� DES,DESede,Blowfish cipherByte Ҫ���ܵ���Ϣ
	 */
	private static String deEncryt(String Algorithm, byte[] cipherByte,
			byte[] keybyte)
	{
		byte[] clearByte = null;
		try
		{
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// ����
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			clearByte = c1.doFinal(cipherByte);

		} catch (java.security.NoSuchAlgorithmException e1)
		{
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2)
		{
			e2.printStackTrace();
		} catch (java.lang.Exception e3)
		{
			e3.printStackTrace();
		}
		return new String(clearByte);

	}

	private static int parse(char c)
	{
		if (c >= 'a')
			return (c - 'a' + 10) & 0x0f;
		if (c >= 'A')
			return (c - 'A' + 10) & 0x0f;
		return (c - '0') & 0x0f;
	}

	/**
	 *  ��ʮ�������ַ������ֽ�����ת��
	 */
	public static byte[] HexString2Bytes(String hexstr)
	{
		byte[] b = new byte[hexstr.length() / 2];
		int j = 0;
		for (int i = 0; i < b.length; i++)
		{
			char c0 = hexstr.charAt(j++);
			char c1 = hexstr.charAt(j++);
			b[i] = (byte) ((parse(c0) << 4) | parse(c1));
		}
		return b;
	}

	/**
	 *  ���ֽ����鵽ʮ�������ַ���ת��
	 */
	public static final String encodeHex(byte[] bytes)
	{
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		int i;

		for (i = 0; i < bytes.length; i++)
		{
			if (((int) bytes[i] & 0xff) < 0x10)
			{
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString();
	}

}