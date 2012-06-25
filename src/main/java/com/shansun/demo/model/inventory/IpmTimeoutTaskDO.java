package com.shansun.demo.model.inventory;

import java.util.Date;

/**
 * 库存中心超时任务表
 * 
 * @author 兰博 Date 2012-04-23
 */
public class IpmTimeoutTaskDO {

	/**
	 * 自增主键
	 */
	private Long	id;

	/**
	 * 超时类型
	 */
	private Byte	tgtType;

	/**
	 * 超时记录ID
	 */
	private Long	tgtId;

	/**
	 * 超时记录所在分库、分表序号
	 */
	private Integer	tgtIndex;

	/**
	 * 超时任务的分库分表值，拍下减库存业务下，biz_id=item_id
	 */
	private Long	bizId;

	/**
	 * 超时时间
	 */
	private Date	timeout;

	/**
	 * 0：未执行；2：执行成功；3：执行失败，但未满5次，可继续重做；4：执行失败，满5次，不可重做；5：取消执行
	 */
	private Integer	status;

	/**
	 * 取模后的值
	 */
	private Integer	modNum;

	/**
	 * 记录创建时间
	 */
	private Date	gmtCreate;

	/**
	 * 记录最后修改时间
	 */
	private Date	gmtModified;

	/**
	 * setter for column 自增主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column 自增主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column 超时类型
	 */
	public void setTgtType(Byte tgtType) {
		this.tgtType = tgtType;
	}

	/**
	 * getter for column 超时类型
	 */
	public Byte getTgtType() {
		return this.tgtType;
	}

	/**
	 * setter for column 超时记录ID
	 */
	public void setTgtId(Long tgtId) {
		this.tgtId = tgtId;
	}

	/**
	 * getter for column 超时记录ID
	 */
	public Long getTgtId() {
		return this.tgtId;
	}

	/**
	 * setter for column 超时记录所在分库、分表序号
	 */
	public void setTgtIndex(Integer tgtIndex) {
		this.tgtIndex = tgtIndex;
	}

	/**
	 * getter for column 超时记录所在分库、分表序号
	 */
	public Integer getTgtIndex() {
		return this.tgtIndex;
	}

	/**
	 * setter for column 超时任务的分库分表值，拍下减库存业务下，biz_id=item_id
	 */
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	/**
	 * getter for column 超时任务的分库分表值，拍下减库存业务下，biz_id=item_id
	 */
	public Long getBizId() {
		return this.bizId;
	}

	/**
	 * setter for column 超时时间
	 */
	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}

	/**
	 * getter for column 超时时间
	 */
	public Date getTimeout() {
		return this.timeout;
	}

	/**
	 * setter for column 0：未执行；2：执行成功；3：执行失败，但未满5次，可继续重做；4：执行失败，满5次，不可重做；5：取消执行
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 0：未执行；2：执行成功；3：执行失败，但未满5次，可继续重做；4：执行失败，满5次，不可重做；5：取消执行
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 取模后的值
	 */
	public void setModNum(Integer modNum) {
		this.modNum = modNum;
	}

	/**
	 * getter for column 取模后的值
	 */
	public Integer getModNum() {
		return this.modNum;
	}

	/**
	 * setter for column 记录创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * getter for column 记录创建时间
	 */
	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	/**
	 * setter for column 记录最后修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * getter for column 记录最后修改时间
	 */
	public Date getGmtModified() {
		return this.gmtModified;
	}

	@Override
	public String toString() {
		return "IpmTimeoutTaskDO [id=" + id + ", tgtType=" + tgtType + ", tgtId=" + tgtId + ", tgtIndex=" + tgtIndex + ", bizId=" + bizId + ", timeout=" + timeout + ", status="
				+ status + ", modNum=" + modNum + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

}