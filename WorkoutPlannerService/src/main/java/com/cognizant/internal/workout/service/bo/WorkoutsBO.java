package com.cognizant.internal.workout.service.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkoutsBO extends BaseBO {

	private List<String> itsWorkoutBO;

	public List<String> getWorkoutBO() {
		return itsWorkoutBO;
	}

	public void setWorkoutBO(final List<String> inWorkoutBO) {
		itsWorkoutBO = inWorkoutBO;
	}

	@Override
	public String toString(){
		return String.format("WorkoutBO [WorkoutBO=%s]", itsWorkoutBO);
	}
}