package com.cognizant.internal.workout.service.rest;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.internal.workout.service.bo.BaseBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.bo.WorkoutBO;
import com.cognizant.internal.workout.service.bo.WorkoutWrapper;
import com.cognizant.internal.workout.service.constant.BusinessConstants;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.manager.WorkoutManager;

@RestController
@RequestMapping("/services/workout")
public class WorkoutService extends BaseService {

	private static final Logger  LOGGER = LoggerFactory.getLogger(WorkoutService.class);
	
	@Autowired
	private WorkoutManager itsWorkoutManager;

	/**
	 * Gets the distinct workout list
	 * 
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseWrapperBO<BaseBO> getAllWorkouts() throws BusinessException {
		final WorkoutWrapper theWorkoutWrapper= new WorkoutWrapper();
		theWorkoutWrapper.setWorkoutBos(itsWorkoutManager.getWorkout().stream().distinct()
				.collect(Collectors.toList()));
		return getSuccessStatus(theWorkoutWrapper);
	}
	

	/**
	 * Workout Inserted
	 * 
	 * @param inWorkoutBO The WorkoutsBO view
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseWrapperBO<BaseBO> addWorkout(
			@RequestBody final WorkoutBO inWorkoutBO)
			throws BusinessException {		
		try{
			itsWorkoutManager.addWorkout(inWorkoutBO);
			return getSuccessMessage(BusinessConstants.PROP_INFO_INSERT_WORKOUT);
		}catch(BusinessException businessException){
			return getFailureMessage(BusinessConstants.PROP_INFO_INSERT_WORKOUT_FAILURE);
		}
	}

	/**
	 * Update workout records
	 * 
	 * @param inWorkoutBO The WorkoutsBO view
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseWrapperBO<BaseBO> updateWorkout(
			@RequestBody final WorkoutBO inWorkoutBO) throws BusinessException {
		try{
			itsWorkoutManager.updateWorkout(inWorkoutBO);
			return getSuccessMessage(BusinessConstants.PROP_INFO_UPDATE_WORKOUT);
		}catch(BusinessException businessException){
			LOGGER.error("Error in updateWorkout", businessException);
			return getFailureMessage(BusinessConstants.PROP_INFO_UPDATE_WORKOUT_FAILURE);
		}
	}

	/**
	 * Delete Workout based on Category
	 * 
	 * @param inWorkoutId Workout Id for Delete
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(value = "workoutId/{workoutId}", method = RequestMethod.DELETE)
	public ResponseWrapperBO<BaseBO> deleteWorkout(
			@PathVariable("workoutId") final String inWorkoutId) throws BusinessException {
		try{
			itsWorkoutManager.deleteWorkout(inWorkoutId);
			return getSuccessMessage(BusinessConstants.PROP_INFO_DELETE_WORKOUT);
		}catch(BusinessException businessException){
			LOGGER.error("Error in deleteWorkout", businessException);
			return getFailureMessage(BusinessConstants.PROP_INFO_DELETE_WORKOUT_FAILURE);
		}		
	}

	/**
	 * Gets the workout detail w.r.t. Year/month/week
	 * 
	 * @param type representing Year/month/week
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(value = "workoutDetails/type/{type}", method = RequestMethod.GET)
	public ResponseWrapperBO<BaseBO> deleteWorworkoutDetails(
			@PathVariable("type") final String type) throws BusinessException  {
		final WorkoutWrapper theWorkoutWrapper= new WorkoutWrapper();
		theWorkoutWrapper.setWorkoutBos(itsWorkoutManager.workoutDetails(type));
		return getSuccessStatus(theWorkoutWrapper);		
	}	
}
