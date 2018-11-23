package com.cognizant.internal.workout.service.rest;

import java.text.ParseException;

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
@RequestMapping("/services/end")
public class EndService extends BaseService{
	
	
	@Autowired
	private WorkoutManager itsWorkoutManager;
	
	/**
	 * To track the end date and time for the workout
	 * 
	 * @param inWorkoutsBean The WorkoutsBO view
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 * @throws ParseException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseWrapperBO<BaseBO> endDateTime(@RequestBody WorkoutBO inWorkoutsBean) throws BusinessException, ParseException {		
		try{
			itsWorkoutManager.endDateTime(inWorkoutsBean);
			return getSuccessMessage(BusinessConstants.PROP_INFO_INSERT_END_DATETIME);
		}catch(BusinessException businessException){
			return getFailureMessage(BusinessConstants.PROP_INFO_INSERT_END_DATETIME_FAILURE);
		}		
	}
}
