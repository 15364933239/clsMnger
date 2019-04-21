package core.support;

import java.util.List;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:32:54
 * @param <E>
 * <dl>
 * 		<dt>ListView</dt>
 *		<dd></dd>
 * </dl>
 */
public class ListView<E> {

	private Long totalRecord;
	private List<E> data;

	public Long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

}
