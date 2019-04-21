package core.support;

import java.util.List;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:33:21
 * @param <E>
 * <dl>
 * 		<dt>QueryResult</dt>
 *		<dd></dd>
 * </dl>
 */
public class QueryResult<E> {

	private List<E> resultList;
	private Long totalCount;

	public List<E> getResultList() {
		return resultList;
	}

	public void setResultList(List<E> resultList) {
		this.resultList = resultList;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
