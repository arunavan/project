package com.cognizant.internal.workout.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cognizant.internal.workout.service.bo.WorkoutBO;
import com.cognizant.internal.workout.service.constant.BusinessConstants;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.mapper.WorkoutMapper;


@Repository
public class WorkoutDao {
	
	@Autowired
	private WorkoutMapper itsWorkoutMapper;

	/**
	 * Distinct list of Workout is returned
	 * 
	 * @return List<WorkoutsBO>
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public List<WorkoutBO> getWorkout() throws BusinessException {
		try {
			return itsWorkoutMapper.getWorkout();
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}
	/**
	 * Workout Inserted
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @return boolean
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void addWorkout(final WorkoutBO inWorkoutsBean) throws BusinessException {
		try {
			itsWorkoutMapper.addWorkOut(inWorkoutsBean);
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}


	/**
	 * Workout Updated
	 *  
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void updateWorkout(WorkoutBO inWorkoutsBean) throws BusinessException {
		try {
			itsWorkoutMapper.updateWorkout(inWorkoutsBean);
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}

	/**
	 * Workout active start and End date updated w.r.t. workoutId
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void updateWorkoutDate(WorkoutBO inWorkoutsBean) throws BusinessException {
		try {
			itsWorkoutMapper.updateWorkoutDate(inWorkoutsBean);
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}

	/**
	 * Delete status for the workout is made 'Y' w.r.t. to CategoryId
	 * 
	 * @param inworkoutId The WorkoutId to perform delete operation
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void deleteWorkout(String inworkoutId) throws BusinessException {
		try {
			itsWorkoutMapper.deleteWorkout(inworkoutId);
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}

	}

	/**
	 * Workout active Start time recorded
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @return boolean
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void addDateTime(WorkoutBO inWorkoutsBean) throws BusinessException {
		try {
			itsWorkoutMapper.addDateTime(inWorkoutsBean);
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}

	/**
	 * Workout active end time recorded
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @return boolean
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public boolean endDateTime(WorkoutBO inWorkoutsBean) throws BusinessException {
		try {
			itsWorkoutMapper.endDateTime(inWorkoutsBean);
			return true;
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}

	/**
	 * All the Start and end Time of the Workout tracked
	 * 
	 * @return List<WorkoutsBO> 
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public List<WorkoutBO> getAllTrack() throws BusinessException {
		try {
			return itsWorkoutMapper.getAllTrack();
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}

	/**
	 * This method is used to search Existing Workout
	 * 
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void searchExistingWorkout() throws BusinessException {
		List<WorkoutBO> theWorkoutList = new ArrayList<>();
		try {
			theWorkoutList = itsWorkoutMapper.searchExistingWorkout();
			if (!theWorkoutList.isEmpty()) {
				throw new BusinessException(BusinessConstants.PROP_INFO_SEARCH_WORKOUT_ALREADY_EXISTS);
			}
			//return false;
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}

	}

	/**
	 * this method will return the work out history done in pass days/week/month
	 * @param type can be day/week/month
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 * @return List<WorkoutsBO>
	 */	

	public List<WorkoutBO> getWorkoutDetails(String type) {
		if(type.equals("yearWise")){
			return itsWorkoutMapper.getWorkoutForYear();
		}else if(type.equals("weekWise")){
			return itsWorkoutMapper.getWorkoutForWeek();
		}else if(type.equals("monthWise")){
			return itsWorkoutMapper.getWorkoutForMonth();
		}
		return null;
	}
}