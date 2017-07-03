package model;
// Generated 2017-7-3 11:58:05 by Hibernate Tools 5.2.3.Final

/**
 * TaskManagerId generated by hbm2java
 */
public class TaskManagerId implements java.io.Serializable {

	private int studentId;
	private int taskId;

	public TaskManagerId() {
	}

	public TaskManagerId(int studentId, int taskId) {
		this.studentId = studentId;
		this.taskId = taskId;
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TaskManagerId))
			return false;
		TaskManagerId castOther = (TaskManagerId) other;

		return (this.getStudentId() == castOther.getStudentId()) && (this.getTaskId() == castOther.getTaskId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getStudentId();
		result = 37 * result + this.getTaskId();
		return result;
	}

}
