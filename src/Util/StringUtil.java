package Util;
/**
 * 字符工具类
 * @author Ping
 *
 */

public class StringUtil {
	public static boolean IsEmpty(String str) {
		if(str==null ||"".equals(str.trim())) {
			return true;
		}else
			return false;
		
	}
	/**
	 * 判断字符是否是空
	 * @param str
	 * @return
	 */
	public static boolean IsNotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else
			return false;
	}
	/**
	 * 判断字符是否不是空
	 */
}
