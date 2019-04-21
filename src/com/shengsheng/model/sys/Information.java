package com.shengsheng.model.sys;

import static org.hibernate.search.annotations.FieldCacheType.CLASS;
import static org.hibernate.search.annotations.FieldCacheType.ID;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.CacheFromIndex;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.shengsheng.model.sys.param.InformationParameter;

import core.support.DateTimeSerializer;
/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:21:08
 * <dl>
 * 		<dt>Information</dt>
 *		<dd>信息发布的实体类</dd>
 * </dl>
 */
@Entity
@Table(name = "information")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount", "sortColumns", "cmd", "queryDynamicConditions", "sortedConditions", "dynamicProperties", "success", "message", "sortColumnsString", "flag" })
@Indexed
@CacheFromIndex({ CLASS, ID })
public class Information extends InformationParameter {

	// 各个字段的含义请查阅文档的数据库结构部分
	private static final long serialVersionUID = 7306241552815502398L;
	@DocumentId
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	/** 标题 	*/
	@Field(index = Index.YES, analyzer = @Analyzer(impl = SmartChineseAnalyzer.class), store = Store.YES)
	@Column(name = "title", length = 100, nullable = false)
	private String title;
	
	/** 作者 	*/
	@Field(index = Index.YES, analyzer = @Analyzer(impl = SmartChineseAnalyzer.class), store = Store.YES)
	@Column(name = "author", length = 40)
	private String author;
	
	/** 所属类型*/
	@ManyToOne
	@JoinColumn(name = "type")
	private Dict type;
	
	/** 是否发布 	*/
	@Column(name = "is_publish")
	private Boolean isPublish;
	
	/** 发布时间 	*/
	@Column(name = "publish_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishTime;
	
	/** 更新时间 	*/
	@Column(name = "refresh_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date refreshTime;
	
	/** 创建用户 	*/
	@ManyToOne
	@JoinColumn(name = "createUser")
	private SysUser createUser;
	
	/** 创建时间 	*/
	@Column(name = "create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	
	/** 内容 	*/
	@Field(index = Index.YES, analyzer = @Analyzer(impl = SmartChineseAnalyzer.class), store = Store.YES)
	@Column(name = "content", columnDefinition = "LONGTEXT")
	private String content;
	
	/** 浏览数 	*/
	@Column(name = "browse_count")
	private Integer browseCount;
	
	/** 相关图片 	*/
	@Column(name = "pic")
	private String pic;
	
	/** 是否显示图片 	*/
	@Column(name = "is_showPic")
	private Boolean isShowPic;

	public Information() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@JsonSerialize(using = DateTimeSerializer.class)
	public Date getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(Date refreshTime) {
		this.refreshTime = refreshTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Information other = (Information) obj;
		return Objects.equal(this.id, other.id) && Objects.equal(this.title, other.title) && Objects.equal(this.author, other.author) && Objects.equal(this.content, other.content);
	}

	public int hashCode() {
		return Objects.hashCode(this.id, this.title, this.author, this.content);
	}

	/**
	 * @return the type
	 */
	public Dict getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Dict type) {
		this.type = type;
	}

	/**
	 * @return the isPublish
	 */
	public Boolean getIsPublish() {
		return isPublish;
	}

	/**
	 * @param isPublish the isPublish to set
	 */
	public void setIsPublish(Boolean isPublish) {
		this.isPublish = isPublish;
	}

	/**
	 * @return the publishTime
	 */
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishTime the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * @return the createUser
	 */
	public SysUser getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(SysUser createUser) {
		this.createUser = createUser;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the browseCount
	 */
	public Integer getBrowseCount() {
		return browseCount;
	}

	/**
	 * @param browseCount the browseCount to set
	 */
	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}

	/**
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**
	 * @return the isShowPic
	 */
	public Boolean getIsShowPic() {
		return isShowPic;
	}

	/**
	 * @param isShowPic the isShowPic to set
	 */
	public void setIsShowPic(Boolean isShowPic) {
		this.isShowPic = isShowPic;
	}

}
