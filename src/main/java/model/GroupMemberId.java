package model;
// Generated 2017-7-1 16:01:00 by Hibernate Tools 5.2.3.Final

/**
 * GroupMemberId generated by hbm2java
 */
public class GroupMemberId implements java.io.Serializable {

	private int groupId;
	private int memberId;

	public GroupMemberId() {
	}

	public GroupMemberId(int groupId, int memberId) {
		this.groupId = groupId;
		this.memberId = memberId;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GroupMemberId))
			return false;
		GroupMemberId castOther = (GroupMemberId) other;

		return (this.getGroupId() == castOther.getGroupId()) && (this.getMemberId() == castOther.getMemberId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getGroupId();
		result = 37 * result + this.getMemberId();
		return result;
	}

}
