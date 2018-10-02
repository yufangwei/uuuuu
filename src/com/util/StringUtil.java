package com.util;

/**
 * �ַ���������
 */
public class StringUtil {
	
	/**
	 * ����<, >,\n �ַ��ķ�����
	 * @param input ��Ҫ���˵��ַ�
	 * @return ��ɹ����Ժ���ַ���
	 */
	public static String filterHTML(String input) {
		if (input == null) {
			return null;
		}
		if (input.length() == 0) {
			return input;
		}
		input = input.replaceAll("&", "&amp;");
		input = input.replaceAll("<", "&lt;");
		input = input.replaceAll(">", "&gt;");
		input = input.replaceAll(" ", "&nbsp;");
		input = input.replaceAll("'", "&#39;");
		input = input.replaceAll("\"", "&quot;");
		return input.replaceAll("\n", "<br>");
	}
	
	/**
	 * ��֤�ַ����Ƿ�Ϊ�գ�null����ַ�����
	 * @param str Ҫ��֤���ַ���
	 * @return ��֤������ַ���Ϊ�շ���true�����򷵻�false��
	 */
	public static boolean isNullOrEmpty(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	/*
	 * �����ַ������ֽڳ���(��ĸ���ּ�1�����ּ�����2) ���� ����
	 */
	public static int byteLength(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Integer.toHexString(str.charAt(i)).length() == 4) {
				count += 2;
			} else {
				count++;
			}
		}
		return count;
	}

	/**
	 * ��ָ�����ȣ�ʡ���ַ��������ַ�
	 * @param str �ַ���
	 * @param len �����ַ�������
	 * @return ʡ�Ժ���ַ���
	 */
	public static String omitString(String str, int len) {
		StringBuffer sb = new StringBuffer();
		if (byteLength(str) > len) {
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				char temp = str.charAt(i);
				if (Integer.toHexString(temp).length() == 4) {
					count += 2;
				} else {
					count++;
				}
				if (count < len - 3) {
					sb.append(temp);
				}
				if (count == len - 3) {
					sb.append(temp);
					break;
				}
				if (count > len - 3) {
					sb.append(" ");
					break;
				}
			}
			sb.append("...");
		} else {
			sb.append(str);
		}
		return sb.toString();
	}
}