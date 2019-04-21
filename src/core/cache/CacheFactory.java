package core.cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:31:02
 * <dl>
 * 		<dt>CacheFactory</dt>
 *		<dd></dd>
 * </dl>
 */
public class CacheFactory {

	public static CacheManager cacheManager;

	static {
		try {
			cacheManager = CacheManager.create(CacheFactory.class.getResource("/ehcache.xml"));
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	private CacheFactory() {
	}

	public static CacheManager getCacheManager() {
		return cacheManager;
	}

}
