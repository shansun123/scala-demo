package com.shansun.demo.model.inventory;

import java.util.Date;

/**
 * ������ĳ�ʱ�����
 * 
 * @author ���� Date 2012-04-23
 */
public class IpmTimeoutTaskDO {

	/**
	 * ��������
	 */
	private Long	id;

	/**
	 * ��ʱ����
	 */
	private Byte	tgtType;

	/**
	 * ��ʱ��¼ID
	 */
	private Long	tgtId;

	/**
	 * ��ʱ��¼���ڷֿ⡢�ֱ����
	 */
	private Integer	tgtIndex;

	/**
	 * ��ʱ����ķֿ�ֱ�ֵ�����¼����ҵ���£�biz_id=item_id
	 */
	private Long	bizId;

	/**
	 * ��ʱʱ��
	 */
	private Date	timeout;

	/**
	 * 0��δִ�У�2��ִ�гɹ���3��ִ��ʧ�ܣ���δ��5�Σ��ɼ���������4��ִ��ʧ�ܣ���5�Σ�����������5��ȡ��ִ��
	 */
	private Integer	status;

	/**
	 * ȡģ���ֵ
	 */
	private Integer	modNum;

	/**
	 * ��¼����ʱ��
	 */
	private Date	gmtCreate;

	/**
	 * ��¼����޸�ʱ��
	 */
	private Date	gmtModified;

	/**
	 * setter for column ��������
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column ��������
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column ��ʱ����
	 */
	public void setTgtType(Byte tgtType) {
		this.tgtType = tgtType;
	}

	/**
	 * getter for column ��ʱ����
	 */
	public Byte getTgtType() {
		return this.tgtType;
	}

	/**
	 * setter for column ��ʱ��¼ID
	 */
	public void setTgtId(Long tgtId) {
		this.tgtId = tgtId;
	}

	/**
	 * getter for column ��ʱ��¼ID
	 */
	public Long getTgtId() {
		return this.tgtId;
	}

	/**
	 * setter for column ��ʱ��¼���ڷֿ⡢�ֱ����
	 */
	public void setTgtIndex(Integer tgtIndex) {
		this.tgtIndex = tgtIndex;
	}

	/**
	 * getter for column ��ʱ��¼���ڷֿ⡢�ֱ����
	 */
	public Integer getTgtIndex() {
		return this.tgtIndex;
	}

	/**
	 * setter for column ��ʱ����ķֿ�ֱ�ֵ�����¼����ҵ���£�biz_id=item_id
	 */
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	/**
	 * getter for column ��ʱ����ķֿ�ֱ�ֵ�����¼����ҵ���£�biz_id=item_id
	 */
	public Long getBizId() {
		return this.bizId;
	}

	/**
	 * setter for column ��ʱʱ��
	 */
	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}

	/**
	 * getter for column ��ʱʱ��
	 */
	public Date getTimeout() {
		return this.timeout;
	}

	/**
	 * setter for column 0��δִ�У�2��ִ�гɹ���3��ִ��ʧ�ܣ���δ��5�Σ��ɼ���������4��ִ��ʧ�ܣ���5�Σ�����������5��ȡ��ִ��
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 0��δִ�У�2��ִ�гɹ���3��ִ��ʧ�ܣ���δ��5�Σ��ɼ���������4��ִ��ʧ�ܣ���5�Σ�����������5��ȡ��ִ��
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column ȡģ���ֵ
	 */
	public void setModNum(Integer modNum) {
		this.modNum = modNum;
	}

	/**
	 * getter for column ȡģ���ֵ
	 */
	public Integer getModNum() {
		return this.modNum;
	}

	/**
	 * setter for column ��¼����ʱ��
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * getter for column ��¼����ʱ��
	 */
	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	/**
	 * setter for column ��¼����޸�ʱ��
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * getter for column ��¼����޸�ʱ��
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