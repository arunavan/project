package com.cognizant.internal.workout.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.internal.workout.service.bo.BaseBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.bo.WorkoutBO;
import com.cognizant.internal.workout.service.constant.BusinessConstants;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.manager.WorkoutManager;

@RestController
@RequestMapping("/services/start")
public class StartService extends BaseService {

	
	@Autowired
	WorkoutManager itsWorkoutManager;
	
	/**
	 * Tracks the Start Date and time for the workout
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseWrapperBO<BaseBO> startDateTime(@RequestBody final WorkoutBO inWorkoutsBean) throws BusinessException {
		try{
			itsWorkoutManager.searchExistingWorkout();
			try{
				itsWorkoutManager.addDateTime(inWorkoutsBean);
			}catch(BusinessException businessException){
				return getFailureMessage(BusinessConstants.PROP_INFO_INSERT_START_DATETIME_FAILURE);
			}			
			return getSuccessMessage(BusinessConstants.PROP_INFO_INSERT_START_DATETIME);
		}catch(BusinessException businessException){
			return getFailureMessage(BusinessConstants.PROP_INFO_SEARCH_WORKOUT_FAILURE);
		}
	}
}	