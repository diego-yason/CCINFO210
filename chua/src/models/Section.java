package models;

public class Section {
	private String name;
	private String status;
	private String termId;
	public Section(String name, String termId, String status) {
		this.setName(name);
		this.setStatus(status);
		this.setTermId(termId);
	}
	/**
	 * @return the termId
	 */
	public String getTermId() {
		return termId;
	}
	/**
	 * @param termId the termId to set
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
