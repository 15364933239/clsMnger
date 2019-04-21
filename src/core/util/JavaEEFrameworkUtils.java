package core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:35:15
 * <dl>
 * 		<dt>JavaEEFrameworkUtils</dt>
 *		<dd>框架的Utils</dd>
 * </dl>
 */
public class JavaEEFrameworkUtils {

	public static String getRandomString(int i) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < i; j++) {
			sb.append(String.valueOf(RandomUtils.nextInt(10)));
		}
		return sb.toString();
	}

	public static String stringFilter(String str) throws PatternSyntaxException {
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

}
