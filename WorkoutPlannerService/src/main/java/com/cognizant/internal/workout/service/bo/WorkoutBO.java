package com.cognizant.internal.workout.service.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkoutBO extends BaseBO {
	private String task;
	private String note;
	private String startTime;
	private String endTime;
	private String startDate;
	private String endDate;
	private String categoryId;
	private String workoutId;
	private String dateDiff;
	private float calBurnPerMinute;
	private int day;
	private float caloriesBurn;
	private int weekOfMonth;
	private int monthOfYear;

	public String getNote() {
		return note;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(String workoutId) {
		this.workoutId = workoutId;
	}

	public float getCalBurnPerMinute() {
		return calBurnPerMinute;
	}

	public void setCalBurnPerMinute(float calBurnPerMinute) {
		this.calBurnPerMinute = calBurnPerMinute;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return String
				.format("WorkoutsBean [task=%s, startTime=%s, endTime=%s, calBurnPerMinute=%s, categoryId=%s, workoutId=%s, note=%s]",
						task, startTime, endTime, calBurnPerMinute, categoryId,
						workoutId, note);
	}

	public String getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(String dateDiff) {
		this.dateDiff = dateDiff;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public float getCaloriesBurn() {
		return caloriesBurn;
	}

	public void setCaloriesBurn(float caloriesBurn) {
		this.caloriesBurn = caloriesBurn;
	}

	public int getWeekOfMonth() {
		return weekOfMonth;
	}

	public void setWeekOfMonth(int weekOfMonth) {
		this.weekOfMonth = weekOfMonth;
	}

	public int getMonthOfYear() {
		return monthOfYear;
	}

	public void setMonthOfYear(int monthOfYear) {
		this.monthOfYear = monthOfYear;
	}

	/*@Override
	public int hashCode() {
		return this.getWorkoutId().hashCode() + this.getTask().hashCode();
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof WorkoutBO) {
			WorkoutBO wb = (WorkoutBO) obj;
			if (this.getWorkoutId().equals(wb.getWorkoutId())
					&& this.getTask().equals(wb.getTask())) {
				return true;
			}
		}
		return false;
	}

}
