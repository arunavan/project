package com.cognizant.internal.workout.service.bo;

import java.util.List;

public class WorkoutWrapper extends BaseBO{
	private List<WorkoutBO> itsWorkoutBos;

	public List<WorkoutBO> getWorkoutBos() {
		return itsWorkoutBos;
	}

	public void setWorkoutBos(List<WorkoutBO> inWorkoutBos) {
		itsWorkoutBos = inWorkoutBos;
	}
}
