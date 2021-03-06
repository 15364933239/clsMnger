package com.shengsheng.dao.sys.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import com.shengsheng.dao.sys.InformationDao;
import com.shengsheng.model.sys.Dict;
import com.shengsheng.model.sys.Information;

import core.dao.BaseDao;
import core.util.HtmlUtils;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:56:40
 * <dl>
 * 		<dt>InformationDaoImpl</dt>
 *		<dd>信息发布的数据持久层的实现类</dd>
 * </dl>
 */
@Repository
public class InformationDaoImpl extends BaseDao<Information> implements InformationDao {

	public InformationDaoImpl() {
		super(Information.class);
	}

	// 生成信息的索引
	public void indexingInformation() {
		try {
			FullTextSession fullTextSession = Search.getFullTextSession(getSession());
			// Object information = fullTextSession.load(Information.class, new BigDecimal(99));
			// fullTextSession.index(information);
			fullTextSession.createIndexer(Information.class).threadsForSubsequentFetching(1).threadsToLoadObjects(1).startAndWait();
			fullTextSession.flushToIndexes();
			fullTextSession.getSearchFactory().optimize();
			fullTextSession.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 全文检索信息
	public List<Information> queryByInformationName(final String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		FullTextSession fullTextSession = Search.getFullTextSession(getSession());
		SearchFactory searchFactory = fullTextSession.getSearchFactory();
		final QueryBuilder queryBuilder = searchFactory.buildQueryBuilder().forEntity(Information.class).get();
		org.apache.lucene.search.Query luceneQuery = queryBuilder.bool().should(queryBuilder.keyword().onField("title").matching(name).createQuery())
				.should(queryBuilder.keyword().onField("author").matching(name).createQuery()).should(queryBuilder.keyword().onField("content").matching(name).createQuery()).createQuery();
		org.hibernate.search.FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Information.class).setMaxResults(500);

		List<Information> originalInformationList = fullTextQuery.list();
		List<Information> informationList = new ArrayList<Information>();
		for (Information entity : originalInformationList) {
			Information information = new Information();
			information.setId(entity.getId());
			information.setTitle(entity.getTitle());
			information.setAuthor(entity.getAuthor());
			information.setRefreshTime(entity.getRefreshTime());
			information.setContent(entity.getContent());
			information.setContentNoHTML(HtmlUtils.htmltoText(entity.getContent()));
			informationList.add(information);
		}

		return informationList;
	}

	@Override
	public List<Information> getPage(Integer page, Integer size) {
		String s = " from Information o "
				+ " order by o.publishTime desc";
		Query query = getSession().createQuery(s);
		query.setFirstResult((page-1)*size);
		query.setMaxResults(size);
		List<Information> list = query.list();
		return list;
	}

	@Override
	public List<Information> getPage(Integer page, Integer size, Dict type) {
		String s = " from Information o "
				+ " where o.type = :type "
				+ " order by o.publishTime desc";
		Query query = getSession().createQuery(s);
		query.setParameter("type", type);
		query.setFirstResult((page-1)*size);
		query.setMaxResults(size);
		List<Information> list = query.list();
		return list;
	}

	@Override
	public Long getCount() {
		String s = "select count(o)  from Information o ";
		Query query = getSession().createQuery(s);
		List list = query.list();
		return (Long) list.get(0);
	}

	@Override
	public Long getCount(Dict type) {
		String s = "select count(o)  from Information o "
				+ " where o.type = :type ";
		Query query = getSession().createQuery(s);
		query.setParameter("type", type);
		List list = query.list();
		return (Long) list.get(0);
	}

}
