package com.security.appsecurity1.model;

public class DepartmentDTO {
	private long id;
    private String depName;
    private long employeeId;

	public DepartmentDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [id=");
		builder.append(id);
		builder.append(", depName=");
		builder.append(depName);
		builder.append(", employeeId=");
		builder.append(employeeId);
		builder.append("]");
		return builder.toString();
	}
}
