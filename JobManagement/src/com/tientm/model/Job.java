package com.tientm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Job {
	private String name;
	private String content;
	private Date dateDeadline;
	private int hourDeadline;
	private int minDeadline;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the dateDeadline
	 */
	public Date getDateDeadline() {
		return dateDeadline;
	}

	/**
	 * @param dateDeadline
	 *            the dateDeadline to set
	 */
	public void setDateDeadline(Date dateDeadline) {
		this.dateDeadline = dateDeadline;
	}

	/**
	 * @return the hourDeadline
	 */
	public int getHourDeadline() {
		return hourDeadline;
	}

	/**
	 * @param hourDeadline
	 *            the hourDeadline to set
	 */
	public void setHourDeadline(int hourDeadline) {
		this.hourDeadline = hourDeadline;
	}

	/**
	 * @return the minDeadline
	 */
	public int getMinDeadline() {
		return minDeadline;
	}

	/**
	 * @param minDeadline
	 *            the minDeadline to set
	 */
	public void setMinDeadline(int minDeadline) {
		this.minDeadline = minDeadline;
	}

	public Job(String name, String content, Date dateDeadline,
			int hourDeadline, int minDeadline) {
		super();
		this.name = name;
		this.content = content;
		this.dateDeadline = dateDeadline;
		this.hourDeadline = hourDeadline;
		this.minDeadline = minDeadline;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return name + " - " + content + " - " + sdf.format(dateDeadline)
				+ " - "
				+ (hourDeadline > 12 ? hourDeadline - 12 : hourDeadline) + ":"
				+ minDeadline + (hourDeadline > 12 ? " PM" : " AM");
	}
}
