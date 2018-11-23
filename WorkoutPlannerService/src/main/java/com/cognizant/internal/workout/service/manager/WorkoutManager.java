package com.cognizant.internal.workout.service.manager;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.internal.workout.service.bo.WorkoutBO;
import com.cognizant.internal.workout.service.dao.WorkoutDao;
import com.cognizant.internal.workout.service.exception.BusinessException;

@Service
public class WorkoutManager {
	@Autowired
	WorkoutDao itsWorkoutDao;

	public List<WorkoutBO> getWorkout() throws BusinessException {
		return itsWorkoutDao.getWorkout();
	}

	/**
	 * Workout Inserted
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @return boolean
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void addWorkout(final WorkoutBO inWorkoutsBean) throws BusinessException {
		itsWorkoutDao.addWorkout(inWorkoutsBean);		
	}
	
	/**
	 * Update workout records
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void updateWorkout(WorkoutBO inWorkoutsBean) throws BusinessException  {
		itsWorkoutDao.updateWorkout(inWorkoutsBean);
		itsWorkoutDao.updateWorkoutDate(inWorkoutsBean);
	}

	/**
	 * Delete Workout based on Category
	 * 
	 * @param inworkoutId The WorkoutId to perform delete operation
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void deleteWorkout(String inworkoutId) throws BusinessException {
		itsWorkoutDao.deleteWorkout(inworkoutId);
	}
	
	/**
	 * Workout active Start time recorded
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void addDateTime(WorkoutBO inWorkoutsBean) throws BusinessException {
		 itsWorkoutDao.addDateTime(inWorkoutsBean);
	}
	
	/**
	 * Tracks the end Dtae time
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 * @throws ParseException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void endDateTime(WorkoutBO inWorkoutsBean) throws BusinessException, ParseException {
		itsWorkoutDao.endDateTime(inWorkoutsBean);
	}

	/**
	 * Get all the track report of the start and end date time
	 * 
	 * @return List<WorkoutsBO>
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public List<WorkoutBO> getAllTrack() throws BusinessException {
		return itsWorkoutDao.getAllTrack();
	}
	
	/**
	 * Search the existing workout list
	 * 
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void searchExistingWorkout() throws BusinessException {
		 itsWorkoutDao.searchExistingWorkout();
	}

	/**
	 * gets the workout detail w.r.t. Year/month/week
	 * 
	 * @param type Mentions the type as Year/month/week
	 * @return List<WorkoutsBO>
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public List<WorkoutBO> workoutDetails(String type) throws BusinessException {
		return itsWorkoutDao.getWorkoutDetails(type);
	}
}
