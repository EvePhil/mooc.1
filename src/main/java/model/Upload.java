package model;
// Generated 2017-7-1 16:01:00 by Hibernate Tools 5.2.3.Final

import java.util.Date;

/**
 * Upload generated by hbm2java
 */
public class Upload implements java.io.Serializable {

	private int resourcesId;
	private Date timestamp;
	private String title;
	private byte[] desc;
	private int teacherId;

	public Upload() {
	}

	public Upload(int resourcesId, String title, int teacherId) {
		this.resourcesId = resourcesId;
		this.title = title;
		this.teacherId = teacherId;
	}

	public Upload(int resourcesId, String title, byte[] desc, int teacherId) {
		this.resourcesId = resourcesId;
		this.title = title;
		this.desc = desc;
		this.teacherId = teacherId;
	}

	public int getResourcesId() {
		return this.resourcesId;
	}

	public void setResourcesId(int resourcesId) {
		this.resourcesId = resourcesId;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getDesc() {
		return this.desc;
	}

	public void setDesc(byte[] desc) {
		this.desc = desc;
	}

	public int getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

}
