package com.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class Employee{
    private String positionId;
    private String positionStatus;
    private LocalDateTime time;
    private LocalDateTime timeOut;
    private double timecardHours;
    private LocalDateTime payCycleStartDate;
    private LocalDateTime payCycleEndDate;
    private String employeeName;
    private String fileNumber;
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getPositionStatus() {
		return positionStatus;
	}
	public void setPositionStatus(String positionStatus) {
		this.positionStatus = positionStatus;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public LocalDateTime getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}
	public double getTimecardHours() {
		return timecardHours;
	}
	public void setTimecardHours(double timecardHours) {
		this.timecardHours = timecardHours;
	}
	public LocalDateTime getPayCycleStartDate() {
		return payCycleStartDate;
	}
	public void setPayCycleStartDate(LocalDateTime payCycleStartDate) {
		this.payCycleStartDate = payCycleStartDate;
	}
	public LocalDateTime getPayCycleEndDate() {
		return payCycleEndDate;
	}
	public void setPayCycleEndDate(LocalDateTime payCycleEndDate) {
		this.payCycleEndDate = payCycleEndDate;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	public Employee(String positionId, String positionStatus, LocalDateTime time, LocalDateTime timeOut,
			double timecardHours, LocalDateTime payCycleStartDate, LocalDateTime payCycleEndDate, String employeeName,
			String fileNumber) {
		super();
		this.positionId = positionId;
		this.positionStatus = positionStatus;
		this.time = time;
		this.timeOut = timeOut;
		this.timecardHours = timecardHours;
		this.payCycleStartDate = payCycleStartDate;
		this.payCycleEndDate = payCycleEndDate;
		this.employeeName = employeeName;
		this.fileNumber = fileNumber;
	}
	@Override
	public String toString() {
		return "EmployeeRecord [positionId=" + positionId + ", positionStatus=" + positionStatus + ", time=" + time
				+ ", timeOut=" + timeOut + ", timecardHours=" + timecardHours + ", payCycleStartDate="
				+ payCycleStartDate + ", payCycleEndDate=" + payCycleEndDate + ", employeeName=" + employeeName
				+ ", fileNumber=" + fileNumber + "]";
	}
    

}
			